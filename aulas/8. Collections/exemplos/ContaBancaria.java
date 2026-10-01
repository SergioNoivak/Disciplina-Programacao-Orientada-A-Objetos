/**
 * EXEMPLO 04 - Lancando Excecao Personalizada com throw e throws
 *
 * Demonstra:
 * - "throws" na assinatura do metodo: informa que o metodo PODE lancar a
 * excecao.
 * - "throw new": lanca ativamente uma instancia da excecao.
 *
 * Depende de: 03_SaldoInsuficienteException.java (compilar antes)
 *
 * Compilar: javac SaldoInsuficienteException.java ContaBancaria.java
 * Executar: java ContaBancaria
 */
public class ContaBancaria {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Realiza um saque na conta.
     *
     * @param valor Valor a ser sacado.
     * @throws SaldoInsuficienteException se o valor for maior que o saldo
     *                                    disponivel.
     */
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            // "throw new" lanca ativamente a excecao personalizada
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente para saque",
                    valor,
                    saldo);
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do deposito deve ser positivo.");
        }
        saldo += valor;
        System.out.printf("Deposito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Maria Silva", 500.00);

        System.out.println("=== Conta de: " + conta.getTitular() + " ===");

        // Operacao que vai falhar: saque acima do saldo
        try {
            System.out.println("\nTentando sacar R$ 1000.00...");
            conta.sacar(1000.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Operacao negada: " + e.getMessage());
            System.out.printf("  Solicitado: R$ %.2f | Disponivel: R$ %.2f%n",
                    e.getValorSolicitado(), e.getSaldoAtual());
        }

        // Operacao que vai funcionar
        try {
            System.out.println("\nTentando sacar R$ 200.00...");
            conta.sacar(200.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Operacao negada: " + e.getMessage());
        }
    }
}
