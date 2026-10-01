/**
 * EXEMPLO 03 - Excecao Personalizada (Checked)
 *
 * Demonstra como criar uma excecao de dominio propria estendendo Exception.
 * Como herda de Exception (e nao de RuntimeException), ela e CHECKED:
 * o compilador obriga quem chama metodos que lancam esta excecao a trata-la.
 *
 * Conceitos de POO aplicados:
 *   - Heranca: SaldoInsuficienteException extends Exception
 *   - Encapsulamento: mensagem de erro encapsulada no objeto
 *   - Reutilizacao: herda toda a infraestrutura de Throwable
 *
 * Este arquivo e usado pelos exemplos 04 e 05.
 */
public class SaldoInsuficienteException extends Exception {

    private final double valorSolicitado;
    private final double saldoAtual;

    public SaldoInsuficienteException(String mensagem, double valorSolicitado, double saldoAtual) {
        super(mensagem);
        this.valorSolicitado = valorSolicitado;
        this.saldoAtual = saldoAtual;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    @Override
    public String toString() {
        return "SaldoInsuficienteException{" +
               "mensagem='" + getMessage() + '\'' +
               ", valorSolicitado=" + valorSolicitado +
               ", saldoAtual=" + saldoAtual +
               '}';
    }
}
