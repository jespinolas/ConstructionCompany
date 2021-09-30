/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.constructioncompany.boundary;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import py.com.ci.constructioncompany.entities.StockControl;
import py.com.ci.constructioncompany.utils.ConnectionManager;

/**
 *
 * @author martin
 */
public class StockControlManager {
    
    public List<StockControl> getAll() {
        List<StockControl> listStock = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStock.add(getFromRsStockControl(rs));
                }
            }
            return listStock;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public String getStatement() {
        String statement = "SELECT idproduct, productName, productValue FROM public.stockcontrol;";
        return statement;
    }

    public StockControl getFromRsStockControl(ResultSet rs) {
        try {
            StockControl data = new StockControl();
            data.setIdProduct(rs.getInt("idproduct"));
            data.setProductName(rs.getString("productName"));
            data.setProductValue(rs.getString("productValue"));

            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean add(StockControl stockControl) {
        String statement = "INSERT INTO public.stockcontrol(productName, productValue) VALUES ( ?, ?)";
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(statement)) {
            s1.setString(1, stockControl.getProductName());
            s1.setString(2, stockControl.getProductValue());
            Integer rs = s1.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public int deleteItem(StockControl stockControl) {       
        String sql = "DELETE FROM public.stockcontrol WHERE idproduct=?";
         int rows = 0;
                try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, stockControl.getIdProduct());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public int updateItem(StockControl stockControl) {
        int rows = 0;
        String sql = "UPDATE public.stockcontrol SET productName=?, productValue=? WHERE idproduct=?";
        try (PreparedStatement s1 = ConnectionManager.getConnection().prepareStatement(sql)) {
            s1.setInt(1, stockControl.getIdProduct());
            s1.setString(2, stockControl.getProductName());
            s1.setString(3, stockControl.getProductValue());
            rows = s1.executeUpdate();
            return rows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

     public String getStatementId() {
        String statement = "SELECT idproduct FROM public.stockcontrol;";
        return statement;
    }
     
     public Integer getFromRsidPoduct(ResultSet rs) {
        try {
            int data=(rs.getInt("idproduct"));
            return data;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
      
    public List<Integer> getidProduct() {
        List<Integer> listStock = new ArrayList();
        try (PreparedStatement s1 = ConnectionManager.getConnection()
                .prepareStatement(getStatement())) {
            s1.setMaxRows(100);
            try (ResultSet rs = s1.executeQuery()) {
                while (rs.next()) {
                    listStock.add(getFromRsidPoduct(rs));
                }
            }
            return listStock;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}

