package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import modelo.Controle;

@Named(value = "bgrCadastro")
@RequestScoped
@ManagedBean
public class bgrCadastro {
    private String mensagem;
    private String Nome;
    private String RG;
    private String CPF;
    
    public bgrCadastro() {
    }    

    public String Cadastrar(){
        this.mensagem = "";
        Controle controle = new Controle();
        List<String> ListaDadosPessoa = new ArrayList<>();
        ListaDadosPessoa.add(Nome);
        ListaDadosPessoa.add(RG);
        ListaDadosPessoa.add(CPF);
        this.mensagem = controle.mensagem;
        return "/paginas/respostaCadastro";
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
