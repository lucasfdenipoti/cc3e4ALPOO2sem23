package modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    public Integer id;
    
    public void Validar(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem = "Fabricante deve ter mais que 3 caracteres";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem = "Modelo deve ter mais que 3 caracteres";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem = "Sistema Operacional deve ter mais que 3 caracteres";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem = "Cor deve ter mais que 3 caracteres";
    }
    
    public void validarId(String numId){
        try{
            this.id = Integer.valueOf(numId);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido";
        }
    }
}
