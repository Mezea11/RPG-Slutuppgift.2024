import java.util.Scanner;
public class Shop {
    Player player;
    Scanner sc = new Scanner(System.in);

    public void inventoryShop() {
        System.out.println("Welcome " + player.getName() + " to the shop.");
        System.out.println("Enter name of item you wish to sell: ");
        for (Item item : player.getInventory().getItems()){
            System.out.println(item.getItemName());
        }
        String sellItem = sc.nextLine();

        //Loop through inventory to sell item
        Item itemToSell = null;
        for (Item item : player.getInventory().getItems()){
            if(item.getItemName().equalsIgnoreCase(sellItem)){
                itemToSell = item;
                break;
            }
        }

        if (itemToSell != null) {
            player.getInventory().sellItem(itemToSell);
            player.setGold(player.getGold() + itemToSell.getItemValue());

            System.out.println("You sold " + itemToSell.getItemName() + " for " + itemToSell.getItemValue() + " gold.");
            System.out.println("Your current gold: " + player.getGold());
        } else {
            System.out.println("Item not found in inventory.");
        }
    }
}
