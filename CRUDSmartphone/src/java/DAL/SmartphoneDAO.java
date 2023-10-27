package DAL;

import modelo.Smartphone;
import org.hibernate.Query;
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
    
    public void Pesquisar(Smartphone smartphone){
        this.mensagem = "";
        try {
            Query query = session.createQuery("from modelo.Smartphone l where l.idsmartphone = :id");
            query.setParameter("id", smartphone.getIdsmartphone());
            if(query.list().size() > 0){
                smartphone = (modelo.Smartphone) query.list().get(0);
            }
            else
                this.mensagem = "Registro não Encontrado";
        } 
        catch (Exception e) {
            this.mensagem = "Erro de Banco de Dados";
        }
        finally {
            session.close();
        }
    }
}
