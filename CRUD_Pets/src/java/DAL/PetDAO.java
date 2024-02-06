package DAL;

import modelo.Pet;
import org.hibernate.Session;

/**
CREATE TABLE crud_pets.pets (
  idPets INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NULL,
  Especie VARCHAR(45) NULL,
  Raca VARCHAR(45) NULL,
  Valor DOUBLE NULL,
  PRIMARY KEY (idPets));
*/
public class PetDAO {
    public String mensagem;
    public Session session = Conexao.getSessionFactory().openSession();
    
    public void Cadastrar(Pet pet){
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.save(pet);
            session.getTransaction().commit();
            session.flush();
            session.close();
            this.mensagem = "Cadastro Realizado com Sucesso!";
        } catch (Exception e) {
            this.mensagem = "Erro com o Banco de Dados";
        }
    }
}
