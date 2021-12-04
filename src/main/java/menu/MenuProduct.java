package menu;

import model.Product;
import persistence.RepositoryProduct;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuProduct {
    RepositoryProduct repoProduct = new RepositoryProduct();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("---------------------------\n");
        System.out.println();
        System.out.println("1: List all products");
        System.out.println("2: Register a new product");
        System.out.println("3: Search product by ID");
        System.out.println("4: Update product quantity in stock");
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
                    menuListAllProducts(input);
                    break;
                case 2:
                    menuSaveProduct(input);
                    break;
                case 3:
                    findProductById(input);
                    break;
                case 4:
                    updateNowInStock(input);
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

    public void menuListAllProducts(Scanner input) {
        List<Product> listProducts = repoProduct.listAllProducts();
        if (!listProducts.isEmpty()) {
            System.out.println("\nList of Products:" + listProducts.size());
            for (Product product : listProducts) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("\nNo products registered");
        }
    }


    public void menuSaveProduct (Scanner input) {
        System.out.println("Type a product name");
        String productName = input.next();

        String countryCode = null;
        boolean validCountryCode = false;
        while (!validCountryCode) {
            System.out.println("ISO 3166 country code is two-letter code, all capital letters like EE, LV, RU, GB.");
            System.out.println("Type a valid country code of product origin");
            countryCode = input.next();
            validCountryCode = validateCountryCode(countryCode);
        }

        System.out.println("Type a product unit");
        String productUnit = input.next();

        System.out.println("Enter price per unit");
        double pricePerUnit = input.nextInt();

        String currencyCode = null;
        boolean validCurrencyCode = false;
        while (!validCurrencyCode) {
            System.out.println("ISO 4217 currency code is three-letter code, all capital letters. The first two letters are the same as the code for the country name. ");
            System.out.println("Type a valid currency code");
            currencyCode = input.next();
            validCurrencyCode = validateCurrencyCode(currencyCode);
        }

        System.out.println("Type a product description");
        String productSpecification = input.next();

        System.out.println("Type a minimum order quantity");
        int minimumOrderQuantity = input.nextInt();
        System.out.println("Type a product quantity in stock");
        int nowInStock = input.nextInt();
        System.out.println("Type an order time");
        int orderTime = input.nextInt();

        Product product = new Product();
        product.setProductName(productName);
        product.setCountryCode(countryCode);
        product.setProductUnit(productUnit);
        product.setPricePerUnit(pricePerUnit);
        product.setCurrencyCode(currencyCode);
        product.setProductSpecification(productSpecification);
        product.setMinOrderQuantity(minimumOrderQuantity);
        product.setNowInStock(nowInStock);
        product.setOrderTime(orderTime);
        repoProduct.saveProduct(product);
    }

    // regex for ISO country code
    public boolean validateCountryCode(String countryCode) {
        String regexPattern = "^(?:[A-Z]{2})+$";
        return Pattern.compile(regexPattern).matcher(countryCode).matches();
    }
    // regex for ISO currency code
    public boolean validateCurrencyCode(String currencyCode) {
        String regexPattern = "^(?:[A-Z]{3})+$";
        return  Pattern.compile(regexPattern).matcher(currencyCode).matches();
    }

     public void findProductById (Scanner input) {
        System.out.println("Type the product ID");
        int productId = input.nextInt();
        Product product = repoProduct.findProductById(productId);
        if(product == null) {
            System.out.println("No product with this product ID");
        } else {
            System.out.println("###### Product  ######");
            System.out.println(product.toString());
        }
    }

    public void updateNowInStock (Scanner input) {
        System.out.println("Type a product ID");
        int productId = input.nextInt();
        Product product = repoProduct.findProductById(productId);
        if(product == null) {
            System.out.println("No product with this ID registered");
        } else {
            System.out.println("Type new quantity to update product now in stock ");
            int nowInStock = input.nextInt();
            Product productInStock = new Product();
            product.setProductId(productId);
            product.setNowInStock(nowInStock);
            repoProduct.updateNowInStock(productId, nowInStock);
            System.out.println(productInStock.toString());
        }
    }

}
