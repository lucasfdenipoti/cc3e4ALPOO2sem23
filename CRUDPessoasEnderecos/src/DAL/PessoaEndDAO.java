package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.Endereco;
import modelo.DTO.Pessoa;

public class PessoaEndDAO {

    public String mensagem;

    public void Cadastrar(Pessoa pessoa) {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try {
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
            if (resultset.next()) {
                int id = resultset.getInt(1);
                if (!pessoa.getEnderecoList().isEmpty()) {
                    for (Endereco e : pessoa.getEnderecoList()) {
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
        catch (SQLException e) {
            this.mensagem = "Erro de conexao BD";
        }
        finally {
            conexao.desconectar();
        }
    }

    public Pessoa PesquisarPorId(Pessoa pessoa) {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try {
            String comSql = "select * from pessoas "
                    + "join enderecos "
                    + "on enderecos.fk_idPessoa = pessoas.idpessoa "
                    + "where idpessoa = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setInt(1, pessoa.getIdpessoa());
            ResultSet resultset = stmt.executeQuery();
            if (resultset.next()) {
                pessoa.setNome(resultset.getString("nome"));
                pessoa.setRg(resultset.getString("rg"));
                pessoa.setCpf(resultset.getString("cpf"));

                Endereco endRes = new Endereco();
                Endereco endCom = new Endereco();
                endRes.setLogradouro(resultset.getString("Logradouro"));
                endRes.setNumero(resultset.getString("Numero"));
                endRes.setBairro(resultset.getString("Bairro"));
                endRes.setCidade(resultset.getString("Cidade"));
                if (resultset.next()) {
                    endCom.setLogradouro(resultset.getString("Logradouro"));
                    endCom.setNumero(resultset.getString("Numero"));
                    endCom.setBairro(resultset.getString("Bairro"));
                    endCom.setCidade(resultset.getString("Cidade"));
                }
                List<Endereco> ListaDadosEnderecos = new ArrayList<>();
                if (endRes != null) {
                    ListaDadosEnderecos.add(endRes);
                }
                if (endCom != null) {
                    ListaDadosEnderecos.add(endCom);
                }
                pessoa.setEnderecoList(ListaDadosEnderecos);
            }
            else {
                this.mensagem = "Não existe esse ID";
            }
            conexao.desconectar();
        }
        catch (SQLException e) {
            this.mensagem = "Erro de leitura no BD";
        }
        return pessoa;
    }

    public void editarPessoa(Pessoa pessoa) {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        try {
            String comSql = "update pessoas "
                    + "set nome = ?,"
                    + "rg = ?,"
                    + "cpf = ? "
                    + "where id = ?";
            PreparedStatement stmt = con.prepareStatement(comSql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRg());
            stmt.setString(3, pessoa.getCpf());
            stmt.setInt(4, pessoa.getIdpessoa());
            stmt.execute();

            for (Endereco end : pessoa.getEnderecoList()) {
                comSql = "update enderecos "
                        + "set logradouro = ?, "
                        + "numero = ?, "
                        + "bairro = ?, "
                        + "cidade = ? "
                        + "where id = ?";
                stmt = con.prepareStatement(comSql);
                stmt.setString(1, end.getLogradouro());
                stmt.setString(2, end.getNumero());
                stmt.setString(3, end.getBairro());
                stmt.setString(4, end.getCidade());
                stmt.setInt(5, end.getIdEndereco());
                stmt.execute();
            }

            conexao.desconectar();
            this.mensagem = "Pessoa editada com sucesso!";
        }
        catch (SQLException e) {
            this.mensagem = "Erro de gravação no BD";
        }
        finally {
            conexao.desconectar();
        }
    }
}
