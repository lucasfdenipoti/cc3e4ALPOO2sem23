package modelo;

import DAL.SmartphoneDAO;
import java.util.List;

public class Controle {
    public String mensagem;
    
    public void Cadastrar(List<String> listaDadosSP)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.Validar(listaDadosSP);
        if (validacao.mensagem.equals(""))
        {
            Smartphone smartphone = new Smartphone();
            smartphone.setFabricante(listaDadosSP.get(0));
            smartphone.setModelo(listaDadosSP.get(1));
            smartphone.setSistemaOperacional(listaDadosSP.get(2));
            smartphone.setCor(listaDadosSP.get(3));
            SmartphoneDAO spDAO = new SmartphoneDAO();
            spDAO.Cadastrar(smartphone);
            this.mensagem = spDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
