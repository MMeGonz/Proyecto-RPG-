package rpg.entities;

import rpg.entities.enemies.Enemy;
import java.util.Scanner;
import rpg.utils.Randomize;
import rpg.inventory.items.Item;

public class Game {

    private static Scanner scanner = new Scanner(System.in);
    private Player player;

    public void startGame() {
        System.out.print("Ingresa el nombre de tu personaje: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        boolean playing = true;

        while (playing) {
            Enemy enemy = generateRandomEnemy();
            System.out.println("Te enfrentas a un " + enemy.getName());

            while (player.isAlive() && enemy.isAlive()) {
                player.attack(enemy);
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (!player.isAlive()) {
                System.out.println("¡Has sido derrotado!");
                System.out.print("¿Quieres jugar de nuevo? (si/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("si")) {
                    player.resetStats();  // Restablecer los stats del jugador sin cambiar su nombre
                } else {
                    playing = false;
                }
            } else {
                System.out.println("¡Has derrotado al " + enemy.getName() + "!");
                player.collectLoot(enemy.getLoot());  // El jugador recoge el loot
                player.increaseStrength();  // Incrementar la fuerza del jugador al ganar
                System.out.print("¿Quieres ver tu inventario? (si/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("si")) {
                    player.getInventory().showInventoryString();  // Mostrar el inventario del jugador
                }
            }
        }
    }

    public Player getPlayer() {
        return player; // Devuelve la instancia del jugador
    }

    public Enemy generateRandomEnemy() {
        return Randomize.getRandomEnemy(); // Genera un enemigo aleatorio
    }


}
