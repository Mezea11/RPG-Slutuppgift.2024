import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    Player player;
    Item item;

    public void GameMenu() {

        while(running) {
            System.out.println("Enter your player name: ");
            String playerName = sc.nextLine();
            player = new Player(playerName, 100, 50, 150, 100);
            System.out.println("Welcome to Dungeons and Dragons.");
            System.out.println("Choose between options:");
            System.out.println("1. Start game");
            System.out.println("2. Exit game");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    clearConsole();
                    startGame();
                    break;

                case 2:
                    System.out.println("Exiting game...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        sc.close();
        System.out.println("You have exited the game.");
    }

    public void startGame() {
        System.out.println("Welcome " + player.getName() + "!");
        System.out.println("Choose between options:");

        while(true) {
            System.out.println("1. Check inventory");
            System.out.println("2. Create item");
            System.out.println("3. Remove item");
            System.out.println("4. Create weapon");
            System.out.println("5. Equip weapon");
            System.out.println("6. Create armor");
            System.out.println("7. Equip armor");
            System.out.println("8. Player stats:");
            System.out.println("9. Exit");
            int playerChoice = sc.nextInt();
            sc.nextLine();
            switch(playerChoice) {
                case 1:
                    player.getInventory().showItems(toString());
                    break;
                case 2:
                    createItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    createWeapon();
                    break;
                case 5:
                    equipWeapon();
                    break;
                case 6:
                    createArmor();
                    break;
                case 7:
                    equipArmor();
                    break;
                case 8:
                    System.out.println("Player stats: ");
                    System.out.println(player);
                    
                    break;
                case 9:
                    System.out.println("Exiting to main menu...");
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    public void createItem() {
        System.out.println("Enter name of the item you want to add: ");
        String itemName = sc.nextLine(); // Read item name

        System.out.println("Enter weight of the item you want to add: ");
        int itemWeight = sc.nextInt();  // Read item weight
        sc.nextLine();

        System.out.println("Enter value of the item you want to add: ");
        int itemValue = sc.nextInt();  // Read item value
        sc.nextLine();

        player.getInventory().addItem(new Item(itemName, itemWeight, itemValue));
    }

    public void removeItem() {
        player.getInventory().showItems(toString());
        System.out.println("Enter name of item you wish to remove: ");
        String removeItem = sc.nextLine();

        player.getInventory().removeItem(removeItem);
    }

    public void createArmor() {
        System.out.println("Enter name of the armor you want to add: ");
        String armorName = sc.nextLine(); // Read item name

        System.out.println("Enter weight of the armor you want to add: ");
        int armorWeight = sc.nextInt();  // Read item weight
        sc.nextLine();

        System.out.println("Enter value of the armor you want to add: ");
        int armorValue = sc.nextInt();  // Read item value
        sc.nextLine();

        Armor armor = new Armor(armorName, armorWeight, armorValue, player);
        player.getInventory().addArmor(armor);  // Add the weapon to the player's inventory
    }


    public void createWeapon() {
        System.out.println("Enter name of the weapon you want to add: ");
        String weaponName = sc.nextLine(); // Read item name

        System.out.println("Enter weight of the item you want to add: ");
        int weaponWeight = sc.nextInt();  // Read item weight
        sc.nextLine();

        System.out.println("Enter value of the item you want to add: ");
        int weaponValue = sc.nextInt();  // Read item value
        sc.nextLine();

        Weapon weapon = new Weapon(weaponName, weaponWeight, weaponValue, player);
        player.getInventory().addWeapon(weapon);  // Add the weapon to the player's inventory
    }

    public void equipWeapon() {
        System.out.println("Enter name of the weapon you wish to equip: ");
        String equipItem = sc.nextLine();
        for (Item item : player.getInventory().getItems()) { // Loop through items list and players inventory
            if (item instanceof Weapon && item.getItemName().equalsIgnoreCase(equipItem)) {
                Weapon weapon = (Weapon) item;
                weapon.equip();
                return;
            }
        }
        System.out.println("Weapon not found.");
    }


    public void equipArmor() {
        System.out.println("Enter name of the armor you wish to equip: ");
        String equipArmor = sc.nextLine();
        for (Item item : player.getInventory().getItems()) { // Loop through items list and players inventory
            if (item instanceof Armor && item.getItemName().equalsIgnoreCase(equipArmor)) {
                Armor armor = (Armor) item;
                armor.equip();
                return;
            }
        }
        System.out.println("Armor not found.");
    }


    // Prints 8 empty lines when invoked to "clear" console.
    public void clearConsole() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
        }
    }


}
