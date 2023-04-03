package src.Interface;

/* Imports */
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame implements KeyListener, ActionListener {
    /* Atributos */
    private JPanel mainPanel;
    private JPanel messagePanel;
    private JTextArea messageInput;
    private JButton messageButton;
    private JScrollPane scrollChat;
    private JTextArea currentMessage;

    // Construtor
    public Interface() {
        // Config basica
        this.setSize(new Dimension(400, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chat");
        this.setLocationRelativeTo(null);

        // Painel principal
        mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(400, 800));
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(null);

        // Painel de escrita das mensagens
        messagePanel = new JPanel();
        messagePanel.setBounds(15, 705, 350, 45);
        messagePanel.setBackground(Color.GRAY);
        messagePanel.setLayout(null);

        // Caixa de entrada da mensagem
        messageInput = new JTextArea();
        messageInput.setBounds(10, 10, 250, 20);
        messageInput.addKeyListener(this);

        // Botão de enviar
        messageButton = new JButton("Send");
        messageButton.setBounds(270, 10, 65, 20);
        messageButton.addActionListener(this);

        // Caixa de exibição da mensagem enviada
        currentMessage = new JTextArea();
        currentMessage.setEditable(false);
        currentMessage.setBackground(Color.GRAY);
        currentMessage.setFont(new Font("Arial", Font.BOLD, 13));
        currentMessage.setForeground(Color.BLUE);

        // Chat de fato
        scrollChat = new JScrollPane(currentMessage);
        scrollChat.setBounds(15, 10, 350, 680);
        scrollChat.getViewport().setBackground(Color.GRAY);
        scrollChat.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollChat.getHorizontalScrollBar().setBackground(Color.BLACK);

        messagePanel.add(messageButton);
        messagePanel.add(messageInput);
        mainPanel.add(scrollChat);
        mainPanel.add(messagePanel);

        this.add(mainPanel);
        this.setVisible(true);
    }

    // Função de escrita no scroll
    public void write(String message) {
        currentMessage.append(message + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.messageButton) {
            try {
                String message = messageInput.getText();
                write(message);

                // Limpa caixa de texto
                messageInput.setText("");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        // Se a tecla pressionada for enter envia a mensagem
        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String message = messageInput.getText();
                write(message);

                // Limpa caixa de texto
                messageInput.setText("");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Não precisa da implementação
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não precisa da implementação
    }

    public static void main(String[] args) {
        Interface i = new Interface();
    }
}