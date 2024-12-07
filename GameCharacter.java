package rpg.entities;

import rpg.enums.Stats;

import java.util.HashMap;

public abstract class GameCharacter {
    protected String name;
    protected HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public abstract void initCharacter();

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {
        if (isAlive()) {
            int damage = stats.get(Stats.ATTACK) - enemy.stats.get(Stats.DEFENSE);
            damage = Math.max(damage, 0); // Asegura que el daño no sea negativo
            enemy.stats.put(Stats.HP, Math.max(0, enemy.stats.get(Stats.HP) - damage));
            System.out.println(name + " atacó a " + enemy.name + " y causó " + damage + " de daño.");
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
