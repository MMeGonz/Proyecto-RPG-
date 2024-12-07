package rpg.inventory;

import rpg.inventory.items.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items; // Devuelve la lista de ítems en el inventario
    }

    public void addItem(Item item) {
        items.add(item); // Añadir un ítem al inventario
    }

    public String showInventoryString() {
        StringBuilder inventoryString = new StringBuilder("Inventario:\n");
        for (Item item : items) {
            inventoryString.append("- ").append(item.getName()).append(" (").append(item.getType()).append(")\n");
        }
        return inventoryString.toString();
    }
}