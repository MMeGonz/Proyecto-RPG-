package rpg.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel, statusBar;
    private JButton button1, button2, button3;

    public MainWindow() {
        setTitle("RPG Game");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear panel principal con BorderLayout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Panel de la barra de estado
        statusBar = new JPanel(new GridBagLayout());
        statusBar.setPreferredSize(new Dimension(1280,720));
        statusBar.setBackground(Color.LIGHT_GRAY);

        // Configuración de GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Margen entre los componentes

        // Imagen del jugador
        JLabel playerImageLabel = new JLabel(new ImageIcon("ruta/de/la/imagen/playerImage.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;  // Ocupa dos filas
        gbc.anchor = GridBagConstraints.WEST;
        statusBar.add(playerImageLabel, gbc);

        // Etiquetas de nivel y estado (Label a la izquierda)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        statusBar.add(new JLabel("Label 1"), gbc);

        gbc.gridy = 1;
        statusBar.add(new JLabel("Label 2"), gbc);

        // Botones a la derecha
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0;  // Empuja los botones a la derecha
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Ocupa espacio horizontal disponible

        // Panel para agrupar los botones y alinearlos
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10)); // FlowLayout alineado a la derecha
        button1 = new JButton("Botón 1", new ImageIcon("ruta/de/la/imagen/icon1.png"));
        button2 = new JButton("Tienda", new ImageIcon("ruta/de/la/imagen/shopIcon.png"));
        button3 = new JButton("Inventario", new ImageIcon("ruta/de/la/imagen/inventoryIcon.png"));

        // Agregar botones al panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Agregar el panel de botones al statusBar
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        statusBar.add(buttonPanel, gbc);

        // Agregar barra de estado a la parte superior
        mainPanel.add(statusBar, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
