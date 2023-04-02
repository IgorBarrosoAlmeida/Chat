package src.Interface;

/* Imports */
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame implements KeyListener, ActionListener {
    /* Atributos */
    private static JFrame mainWindow = new JFrame("Chat");
    private static JPanel writeArea = new JPanel();
    private static JTextField input = new JTextField(20);
    private static JButton sendButton = new JButton("Send");

    public static void main(String[] args) {

        mainWindow.setSize(new Dimension(400, 800));

        // Painel
        writeArea.setSize(new Dimension(400, 800));
        input.setSize(new Dimension(100, 300));
        input.setBackground(Color.WHITE);
        // font collor
        input.setForeground(Color.DARK_GRAY);
        writeArea.setBackground(Color.GRAY);
        sendButton.setLocation(300, 300);

        writeArea.add(input, BorderLayout.WEST);
        writeArea.add(sendButton, BorderLayout.EAST);
        mainWindow.add(writeArea, BorderLayout.SOUTH);

        input.setVisible(true);
        writeArea.setVisible(true);
        mainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

}