import java.util.List;
import java.util.ArrayList;

class Inventory  {
    private List<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
        System.out.println(item.getItemName() + " has been added to your inventory.");
    }

    public void removeItem(String itemName){
        Item itemToRemove = null;
        for(Item item : items) {
            if(item.getItemName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                System.out.println("Item has been removed from the inventory.");
                break;
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
        } else {
            System.out.println("No item with that name exists.");
        }
    }

    public void showItems(String string){
        for(Item item : items){
            System.out.println(item);
        }
    }

    public void addWeapon(Weapon weapon) {
        items.add(weapon);
        System.out.println(weapon.getItemName() + " has been added to your weapon arsenal.");
        
    }

    public void addArmor(Armor armor) {
        items.add(armor);
        System.out.println(armor.getItemName() + " has been added to your armor storage.");
    }

    @Override
    public String toString() {
        return items.toString();
    }

    // RETURN LIST OF ITEMS IN INVENTORY!!!
    public List<Item> getItems() {
        return items;
    }


}
