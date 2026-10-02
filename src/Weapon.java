public abstract class Weapon extends Item{

    public Weapon(String shortName, String longName) {
        super(shortName, longName);
    }

    public abstract boolean canUse();
    public abstract int use();
}
