package rpg.entities.enemies;

import rpg.enums.Stats;
import rpg.inventory.items.Item;
import rpg.inventory.items.MiscItem;

public class Demon extends Enemy {
    public Demon() {
        super("Demonio");
        stats.put(Stats.MAX_HP, 80);
        stats.put(Stats.HP, 80);
        stats.put(Stats.ATTACK, 15);
        stats.put(Stats.DEFENSE, 3);
    }

    @Override
    public Item getLoot() {
        return new MiscItem("Demon's Horn", 10);
    }
}
