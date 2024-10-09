import java.util.ArrayList;
import java.util.List;

public class Weapon extends Item implements Equip{
    private Player player;
    private List<Item> weapons;


    public Weapon(String name, int weight, int value) {
        super(name, weight, value);
    }

    public Weapon (String name, int weight, int value, Player player) {
        super(name, weight, value);
        this.player = player;
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
        System.out.println(weapon.getItemName() + " has been added to your weapon arsenal.");
    }

    @Override
    public void equip() {
        if (player.getWeapon() != null) {
            System.out.println("Unequipping" + player.getWeapon().getItemName() + "before equipping" + getItemName() + ".");
            player.getWeapon().unequip();
        }
        player.setWeapon(this);
        System.out.println(getItemName() + " has been equipped.");
    }

    @Override
    public void unequip() {
        if (player.getWeapon() == this) {
            System.out.println(getItemName() + " has been unequipped.");
        } else {
            System.out.println("No weapon to unequip.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Item Type: Weapon";
    }

}
