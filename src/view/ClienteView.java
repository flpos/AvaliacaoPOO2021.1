package view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import controller.ClienteController;
import controller.FornecedorController;
import model.Cliente;
import model.Produto;
import utils.Screen;

public class ClienteView {
    public static void menuPrincipal(Scanner sc) {
        ClienteController clienteController = new ClienteController();
        FornecedorController fornecedorController = new FornecedorController();
        Screen.clearScreen();
        System.out.println("Digite seu usuário, pode ser um novo: ");
        String nomeLogin = sc.nextLine();
        Cliente cliente = clienteController.findByLogin(nomeLogin);
        if (cliente != null) {
            Screen.clearScreen();
            System.out.println("Seja bem vindo(a) " + cliente.getNome() + "\n");
            System.out.println("Digite (V) para ver produtos disponíveis");
            System.out.println("Digite (P) para ver pedidos anteriores");
            System.out.println("Digite (S) para sair");
            String comando = "";
            comando = sc.nextLine();
            while (comando != "S") {
                switch (comando.toUpperCase()) {
                case "V":
                    mostrarProdutos(fornecedorController);
                    comando = "";
                    break;
                case "P":
                    Screen.clearScreen();
                    System.out.println("Ainda não há pedidos...\n");
                    comando = "";
                    break;
                case "S":
                    comando = "S";
                    break;
                default:
                    System.out.println("\nDigite V, P ou S");
                    comando = sc.nextLine();
                }
            }
        } else {
            System.out.println("Criando usuário...");
            System.out.println("Digite seu nome");
            String nome = sc.nextLine();
            Integer newId = ThreadLocalRandom.current().nextInt();
            clienteController.addCliente(new Cliente(newId, nome, nomeLogin));
        }

    }

    private static void mostrarProdutos(FornecedorController fornecedorController) {
        Screen.clearScreen();
        Iterator<Produto> produtos = fornecedorController.getTodosOsProdutos().iterator();
        if (!produtos.hasNext()) {
            System.out.println("Não há produtos cadastrados...\n");
        }
        while (produtos.hasNext()) {
            Produto produto = produtos.next();
            System.out.println(produto.getId() + " " + produto.getNome() + "\t" + produto.getPreco());
        }
    }
}
