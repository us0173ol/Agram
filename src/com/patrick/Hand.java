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

    public LinkedList<Card> getHandOfCards() {
        return handOfCards;
    }
    public Card getSingleCard(int v){
        return this.handOfCards.get(v);
    }

    public int size() {
        return handOfCards.size();

    }
/*
    public int getMinimumScore() {
        //TODO Ace is 11?
        //Assume ace is low.
        int s = 0;

        for (Card c : this.handOfCards) {

            int val = c.getMinValue();
            s += val;
        }

        return s;

    }*/
    public String toString() {
        String cards = "";
        for (Card c : handOfCards) {
            cards = cards + c.toString() + " ";
        }
        return cards;

    }
    public void displayHand() {
        System.out.println(".............Your_Hand........ ");
        for (int v = 0; v <= handOfCards.size(); v++) {
            System.out.format("%d) %s", v+1, this.handOfCards.get(v));
        }
    }
}