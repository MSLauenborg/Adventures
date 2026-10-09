import java.util.ArrayList;

public class Room {

    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }



    public Enemy findEnemy(String enemyShortName) {
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyShortName().equals(enemyShortName)) {
                return enemy;
            }
        }
        return null;
    }

    public Item findItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }

    //ALL DIRECTIONS WITH GET AND SET

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    @Override
    public String toString() {
        return (name + " - " + description);
    }
}


