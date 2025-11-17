package crudprodutos;

import java.util.*; //importando todas classes do pacote util

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>(); //criando uma lista do tipo produto(classe)
    private int nextId = 1; //guarda o id, começando pelo 1

    //recebe um objeto 'produto' e adciona na lista, o atribuindo o id atual, e depois incrementando o id para o próximo produto
    public void adicionar(Produto produto) {
        produto.setId(nextId++);
        produtos.add(produto);
    }
    //retorna a lista de produtos
    public List<Produto> listar() {
        return produtos;
    }

    //editar informações, caso selecionado um id já existente.
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

    //remove pelo id
    public boolean remover(int id) {
        return produtos.removeIf(p -> p.getId() == id); //lambda, que indica para a remoção de todos os itens, onde a condição for verdadeira
        
    }
}

