package rpg.entities.enemies;

import rpg.enums.Stats;
import rpg.inventory.items.Item;
import rpg.inventory.items.MiscItem;

public class Lich extends Enemy {
    public Lich() {
        super("Lich");
        stats.put(Stats.MAX_HP, 120);
        stats.put(Stats.HP, 120);
        stats.put(Stats.ATTACK, 18);
        stats.put(Stats.DEFENSE, 7);
    }

    @Override
    public Item getLoot() {
        return new MiscItem("Lich's Tome", 25);
    }
}
