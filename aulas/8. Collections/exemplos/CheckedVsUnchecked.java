
/**
 * EXEMPLO 12 - Checked vs Unchecked Exceptions
 *
 * CHECKED (Verificadas): herdam de Exception (exceto RuntimeException).
 *   - O compilador OBRIGA o tratamento ou a declaracao com throws.
 *   - Representam condicoes recuperaveis (arquivos, rede, BD).
 *   - Exemplos: IOException, SQLException, ParseException
 *
 * UNCHECKED (Nao Verificadas): herdam de RuntimeException.
 *   - O compilador NAO exige tratamento.
 *   - Representam bugs de logica do programador.
 *   - Exemplos: NullPointerException, IllegalArgumentException, ArrayIndexOutOfBoundsException
 *
 * Compilar: javac 12_CheckedVsUnchecked.java
 * Executar: java CheckedVsUnchecked
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CheckedVsUnchecked {

    // Excecao CHECKED personalizada
    static class AutenticacaoException extends Exception {
        public AutenticacaoException(String mensagem) {
            super(mensagem);
        }
    }

    // Excecao UNCHECKED personalizada
    static class ConfiguracaoInvalidaException extends RuntimeException {
        public ConfiguracaoInvalidaException(String mensagem) {
            super(mensagem);
        }
    }

    // Metodo com CHECKED: compilador exige tratamento pelo chamador
    static void autenticar(String usuario, String senha) throws AutenticacaoException {
        if (!"admin".equals(usuario) || !"1234".equals(senha)) {
            throw new AutenticacaoException("Usuario ou senha invalidos.");
        }
        System.out.println("  Autenticado com sucesso: " + usuario);
    }

    // Metodo com UNCHECKED: compilador nao exige tratamento (mas pode ser
    // capturada)
    static void configurar(String valor) {
        if (valor == null || valor.isEmpty()) {
            throw new ConfiguracaoInvalidaException("Valor de configuracao nao pode ser nulo ou vazio.");
        }
        System.out.println("  Configuracao aplicada: " + valor);
    }

    public static void main(String[] args) {

        // --- Checked: OBRIGATORIO tratar (try-catch OU throws na assinatura) ---
        System.out.println("=== Checked Exception (Obrigatorio tratar) ===");
        try {
            autenticar("admin", "1234"); // Sucesso
            autenticar("hacker", "senha_errada"); // Lanca AutenticacaoException
        } catch (AutenticacaoException e) {
            System.out.println("  Falha de autenticacao: " + e.getMessage());
        }

        // --- Unchecked: Opcional tratar (mas recomendado para erros esperados) ---
        System.out.println("\n=== Unchecked Exception (Opcional tratar) ===");
        configurar("max_conexoes=10"); // Sucesso

        // Se quiser capturar, pode - mas nao e obrigatorio:
        try {
            configurar(""); // Lanca ConfiguracaoInvalidaException
        } catch (ConfiguracaoInvalidaException e) {
            System.out.println("  Erro de configuracao: " + e.getMessage());
        }

        // --- Unchecked nativa da JVM (NullPointerException, sem declaracao) ---
        System.out.println("\n=== Unchecked nativa da JVM (NullPointerException) ===");
        try {
            String texto = null;
            System.out.println(texto.length()); // Bug de logica
        } catch (NullPointerException e) {
            System.out.println("  Bug capturado: referencia nula. Corrija a logica!");
        }
    }
}
