package src.logica;

/* Importações */
import java.io.*;
import java.net.*;
import java.util.Scanner;

import src.Interface.*;

/**
 *
 * @author Virginia
 * @grupo Igor Barroso Almeida, Leandro Rodrigues Marques, João Pedro Neffa,
 *        Eduardo Evangelista Santos
 */
public class Cliente {
    // Atributos
    private String host;
    private int porta;
    private String name;
    private Interface mainInterface;

    // Getters
    public String getName() {
        return name;
    }

    private Socket clienteSocket;

    public Socket getClienteSocket() {
        return clienteSocket;
    }

    // Construtores
    public Cliente(String host, int porta, String name) {
        this.host = host;
        this.porta = porta;
        this.name = name;
    }

    // Métodos
    // Main
    public static void main(String[] args) throws UnknownHostException, IOException {
        Login login = new Login();

        String nome = null;

        while (login.verifyLogin == false) {
            nome = login.getUsername();
        }

        // dispara cliente
        new Cliente("127.0.0.1", 12345, nome).executa();
    }

    public void executa() throws UnknownHostException, IOException {
        clienteSocket = new Socket(this.host, this.porta);
        mainInterface = new Interface(this);

        Scanner reader = new Scanner(this.clienteSocket.getInputStream());

        while (reader.hasNextLine()) {
            String message = reader.nextLine();
            String[] splitMessage = message.split(":");
            String destiny = splitMessage[0]; // Pega o destinatário

            if (destiny == this.name) {
                System.out.println("mudou message");
                message = "You:" + splitMessage;
            }
            mainInterface.write(message);
        }

        clienteSocket.close();
    }
}