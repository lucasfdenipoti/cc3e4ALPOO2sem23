package DAL;

import modelo.Smartphone;
import org.hibernate.Session;

/**
 CREATE TABLE crud_smartphone.smartphones (
  idsmartphone INT NOT NULL AUTO_INCREMENT,
  fabricante VARCHAR(45) NULL,
  modelo VARCHAR(45) NULL,
  sistemaOperacional VARCHAR(45) NULL,
  cor VARCHAR(45) NULL,
  PRIMARY KEY (idsmartphone));
 * @author Lucas Denipoti
 */
public class SmartphoneDAO {
    public String mensagem;
    public Session session = 
            Conexao.getSessionFactory().openSession();
    
    public void Cadastrar(Smartphone smartphone)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(smartphone);
            session.getTransaction().commit();
            session.flush();
            session.close();
            this.mensagem = "Smartphone cadastrado com sucesso";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
    }
}
