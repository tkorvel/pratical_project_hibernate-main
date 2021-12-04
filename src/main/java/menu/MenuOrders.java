package menu;

import model.Orders;
import persistence.RepositoryOrders;

import java.util.List;
import java.util.Scanner;

public class MenuOrders {
    RepositoryOrders repoOrders = new RepositoryOrders();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("---------------------------\n");
        System.out.println();
        System.out.println("1: List all orders");
        System.out.println("2: Register a new order");
        System.out.println("3: Search order by ID");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllOrders(input);
                   break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    public void menuListAllOrders(Scanner input) {
        List<Orders> listOrders = repoOrders.listAllOrders();
        if (!listOrders.isEmpty()) {
            System.out.println("\nList of Orders:" + listOrders.size());
            for (Orders orders : listOrders) {
                System.out.println(orders.toString());
            }
        } else {
            System.out.println("\nNo orders registered in our system");
        }
    }

    public void menuInsertOrder(Scanner input) {
        System.out.println("Type product ID");
        int productId = input.nextInt();


    }
}
