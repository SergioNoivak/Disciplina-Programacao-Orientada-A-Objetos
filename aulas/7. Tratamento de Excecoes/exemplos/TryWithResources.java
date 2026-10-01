/**
 * EXEMPLO 07 - Try-with-Resources (Java 7+)
 *
 * Demonstra o fechamento automatico de recursos que implementam AutoCloseable.
 * O close() e chamado automaticamente ao sair do bloco try, mesmo em caso de erro.
 *
 * Tambem demonstra:
 *   - Multiplos recursos no mesmo try (fechados em ordem REVERSA de declaracao)
 *   - Excecoes Supressas (Suppressed): quando o processamento e o close() falham,
 *     a excecao do processamento prevalece e a do close() e anexada como suprimida.
 *
 * Compilar: javac 07_TryWithResources.java
 * Executar: java TryWithResources
 */
public class TryWithResources {

    /**
     * Recurso simulado que implementa AutoCloseable.
     * Permite configurar se o close() deve simular uma falha.
     */
    static class RecursoSimulado implements AutoCloseable {
        private final String nome;
        private final boolean falharAoFechar;

        RecursoSimulado(String nome, boolean falharAoFechar) {
            this.nome = nome;
            this.falharAoFechar = falharAoFechar;
            System.out.println("  [" + nome + "] Recurso ABERTO.");
        }

        public void processar(boolean simularErro) throws Exception {
            System.out.println("  [" + nome + "] Processando...");
            if (simularErro) {
                throw new Exception("[" + nome + "] Erro durante o processamento!");
            }
            System.out.println("  [" + nome + "] Processamento OK.");
        }

        @Override
        public void close() throws Exception {
            System.out.println("  [" + nome + "] Recurso FECHADO automaticamente.");
            if (falharAoFechar) {
                throw new Exception("[" + nome + "] Erro ao fechar o recurso!");
            }
        }
    }

    public static void main(String[] args) {

        // --- Exemplo 1: recurso simples, fechamento automatico ---
        System.out.println("=== Exemplo 1: Um recurso, sem erros ===");
        try (RecursoSimulado r = new RecursoSimulado("Arquivo", false)) {
            r.processar(false);
        } catch (Exception e) {
            System.out.println("  Erro: " + e.getMessage());
        }
        // close() ja foi chamado automaticamente aqui

        // --- Exemplo 2: multiplos recursos - ordem de fechamento REVERSA ---
        System.out.println("\n=== Exemplo 2: Multiplos recursos (fechamento em ordem reversa) ===");
        try (RecursoSimulado r1 = new RecursoSimulado("ZipFile", false);
             RecursoSimulado r2 = new RecursoSimulado("InputStream", false)) {
            r1.processar(false);
            r2.processar(false);
        } catch (Exception e) {
            System.out.println("  Erro: " + e.getMessage());
        }
        // InputStream e fechado ANTES de ZipFile (ordem reversa)

        // --- Exemplo 3: Excecoes supressas ---
        System.out.println("\n=== Exemplo 3: Excecoes Supressas ===");
        try (RecursoSimulado r = new RecursoSimulado("ConexaoDB", true)) {
            // processar lanca excecao, e o close() tambem lanca
            r.processar(true);
        } catch (Exception e) {
            System.out.println("  Excecao principal: " + e.getMessage());
            Throwable[] suprimidas = e.getSuppressed();
            if (suprimidas.length > 0) {
                System.out.println("  Excecao suprimida (do close): " + suprimidas[0].getMessage());
            }
        }
    }
}
