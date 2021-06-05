package view;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import controller.ClienteController;
import controller.FornecedorController;
import model.Cliente;
import utils.Screen;

public class FornecedorView {
    public static void menuPrincipal(Scanner sc) {
    	ClienteController clienteController = new ClienteController();
        FornecedorController fornecedorController = new FornecedorController();
        Screen.clearScreen();
        System.out.println("Digite seu usuário: ");
        String nomeLogin = sc.nextLine();
        Cliente cliente = clienteController.findByLogin(nomeLogin);
        if (cliente != null) {
            Screen.clearScreen();
            System.out.println("Seja bem vindo(a) " + cliente.getNome() + "\n");
            System.out.println("Digite (V) para ver pedidos recebidos");
            System.out.println("Digite (c) para cadastrar produtos");
            System.out.println("Digite (S) para sair");
            String comando = "";
            comando = sc.nextLine();
            while (comando != "S") {
                switch (comando.toUpperCase()) {
                case "c":
                    CadastrarProdutos(fornecedorController);
                    comando = "";
                    break;
                case "v":
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

	private static void CadastrarProdutos(FornecedorController fornecedorController) {
		
		
	}
}
