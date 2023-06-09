package src.logica;

/* Imports */
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Virginia
 * @grupo Igor Barroso Almeida, Leandro Rodrigues Marques, João Pedro Neffa,
 *        Eduardo Evangelista Santos
 */
public class TrataCliente implements Runnable {
  // Atributos
  private InputStream cliente;
  private Servidor servidor;

  // Construtor
  public TrataCliente(InputStream cliente, Servidor servidor) {
    this.cliente = cliente;
    this.servidor = servidor;
  }

  @Override
  public void run() {
    // quando chegar uma msg, distribui pra todos
    Scanner s = new Scanner(this.cliente);
    while (s.hasNextLine()) {
      servidor.distribuiMensagem(s.nextLine());
    }
    s.close();
  }
}