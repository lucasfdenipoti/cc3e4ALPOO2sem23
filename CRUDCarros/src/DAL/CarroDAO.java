package DAL;

import java.sql.*;
import Modelo.Carro;

public class CarroDAO{
    public String mensagem;
    
    public void cadastrarCarro(Carro carro){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "insert into carros "
                    + "(fabricante, modelo, ano, cor) "
                    + "values(?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, carro.Fabricante);
            stmt.setString(2, carro.Modelo);
            stmt.setString(3, carro.Ano);
            stmt.setString(4, carro.Cor);
            //stmt.setDouble(5, carro.Valor);
            stmt.execute();
            this.mensagem = "Cadastro efetuado com sucesso!";
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
    }
    
    public Carro pesquisarCarroPorId(Carro carro){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "select * from carros "
                    + "where idcarro = ?";            
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, carro.idCarro);
            stmt.executeQuery();
            ResultSet resultset = stmt.executeQuery();
            if(resultset.next()){
                carro.Fabricante = resultset.getString("fabricante");
                carro.Modelo = resultset.getString("modelo");
                carro.Ano = resultset.getString("ano");
                carro.Cor = resultset.getString("cor");
                //carro.Valor = resultset.getDouble("valor");
            }
            else{
                this.mensagem = "Não existe registro com este ID";
            }
        }
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
       return carro;
    }
    
    public void editarCarro(Carro carro){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "update carro "
                    + "set fabricante = ?, modelo = ?, ano = ?, cor = ?"
                    + "where idCarro = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1,carro.Fabricante );
            stmt.setString(2, carro.Modelo);
            stmt.setString(3, carro.Ano);
            stmt.setString(4, carro.Cor);
            //stmt.setDouble(5, carro.Valor);
            stmt.execute();
            this.mensagem = "Edição efetuado com sucesso!";
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
    }
    
    public void excluirCarro(Carro carro){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "delete from carros "
                    + "where idCarro = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, carro.idCarro);
            stmt.execute();
            this.mensagem = "Exclusão efetuada com sucesso!";
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
    }    
}
