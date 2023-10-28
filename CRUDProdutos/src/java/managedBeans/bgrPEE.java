package managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;
import modelo.Produto;

@RequestScoped
@ManagedBean
public class bgrPEE {
    private String resposta;
    private Integer Id;
    private String Titulo;
    private String Fabricante;
    private Double Peso;
    private Double Valor;
    
    public bgrPEE() {
    }
    
    public String Pesquisar(){
        Produto produto = new Produto();
        Controle controle = new Controle();
        controle.Pesquisar(Id.toString());
        produto.setTitulo(Titulo);
        produto.setFabricante(Fabricante);
        produto.setPeso(Peso);
        produto.setValor(Valor);
        this.resposta = controle.mensagem;
        return "paginas/rsptPEE";
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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
