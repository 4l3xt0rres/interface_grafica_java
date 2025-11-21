package crudprodutos;
//classe que representa o modelo de produto
public class Produto {
    // atributos 
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    // construtor 
    public Produto(int id, String nome, int quantidade, double preco){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // os metodos de get(pega o id) e set(troca o valor do id pelo valor passado)
    public int getId() {return id;} 
    public void setId(int id){this.id = id;}

    //Campo do nome, e pra atualizar o nome quando inserido
    public String getNome() {return nome;}
    public void setNome(String nome){this.nome = nome;}

    //ler quantidade, e atualizar
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade; }

    //Ler preço e atualizar preço
    public double getPreco() {return preco;}
    public void setPreco(double preco) { this.preco = preco;}

    //sobrescreve as informações 
    @Override
    //metódo de retorno deu mensagem.
    public String toString() {
        return id + " - " + nome + " | R$" + preco + " | Qtd: " + quantidade; // retornando texto
    }
}
