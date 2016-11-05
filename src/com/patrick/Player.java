package com.patrick;

public abstract class Player {
    int wins = 0;

    public int getCurrentScore() {//Alt insert generate getter and setter.
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {//Alt insert generate getter and setter.
        this.currentScore = currentScore;
    }

    int currentScore = 0;
    String name;
    Hand handOfCards;
    PlayerManager manager;
    boolean isPlayerOne = false;

    Player(String name) {
        this.name = name;
    }

    Player(String name, PlayerManager manager) {
        this.name = name;
        this.manager = manager;
    }

    //Insist that subclasses implement this method.
    //public abstract void playHand(Deck allCards);

    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    public void setPlayerOne(boolean playerOne) {
        isPlayerOne = playerOne;
    }

    public void wonRound() {
        wins += 1;
    }

    //Getters and setters.
    public void setManager(PlayerManager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Hand getHandOfCards() {
        return handOfCards;
    }

    public void setHand(Hand handOfCards) {
        this.handOfCards = handOfCards;
    }

    public int getWins() {
        return wins;
    }


    @Override
    public String toString() {
        String playerOne = (isPlayerOne) ? "* is currently Player One" : "(is not Player One)";
        return name + " " + playerOne;
    }
}
