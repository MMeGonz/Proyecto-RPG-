package rpg.entities.enemies;

import rpg.enums.Stats;
import rpg.inventory.items.Item;
import rpg.inventory.items.MiscItem;

public class Dragon extends Enemy {
    public Dragon() {
        super("Dragón");
        stats.put(Stats.MAX_HP, 150);
        stats.put(Stats.HP, 150);
        stats.put(Stats.ATTACK, 20);
        stats.put(Stats.DEFENSE, 10);
    }

    @Override
    public Item getLoot() {
        return new MiscItem("Dragon's Scale", 20);
    }
}
