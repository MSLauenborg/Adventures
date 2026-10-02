public class RangedWeapon extends Weapon {

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int ammunition) {
        super(shortName, longName);
        this.ammunition = ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public int use() {
        this.ammunition -= 1;
        return ammunition;
    }


}
