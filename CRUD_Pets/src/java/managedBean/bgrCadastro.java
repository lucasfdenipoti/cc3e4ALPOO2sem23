/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;

/**
 *
 * @author Lucas Denipoti
 */
@ManagedBean
@RequestScoped
public class bgrCadastro {
    private String resposta;
    private String Nome;
    private String Especie;
    private String Raca;
    private Double Valor;
    
    public bgrCadastro() {
    }
    
    public String Cadastro(){
        List<String> ListaDadosPet = new ArrayList<String>();
        ListaDadosPet.add(Nome);
        ListaDadosPet.add(Especie);
        ListaDadosPet.add(Raca);
        ListaDadosPet.add(Valor.toString());
        Controle controle = new Controle();
        controle.Cadastrar(ListaDadosPet);
        this.resposta = controle.mensagem;
        return "/paginas/respostaCadastro";
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }
}
