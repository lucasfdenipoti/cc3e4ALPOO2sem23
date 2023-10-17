package modelo;

import DAL.PessoaEndDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.DTO.Endereco;
import modelo.DTO.Pessoa;

public class Controle {
    public String mensagem;
    
    public void cadastrar(List<String> ListaDadosPessoa){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPessoa(ListaDadosPessoa);
        validacao.validarEndereco(ListaDadosPessoa);
        if (validacao.mensagem.equals("")){
            Pessoa pessoa = new Pessoa();
            Endereco endRes = new Endereco();
            Endereco endCom = new Endereco();
            List<Endereco> listaDadosEnderecos = new ArrayList<>();
            
            pessoa.setNome(ListaDadosPessoa.get(1));
            pessoa.setRg(ListaDadosPessoa.get(2));
            pessoa.setCpf(ListaDadosPessoa.get(3));
            
            endRes.setLogradouro(ListaDadosPessoa.get(4));
            endRes.setNumero(ListaDadosPessoa.get(5));
            endRes.setBairro(ListaDadosPessoa.get(6));
            endRes.setCidade(ListaDadosPessoa.get(7));
            
            endCom.setLogradouro(ListaDadosPessoa.get(8));
            endCom.setNumero(ListaDadosPessoa.get(9));
            endCom.setBairro(ListaDadosPessoa.get(10));
            endCom.setCidade(ListaDadosPessoa.get(11));
            
            listaDadosEnderecos.add(endRes);
            listaDadosEnderecos.add(endCom);
            
            pessoa.setEnderecoList(listaDadosEnderecos);
            
            PessoaEndDAO pessoaendDAO = new PessoaEndDAO();
            pessoaendDAO.Cadastrar(pessoa);
            this.mensagem = pessoaendDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Pessoa pesquisarPessoaPorId(String numeroId){
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarIdPessoa(numeroId);
        if(validacao.mensagem.equals("")){
            pessoa.setIdpessoa(validacao.idP);
            PessoaEndDAO pessoaDAO = new PessoaEndDAO();
            pessoa = pessoaDAO.PesquisarPorId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
        return pessoa;
    }
    
}
