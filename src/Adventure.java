public class Adventure {

    private Room currentRoom;
    private Room winningRoom;
    private String correctAnswer;
    private Room startRoom;

    // ALL ROOMS AND DESCRIPTION
    public Adventure() {
        Room room1 = new Room("Room 1", "You are in the darkest room!");
        Room room2 = new Room("Room 2", "You are in the red room, be careful!");
        Room room3 = new Room("Room 3", "You are in the yellow room! lies await so guess careful");
        Room room4 = new Room("Room 4", "You are in the grey room! life is grey, so move on");
        Room room5 = new Room("Room 5", "You are close to finish but you must answer 1 question to pass: \n");
        Room room6 = new Room("Room 6", "You are in the purple room! You are tripping and far away");
        Room room7 = new Room("Room 7", "You are in the pink room! You are delusional, and scared");
        Room room8 = new Room("Room 8", "You are in the brown room! It's muddy but you sense something is close");
        Room room9 = new Room("Room 9", "You are in the orange room! when life makes you oranges do what? go back!");
        this.currentRoom = room1;
        this.winningRoom = room5;
        this.correctAnswer = "white";
        this.startRoom = room1;

    // ALL POSSIBLE DIRECTIONS IN THE ESCAPE-ROOM
        //ROOM 1:
        room1.setEast(room2);
        room1.setSouth(room4);
        //ROOM 2:
        room2.setWest(room1);
        room2.setEast(room3);
        //ROOM 3:
        room3.setWest(room2);
        room3.setSouth(room6);
        //ROOM 4:
        room4.setNorth(room1);
        room4.setSouth(room7);
        //ROOM 5:
        room5.setSouth(room8);
        //ROOM 6:
        room6.setNorth(room3);
        room6.setSouth(room9);
        //ROOM 7:
        room7.setNorth(room4);
        room7.setEast(room8);
        //ROOM 8:
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);
        //ROOM 9:
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean winningRoom5() {
        if (getCurrentRoom() == winningRoom) {
            return true;
        }
        return false;
    }


    //NAVIGATION
    public boolean goNorth() {
        Room north = currentRoom.getNorth();
        if (north == null) {
            return false;
        }
        currentRoom = north;
        return true;
    }

    public boolean goSouth() {
        Room south = currentRoom.getSouth();
        if (south == null) {
            return false;
        }
        currentRoom = south;
        return true;
    }

    public boolean goEast() {
        Room east = currentRoom.getEast();
        if (east == null) {
            return false;
        }
        currentRoom = east;
        return true;
    }

    public boolean goWest() {
        Room west = currentRoom.getWest();
        if (west == null) {
            return false;
        }
        currentRoom = west;
        return true;
    }

    public String questionToWin() {
        return "What colour is snow? ";
    }

    public boolean checkAnswer(String playerAnswer) {
        if(correctAnswer.equals(playerAnswer)) {
            return true;
        } return false;
    }

    public void wrongAnswerMoveToStart() {
        currentRoom = startRoom;
    }


}
