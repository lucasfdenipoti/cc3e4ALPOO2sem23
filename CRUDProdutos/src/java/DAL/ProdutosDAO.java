package DAL;

import modelo.Produto;
import org.hibernate.Query;
import org.hibernate.Session;

/**
CREATE TABLE `crud_produto`.`produtos` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NULL,
  `Peso` DOUBLE NULL,
  `Valor` DOUBLE NULL,
  PRIMARY KEY (`idProduto`));
*/
public class ProdutosDAO {
    public String mensagem;
    public Session session = Conexao.getSessionFactory().openSession();
    
    public void Cadastrar(Produto produto)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(produto);
            session.getTransaction().commit();
            session.flush();
            session.close();
            this.mensagem = "Produto cadastrado com sucesso";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de BD";
        }
    }
    
    public Produto Pesquisar(Produto produto){
        this.mensagem = "";
        try {
            Query query = session.createQuery("from modelo.Produto l where l.idProduto = :id");
            query.setParameter("id", produto.getIdProduto());
            if(query.list().size() > 0){
                produto = (modelo.Produto) query.list().get(0);
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
        return produto;
    }
}
