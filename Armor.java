package rpg.inventory.items;

import rpg.enums.ItemType;

public class Armor extends Item {
    private int defense;

    public Armor(String name, int value, int defense) {
        super(name, value); // Llama al constructor de la clase base Item
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public ItemType getType() {
        return ItemType.ARMOR; // Retorna el tipo de ítem
    }
}
