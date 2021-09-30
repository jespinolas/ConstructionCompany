/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.constructioncompany.presentation.console;
import java.util.List;
import java.util.Scanner;
import py.com.ci.constructioncompany.boundary.StockControlManager;
import py.com.ci.constructioncompany.entities.StockControl;
/**
 *
 * @author martin
 */
public class StockControlUI {
    
    Scanner sc = new Scanner(System.in);
    StockControlManager stockControlManager = new StockControlManager();
    StockControl stockControl = new StockControl();


    public static void main(String[] args) {
        StockControlUI stockControlUI = new StockControlUI();
        stockControlUI.mainMenu();
    }

    public void mainMenu() {
        System.out.println("Welcome to the Stock Control U.I. beta 0.0");
        System.out.println("-----------------------------------");
        System.out.println("Choose an option: ");
        System.out.println("1 : List Complete Stock");
        System.out.println("2 : Add an Item");
        System.out.println("3 : Update an Item");
        System.out.println("4 : Delete an Item");
        System.out.println("5 : Exit");
        System.out.println("Option: ");
        String option = sc.next();
        try {
            Integer selectedOption = Integer.parseInt(option);
            switch (selectedOption) {
                case 1:
                    listAllStock();
                    break;
                case 2:
                    registerItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    return;
            }
            mainMenu();
        } catch (Exception ex) {

            mainMenu();
        }
    }

    public void listAllStock() {
        List<StockControl> listStock = stockControlManager.getAll();
        if (!listStock.isEmpty()) {
            for (StockControl stockControl : listStock) {
                System.out.println(stockControl);
            }
        } else {
            System.out.println("No Items Found in Stock");
        }
    }

    private void registerItem() {
        String productName = null, productValue = null;

        sc.nextLine();
        System.out.println("Insert Item Name");
        productName = sc.nextLine();
        System.out.println("Insert Item Value");
        productValue = sc.nextLine();

        stockControl.setProductName(productName);
        stockControl.setProductValue(productValue);

        boolean em = stockControlManager.add(stockControl);
        if (em == true) {
            System.out.println("Operation successfull");

        } else {
            System.out.println("Error");
        }
    }

    private void deleteItem() {
        this.listAllStock();
        System.out.println("Insert Item Id ");
        int id = sc.nextInt();
        stockControl.setIdProduct(id);

        int rows = stockControlManager.deleteItem(stockControl);
        System.out.println("Applied, " + rows + " affected");
    }

    private void updateItem() {
        this.listAllStock();
        System.out.println("Insert Item Id ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Insert Item's new Name");
        String productName = sc.nextLine();
        System.out.println("Insert Item's new Value");
        String productValue = sc.nextLine();
        stockControl.setIdProduct(id);
        stockControl.setProductName(productName);
        stockControl.setProductValue(productValue);


        int rows = stockControlManager.updateItem(stockControl);
        System.out.println("Applied, " + rows + " affected");
    }


}
    

