/**
 * EXEMPLO 10 - A Jornada da Call Stack (Propagacao de Excecoes)
 *
 * Demonstra visualmente como uma excecao "borbulha" da camada mais profunda
 * ate a camada que possui o bloco catch compativel.
 *
 * Hierarquia de chamadas:
 *   main() -> metodoA() -> metodoB() -> metodoC() [lanca a excecao]
 *
 * O stack trace impresso mostra exatamente essa pilha de chamadas.
 *
 * Compilar: javac 10_JornadaCallStack.java
 * Executar: java JornadaCallStack
 */
public class JornadaCallStack {

    // Camada mais profunda - onde o erro ocorre
    static void metodoC() {
        System.out.println("  [metodoC] Executando... ERRO detectado!");
        throw new ArithmeticException("Divisao por zero em metodoC");
        // JVM faz Pop de metodoC e passa a excecao para metodoB
    }

    // Camada intermediaria - sem catch, apenas propaga
    static void metodoB() {
        System.out.println("  [metodoB] Chamando metodoC...");
        metodoC(); // Sem try-catch: excecao borbulha automaticamente
        System.out.println("  [metodoB] Esta linha NUNCA executa.");
        // JVM faz Pop de metodoB e passa a excecao para metodoA
    }

    // Outra camada intermediaria - sem catch
    static void metodoA() {
        System.out.println("  [metodoA] Chamando metodoB...");
        metodoB(); // Sem try-catch: excecao borbulha automaticamente
        System.out.println("  [metodoA] Esta linha NUNCA executa.");
        // JVM faz Pop de metodoA e passa a excecao para main
    }

    public static void main(String[] args) {
        System.out.println("[main] Iniciando execucao...\n");
        System.out.println("Fluxo de chamadas: main -> metodoA -> metodoB -> metodoC");
        System.out.println("Fluxo do erro   : metodoC -> metodoB -> metodoA -> main (catch)\n");

        try {
            metodoA();
        } catch (ArithmeticException e) {
            // main() captura a excecao que veio de 3 niveis abaixo
            System.out.println("\n[main] Excecao capturada aqui!");
            System.out.println("[main] Mensagem: " + e.getMessage());
            System.out.println("\n--- Stack Trace (mostra o caminho completo do erro) ---");
            e.printStackTrace();
        }

        System.out.println("\n[main] Programa continua normalmente apos o catch.");
    }
}
