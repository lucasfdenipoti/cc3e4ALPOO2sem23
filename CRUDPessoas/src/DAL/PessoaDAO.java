package DAL;

import java.sql.*;
import Modelo.Pessoa;

public class PessoaDAO{
    public String mensagem;
    
    public void cadastrarPessoa(Pessoa pessoa){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pessoa.nome);
            stmt.setString(2, pessoa.rg);
            stmt.setString(3, pessoa.cpf);
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
    
    public Pessoa pesquisarPessoaPorId(Pessoa pessoa){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "select * from pessoas "
                    + "where idPessoa = ?";            
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pessoa.idPessoa);
            stmt.executeQuery();
            ResultSet resultset = stmt.executeQuery();
            if(resultset.next()){
                pessoa.nome = resultset.getString("nome");
                pessoa.rg = resultset.getString("rg");
                pessoa.cpf = resultset.getString("cpf");
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
        return pessoa;
    }
    
    public void editarPessoa(Pessoa pessoa){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "update pessoas "
                    + "set nome = ?, rg = ?, cpf = ? "
                    + "where idPessoa = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pessoa.nome);
            stmt.setString(2, pessoa.rg);
            stmt.setString(3, pessoa.cpf);
            stmt.setInt(4, pessoa.idPessoa);
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
}
