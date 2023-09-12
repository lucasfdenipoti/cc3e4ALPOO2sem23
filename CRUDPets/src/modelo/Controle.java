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
            pet.Idade = validacao.idade;
            pet.Servico = ListaDadosPet.get(5);
            PetDAO petDAO = new PetDAO();
            petDAO.cadastrarPet(pet);
            this.mensagem = petDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
}
