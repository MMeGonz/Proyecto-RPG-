package rpg.gui;

import rpg.entities.Game;
import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final Game game;
    private final Player player;
    private Enemy currentEnemy;

    private final JPanel mainPanel; // 'mainPanel' now marked as final
    private JLabel playerNameLabel, playerGoldLabel, enemyNameLabel;
    private JProgressBar playerHpBar, enemyHpBar;
    private JTextArea messageArea;

    public GameWindow(Game game) {
        this.game = game;
        this.player = game.getPlayer();
        this.currentEnemy = game.generateRandomEnemy();

        // Configurar la ventana
        setTitle("RPG Game - Combate");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        createStatusBar();
        createGamePanel();
        createActionBar();

        updateUI();

        setVisible(true);
    }

    private void createStatusBar() {
        JPanel statusBar = new JPanel(new GridLayout(1, 4));
        statusBar.setPreferredSize(new Dimension(1280, 50));
        statusBar.setBackground(Color.LIGHT_GRAY);

        playerNameLabel = new JLabel("Jugador: " + player.getName());
        playerGoldLabel = new JLabel("Oro: 0");
        playerHpBar = new JProgressBar(0, 100);
        playerHpBar.setValue(player.getStats().get(Stats.HP));
        playerHpBar.setString("HP: " + player.getStats().get(Stats.HP));
        playerHpBar.setStringPainted(true);

        statusBar.add(playerNameLabel);
        statusBar.add(playerHpBar);
        statusBar.add(playerGoldLabel);

        mainPanel.add(statusBar, BorderLayout.NORTH);
    }

    private void createGamePanel() {
        JPanel gamePanel = new JPanel(new BorderLayout());
        enemyHpBar = new JProgressBar(0, 100);
        enemyHpBar.setValue(currentEnemy.getStats().get(Stats.HP));
        enemyHpBar.setString("HP Enemigo: " + currentEnemy.getStats().get(Stats.HP));
        enemyHpBar.setStringPainted(true);

        enemyNameLabel = new JLabel("Enemigo: " + currentEnemy.getName(), SwingConstants.CENTER);
        enemyNameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(enemyHpBar, BorderLayout.NORTH);
        gamePanel.add(enemyNameLabel, BorderLayout.CENTER);

        mainPanel.add(gamePanel, BorderLayout.CENTER);
    }

    private void createActionBar() {
        JPanel actionBar = new JPanel(new FlowLayout());
        actionBar.setPreferredSize(new Dimension(1280, 100));
        actionBar.setBackground(Color.DARK_GRAY);

        JButton attackButton = new JButton("Atacar");
        JButton inventoryButton = new JButton("Inventario");
        JButton fleeButton = new JButton("Huir");

        messageArea = new JTextArea(3, 40);
        messageArea.setEditable(false);
        JScrollPane messageScrollPane = new JScrollPane(messageArea);

        actionBar.add(attackButton);
        actionBar.add(inventoryButton);
        actionBar.add(fleeButton);
        actionBar.add(messageScrollPane);

        mainPanel.add(actionBar, BorderLayout.SOUTH);

        // Eliminamos el parámetro 'e' en el ActionListener, ya que no se utiliza.
        attackButton.addActionListener(e -> handleAttack());
        inventoryButton.addActionListener(e -> handleInventory());
        fleeButton.addActionListener(e -> handleFlee());
    }

    private void updateUI() {
        playerHpBar.setValue(player.getStats().get(Stats.HP));
        playerHpBar.setString("HP: " + player.getStats().get(Stats.HP) + "/" + player.getStats().get(Stats.MAX_HP));

        enemyHpBar.setValue(currentEnemy.getStats().get(Stats.HP));
        enemyHpBar.setString("HP Enemigo: " + currentEnemy.getStats().get(Stats.HP));

        playerNameLabel.setText("Jugador: " + player.getName());
        playerGoldLabel.setText("Oro: " + player.getInventory().getItems().size());
        enemyNameLabel.setText("Enemigo: " + currentEnemy.getName());
    }

    private void handleAttack() {
        player.attack(currentEnemy);
        if (!currentEnemy.isAlive()) {
            messageArea.append("¡Derrotaste a " + currentEnemy.getName() + "!\n");
            player.collectLoot(currentEnemy.getLoot());
            currentEnemy = game.generateRandomEnemy();
        } else {
            currentEnemy.attack(player);
            if (!player.isAlive()) {
                gameOver();
            }
        }
        updateUI();
    }

    private void handleInventory() {
        // Usamos showInventoryString() en lugar de showInventory()
        JOptionPane.showMessageDialog(this, player.getInventory().showInventoryString(),
                "Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleFlee() {
        messageArea.append("¡Huiste del combate contra " + currentEnemy.getName() + "!\n");
        currentEnemy = game.generateRandomEnemy();
        updateUI();
    }

    private void gameOver() {
        int choice = JOptionPane.showConfirmDialog(this, "Has perdido. ¿Quieres reiniciar?", "Game Over",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            player.resetStats();
            currentEnemy = game.generateRandomEnemy();
            updateUI();
        } else {
            System.exit(0);
        }
    }
}