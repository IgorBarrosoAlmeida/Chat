package src.logica;

/* Importações */
import java.io.*;
import java.net.*;
import java.nio.file.ClosedWatchServiceException;
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

            } else {
                mainInterface.write(message);
            }
        }

        /*
         * // thread para receber mensagens do servidor
         * Recebedor r = new Recebedor(cliente.getInputStream(), this.name);
         * new Thread(r).start();
         * 
         * // lê msgs do teclado e manda pro servidor
         * Scanner teclado = new Scanner(System.in);
         * PrintStream saida = new PrintStream(cliente.getOutputStream());
         * while (teclado.hasNextLine()) {
         * saida.println(this.name + " " + teclado.nextLine());
         * }
         * 
         * saida.close();
         * teclado.close();
         */
        System.out.println("Funcionou");
        clienteSocket.close();
    }
}