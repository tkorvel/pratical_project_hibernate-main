package menu;

import model.Address;
import model.Company;
import persistence.RepositoryCompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuCompany {
    RepositoryCompany repoCompany = new RepositoryCompany();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("---------------------------\n");
        System.out.println();
        System.out.println("1: List all companies");
        System.out.println("2: Register a new company");
        System.out.println("3: Search a company by ID");
        System.out.println("4: Register a new address");
        System.out.println("5: Search a company by registry code");
        System.out.println("6: Update a company credit rating");
        System.out.println("7: Update a company phone number");
        System.out.println("8: Delete company by ID");
        System.out.println("9: Delete an address by ID");
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
                    menuListAllCompanies(input);
                    break;
                case 2:
                    menuSaveCompany(input);
                     break;
                case 3:
                    findCompanyById(input);
                    break;
                case 4:
                    menuInsertAddress(input);
                    break;
                case 5:
                    findCompanyByRegistryCode(input);
                    break;
                case 6:
                    updateCompanyCreditRating(input);
                    break;
                case 7:
                    updateCompanyPhoneNumber(input);
                    break;
                case 8:
//                    deleteCompany(input);
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

    public void menuListAllCompanies(Scanner input) {
        List<Company> listCompanies = repoCompany.listAllCompanies();
        if (!listCompanies.isEmpty()) {
            System.out.println("\nList of Companies:" + listCompanies.size());
            for (Company co : listCompanies) {
                System.out.println(co.toString());
            }
        } else {
            System.out.println("\nNo companies registered in our system");
        }
    }

    public void menuSaveCompany(Scanner input) {
        System.out.println("Type a company registry code");
        int registryCode = input.nextInt();

        System.out.println("Type company name");
        String name = input.next();

        String email = null;
        boolean validEmail = false;
        while (!validEmail) {
            System.out.println("Type the email");
            email = input.next();
            validEmail = validateEmail(email);
        }

        System.out.println("Type phone number");
        String phoneNumber = input.next();

        System.out.println("Type credit rating");
        int creditRating = input.nextInt();

        // add new attribute 'dateOfRegister
        // type LocalDate

        System.out.println("Date of company registration");
        LocalDate dateOfRegister = LocalDate.parse(input.next());
//                , DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Company company = new Company();
        company.setRegistryCode(registryCode);
        company.setName(name);
        company.setEmail(email);
        company.setPhoneNumber(phoneNumber);
        company.setCreditRating(creditRating);
        company.setDateOfRegister(dateOfRegister);
        repoCompany.saveCompany(company);
    }
    // regex to validate email
    public boolean validateEmail(String email) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?'{|}?~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern).matcher(email).matches();
        }
//    // regex to validate date
//    public boolean validateDateOfRegister (String date) {
//        String regexPattern = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
//        return Pattern.compile(regexPattern).matcher(date).matches();
//    }

    public void menuInsertAddress (Scanner input) {
        String buildingNumber = null;
        boolean validBuildingNumber = false;
        while (!validBuildingNumber) {
            System.out.println("Building number may contain only letters and numbers, cannot contain special character, minimum size 3, maximum 20");
            System.out.println("Type a building number");
            buildingNumber = input.next();
            validBuildingNumber = validateBuildingNumber(buildingNumber);
        }

        String streetName = null;
        boolean validStreetName = false;
        while (!validStreetName) {
            System.out.println("Street name may contain only letters, cannot contain special character and numbers, minimum size 3, maximum 20");
            System.out.println("Type a street name");
            streetName = input.next();
            validStreetName = validateStreetName(streetName);
        }

        System.out.println("Type a city");
        String city = input.next();

        String postalCode = null;
        boolean validPostalCode = false;
        while (!validPostalCode) {
            System.out.println("Postal code may contain only numbers");
            System.out.println("Type a postal code");
            postalCode = input.next();
            validPostalCode = validatePostalCode(postalCode);
        }

        System.out.println("Type a country");
        String country = input.next();

        Address address = new Address();
        address.setBuildingNumber(buildingNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setCountry(country);
        repoCompany.insertAddress(address);
    }

    // regex to validate building number:
    // contains only letters, can not contain special character and numbers, minimum size 3, maximum 20
    public boolean validateBuildingNumber(String buildingNumber) {
        String regexPattern = "^[a-zA-Z0-9]{3,20}+$";

//        String regexPattern = "^[0-9]{3,20}+[a-zA-Z]+[!#$%&'*+/=?'{|}?~^.-]+$";

//        String regexPattern = "^([a-zA-Z]|[0-9]{3,20}+[!#$%&'*+/=?'{|}?~^.-])$";
//        String regexPattern = "^[a-zA-Z_!#$%&'*+/=?'{|}?~^.-][{3,20}]+$";
        return Pattern.compile(regexPattern).matcher(buildingNumber).matches();
    }

    // regex to validate street name:
    // contains only letters, can not contain special character and numbers, minimum size 3, maximum 20
    public boolean validateStreetName(String streetName) {
        String regexPattern = "^[a-zA-Z]{3,20}+$";

//        String regexPattern = "^([a-zA-Z]|[0-9]{3,20}+[!#$%&'*+/=?'{|}?~^.-])$";
        return Pattern.compile(regexPattern).matcher(streetName).matches();
    }

    // regex to validate postal code:
    // contains only numbers
    public boolean validatePostalCode(String postalCode) {
        String regexPattern = "^[0-9]+$";
        return Pattern.compile(regexPattern).matcher(postalCode).matches();
    }

    public void findCompanyById (Scanner input) {
        System.out.println("Type the company ID");
        int companyId = input.nextInt();
        Company company = repoCompany.findCompanyById(companyId);
        if(company == null) {
            System.out.println("Company is not registered as our customer");
        } else {
            System.out.println("###### COMPANY DETAILS ######");
            System.out.println(company.toString());
        }
    }

    public void findCompanyByRegistryCode (Scanner input) {
        System.out.println("Type the company registry code");
        int registryCode = input.nextInt();
        Company company = repoCompany.findCompanyByRegistryCode(registryCode);
        if(company == null) {
            System.out.println("Company is not our customer");
        } else {
            System.out.println("###### COMPANY DETAILS ######");
            System.out.println(company.toString());
        }
    }

    public void updateCompanyCreditRating (Scanner input) {
        System.out.println("Type the Company ID");
        int companyId = input.nextInt();
        System.out.println("Type new credit rating");
        int creditRating = input.nextInt();
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setCreditRating(creditRating);
        repoCompany.updateCompanyCreditRating(companyId, creditRating);
    }

    public void updateCompanyPhoneNumber (Scanner input) {
        System.out.println("Type the Company ID");
        int companyId = input.nextInt();
        System.out.println("Type new phone number");
        String phoneNumber = input.next();
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setPhoneNumber(phoneNumber);
        repoCompany.updateCompanyPhoneNumber(companyId, phoneNumber);
    }

//    ??????????????????
//    public void deleteCompany (Scanner input) {
//        System.out.println("Type a company ID");
//        int delete = input.nextInt();
//        repoCompany.deleteCompany(delete);
//    }
 }
