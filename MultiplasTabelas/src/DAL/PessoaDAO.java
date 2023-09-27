package DAL;

import java.sql.*;
import modelo.Endereco;
import modelo.Pessoa;

public class PessoaDAO {
    public String mensagem;
    
    public void CadastrarPessoa(Pessoa pessoa){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try{
            String comSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(comSql,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getRg());
            stmt.execute();
            ResultSet resultset = stmt.getGeneratedKeys();
            if(resultset.next()){
                int id = resultset.getInt(1);
                if(!pessoa.getEnderecoList().isEmpty()){
                    for(Endereco e : pessoa.getEnderecoList()){
                        comSql = "insert into enderecos "
                    + "(Logradouro, Numero, Bairro, Cidade, fk_idPessoa) "
                    + "values(?, ?, ?, ?, ?)";
                        stmt = con.prepareStatement(comSql);
                        stmt.setString(1, e.getLogradouro());
                        stmt.setString(2, e.getNumero());
                        stmt.setString(3, e.getBairro());
                        stmt.setString(4, e.getCidade());
                        stmt.setInt(5, id);
                        stmt.execute();
                    }
                }
                this.mensagem = "Cadastro efetuado com sucesso!";
            }
        } 
        catch (SQLException e){
            this.mensagem = "Erro de conexao BD";
        }
        finally{
            conexao.desconectar();
        }
    }
}
