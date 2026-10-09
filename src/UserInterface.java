import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private Adventure adventure;

    public UserInterface() {
        this.adventure = new Adventure();

    }

    private void printCurrentRoom() {
        IO.println(adventure.getCurrentRoom());
        ArrayList<Item> items = adventure.getCurrentRoomItems();
        if (!items.isEmpty()) {
            IO.println("Here you see: " + itemsToString(items));
        }
        printEnemiesInRoom();
    }

    private void printEnemiesInRoom() {
        ArrayList<Enemy> enemy = adventure.getCurrentRoom().getEnemies();
        if (!enemy.isEmpty()) {
            IO.println("Here lurks " + enemyToString(enemy));
        }
    }

    private String itemsToString(ArrayList<Item> items) {
        String itemList = "";
        for (Item item : items) {
            if (!itemList.isEmpty()) {
                itemList += ", ";
            }
            itemList += item;
        }
        return itemList;
    }

    private String enemyToString(ArrayList<Enemy> enemies) {
        String enemyList = "";
        for (Enemy enemy : enemies) {
            if (!enemyList.isEmpty()) {
                enemyList += ", ";
            }
            enemyList += enemy.getEnemyLongName();
        }
        return enemyList;
    }

    private void move(String direction) {
        boolean moved = false;

        switch (direction) {
            case "north" -> moved = adventure.goNorth();
            case "south" -> moved = adventure.goSouth();
            case "east" -> moved = adventure.goEast();
            case "west" -> moved = adventure.goWest();
        }

        if (moved) {
            printCurrentRoom();

        } else {
            IO.println("You cannot go that way!");
        }
    }

    public void startGame() {
        boolean escapeRoomFinished = false;

        IO.println("Welcome to the escape room! \nYou have to find room 5 to survive and get out!");
        IO.println("Rules: You can move in directions: North, South, East and West...Just type e.g. 'north' or 'go north' to move north");
        IO.println("Extra commands are: \n'help' for help  \n'look' for current room position \n'health' for current health points \n'exit' for exiting the game (but why do that?) \n");

        String gameName = (IO.readln("What is your name player? "));
        adventure.setPlayerName(gameName);
        IO.println("hello " + adventure.getPlayerName() + " - Good luck finding your way out!");

        printCurrentRoom();


        while (!escapeRoomFinished) {

            IO.println("\nWhere do you want to go?");
            String playerMove = IO.readln().toLowerCase();
            String[] parts = playerMove.split(" ");
            String command = parts[0];
            String itemName = "";
            if (parts.length > 1) {
                itemName = parts[1];
            }

            switch (command) {

                case "go" -> {
                    move(itemName);
                }
                case "north" -> {
                    move("north");
                }

                case "south" -> {
                    move("south");
                }

                case "east" -> {
                    move("east");
                }

                case "west" -> {
                    move("west");
                }

                case "help" -> {
                    IO.println("You can only go 4 directions (north, south, east and west). You can pick up items by typing 'take' and name of the item. You can also drop an item in a room if you type 'drop' 'name of item'...\n If you're lost, type 'look' else type 'exit' to close program");
                }
                case "look" -> {
                    printCurrentRoom();
                }
                case "exit" -> {
                    IO.println("Hasta la vista " + adventure.getPlayerName());
                    escapeRoomFinished = true;
                }

                case "take" -> {
                    Item playerItem = adventure.takeItem(itemName);
                    if (playerItem == null) {
                        IO.println("There is nothing like " + itemName + " to take around here");
                    } else {
                        IO.println("You have taken " + playerItem.getLongName());
                    }
                }

                case "drop" -> {
                    Item playerItem = adventure.dropItem(itemName);
                    if (playerItem == null) {
                        IO.println("You do not possess " + itemName + " in your inventory.");
                    } else {
                        IO.println("You have dropped the " + playerItem.getLongName());
                    }
                }

                case "inventory", "inv", "invent" -> {

                    ArrayList<Item> inventory = adventure.getPlayerInventory();
                    if (inventory.isEmpty()) {
                        IO.println("You are not carrying anything");
                    } else {
                        IO.println("You are carrying: " + itemsToString(inventory));
                    }
                }

                case "health" -> {
                    int playerHealth = adventure.getPlayerHealth();
                    if (playerHealth >= 80) {
                        IO.println("health: " + playerHealth + " - you are in perfect health");
                    } else if (playerHealth >= 50) {
                        IO.println("health: " + playerHealth + " - you are ok, but need more energy!");
                    } else {
                        IO.println("health: " + playerHealth + " - You really need some more food NOW!");
                    }
                }

                case "eat" -> {
                    Item item = adventure.findItemAnywhere(itemName);
                    EatResult result = adventure.eatItem(itemName);
                    switch (result) {
                        case NOT_FOUND -> IO.println("There is nothing like " + itemName + " to eat around here");
                        case NOT_FOOD -> IO.println("You cannot eat " + item.getLongName());
                        case EATEN -> IO.println("You ate " + item.getLongName());
                        case DIED -> {
                            IO.println("You ate too much bad food and now are dead! GAME OVER");
                            escapeRoomFinished = true;
                        }
                    }
                }

                case "equip" -> {
                    Item item = adventure.findItemAnywhere(itemName);
                    EquipResult result = adventure.equipItem(itemName);
                    switch (result) {
                        case NOT_FOUND -> IO.println("You do not have " + itemName + " in your inventory");
                        case NOT_WEAPON -> IO.println("Your " + item.getLongName() + " is not a weapon!");
                        case EQUIPPED -> IO.println("You have equipped the " + item.getLongName());
                    }
                }

                case "attack" -> {
                    AttackResult remainingShots = adventure.attack(itemName);
                    int numberFromAttack = adventure.getRemainingShots();
                    switch (remainingShots) {
                        case NO_ENEMY -> IO.println("there is no enemy with that name");

                        case NO_WEAPON -> IO.println("You have no weapon equipped");

                        case NO_AMMO -> {
                            String weapon = adventure.getEquippedWeapon().getLongName();
                            IO.println("Your " + weapon + " have no ammunition");
                        }

                        case ATTACKED_AIR -> {
                            String weapon = adventure.getEquippedWeapon().getLongName();
                            //IO.println("You fire the " + weapon + " in the empty air");
                            if (numberFromAttack == -1) {
                                IO.println("You swing the " + weapon + " in the empty air");
                            } else if (numberFromAttack > -1) {
                                IO.println("You fire the " + weapon + " into the empty air. " + numberFromAttack + " shots left");
                            }
                        }

                        case ATTACKED -> {
                            String weapon = adventure.getEquippedWeapon().getLongName();
                            Enemy enemy = adventure.getEnemyHit();
                            IO.println("you used the " + weapon + " and hit the " + enemy.getEnemyLongName());
                            IO.println("The " + enemy.getEnemyLongName() + " used " + enemy.getWeapon() + " at you for " + enemy.getWeapon().getDamage());
                        }

                        case ENEMY_DIED -> {
                            String weapon = adventure.getEquippedWeapon().getLongName();
                            Enemy enemy = adventure.getEnemyHit();
                            IO.println("you used the " + weapon + " and hit the " + enemy.getEnemyLongName() + "\nthe " + enemy.getEnemyShortName() + " dies, dropping it's " + enemy.getWeapon().getLongName());
                        }

                        case PLAYER_DIED -> {
                            String weapon = adventure.getEquippedWeapon().getLongName();
                            Enemy enemy = adventure.getEnemyHit();
                            IO.println("you used the " + weapon + " and hit the " + enemy.getEnemyLongName());
                            IO.println("The " + enemy.getEnemyLongName() + " used " + enemy.getWeapon() + " at you for " + enemy.getWeapon().getDamage());
                            IO.println("You have lost all your healthPoints and are dead! - GAME OVER!");
                            escapeRoomFinished = true;
                        }
                    }
                }

                default -> {
                    IO.println("Unknown move, try again");
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
                        printCurrentRoom();
                    } else {
                        escapeRoomFinished = true;
                        IO.println("Goodbye " + adventure.getPlayerName());
                    }
                } else {
                    IO.println("Wrong answer, back to start!");
                    adventure.wrongAnswerMoveToStart();
                    printCurrentRoom();
                }

            }
        }

    }
}
