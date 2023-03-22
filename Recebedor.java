
/* Importações */
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Virginia
 * @grupo Igor Barroso Almeida, Leandro Rodrigues Marques, João Pedro Neffa,
 *        Eduardo Evangelista Santos
 */
public class Recebedor implements Runnable {
    // Atributos
    private InputStream servidor;
    private String name;

    public Recebedor(InputStream servidor, String name) {
        this.servidor = servidor;
        this.name = name;
    }

    @Override
    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);

        while (s.hasNextLine()) {
            String msg = s.nextLine();
            // Pega o nome do usuario (primeira posição do texto separado por espaço)
            String nome = msg.split(" ")[0];

            if (!(nome.equals(this.name))) {
                System.out.println(msg);
            }
        }
    }
}