package src.Interface;

/* Importações */
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class Exibidor {
    public class TextAreaOutput extends OutputStream {
        JTextArea outputConsole;

        public TextAreaOutput(JTextArea outputConsole) {
            this.outputConsole = outputConsole;
        }

        @Override
        public void write(int b) throws IOException {
            outputConsole.append(String.valueOf((char) b));
        }
    }
}
