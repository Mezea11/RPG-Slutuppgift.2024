import java.util.ArrayList;
import java.util.List;

public class Armor extends Item implements Equip {
    private Player player;
    private List<Item> armor;  // Use List<Item> if you want to store generic items, otherwise List<Armor> for only armor items

    // Constructor
    public Armor(String name, int weight, int value) {
        super(name, weight, value);
        this.armor = new ArrayList<>();  // Initialize the armor list
    }

    // Constructor with Player
    public Armor(String name, int weight, int value, Player player) {
        super(name, weight, value);
        this.player = player;
        this.armor = new ArrayList<>();  // Initialize the armor list
    }

    // Method to add armor to the list
    public void addArmor(Armor armorItem) {
        armor.add(armorItem);  // Add the armor item passed to the method
        System.out.println(armorItem.getItemName() + " has been added to your armor storage.");
    }

    @Override
    public void equip() {
        if (player.getArmor() != null) {
            System.out.println("Unequipping " + player.getArmor().getItemName() + " before equipping " + getItemName() + ".");
            player.getArmor().unequip();
        }
        player.setArmor(this);
        System.out.println(getItemName() + " has been equipped.");
    }

    @Override
    public void unequip() {
        if (player.getArmor() == this) {
            System.out.println(getItemName() + " has been unequipped.");
        } else {
            System.out.println("No armor to unequip.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Item Type: Armor";
    }

}
