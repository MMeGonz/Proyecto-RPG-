package rpg.utils;

import rpg.entities.enemies.Demon;
import rpg.entities.enemies.Dragon;
import rpg.entities.enemies.Ent;
import rpg.entities.enemies.Goblin;
import rpg.entities.enemies.Lich;
import rpg.entities.enemies.Enemy;

import java.util.Random;

public class Randomize {
    private static Random random = new Random();

    public static Enemy getRandomEnemy() {
        int enemyType = random.nextInt(5); // Cambia el rango según el número de enemigos
        switch (enemyType) {
            case 0:
                return new Demon();
            case 1:
                return new Dragon();
            case 2:
                return new Ent();
            case 3:
                return new Goblin();
            case 4:
                return new Lich();
            default:
                return null; // Esto no debería suceder
        }
    }
}
