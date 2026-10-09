import java.util.ArrayList;

public class Enemy {
    private String shortName;
    private String longName;
    private String description;
    private Weapon weapon;
    private int health;
    private Room currentRoom;

    public Enemy(String shortName, String longName, String description, Weapon weapon, int health, Room currentRoom) {
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.weapon = weapon;
        this.health = health;
        this.currentRoom = currentRoom;
    }


    public String getEnemyLongName() {
        return longName;
    }

    public String getEnemyShortName() {
        return shortName;
    }

    public boolean hit(int damage) {
        health -= damage;
        if (health <= 0) {
            currentRoom.addItem(weapon);
            currentRoom.removeEnemy(this);
            return true;
        }
        return false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}