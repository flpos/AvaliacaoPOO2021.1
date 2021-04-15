import java.util.Scanner;

import utils.Screen;
import view.ClienteView;
import view.FornecedorView;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String comando = "";
        Screen.clearScreen();
        System.out.println("Gostaria de comprar ou vender?");
        System.out.println("(C) para comprar");
        System.out.println("(V) para vender");
        System.out.println("(S) para sair");
        comando = sc.nextLine();
        while (comando.toUpperCase() != "S") {
            switch (comando.toUpperCase()) {
            case "C":
                ClienteView.menuPrincipal(sc);
                comando = "";
                break;
            case "V":
                FornecedorView.menuPrincipal(sc);
                comando = "";
                break;
            case "S":
                comando = "S";
                break;
            default:
                System.out.println("\nMenu principal\nDigite C, V ou S.");
                comando = sc.nextLine();
            }
        }
        sc.close();
    }
}
