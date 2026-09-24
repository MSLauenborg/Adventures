public class Player {
    private Room currentRoom;
    private String name;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveTo(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
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


}
