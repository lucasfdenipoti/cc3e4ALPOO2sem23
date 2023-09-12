package modelo;

import DAL.PetDAO;
import java.util.List;

public class Controle{
    public String mensagem;
    
    public void cadastrarPet(List<String> ListaDadosPet){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarPet(ListaDadosPet);
        if (validacao.mensagem.equals("")){
            Pet pet = new Pet();
            pet.Nome = ListaDadosPet.get(1);
            pet.Especie = ListaDadosPet.get(2);
            pet.Raca = ListaDadosPet.get(3);
            pet.Idade = ListaDadosPet.get(4);
            pet.Servico = ListaDadosPet.get(5);
            PetDAO petDAO = new PetDAO();
            petDAO.cadastrarPet(pet);
            this.mensagem = petDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Pet pesquisarPetPorId(String numId){
        this.mensagem = "";
        Pet pet = new Pet();
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if(validacao.mensagem.equals("")){
            pet.idPet = validacao.id;
            PetDAO petDAO = new PetDAO();
            pet = petDAO.pesquisarPetPorId(pet);
            this.mensagem = petDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
        return pet;
    }
}
