package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.enums.Stats;
import rpg.inventory.items.Item;

public abstract class Enemy extends GameCharacter {

    public Enemy(String name) {
        super(name);
        initCharacter();
    }

    @Override
    public void initCharacter() {
        stats.put(Stats.HP, 50);  // Valor base, cada enemigo puede sobrescribirlo
        stats.put(Stats.ATTACK, 5);  // Valor base
        stats.put(Stats.DEFENSE, 2);  // Valor base
    }

    // Método abstracto para que cada enemigo específico tenga su propio loot
    public abstract Item getLoot();
}
