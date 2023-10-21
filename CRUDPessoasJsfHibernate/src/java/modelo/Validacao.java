package modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    
    public void ValidarPessoa(List<String> ListaDadosPessoa){
        this.mensagem = "";
        if(ListaDadosPessoa.get(0).length() < 0)
            this.mensagem = "Nome deve ter mais caracteres";
    }
}
