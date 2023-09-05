package Modelo;

import DAL.CarroDAO;
import java.util.List;

public class Controle{
    public String mensagem;
    
    public void cadastrarCarro(List<String> ListaDadosCarro){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCarro(ListaDadosCarro);
        if (validacao.mensagem.equals("")){
            Carro carro = new Carro();
            carro.Fabricante = ListaDadosCarro.get(1);
            carro.Modelo = ListaDadosCarro.get(2);
            carro.Ano = ListaDadosCarro.get(3);
            carro.Cor = ListaDadosCarro.get(4);
            //carro.Valor = ListaDadosCarro.get(5);
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.cadastrarCarro(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Carro pesquisarCarroPorId(String numId){
        this.mensagem = "";
        Carro carro = new Carro();
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if(validacao.mensagem.equals("")){
            carro.idCarro = validacao.id;
            CarroDAO carroDAO = new CarroDAO();
            carro = carroDAO.pesquisarCarroPorId(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
        return carro;
    }
    
    public void editarCarro(List<String> ListaDadosCarro){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarCarro(ListaDadosCarro);
        if (validacao.mensagem.equals("")){
            Carro carro = new Carro();
            carro.idCarro = validacao.id;
            carro.Fabricante = ListaDadosCarro.get(1);
            carro.Modelo = ListaDadosCarro.get(2);
            carro.Ano = ListaDadosCarro.get(3);
            carro.Cor = ListaDadosCarro.get(4);
            //carro.Valor = ListaDadosCarro.get(5);
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.editarCarro(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
    
    public void excluirCarro(String numId){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if (validacao.mensagem.equals("")){
            Carro carro = new Carro();
            carro.idCarro = validacao.id;
            CarroDAO carroDAO = new CarroDAO();
            carroDAO.excluirCarro(carro);
            this.mensagem = carroDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
}
