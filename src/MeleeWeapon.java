public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName) {
        super(shortName, longName);
    }

    @Override
    public boolean canUse() {
        return true;

    }

    @Override
    public int use() {
        return -1;
    }
}
