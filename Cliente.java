/* Importações */
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Virginia
 * @grupo Igor Barroso Almeida, Leandro Rodrigues Marques, João Pedro Neffa, Eduardo Evangelista Santos
 */
public class Cliente {
    // Atributos
    private String host;
    private int porta;
    private String name;

    // Construtores
    public Cliente (String host, int porta, String name) {
        this.host = host;
        this.porta = porta;
        this.name = name;
    }

    // Métodos
    // Main
    public static void main(String[] args) throws UnknownHostException, IOException {
        // dispara cliente
        new Cliente("10.0.0.54", 12345, "Igor").executa();
    }
   
    public void executa() throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println(this.name + " se conectou ao servidor");
    
        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(cliente.getInputStream(), this.name);
        new Thread(r).start();
        
        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(this.name + teclado.nextLine());
        }
        
        saida.close();
        teclado.close();
        cliente.close();    
    }
 }