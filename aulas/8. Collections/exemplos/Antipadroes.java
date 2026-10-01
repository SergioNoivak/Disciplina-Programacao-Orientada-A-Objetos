/**
 * EXEMPLO 11 - Antipadroes Comuns
 *
 * Demonstra os tres principais antipadroes no tratamento de excecoes:
 *
 *   ANTIPADRAO 1: Silenciar a excecao (swallowing)
 *   ANTIPADRAO 2: Catch generico (Exception) ocultando bugs
 *   ANTIPADRAO 3: Excecoes para controle de fluxo (performance)
 *
 * E a versao CORRETA de cada um.
 *
 * Compilar: javac 11_Antipadroes.java
 * Executar: java Antipadroes
 */
public class Antipadroes {

    // -----------------------------------------------------------------------
    // ANTIPADRAO 1: Silenciar excecoes (Swallowing)
    // -----------------------------------------------------------------------
    @SuppressWarnings("null")
    static void antipadrao1_silenciar() {
        try {
            String s = null;
            s.length(); // Lanca NullPointerException
        } catch (NullPointerException e) {
            // Bloco vazio: o erro ocorre, o estado corrompe, ninguem sabe!
            // Esta e considerada a PIOR pratica possivel.
        }
        // O codigo continua como se nada tivesse acontecido (estado invalido!)
    }

    @SuppressWarnings("null")
    static void correto1_tratarOuRelancar() {
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("  [CORRETO] Referencia nula detectada. Usando valor padrao.");
            // Ou: throw e; (se nao sabe tratar, relanca)
        }
    }

    // -----------------------------------------------------------------------
    // ANTIPADRAO 2: Catch generico ocultando bugs
    // -----------------------------------------------------------------------
    static void antipadrao2_catchGenerico(String usuario) {
        try {
            usuario.toUpperCase(); // NullPointerException se usuario for null
        } catch (Exception e) {
            // Captura TUDO: esconde NullPointerException como se fosse erro normal
            System.out.println("  [RUIM] Erro generico: " + e.getMessage());
        }
    }

    static void correto2_catchEspecifico(String usuario) {
        try {
            usuario.toUpperCase();
        } catch (NullPointerException e) {
            // Especifico: sabe exatamente o que aconteceu e trata adequadamente
            System.out.println("  [CORRETO] Nome do usuario nao pode ser nulo.");
        }
    }

    // -----------------------------------------------------------------------
    // ANTIPADRAO 3: Excecao para controle de fluxo
    // -----------------------------------------------------------------------
    static void antipadrao3_fluxoComExcecao(int[] array) {
        // Usa excecao para saber quando parou o loop (LENTO: instancia stack trace!)
        try {
            int i = 0;
            while (true) {
                System.out.print(array[i++] + " ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
        }
    }

    static void correto3_fluxoNormal(int[] array) {
        // Condicao normal do loop: sem overhead de excecao
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=== Antipadrao 1: Silenciamento ===");
        antipadrao1_silenciar();
        System.out.println("  [RUIM] Executou sem erro aparente, mas o estado pode estar corrompido.");
        correto1_tratarOuRelancar();

        System.out.println("\n=== Antipadrao 2: Catch Generico ===");
        antipadrao2_catchGenerico(null);
        correto2_catchEspecifico(null);

        System.out.println("\n=== Antipadrao 3: Excecao para Controle de Fluxo ===");
        int[] dados = {10, 20, 30, 40, 50};
        System.out.print("  [RUIM]    : ");
        antipadrao3_fluxoComExcecao(dados);
        System.out.print("  [CORRETO] : ");
        correto3_fluxoNormal(dados);
    }
}
