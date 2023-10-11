package DAL;

import modelo.Livro;
import org.hibernate.Session;

public class LivroDAO {
    public String mensagem;
    public Session session = Conexao.getSessionFactory().openSession();
    
    public void Cadastrar(Livro livro){
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.save(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro Cadastrado com Sucesso!";
        } 
        catch (Exception e) {
            this.mensagem = "Erro de Banco de Dados";
        }
        finally {
            session.close();
        }
    }
}
