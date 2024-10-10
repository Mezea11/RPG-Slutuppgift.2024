public class Item {
    private String name;
    private int weight;
    private int value;

    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getItemName() {
        return name;
    }
    public void setItemName(String name) {
        this.name = name;
    }

    public int getItemValue() {
        return value;
    }

    public void setItemValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Item name: " + name + ", weight: " + weight + ", value: " + value;
    }

}
