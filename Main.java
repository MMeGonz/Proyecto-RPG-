package rpg;

import rpg.entities.Game;
import rpg.gui.GameWindow;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(); // Crear instancia del juego
        game.startGame();
        new GameWindow(game);  // Pasar el objeto Game a la ventana gráfica
    }
}

