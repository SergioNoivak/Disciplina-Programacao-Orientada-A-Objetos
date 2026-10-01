/**
 * EXEMPLO 05 - Hierarquia de Excecoes e Polimorfismo
 *
 * Demonstra que capturar uma superclasse captura todas as subclasses.
 * IOException e superclasse de FileNotFoundException e EOFException.
 *
 * Tambem mostra a ORDEM obrigatoria dos blocos catch:
 *   - SUBCLASSES devem vir ANTES das superclasses.
 *   - Colocar Exception antes de qualquer subclasse causa erro de compilacao.
 *
 * Compilar: javac 05_HierarquiaExcecoes.java
 * Executar: java HierarquiaExcecoes
 */
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HierarquiaExcecoes {

    // Simula abertura de arquivo - lanca FileNotFoundException (subclasse de IOException)
    public static void abrirArquivo(String nome) throws IOException {
        if (nome == null || nome.isEmpty()) {
            throw new FileNotFoundException("Arquivo nao encontrado: nome invalido.");
        }
        if (nome.endsWith(".eof")) {
            throw new EOFException("Fim inesperado do arquivo: " + nome);
        }
        System.out.println("Arquivo '" + nome + "' aberto com sucesso.");
    }

    public static void main(String[] args) {

        // --- Exemplo 1: captura polimórfica com IOException (captura subclasses) ---
        System.out.println("=== Captura Polimórfica com IOException ===");
        String[] arquivos = {"dados.txt", null, "relatorio.eof"};

        for (String arq : arquivos) {
            try {
                abrirArquivo(arq);
            } catch (IOException e) {
                // Este catch captura FileNotFoundException e EOFException!
                System.out.println("Erro de I/O capturado: [" +
                    e.getClass().getSimpleName() + "] " + e.getMessage());
            }
        }

        // --- Exemplo 2: ordem correta (especifico antes do genérico) ---
        System.out.println("\n=== Ordem Correta dos Blocos Catch ===");
        try {
            abrirArquivo(null);
        } catch (FileNotFoundException e) {
            // Captura especifica primeiro
            System.out.println("FileNotFoundException tratada especificamente: " + e.getMessage());
        } catch (IOException e) {
            // Captura generica por ultimo - nunca chegaria aqui para FileNotFoundException
            System.out.println("IOException generica: " + e.getMessage());
        }

        /*
         * EXEMPLO DE CODIGO QUE NAO COMPILA (erro de compilacao):
         *
         * try {
         *     abrirArquivo(null);
         * } catch (Exception e) {         // SUPERCLASSE PRIMEIRO = ERRO!
         *     System.out.println(e);
         * } catch (FileNotFoundException e) { // INALCANCAVEL - compilador rejeita
         *     System.out.println(e);
         * }
         */
    }
}
