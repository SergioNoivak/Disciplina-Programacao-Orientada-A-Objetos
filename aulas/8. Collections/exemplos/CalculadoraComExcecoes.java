/**
 * EXEMPLO 02 - Abordagem com Excecoes (POO)
 *
 * A divisao por zero gera uma ArithmeticException automaticamente pela JVM.
 * O bloco try contem apenas a logica de sucesso; o catch isola o tratamento.
 *
 * Compilar: javac 02_CalculadoraComExcecoes.java
 * Executar: java CalculadoraComExcecoes
 */
public class CalculadoraComExcecoes {

    public static int dividir(int a, int b) {
        return a / b; // JVM lanca ArithmeticException se b == 0
    }

    public static void main(String[] args) {
        System.out.println("--- Caso com erro ---");
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado); // Nunca chega aqui
        } catch (ArithmeticException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        System.out.println("\n--- Caso sem erro ---");
        try {
            int resultado = dividir(10, 2);
            System.out.println("Resultado: " + resultado); // Resultado: 5
        } catch (ArithmeticException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
