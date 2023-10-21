package modelo;

import DAL.PessoaDAO;
import java.util.List;

public class Controle {
    public String mensagem;
    
    public void Cadastrar(List<String> ListaDadosPessoa){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.ValidarPessoa(ListaDadosPessoa);
        if(validacao.mensagem.equals("")){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(ListaDadosPessoa.get(0));
            pessoa.setRg(ListaDadosPessoa.get(1));
            pessoa.setCpf(ListaDadosPessoa.get(2));
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.Cadastrar(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
}
