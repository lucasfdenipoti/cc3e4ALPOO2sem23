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
            stmt.setInt(4, pet.Idade);
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
}
