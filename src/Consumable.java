public class Consumable extends Item implements Usable {
    private Player player;
    private Inventory inventory;
    private String type;
    private int effectAmount;

    public Consumable(String name, int weight, int value, String type, int effectAmount) {
        super(name, weight, value);
        this.effectAmount = effectAmount;
        this.type = type;
    }

    // Constructor with player
    public Consumable(String name, int weight, int value, Player player, String type, int effectAmount) {
        super(name, weight, value);
        this.player = player;
        this.effectAmount = effectAmount;
        this.type = type;
    }

    @Override
    public void use() {
        if (player == null) {
            System.out.println("No player associated with this consumable.");
            return;
        }

        // Health potion use
        if (type.equalsIgnoreCase("Health potion")) {
            int initialHealth = player.getHealth();
            int newHealth = initialHealth + effectAmount;

            if (newHealth > player.getMax_HP()) {
                newHealth = player.getMax_HP();
            }

            int restoredHealth = newHealth - initialHealth;
            player.setHealth(newHealth);
            System.out.println("You used a health potion and restored " + restoredHealth + " health points. Current health: " + player.getHealth());

            // Mana potion use
        } else if (type.equalsIgnoreCase("Mana potion")) {
            int initialMana = player.getMana();
            int newMana = initialMana + effectAmount;

            if (newMana > player.getMax_Mana()) {
                newMana = player.getMax_Mana();
            }

            int restoredMana = newMana - initialMana;
            player.setMana(newMana);
            System.out.println("You used a mana potion and restored " + restoredMana + " mana points. Current mana: " + player.getMana());
        }

        // Remove the consumable after use
        player.getInventory().removeItem(this.getItemName());
    }

    @Override
    public String toString() {
        return super.toString() + ", Item Type: Consumable";
    }
}
