package com.patrick;
import java.util.LinkedList;
public class Hand {
    private LinkedList<Card> handOfCards;


    public Hand() {
        this.handOfCards = new LinkedList<Card>();
    }
    public Card playCard(int cardNumber){
        return handOfCards.remove(cardNumber);
    }
    public void addCard(Card newCard) {

        if (this.handOfCards.size() < Game.MAX_CARDS_IN_HAND) {
            handOfCards.add(newCard);
        } else {
            Game.ui.output("Can't have more than " + Game.MAX_CARDS_IN_HAND + " cards!");
        }
    }


    public int size() {
        return handOfCards.size();

    }

    public int getMinimumScore() {

        //Assume ace is low.
        int s = 0;

        for (Card c : this.handOfCards) {

            int val = c.getMinValue();
            s += val;
        }

        return s;

    }
    public String toString() {
        String cards = "";
        for (Card c : handOfCards) {
            cards = cards + c.toString() + " ";
        }
        return cards;

    }
}