package modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    public Double valor;
    
    public void validarValor(String numValor){
        try {
            this.valor = Double.valueOf(numValor);
        } catch (Exception e) {
            this.mensagem = "Valor Inválido";
        }
    }
    
    public void validarPet(List<String> ListaDadosPet){
        this.mensagem = "";
        if(ListaDadosPet.get(0).length() < 3)
            this.mensagem = "Nome deve ter mais de 3 caracteres";
        if(ListaDadosPet.get(1).length() < 3)
            this.mensagem = "Espécie deve ter mais de 3 caracteres";
        if(ListaDadosPet.get(2).length() < 3)
            this.mensagem = "Raça deve ter mais de 3 caracteres";
        validarValor(ListaDadosPet.get(3));
    }
}
