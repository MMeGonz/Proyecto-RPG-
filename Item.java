package rpg.inventory.items;

import rpg.enums.ItemType;

public abstract class Item {
    private String name;
    private int value; // Valor del ítem

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    // Método abstracto para obtener el tipo de item
    public abstract ItemType getType();
}
