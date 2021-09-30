/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.constructioncompany.entities;
import java.util.Date;
/**
 *
 * @author martin
 */
public class StockControl {
    
    private int idProduct;
    private String productName;
    private String productValue;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }
    
    
    @Override
    public String toString() {
        return "Product ID = " + idProduct + "\n" +
               "Product Name = " + productName + "\n" +
               "Product Value = " + productValue +
               "\n----------------------------------------";
    }
}
