package rpg.inventory.items;

import rpg.enums.ItemType;

public class HealingPotion extends MiscItem {

    public HealingPotion() {
        super("Poción de Curación",25);
    }

    @Override
    public ItemType getType() {
        return ItemType.MISC; // Retorna el tipo de ítem
    }
}
