package modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    
    public void validarLivro(List<String> ListaDadosLivro){
        this.mensagem = "";
        for(String s : ListaDadosLivro){
            if(s.isEmpty())
                this.mensagem = "Nenhum dado pode ser vazio";
        }
    }
}
