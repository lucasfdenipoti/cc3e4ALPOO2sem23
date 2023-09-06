package Modelo;

import java.util.List;

public class Validacao{
    public String mensagem;
    public Integer id;
    public Double valor;
    
    public void validarValor(String numValor){
        this.mensagem = "";
        try{
            this.valor = Double.valueOf(numValor);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um valor válido";
        }
    }
    
    public void validarId(String numId){
        this.mensagem = "";
        try{
            this.id = Integer.valueOf(numId);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarCarro(List<String> listaDadosCarro){
        this.mensagem = "";
        validarId(listaDadosCarro.get(0));
        if (listaDadosCarro.get(1).length() > 30)
            this.mensagem += "Fabricante deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(2).length() > 30)
            this.mensagem += "Modelo deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(3).length() > 4)
            this.mensagem += "Ano deve ter menos que 4 Digitos\n";
        if (listaDadosCarro.get(4).length() > 30)
            this.mensagem += "Cor deve ter menos que 30 caracteres\n";
        validarValor(listaDadosCarro.get(5));
    }
}
