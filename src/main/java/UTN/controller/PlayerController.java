package UTN.controller;

import UTN.models.Player;


public class PlayerController {

    private Player winner;
    private boolean draw;

    public PlayerController() {
        this.draw = false;
        this.winner = null;
    }

    public synchronized void playLetter(Player player) {
        try {

            while (Player.isPlaying()) {
                wait();
            }

            Player.setPlaying(true);

            boolean hitLetter = player.getWord().addChar(player.dropLetter());

            if (!hitLetter) {
                player.setLifes(player.getLifes() - 1);
            }

            player.setAttempts(player.getAttempts() + 1);

            Player.setPlaying(false);
            notifyAll();
            System.out.println(player.getPlayerName() + " ---- " + player.getWord().showCurrentWord());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public Player compareWinner(Player player1, Player player2){

        if (player1.getWord().isComplete() && player2.getWord().isComplete()){

            this.winner = this.betterPlayerIfWin(player1,player2);

        }else if (player1.getWord().isComplete() || player2.getWord().isComplete()){
            if (player1.getWord().isComplete()){
                this.winner = player1;
            }else{
                this.winner = player2;
            }
        }else{
            this.winner = this.betterPlayerIfLose(player1,player2);
        }

        return this.winner;

    }

    private Player betterPlayerIfWin(Player player1, Player player2){

        if (player1.getAttempts() < player2.getAttempts()){
            return player1;
        }else if (player2.getAttempts() < player1.getAttempts()){
            return player2;
        }else{
            if (player1.getLifes() > player2.getLifes()){
                return player1;
            }else{
                return player2;
            }
        }

    }

    private Player betterPlayerIfLose(Player player1, Player player2){

        if (player1.getAttempts() < player2.getAttempts()){
            return player2;
        }else if (player2.getAttempts() < player1.getAttempts()){
            return player1;
        }else{
            this.draw = true;
            return null;
        }

    }

    public void showWinner(){
        if (this.winner.getWord().isComplete()){
            System.out.println(String.format("Gano %s en %d intentos, restandole %d vidas",this.winner.getPlayerName(),this.winner.getAttempts(),this.winner.getLifes()));
        }else if (this.draw){
            System.out.println("Hay empate. Ambos acertaron la misma cantidad de letras");
        }else{
            System.out.println(String.format("%s no completo la palabra, pero aun asi, gano por acertar mas letras",this.winner.getPlayerName()));
        }
    }

    public Player getWinner() {
        return winner;
    }
}
