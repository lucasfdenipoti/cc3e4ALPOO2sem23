package modelo;

import DAL.ToysDAO;
import java.util.List;

public class Controle{
    public String mensagem;
    
    public void Cadastrar(List<String> ListaDadosToys){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.ValidarToy(ListaDadosToys);
        if(validacao.mensagem.equals("")){
            Toys toys = new Toys();
            toys.Marca = ListaDadosToys.get(1);
            toys.Nome = ListaDadosToys.get(2);
            toys.Preco = validacao.Preco;
            ToysDAO toysDAO = new ToysDAO();
            toysDAO.Cadastrar(toys);
            this.mensagem = toysDAO.mensagem; 
       }
        else
            this.mensagem = validacao.mensagem;
    }
}
