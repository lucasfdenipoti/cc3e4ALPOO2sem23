package modelo;

import DAL.LivroDAO;
import java.util.List;

public class Controle {
    public String mensagem;
    
    public void Cadastrar(List<String> ListaDadosLivro){
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarLivro(ListaDadosLivro);
        if(validacao.mensagem.equals("")){
            Livro livro = new Livro();
            livro.setTitulo(ListaDadosLivro.get(0));
            livro.setAutor(ListaDadosLivro.get(1));
            livro.setNumPaginas(ListaDadosLivro.get(2));
            livro.setEditora(ListaDadosLivro.get(3));
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.Cadastrar(livro);
            this.mensagem = livroDAO.mensagem;
        }
        else{
            this.mensagem = validacao.mensagem;
        }
    }
}
