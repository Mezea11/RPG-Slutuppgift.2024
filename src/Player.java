public class Player {
    private String name;
    private int health;
    private int mana;
    private int max_HP;
    private int max_Mana;
    private int gold;
    private Inventory inventory;
    private Weapon weapon;
    private Armor armor;
    private Item item;
    private Consumable consumable;

    // CONSTRUCTOR
    Player(String name, int health, int mana, int max_HP, int max_Mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.max_HP = max_HP;
        this.max_Mana = max_Mana;
        this.inventory = new Inventory();
        this.weapon = null;
        this.armor = null;
        this.consumable = null;
        this.gold = gold;
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getMax_HP() {
        return max_HP;
    }

    public int getMax_Mana() {
        return max_Mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Consumable getConsumable() {
        return consumable;
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
                ", Armor: " + armorName +
                ", Gold: " + gold;
    }
}
