package Modelo;

import DAL.PessoaDAO;
import java.util.List;

public class Controle{
    public String mensagem;
    public void cadastrarPessoa(List<String> ListaDadosPessoa){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPessoa(ListaDadosPessoa);
        if (validacao.mensagem.equals("")){
            Pessoa pessoa = new Pessoa();
            pessoa.nome = ListaDadosPessoa.get(0);
            pessoa.rg = ListaDadosPessoa.get(1);
            pessoa.cpf = ListaDadosPessoa.get(2);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Pessoa pesquisarPessoaPorId(String numId){
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if(validacao.mensagem.equals("")){
            pessoa.idPessoa = validacao.id;
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.pesquisarPessoaPorId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
        return pessoa;
    }
}