package modelo;

import DAL.ProdutosDAO;
import java.util.List;

public class Controle {
    public String mensagem;
    
    public void Cadastrar(List<String> listaDadosProdutos)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.Validar(listaDadosProdutos);
        if (validacao.mensagem.equals(""))
        {
            Produto produto = new Produto();
            produto.setTitulo(listaDadosProdutos.get(0));
            produto.setFabricante(listaDadosProdutos.get(1));
            produto.setPeso(validacao.peso);
            produto.setValor(validacao.valor);
            ProdutosDAO produtoDAO = new ProdutosDAO();
            produtoDAO.Cadastrar(produto);
            this.mensagem = produtoDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Produto Pesquisar(String numId)
    {
        this.mensagem = "";
        Produto produto = new Produto();
        Validacao validacao = new Validacao();
        validacao.validarId(numId);
        if (validacao.mensagem.equals(""))
        {
            produto.setIdProduto(validacao.id);
            ProdutosDAO produtosDAO = new ProdutosDAO();
            produto = produtosDAO.Pesquisar(produto);
            this.mensagem = produtosDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
        return produto;
    }
}
