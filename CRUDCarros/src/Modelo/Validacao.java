package Modelo;

import java.util.List;

public class Validacao{
    public String mensagem;
    public Integer id;
    
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
        if (listaDadosCarro.get(1).length() < 30)
            this.mensagem += "Fabricante deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(2).length() > 30)
            this.mensagem += "Modelo deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(3).length() > 30)
            this.mensagem += "Ano deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(4).length() > 30)
            this.mensagem += "Cor deve ter menos que 30 caracteres\n";
        if (listaDadosCarro.get(5).length() < 0)
            this.mensagem += "Valor deve ser maior que 0\n";
    }
}
