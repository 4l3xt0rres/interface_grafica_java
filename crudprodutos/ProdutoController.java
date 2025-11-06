package crudprodutos;

import java.util.*;

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private int nextId = 1;

    public void adicionar(Produto produto) {
        produto.setId(nextId++);
        produtos.add(produto);
    }

    public List<Produto> listar() {
        return produtos;
    }

    public boolean atualizar(int id, Produto novoProduto) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoProduto.getNome());
                p.setPreco(novoProduto.getPreco());
                p.setQuantidade(novoProduto.getQuantidade());
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }
}

