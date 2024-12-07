package rpg.entities.enemies;

import rpg.enums.Stats;
import rpg.inventory.items.Item;
import rpg.inventory.items.MiscItem;

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin");
        stats.put(Stats.MAX_HP, 50);
        stats.put(Stats.HP, 50);
        stats.put(Stats.ATTACK, 8);
        stats.put(Stats.DEFENSE, 2);
    }

    @Override
    public Item getLoot() {
        return new MiscItem("Goblin's Gold", 5);
    }
}
