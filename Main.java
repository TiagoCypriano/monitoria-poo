
import com.aluguelcarro.view.TelaPrincipal;
import javax.swing.SwingUtilities;

/**
 * Classe principal que inicia a aplicacao.
 *
 * Paradigmas de POO aplicados:
 * - Coesao: Esta classe tem uma unica responsabilidade, que e iniciar
 * a interface grafica, mantendo a logica de negocio e a interface
 * separadas.
 * - Encapsulamento: Esconde a complexidade de inicializacao do Swing
 * por tras de uma chamada simples ao metodo 'setVisible()'.
 */
public class Main {
    public static void main(String[] args) {
        
        // SwingUtilities.invokeLater garante que a criacao e atualizacao
        // da interface grafica ocorram na thread segura do Swing.
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}