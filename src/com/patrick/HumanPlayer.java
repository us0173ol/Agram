package com.patrick;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }


    public Card selectCardToPlay(Deck cards) {
        handOfCards.displayHand();
        String prompt = "Pleaes select a card to play.";
        int userChoice = Game.ui.numInput(prompt);

    }
}
