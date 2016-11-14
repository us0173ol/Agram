package com.patrick;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {

        super(name);
        this.handOfCards.setOwner(this.name);
    }


    /*Call the Hand class display the hand.
        use this string as a prompt.
        Get user's choice of card as an integer.*/
}