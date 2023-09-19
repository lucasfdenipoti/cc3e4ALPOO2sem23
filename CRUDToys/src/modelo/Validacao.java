package modelo;

import java.util.List;

public class Validacao{
    public String mensagem;
    public Integer Id;
    public Double Preco;
    
    public void ValidarPreco(String numPreco){
        this.mensagem = "";
        try{
            this.Preco = Double.valueOf(numPreco);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um Preço válido"; 
        }
    }
    
    public void ValidarId(String numId){
        this.mensagem = "";
        try{
            this.Id = Integer.valueOf(numId);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido"; 
        }
    }
    
    public void ValidarToy(List<String> ListaDadosToys){
        this.mensagem = "";
        ValidarId(ListaDadosToys.get(0));
        if(ListaDadosToys.get(1).length() > 45)
            this.mensagem += "Marca deve conter menos que 45 digitos\n";
        if(ListaDadosToys.get(2).length() > 45)
            this.mensagem += "Nome deve conter menos que 45 digitos\n";
        ValidarPreco(ListaDadosToys.get(3));
    }
}
