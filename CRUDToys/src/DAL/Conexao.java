package DAL;

import java.sql.*;

public class Conexao{
    public String stringConexao = 
            "jbdc:mysql://localhost:3306/ALPOO";
    public String mensagem;
    private Connection con;
    
    public Connection conectar(){
        this.mensagem = "";
        try{
            if(con == null || con.isClosed())
                con = DriverManager.getConnection(stringConexao, "root", "Lu08crepper@");
        }
        catch (SQLException e){
            this.mensagem = "Erro de Conexão com BD";
        }
        return con;
    }
    
    public void desconectar(){
        try{
            if(con != null && !con.isClosed())
                con.close();
        }
        catch (SQLException e){
            this.mensagem = "Erro de conexão com BD";
        }
    }
}
