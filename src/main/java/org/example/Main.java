package org.example;

import org.example.produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String opcao, nome;
        double preco, precoTotal;
        int quantidade, codigoDoProduto;

        ArrayList<Produto> produtos = new ArrayList<>();

        while (true) {
            System.out.println("Sistema de Utilidades\n1 - Cadastrar Produto\n2 - Vender Produto\n0 - Sair");
            precoTotal = 0;
            Scanner sc = new Scanner(System.in);
            opcao = sc.nextLine();

            if (opcao.equals("1")) {
                System.out.println("Informe o nome do Produto: ");
                sc = new Scanner(System.in);
                nome = sc.nextLine();

                System.out.println("Informe o preço do Produto: ");
                sc = new Scanner(System.in);
                preco = Double.parseDouble(sc.nextLine());

                System.out.println("Informe a quantidade do Produto: ");
                sc = new Scanner(System.in);
                quantidade = Integer.parseInt(sc.nextLine());

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);

                System.out.println("O produto " + produto.getNome() + " foi cadastrado!\n");

            } else if (opcao.equals("2")) {
                while (true) {
                    for (int i = 0; i < produtos.size(); i++) {
                        Produto p = produtos.get(i);
                        System.out.println(i + ": " + p.apresentar());
                    }

                    System.out.println("Informe o código do Produto: ");
                    sc = new Scanner(System.in);

                    codigoDoProduto = Integer.parseInt(sc.nextLine());
                    Produto produtoVendido = produtos.get(codigoDoProduto);

                    System.out.println("Informe quantidade deste Produto: ");
                    sc = new Scanner(System.in);

                    int quantidadeVendida = Integer.parseInt(sc.nextLine());

                    precoTotal += (produtoVendido.getPreco() * quantidadeVendida);
                    produtoVendido.remover(quantidadeVendida);

                    System.out.println("Deseja adicionar um novo produto ao carrinho?\n1-Sim\n0-Não");
                    sc = new Scanner(System.in);
                    String statusCarrinho = sc.nextLine();

                    if (statusCarrinho.equals("1")) {
                        continue;
                    } else if (statusCarrinho.equals("0")) {
                        System.out.println("Preço Total: R$ " + precoTotal);
                        break;
                    }
                }
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Informe o código correto!\n");
            }
        }
    }
}
