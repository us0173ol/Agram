package com.patrick;

import java.util.LinkedList;
public class PlayerManager {
    LinkedList<Player> players;
    LinkedList<Card> cardsThatWereAlreadyPlayedThisRound;

    public final int MAX_PLAYERS = 5; //for a single deck, anyway, to allow for a possible max of 5 cards per player

    public PlayerManager(LinkedList<Player> players) {
        this.players = players;

        //only take the first 5 players
        while (players.size() > MAX_PLAYERS) {
            System.out.println("More than 5 players, removing players from end of list");
            System.out.println(players.removeLast().getName());
        }
        //setDealer();
    }

    public PlayerManager() {
        this.players = new LinkedList<Player>();
        this.cardsThatWereAlreadyPlayedThisRound = new LinkedList<Card>();
    }


    public void add(Player player) {
        //refuse to add more than 5 players
        if (players.size() < MAX_PLAYERS) {
            player.setManager(this);
            players.add(player);
            //setDealer();
        } else {
            Game.ui.output("There's already " + MAX_PLAYERS + " in the game. Can't add " + player.getName());
        }
    }

/*
    /* Enable all players to have a chance at being the dealer, in turn */
    /*public void rotateDealer() {

        Player lastDealer = players.removeLast();  //remove last player,
        lastDealer.setDealer(false);
        players.addFirst(lastDealer);              //add them at the beginning.
        //set last player to be dealer
        //setDealer();
    }


	*//* Methods used by Players to figure out status of the game,
	e.g. how many players left to play, what's the score to beat etc.*//*
    }*/
    public void getRound(){
// 1. PlayerOne plays a card
// 2. Each other player tries to match the suit with as high a card as possible.
// 3. This mmethod compares those cards to PlayerOne's card.
// 4. Gives players who matched the suit points for their cards.
// 5. Figure out who PlayerOne is now.
// 6. Sets new playerOne to True, Switches old to false.
       for (Player p : players){
           if (p.isPlayerOne){

           }
       }
    }


    public void printWins() {

        for (Player p : players) {
            int wins = p.getWins();
            System.out.println(p.getName() + " won " + wins + " times");
        }
    }

    public void printPlayerScores(){
        for (Player p : players){
            int score = p.getCurrentScore();
            System.out.format("| Player: %s      Score:  %d |", p.getName(), score);
        }
    }


    public void printFinalWins() {

        int mostWins = 0;
        String winnerName = null;

        for (Player p : players) {
            int wins = p.getWins();
            System.out.println(p.getName() + " won " + wins + " times");
            if (wins > mostWins) {
                mostWins = wins;
                winnerName = p.getName();
            }
        }

        Game.ui.output("The winner is " + winnerName);

    }

    //TODO with two equal high scores, the dealer is the winner
    //TODO otherwise a hand with 5 cards is the winner
    //TODO how else should ties be decided?

    public Player determineRoundWinner() {

        boolean everyoneBust = true;

        int maxScore = 0;

        Player winner = players.get(0);  //Assume first player is winner.. unless someone else is

        for (Player p : players) {
            //If there is a tie, the dealer wins
            //The dealer is the LAST players in allPlayers
            //So if we use >= then the dealer's will overwrite the other player
            //TODO make better use of isDealer flag

            int playerScore = p.getHandOfCards().getScoreClosestTo21();

            if (playerScore > 0) {
                //This player did not go bust
                everyoneBust = false;
            }

            if (playerScore >= maxScore) {
                maxScore = playerScore;
                winner = p;
            }

        }

        if (everyoneBust) {
            return null;
        }

        return winner;

    }

    public LinkedList<Player> getPlayersList() {
        return players;
    }
}