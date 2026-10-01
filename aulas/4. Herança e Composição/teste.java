public class ContaBancaria {

    // =========================
    // ATRIBUTOS (encapsulados)
    // =========================
    private String titular;
    private String numeroConta;
    private double saldo;

    // =========================
    // CONSTRUTOR
    // =========================
    public ContaBancaria(String titular, String numeroConta) {

        if (titular == null || titular.trim().isEmpty()) {
            System.out.println("Titular inválido.");
            return;
        }

        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            System.out.println("Número da conta inválido.");
            return;
        }

        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    // =========================
    // GETTERS
    // =========================
    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // =========================
    // MÉTODOS DE NEGÓCIO
    // =========================
    public void depositar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de depósito deve ser positivo.");
            return; // early return
        }

        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de saque deve ser positivo.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        saldo -= valor;
        System.out.println("Saque realizado com sucesso.");
    }

    public void transferir(double valor, ContaBancaria destino) {

        if (destino == null) {
            System.out.println("Conta de destino inválida.");
            return;
        }

        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
            return;
        }

        this.sacar(valor);
        destino.depositar(valor);

        System.out.println("Transferência realizada com sucesso.");
    }

    // =========================
    // REPRESENTAÇÃO
    // =========================
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "titular='" + titular + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}