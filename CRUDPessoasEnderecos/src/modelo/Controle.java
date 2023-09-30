package modelo;

import DAL.PessoaEndDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.Endereco;
import modelo.DTO.Pessoa;

public class Controle {
    public String mensagem;
    
    public void cadastrar(List<String> ListaDadosPessoa, List<List<String>> ListaDadosEndereco){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPessoa(ListaDadosPessoa);
        validacao.validarEndereco(ListaDadosPessoa);
        if (validacao.mensagem.equals("")){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(ListaDadosPessoa.get(1));
            pessoa.setRg(ListaDadosPessoa.get(2));
            pessoa.setCpf(ListaDadosPessoa.get(3));
            List<Endereco> ListaEnd = new ArrayList<>();
            for(List<String> e : ListaDadosEndereco){
                Endereco endereco = new Endereco();
                endereco.setLogradouro(e.get(1));
                endereco.setNumero(e.get(2));
                endereco.setBairro(e.get(3));
                endereco.setCidade(e.get(4));
                ListaEnd.add(endereco);
            }
            pessoa.setEnderecoList(ListaEnd);
            PessoaEndDAO pessoaendDAO = new PessoaEndDAO();
            pessoaendDAO.Cadastrar(pessoa);
            this.mensagem = pessoaendDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
}
