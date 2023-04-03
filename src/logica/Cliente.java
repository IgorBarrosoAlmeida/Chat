package src.logica;

/* Imports */
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
    private int port;
    private String name;

    private Interface mainInterface;
    private Socket clienteSocket;

    // Getters
    public String getName() {
        return name;
    }

    public Socket getClienteSocket() {
        return clienteSocket;
    }

    // Construtores
    public Cliente(String host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
    }

    // Métodos
    // Main
    public static void main(String[] args) throws UnknownHostException, IOException {
        Login login = new Login();

        String nome = null;
        String host = null;

        while (login.verifyLogin == false) {
            nome = login.getUsername();
            host = login.getHost();
        }

        // dispara cliente
        new Cliente(host, 12345, nome).executa();
    }

    public void executa() throws UnknownHostException, IOException {
        clienteSocket = new Socket(this.host, this.port);
        mainInterface = new Interface(this);

        Scanner reader = new Scanner(this.clienteSocket.getInputStream());

        while (reader.hasNextLine()) {
            String message = reader.nextLine();
            mainInterface.write(message);
        }

        clienteSocket.close();
    }
}