package modelo;

import java.util.List;

public class Validacao {
    public String mensagem = "";
    public Integer idP;
    public Integer idE;

    void validarIdPessoa(String numId){
        try{
            this.idP = Integer.valueOf(numId);
        }
        catch (NumberFormatException e){
            this.mensagem = "Digite um ID válido";
        }
    }
    
    public void validarPessoa(List<String> listaDadosPessoa){
        validarIdPessoa(listaDadosPessoa.get(0));
        if (listaDadosPessoa.get(1).length() > 10)
            this.mensagem += "Nome deve ter menos que 50 caracteres\n";
        if (listaDadosPessoa.get(2).length() > 10)
            this.mensagem += "RG deve ter menos que 10   caracteres\n";
        if (listaDadosPessoa.get(3).length() > 13)
            this.mensagem += "CPF deve ter menos que 13 caracteres\n";
    }
    
    public void validarEndereco(List<String> listaDadosEnd){
        if (listaDadosEnd.get(1).length() > 10)
            this.mensagem += "Logradouro deve ter menos que 45 caracteres\n";
        if (listaDadosEnd.get(2).length() > 10)
            this.mensagem += "Numero deve ter menos que 45 caracteres\n";
        if (listaDadosEnd.get(3).length() > 13)
            this.mensagem += "Bairro deve ter menos que 45 caracteres\n";
        if (listaDadosEnd.get(4).length() > 13)
            this.mensagem += "Cidade deve ter menos que 45 caracteres\n";
    }
}
