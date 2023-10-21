package DAL;

import modelo.Pessoa;
import org.hibernate.Session;

public class PessoaDAO {
    public String mensagem;
    public Session session = Conexao.getSessionFactory().openSession();
    
    public void Cadastrar(Pessoa pessoa){
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
            session.flush();
            session.close();
            this.mensagem = "Pessoa Cadastrada com Sucesso!";
        } catch (Exception e) {
            this.mensagem = "Erro de Banco de Dados";
        }
    }
}
