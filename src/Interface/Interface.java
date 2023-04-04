package src.Interface;

/* Imports */
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import src.logica.*;

public class Interface extends JFrame implements KeyListener, ActionListener {
    // Atributos
    private JPanel mainPanel;
    private JPanel messagePanel;
    private JTextArea messageInput;
    private JButton messageButton;
    private JScrollPane scrollChat;
    private JTextArea currentMessage;

    private Cliente cliente;
    private PrintStream output;

    // Construtor
    public Interface(Cliente cliente) {
        this.cliente = cliente;
        try {
            output = new PrintStream(this.cliente.getClienteSocket().getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Config basica
        this.setSize(new Dimension(400, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chat " + cliente.getName());
        this.setLocationRelativeTo(null);

        // Painel principal
        mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(400, 800));
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(null);

        // Painel de escrita das mensagens
        messagePanel = new JPanel();
        messagePanel.setBounds(15, 705, 370, 45);
        messagePanel.setBackground(Color.GRAY);
        messagePanel.setLayout(null);

        // Caixa de entrada da mensagem
        messageInput = new JTextArea();
        messageInput.setBounds(10, 10, 250, 20);
        messageInput.addKeyListener(this);

        // Botão de enviar
        messageButton = new JButton("Send");
        messageButton.setBounds(270, 10, 85, 20);
        messageButton.addActionListener(this);

        // Caixa de exibição das mensagens enviadas
        currentMessage = new JTextArea();
        currentMessage.setEditable(false);
        currentMessage.setBackground(Color.GRAY);
        currentMessage.setFont(new Font("Arial", Font.BOLD, 15));
        currentMessage.setForeground(Color.WHITE);
        currentMessage.setLineWrap(true);

        // Painel "scroll" que contem as mensagens
        scrollChat = new JScrollPane(currentMessage);
        scrollChat.setBounds(15, 10, 370, 680);
        scrollChat.getViewport().setBackground(Color.GRAY);
        scrollChat.getVerticalScrollBar().setBackground(Color.BLACK);
        scrollChat.getHorizontalScrollBar().setBackground(Color.BLACK);
        scrollChat.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        messagePanel.add(messageButton);
        messagePanel.add(messageInput);
        mainPanel.add(scrollChat);
        mainPanel.add(messagePanel);

        this.add(mainPanel);
        this.setVisible(true);

        // Mensagem de conexão
        output.println(this.cliente.getName() + " connected to the chat");
    }

    // Função de escrita no scroll
    public void write(String message) {
        currentMessage.append(message + "\n");
    }

    // Método executado quando o ActionListener identifica uma ação
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.messageButton) {
            String message = this.cliente.getName() + ": " + messageInput.getText();
            output.println(message);

            // Limpa caixa de texto
            messageInput.setText("");
        }
    }

    // Método executado quando o KeyListener identifica uma key
    @Override
    public void keyPressed(KeyEvent event) {
        // Se a tecla pressionada for enter envia a mensagem
        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            String message = this.cliente.getName() + ": " + messageInput.getText();
            output.println(message);

            // Limpa caixa de texto
            messageInput.setText("");
            event.consume();

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
}
