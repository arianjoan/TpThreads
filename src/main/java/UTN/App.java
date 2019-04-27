package UTN;

import UTN.models.Player;
import UTN.models.Word;
import UTN.controller.PlayerController;
import UTN.repository.WinnersDao;
import UTN.repository.WordsDao;

import static java.lang.Thread.sleep;


public class App {
    public static void main(String[] args) throws InterruptedException {

        String wordPlay = WordsDao.getWord();

        Word word = new Word(wordPlay);
        Word word2 = new Word(wordPlay);

        PlayerController controller = new PlayerController();

        Thread player = new Player("Arian", controller);
        Thread player2 = new Player("Agustin", controller);

        ((Player) player).setWord(word);
        ((Player) player2).setWord(word2);

        player.start();
        player2.start();

        player.join();
        player2.join();

        Player winner = controller.compareWinner((Player) player, (Player) player2);

        controller.showWinner();

        if (winner != null) {
            WinnersDao.insertWinner(winner);
        }
    }
}
