package modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    public Integer id;
    public Double valor;
    public Double peso;

    public void validarId(String numId){
        try{
            this.id = Integer.valueOf(numId);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarPeso(String numPeso){
        try{
            this.peso = Double.valueOf(numPeso);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um Peso válido";
        }
    }
    
    public void validarValor(String numValor){
        try{
            this.valor = Double.valueOf(numValor);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um Valor válido";
        }
    }
    
    public void Validar(List<String> listaDadosProduto)
    {
        this.mensagem = "";
        if (listaDadosProduto.get(0).length() < 3)
            this.mensagem = "Titulo deve ter mais que 3 caracteres";
        if (listaDadosProduto.get(1).length() < 3)
            this.mensagem = "Fabricante deve ter mais que 3 caracteres";
        validarPeso(listaDadosProduto.get(2));
        validarValor(listaDadosProduto.get(3));
    }
}
