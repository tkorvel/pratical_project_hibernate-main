package menu;

import model.PaymentTerms;
import persistence.RepositoryPaymentTerms;
import java.util.List;
import java.util.Scanner;

public class MenuPaymentTerms {
    RepositoryPaymentTerms repoPaymentTerms = new RepositoryPaymentTerms();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("---------------------------\n");
        System.out.println();
        System.out.println("1: List all payment terms");
        System.out.println("2: Save new payment term");
        System.out.println("3: Search payment terms by ID");
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
                    menuListAllPaymentTerms(repoPaymentTerms);
                    break;
                case 2:
                    menuSavePaymentTerms(input, repoPaymentTerms);
                    break;
                case 3:
                    findPaymentTermsById(input, repoPaymentTerms);
                    break;
                case 4:
                    break;
                case 5:
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

    public static void menuSavePaymentTerms(Scanner input, RepositoryPaymentTerms repoPaymentTerms) {
        System.out.println("Type the payment terms name");
        String paymentTermsName = input.next();
        System.out.println("Type the payment terms description name");
        String paymentTermsDescription = input.next();
        PaymentTerms paymentTerms = new PaymentTerms();
        paymentTerms.setPaymentTermsName(paymentTermsName);
        paymentTerms.setPaymentTermsDescription(paymentTermsDescription);
        repoPaymentTerms.savePaymentTerms(paymentTerms);
    }

    public static void menuListAllPaymentTerms(RepositoryPaymentTerms repoPaymentTerms) {
        List<PaymentTerms> listPaymentTerms = repoPaymentTerms.listAllPaymentTerms();
        if (!listPaymentTerms.isEmpty()) {
            System.out.println("\nList of Payment Terms:" + listPaymentTerms.size());
            for (PaymentTerms terms : listPaymentTerms) {
                System.out.println(terms.toString());
            }
        } else {
            System.out.println("\nNo payment terms in our system");
        }
    }

    public static void findPaymentTermsById (Scanner input, RepositoryPaymentTerms repoPaymentTerms) {
        System.out.println("Type the payment terms ID");
        int paymentTermsId = input.nextInt();
        PaymentTerms paymentTerms = repoPaymentTerms.findPaymentTermsById(paymentTermsId);
        if(paymentTerms == null) {
            System.out.println("No payment terms with this ID");
        } else {
            System.out.println("###### PAYMENT TERMS INFORMATION ######");
            System.out.println(paymentTerms.toString());
        }
    }

}
