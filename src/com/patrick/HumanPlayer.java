package com.patrick;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

/*Call the Hand class display the hand.
use this string as a prompt.
Get user's choice of card as an integer.*/
    public Card selectCardToPlay(Deck cards) {
        handOfCards.displayHand();
        String prompt = "Pleaes select a card to play.";
        int userChoice = Game.ui.numInput(prompt);
        Card selectedCard = handOfCards.getSingleCard(userChoice);
        //Returns a card to PlayerManager.TODO Add this card to the pile of played cards.
        return handOfCards.getSingleCard(userChoice);

    }
}