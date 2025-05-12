package com.variable.gamescoretracker;

public class GameTracker {

    private String playerName;
    private int score;
    private int level;

    final int MAX_LEVEL = 10;

    public GameTracker(String playerName, int score, int level) {
        this.playerName = playerName;
        this.score = score;
        this.level = level;
    }

    public void increaseScore(int score) {
        this.score += score;
        System.out.println("Player :" + playerName);
        System.out.println("current score " + score);
        System.out.println("increasedScore " + this.score);

        System.out.println("Current Level : " + levelUp());
    }

    public int levelUp() {
        if (level < 10 && score > 0) {
            level = (score - 1) / 10 + 1;
            if (level > 10) {

                throw new RuntimeException("Level exceeded");
            }

        }
        return level;
    }



}
