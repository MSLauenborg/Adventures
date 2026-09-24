public class UserInterface {

    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();

    }

    public void startGame() {
        boolean escapeRoomFinished = false;
        String notGoThatWay = "You cannot go that way";

        IO.println("Welcome to the escape room! \nYou have to find room 5 to survive and get out! If you don't make it in time, the game will end and you will die!!! ");
        IO.println("Rules: You can move in directions: North, South, East and West \njust type 'go north' to move north or 'go south' for south");
        IO.println("If you need help you can also type 'help', and if you want your current position repeated type 'look' \nif you wish to exit the game just type 'exit'\n");

        String gameName =(IO.readln("What is your name player? "));
        adventure.setPlayerName(gameName);
        IO.println("hello "+ adventure.getPlayerName());

        IO.println("Good luck finding your way out!");
        IO.println(adventure.getCurrentRoom());

        while (!escapeRoomFinished) {

            IO.println("\nWhere do you want to go?");
            String playerMove = IO.readln();

            switch (playerMove) {

                case "go north", "Go north", "north" -> {
                    if (adventure.goNorth()) {
                        IO.println(adventure.getCurrentRoom());
                    } else {
                        IO.println(notGoThatWay);
                    }
                }

                case "go south", "Go south", "south" -> {
                    if (adventure.goSouth()) {
                        IO.println(adventure.getCurrentRoom());
                    } else {
                        IO.println(notGoThatWay);
                    }
                }
                case "go east", "Go east", "east" -> {
                    if (adventure.goEast()) {
                        IO.println(adventure.getCurrentRoom());
                    } else {
                        IO.println(notGoThatWay);
                    }
                }
                case "go west", "Go west", "west" -> {
                    if (adventure.goWest()) {
                        IO.println(adventure.getCurrentRoom());
                    } else {
                        IO.println(notGoThatWay);
                    }
                }
                case "help" -> {
                    IO.println("You can only go 4 directions (north, south, east and west). If you're lost, type 'look' else type 'exit' to close program");
                }
                case "look" -> {
                    IO.println(adventure.getCurrentRoom());
                }
                case "exit" -> {
                    IO.println("Hasta la vista " + adventure.getPlayerName());
                    escapeRoomFinished = true;
                }
                default -> {
                    IO.println("unknown move, try again");
                }
            }
            //QUESTION TO SOLVE - IF USER GUESS WRONG, IT'S BACK TO ROOM 1 AND START OVER
            if (adventure.winningRoom5()) {
                String answerToWinOrFail = IO.readln(adventure.questionToWin());
                if (adventure.checkAnswer(answerToWinOrFail)) {
                    IO.println("Congratulations! You answered correctly and made it to room 5 - the White room with light");
                    String answer = IO.readln(adventure.getPlayerName() + " do you want to play again? (yes/no)");
                    if (answer.equals("yes")) {
                        String keepName = adventure.getPlayerName();
                        adventure = new Adventure();
                        adventure.setPlayerName(keepName);
                        IO.println(adventure.getCurrentRoom());
                    } else {
                        escapeRoomFinished = true;
                        IO.println("Goodbye " + adventure.getPlayerName());
                    }
                } else {
                    IO.println("Wrong answer, back to start!");
                    adventure.wrongAnswerMoveToStart();
                    IO.println(adventure.getCurrentRoom());
                }

            }
        }

    }
}
