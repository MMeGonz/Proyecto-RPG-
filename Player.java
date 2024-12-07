package rpg.entities;

import rpg.inventory.Inventory;
import rpg.inventory.items.Item;
import rpg.enums.Stats;

public class Player extends GameCharacter {
    private Inventory inventory;

    public Player(String name) {
        super(name);
        this.inventory = new Inventory();
        initCharacter();
    }

    @Override
    public void initCharacter() {
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
    }

    // Método para restablecer las estadísticas después de ser derrotado
    public void resetStats() {
        stats.put(Stats.HP, stats.get(Stats.MAX_HP));  // Restablecer la HP a su valor máximo
        System.out.println("Te has recuperado, pero mantienes tu nombre y fuerza.");
    }

    public void increaseStrength() {
        stats.put(Stats.ATTACK, stats.get(Stats.ATTACK) + 5);
        System.out.println("¡Has ganado fuerza! Tu ataque es ahora: " + stats.get(Stats.ATTACK));
    }

    public void collectLoot(Item loot) {
        inventory.addItem(loot);
        System.out.println("Has obtenido: " + loot.getName());
    }

    public Inventory getInventory() {
        return inventory;
    }
}
