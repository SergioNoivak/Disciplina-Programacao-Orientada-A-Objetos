/**
 * EXEMPLO 01 - Abordagem Tradicional (Procedural)
 * 
 * Demonstra o tratamento de erros sem excecoes, usando codigos de retorno.
 * Problemas desta abordagem:
 *   - A logica de sucesso fica misturada com verificacoes de erro.
 *   - O codigo de erro (-1) pode ser confundido com um resultado valido.
 *   - Facil de esquecer a verificacao, causando bugs silenciosos.
 *
 * Compilar: javac 01_CalculadoraProcedural.java
 * Executar: java CalculadoraProcedural
 */
public class CalculadoraProcedural {

    // Retorna -1 como "codigo de erro" quando o divisor e zero
    public static int dividir(int a, int b) {
        if (b == 0) {
            return -1; // Representacao de erro por convencao
        }
        return a / b;
    }

    public static void main(String[] args) {
        // Caso com erro
        int resultado = dividir(10, 0);
        if (resultado == -1) {
            System.out.println("Erro: divisao por zero detectada.");
        } else {
            System.out.println("Resultado: " + resultado);
        }

        // Caso sem erro
        resultado = dividir(10, 2);
        if (resultado == -1) {
            System.out.println("Erro: divisao por zero detectada.");
        } else {
            System.out.println("Resultado: " + resultado); // Resultado: 5
        }
    }
}
