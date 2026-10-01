/**
 * EXEMPLO 09 - Excecoes Encadeadas (Chained Exceptions)
 *
 * Em sistemas multicamadas, captura-se a excecao tecnica de baixo nivel
 * (ex: SQLException) e relanca-se uma excecao de dominio (ex: PersistenciaException),
 * preservando a causa original via super(mensagem, causa).
 *
 * Isso mantém o encapsulamento (camadas superiores nao veem SQLException)
 * e a rastreabilidade (o stack trace completo ainda esta disponivel).
 *
 * Compilar: javac 09_ExcoesEncadeadas.java
 * Executar: java ExcoesEncadeadas
 */
import java.sql.SQLException;

public class ExcoesEncadeadas {

    // Excecao de dominio (negocio) - oculta detalhes de infraestrutura
    static class PersistenciaException extends Exception {
        public PersistenciaException(String mensagem, Throwable causa) {
            super(mensagem, causa); // Encadeia a causa original!
        }
    }

    // Simula uma operacao de banco de dados
    static class UsuarioDAO {
        public void salvar(String usuario) throws PersistenciaException {
            try {
                // Simula falha de SQL (infraestrutura)
                throw new SQLException("Coluna 'nome' viola restricao NOT NULL.");
            } catch (SQLException e) {
                // Encadeia: relanca como excecao de dominio, preservando a causa
                throw new PersistenciaException("Erro ao persistir o usuario: " + usuario, e);
            }
        }
    }

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        try {
            dao.salvar("joao.silva");
        } catch (PersistenciaException e) {
            System.out.println("Erro de negocio: " + e.getMessage());
            System.out.println("Causa raiz   : " + e.getCause().getMessage());
            System.out.println("Tipo da causa: " + e.getCause().getClass().getSimpleName());
            System.out.println("\nStack trace completo:");
            e.printStackTrace();
        }
    }
}
