package modelo;

import DAL.PetDAO;
import java.util.List;

public class Controle {
    public String mensagem;
    
    public void Cadastrar(List<String> ListaDadosPet){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPet(ListaDadosPet);
        if(validacao.mensagem.equals("")){
            Pet pet = new Pet();
            pet.setNome(ListaDadosPet.get(0));
            pet.setEspecie(ListaDadosPet.get(1));
            pet.setRaca(ListaDadosPet.get(2));
            pet.setValor(validacao.valor);
            PetDAO petDAO = new PetDAO();
            petDAO.Cadastrar(pet);
            this.mensagem = petDAO.mensagem;
        }
        else
            this.mensagem = validacao.mensagem;
    }
}
