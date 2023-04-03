package src.logica;

/* Imports */
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Virginia
 * @grupo Igor Barroso Almeida, Leandro Rodrigues Marques, João Pedro Neffa,
 *        Eduardo Evangelista Santos
 */
public class Servidor {
    // Atributos
    private int port;
    private List<PrintStream> clientes;

    // Construtor
    public Servidor(int port) {
        this.port = port;
        this.clientes = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Servidor(12345).executa();
    }

    public void executa() throws IOException {
        ServerSocket servidor = new ServerSocket(this.port);
        System.out.println("Port 12345 aberta!");

        while (true) {
            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            // cria tratador de cliente numa nova thread
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }

    }

    public void distribuiMensagem(String msg) {
        // envia msg para todo mundo
        for (PrintStream cliente : this.clientes) {
            cliente.println(msg);
        }
    }
}