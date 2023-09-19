package DAL;

import java.sql.*;
import modelo.Toys;

public class ToysDAO{
    public String mensagem;
    
    public void Cadastrar(Toys toys){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String conSql = "insert into toys "
                    + "(marca, nome, preco) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(conSql);
            stmt.setString(1, toys.Marca);
            stmt.setString(2, toys.Nome);
            stmt.setDouble(3, toys.Preco);
            stmt.execute();
            this.mensagem = "Cadastro efetuado com Sucesso";
        }
        catch (SQLException e){
            this.mensagem = "Erro de Banco de Dados";
        }
        finally{
            conexao.desconectar();
        }
    }
}
