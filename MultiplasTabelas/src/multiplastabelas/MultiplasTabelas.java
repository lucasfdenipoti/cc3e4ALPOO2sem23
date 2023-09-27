package multiplastabelas;

import DAL.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Endereco;
import modelo.Pessoa;

public class MultiplasTabelas
{
    public static void main(String[] args){
        Pessoa pessoa = new Pessoa();
        Endereco endRes = new Endereco();
        Endereco endCom = new Endereco();
        List<Endereco> ListaEnderecos = new ArrayList<>();
        
        pessoa.setNome("Lucas");
        pessoa.setCpf("111111");
        pessoa.setRg("222222");
        
        endRes.setLogradouro("Rua Segunda");
        endRes.setNumero("398");
        endRes.setBairro("Iporanga");
        endRes.setCidade("Sorocaba");
        
        endRes.setLogradouro("Rua Sétima");
        endRes.setNumero("571");
        endRes.setBairro("Ubirajara");
        endRes.setCidade("Sorocaba");
        
        ListaEnderecos.add(endRes);
        ListaEnderecos.add(endCom);
        
        pessoa.setEnderecoList(ListaEnderecos);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.CadastrarPessoa(pessoa);
    }    
}
