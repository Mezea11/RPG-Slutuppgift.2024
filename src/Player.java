public class Player {
    private String name;
    private int health;
    private int mana;
    private int max_HP;
    private int max_Mana;
    private Inventory inventory;
    private Weapon weapon;
    private Armor armor;
    private Item item;

    // CONSTRUCTOR
    Player(String name, int health, int mana, int max_HP, int max_Mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.max_HP = max_HP;
        this.max_Mana = max_Mana;
        this.inventory = new Inventory();
        this.weapon = null;
        this.armor = null;
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        String weaponName = (weapon != null) ? weapon.getItemName() : "No weapon equipped";
        String armorName = (armor != null) ? armor.getItemName() : "No armor equipped";

        return "Player name: " + name +
                ", Health: " + health +
                ", Mana: " + mana +
                ", Weapon: " + weaponName +
                ", Armor: " + armorName;
    }
}
