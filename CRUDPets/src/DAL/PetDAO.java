package DAL;

import java.sql.*;
import modelo.Pet;

public class PetDAO{
    public String mensagem;
    
    public void cadastrarPet(Pet pet){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "insert into pets "
                    + "(nome, especie, raca, idade, servico) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pet.Nome);
            stmt.setString(2, pet.Especie);
            stmt.setString(3, pet.Raca);
            stmt.setString(4, pet.Idade);
            stmt.setString(5, pet.Servico);
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
    
    public Pet pesquisarPetPorId(Pet pet){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "select * from pets "
                    + "where idpet = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pet.idPet);
            stmt.executeQuery();
            ResultSet resultset = stmt.executeQuery();
            if(resultset.next()){
                pet.Nome = resultset.getString("nome");
                pet.Especie = resultset.getString("especie");
                pet.Raca = resultset.getString("raca");
                pet.Idade = resultset.getString("idade");
                pet.Servico = resultset.getString("servico");
            }
            else{
                this.mensagem = "Não existe registro com esse ID";
            }
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
        return pet;
    }
    
    public void editarPet(Pet pet){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "update pets "
                    + "set nome = ?, especie = ?, raca = ?, idade = ?, servico = ? "
                    + "where idpet = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pet.Nome);
            stmt.setString(2, pet.Especie);
            stmt.setString(3, pet.Raca);
            stmt.setString(4, pet.Idade);
            stmt.setString(5, pet.Servico);
            stmt.setInt(6, pet.idPet);
            stmt.execute();
            this.mensagem = "Edição efetuada com sucesso!";
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
    }
    
    public void excluirPet(Pet pet){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "delete from pets "
                    + "where idpet = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pet.idPet);
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
