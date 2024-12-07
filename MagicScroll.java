package rpg.inventory.items;

import rpg.enums.ItemType;

public class MagicScroll extends MiscItem {

    public MagicScroll() {
        super("Pergamino Mágico",20);
    }

    @Override
    public ItemType getType() {
        return ItemType.MISC; // Retorna el tipo de ítem
    }
}
