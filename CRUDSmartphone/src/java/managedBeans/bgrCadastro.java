package managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;


@RequestScoped
@ManagedBean
public class bgrCadastro {
    private String resposta;
    private String fabricante;
    private String modelo;
    private String sistemaOperacional;
    private String cor;
    
    public bgrCadastro() {
    }    
    
    public String Cadastro()
    {
        List<String> ListaDadosSP = new ArrayList<String>();
        ListaDadosSP.add(fabricante);
        ListaDadosSP.add(modelo);
        ListaDadosSP.add(sistemaOperacional);
        ListaDadosSP.add(cor);
        Controle controle = new Controle();
        controle.Cadastrar(ListaDadosSP);
        this.resposta = controle.mensagem;
        return "/paginas/respostaCadastro";
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
