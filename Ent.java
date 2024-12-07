package rpg.entities.enemies;

import rpg.enums.Stats;
import rpg.inventory.items.Item;
import rpg.inventory.items.MiscItem;

public class Ent extends Enemy {
    public Ent() {
        super("Ent");
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.ATTACK, 12);
        stats.put(Stats.DEFENSE, 5);
    }

    @Override
    public Item getLoot() {
        return new MiscItem("Ent's Leaf", 15);
    }
}
