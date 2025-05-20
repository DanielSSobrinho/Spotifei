package spotifei.util;

import java.sql.Connection;
import java.sql.SQLException;
import spotifei.Util.Conexao;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Conexao conexao = new Conexao(); // cria o objeto
            Connection conn = conexao.getConnection(); // usa o método da instância
            System.out.println("Conexão bem-sucedida com o banco de dados!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
