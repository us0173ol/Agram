package com.patrick;

public class Game {
    final static int MAX_CARDS_IN_HAND = 6; //variable in Hand and Player
    final static int MAX_TRICKS = 6
    int current_trick = 0;

    static UI ui;

    public static void main(String[] args) {

        createUI();

        Game game = new Game();
        game.play();

        UI.close();

    }

    public static void createUI() {
        ui = new UI();
    }

    private void play() {

        //Can modify this to add more human players and computer players if needed

        PlayerManager playerManager = new PlayerManager();
        String number_of_players_prompt = "How many new players?\nMax of 5 players. ";
        ui.input(number_of_players_prompt);
        //TODO: validate input for integers only and 2 to 5 players.
        int number_of_players = ui.numInput(number_of_players_prompt);
        //for loop over 'number_of_pllayers' til we get to last player.
        //in the loop each player gets a name from ui.input.
        //each player gets a name from player_name = ui.input(player_name_prompt) make a String player_name_prompt.
        //make humanplayer object.
        //humanplayer is added to playerManager.addd(player)
//		playerManager.add(human);      // TODO If you want to play too, uncomment this line
//		playerManager.add(human2);     // And uncomment this if you want to add another human


        boolean playAgain = true;
        String anotherRound;
        //TODO: make outer while loop for playing more games of Agram.
        //new deck, collections.shuffle(playerManager.players)
        //reset all before new game.
        while (current_trick < 6) {
            playerManager.oneTrick();
            current_trick ++;
            //start trick from playermanager.

            Round round = new Round(playerManager);
            round.play();
            playerManager.printWins();

            anotherRound = ui.input("Another hand? n to quit, anything else to continue... ");

            playAgain = !anotherRound.equals("n");   // another.equals("n") returns a boolean

            //rotate the dealer, so everyone gets turns to be the dealer.


        }

        playerManager.printFinalWins();
    }
}