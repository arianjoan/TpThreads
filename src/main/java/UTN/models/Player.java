package UTN.models;

import UTN.Utilities;
import UTN.controller.PlayerController;

public class Player extends Thread {

    private String name;
    private Integer lifes;
    private Integer attempts;
    private Word word;
    private static boolean playing = false;
    private PlayerController controller;

    public Player(String nombre, PlayerController controller) {
        this.name = nombre;
        this.lifes = 20;
        this.attempts = 0;
        this.controller = controller;
    }

    public String getPlayerName() {
        return name;
    }

    public Integer getLifes() {
        return lifes;
    }

    public void setLifes(Integer lifes) {
        this.lifes = lifes;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public static boolean isPlaying() {
        return playing;
    }


    public static void setPlaying(boolean playing) {
        Player.playing = playing;
    }

    public Character dropLetter() {

        Character c = (char) (Utilities.getRandom().nextInt(26) + 65);
        return c;
    }


    @Override
    public void run() {

        this.attempts = 0;

        while (this.lifes > 0 && !this.word.isComplete()) {

            controller.playLetter(this);

        }

    }

}
