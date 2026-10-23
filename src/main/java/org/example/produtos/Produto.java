
package org.example.produtos;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcular() {
        double precoTotal = preco * quantidade;
        return precoTotal;
    }

    public void remover(int quantidadeVendida) {
        int estoque = quantidade - quantidadeVendida;

        if (estoque >= 0) {
            quantidade = estoque;
        }
    }

    public void adicionar(int quantidade) {
        this.quantidade += quantidade;
    }

    public String apresentar() {
        return (nome + "," + preco + "," + quantidade);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
