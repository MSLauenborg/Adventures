import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String name;
    private ArrayList<Item> inventory;
    private int health;

    public Player(Room startRoom) {
        this.inventory = new ArrayList<>();
        this.currentRoom = startRoom;
        this.health = 60;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setName(String name) {
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

    public ArrayList<Item> getCurrentRoomItems() {
        return getCurrentRoom().getItems();
    }

    public Item findItemAnywhere(String shortName) {
        Item item = findItem(shortName);
        if (item == null) {
            item = currentRoom.findItem(shortName);
        }
        return item;
    }

    public EatResult eatItem(String shortName) {
        Item item = findItemAnywhere(shortName);
        if (item == null) {
            return EatResult.NOT_FOUND;
        }
        if (!(item instanceof Food)) {
            return EatResult.NOT_FOOD;
        }
        Food food = (Food) item;
        health += food.getHealthPoints();
        inventory.remove(item);
        currentRoom.removeItem(item);
        return EatResult.EATEN;
    }


//METHODS FOR HANDLING ITEMS:

    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item == null) {
            return null;
        }
        currentRoom.removeItem(item);
        inventory.add(item);
        return item;
    }

    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }


    public Item dropItem(String shortName) {
        Item item = findItem(shortName);
        if (findItem(shortName) == null) {
            return null;
        }
        currentRoom.addItem(item);
        inventory.remove(item);
        return item;
    }


//NAVIGATION METHODS:

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
