package rpg.inventory.items;

import rpg.enums.ItemType;

public class GoldCoin extends MiscItem {

    public GoldCoin() {
        super("Moneda de Oro",30);
    }

    @Override
    public ItemType getType() {
        return ItemType.MISC; // Retorna el tipo de ítem
    }
}
