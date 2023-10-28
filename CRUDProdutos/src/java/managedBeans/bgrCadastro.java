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
    private String Titulo;
    private String Fabricante;
    private Double Peso;
    private Double Valor;
    
    public bgrCadastro() {
    }

    public String Cadastro()
    {
        List<String> ListaDadosProdutos = new ArrayList<String>();
        ListaDadosProdutos.add(Titulo);
        ListaDadosProdutos.add(Fabricante);
        ListaDadosProdutos.add(Peso.toString());
        ListaDadosProdutos.add(Valor.toString());
        Controle controle = new Controle();
        controle.Cadastrar(ListaDadosProdutos);
        this.resposta = controle.mensagem;
        return "/paginas/rsptCadastro";
    }
    
    public String getResposta() {
        return resposta;
    }

    public void setResposta(String Resposta) {
        this.resposta = Resposta;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }    
}
