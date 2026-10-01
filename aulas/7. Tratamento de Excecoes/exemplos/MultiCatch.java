
/**
 * EXEMPLO 08 - Multi-Catch (Java 7+)
 *
 * Sintaxe: catch (TipoA | TipoB e)
 * Regra: os tipos NAO podem ter relacao de heranca entre si.
 * A variavel 'e' e implicitamente final.
 *
 * Compilar: javac 08_MultiCatch.java
 * Executar: java MultiCatch
 */
import java.io.IOException;
import java.sql.SQLException;

public class MultiCatch {

    public static void executarOperacao(int tipo) throws IOException, SQLException {
        switch (tipo) {
            case 1:
                throw new IOException("Falha ao ler arquivo de configuracao.");
            case 2:
                throw new SQLException("Falha ao conectar ao banco de dados.");
            default:
                System.out.println("  Operacao " + tipo + " OK.");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Abordagem Antiga (redundante) ===");
        for (int tipo = 1; tipo <= 3; tipo++) {
            try {
                executarOperacao(tipo);
            } catch (IOException e) {
                System.out.println("  [" + tipo + "] IOException: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("  [" + tipo + "] SQLException: " + e.getMessage());
            }
        }

        System.out.println("\n=== Abordagem Moderna (multi-catch) ===");
        for (int tipo = 1; tipo <= 3; tipo++) {
            try {
                executarOperacao(tipo);
            } catch (IOException | SQLException e) {
                System.out.println("  [" + tipo + "] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}
