package modelo;

import java.util.List;

public class Validacao{
    public String mensagem;
    public int id;
    
    public void validarId(String numId){
        this.mensagem = "";
        try{
            this.id = Integer.parseInt(numId);
       }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarPet(List<String> listaDadosPet){
        this.mensagem = "";
        validarId(listaDadosPet.get(0));
        if(listaDadosPet.get(1).length() > 45)
            this.mensagem = "Nome deve conter menos de 45 caracteres";
        if(listaDadosPet.get(2).length() > 45)
            this.mensagem = "Espécie deve conter menos de 45 caracteres";
        if(listaDadosPet.get(3).length() > 45)
            this.mensagem = "Raça deve conter menos de 45 caracteres";
        if(listaDadosPet.get(4).length() > 25)
            this.mensagem = "Idade deve conter menos de 25 digitos";
        if(listaDadosPet.get(5).length() > 45)
            this.mensagem = "Serviço deve conter menos de 45 caracteres";
    }
}
