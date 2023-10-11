package DAL;

import modelo.Livro;
import org.hibernate.Query;
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
    
    public void PesquisarPorId(Livro livro){
        this.mensagem = "";
        try {
            Query query = session.createQuery("from modelo.Livro l where l.idLivro = :id");
            query.setParameter("id", livro.getIdLivro());
            if(query.list().size() > 0){
                livro = (modelo.Livro) query.list().get(0);
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
    
    public void Editar(Livro livro){
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.saveOrUpdate(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro Editado com Sucesso!";
        } 
        catch (Exception e) {
            this.mensagem = "Erro de Banco de Dados";
        }
        finally {
            session.close();
        }
    }
    
    public void Excluir(Livro livro){
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.delete(livro);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Livro Excluido com Sucesso!";
        } 
        catch (Exception e) {
            this.mensagem = "Erro de Banco de Dados";
        }
        finally {
            session.close();
        }
    }
}
