package menu;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuCompany menuCompany;
    private MenuProduct menuProduct;

    public SubMenuOptions() {
        this.menuCompany = new MenuCompany();
        this.menuProduct = new MenuProduct();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Order");
        System.out.println("2: Sub Menu - Company");
        System.out.println("3: Sub Menu - Product");
        System.out.println("4: Sub Menu - NA");
        System.out.println("5: Sub Menu - NA");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
//                    this.menuOrders.menuChoice(input);
                    break;
                case 2:
                    this.menuCompany.menuChoice(input);
                    break;
                case 3:
                    this.menuProduct.menuChoice(input);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed");
                    break;
//                default:
//                    System.out.println("\nSorry, please enter valid Option");
//                    menuChoice(input);
            }
        }
    }
}
