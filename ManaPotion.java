package rpg.inventory.items;

import rpg.enums.ItemType;

public class ManaPotion extends MiscItem {

    public ManaPotion() {
        super("Poción de Maná",10);
    }

    @Override
    public ItemType getType() {
        return ItemType.MISC; // Retorna el tipo de ítem
    }
}
