/**
 * EXEMPLO 06 - O Bloco Finally: Execucao Garantida
 *
 * Demonstra que o bloco finally executa SEMPRE, independentemente de:
 *   - O try ter completado com sucesso.
 *   - Um catch ter capturado uma excecao.
 *   - A excecao nao ter sido capturada.
 *
 * Tambem demonstra a ARMADILHA: se finally lanca uma excecao,
 * ela SUPRIME (apaga) a excecao original do try.
 *
 * Compilar: javac 06_BlocoFinally.java
 * Executar: java BlocoFinally
 */
public class BlocoFinally {

    // Simula um lock/recurso que precisa ser liberado
    static boolean lockAdquirido = false;

    public static void processarComLock(boolean simularErro) {
        System.out.println("  Adquirindo lock...");
        lockAdquirido = true;

        try {
            System.out.println("  Processando dados...");
            if (simularErro) {
                throw new RuntimeException("Falha durante o processamento!");
            }
            System.out.println("  Processamento concluido com sucesso.");
        } catch (RuntimeException e) {
            System.out.println("  Erro capturado no catch: " + e.getMessage());
        } finally {
            // Este bloco executa SEMPRE - ideal para liberar recursos
            lockAdquirido = false;
            System.out.println("  Lock liberado no finally. (lockAdquirido = " + lockAdquirido + ")");
        }
    }

    // Demonstra a ARMADILHA: excecao no finally suprime a excecao original
    public static void armadilhaFinally() {
        try {
            System.out.println("  Lancando 'Erro A' no try...");
            throw new RuntimeException("Erro A - causa real do problema");
        } finally {
            System.out.println("  Lancando 'Erro B' no finally (ARMADILHA!)...");
            throw new RuntimeException("Erro B - este suprime o Erro A!");
            // O chamador recebera APENAS o Erro B. O Erro A desaparece!
        }
    }

    public static void main(String[] args) {

        // Caso 1: Sem erro - finally executa apos o try
        System.out.println("=== Caso 1: Execucao sem erro ===");
        processarComLock(false);
        System.out.println();

        // Caso 2: Com erro - finally executa apos o catch
        System.out.println("=== Caso 2: Execucao com erro ===");
        processarComLock(true);
        System.out.println();

        // Caso 3: A armadilha - excecao no finally suprime a original
        System.out.println("=== Caso 3: Armadilha - excecao no finally ===");
        try {
            armadilhaFinally();
        } catch (RuntimeException e) {
            // Recebemos apenas "Erro B", "Erro A" foi perdido!
            System.out.println("  Excecao recebida pelo chamador: " + e.getMessage());
            System.out.println("  ATENCAO: A causa original (Erro A) foi suprimida!");
        }
    }
}
