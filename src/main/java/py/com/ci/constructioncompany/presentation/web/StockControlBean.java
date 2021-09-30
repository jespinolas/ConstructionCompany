package py.com.ci.constructioncompany.presentation.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import py.com.ci.constructioncompany.boundary.StockControlManager;
import py.com.ci.constructioncompany.entities.StockControl;
/**
 *
 * @author martin
 */
@Named("StockControlBean")
@SessionScoped
public class StockControlBean implements Serializable {


    private StockControl stockControl;
    private StockControlManager stockControlManager;
    private List<StockControl> stockControllist;

    @PostConstruct
    public void init(){
        stockControlManager = new StockControlManager();
        stockControl = new StockControl();
        stockControllist= stockControlManager.getAll();
        RequestContext.getCurrentInstance().update("stock-form:dtStock");

    }

    public void logTeacher(){
        if (stockControl != null ){
            System.out.println("StockControlBean  - init > "+ stockControl);
        }else{
            System.out.println("StockControlBean  - init > no result fount");
        }
    }

    public StockControl getStockControl() {
        return stockControl;
    }

    public void setStockControl(StockControl stockControl) {
        this.stockControl = stockControl;
    }

    public StockControlManager getStockControlManager() {
        return stockControlManager;
    }

    public void setStockControlManager(StockControlManager stockControlManager) {
        this.stockControlManager = stockControlManager;
    }

    public List<StockControl> getStockControllist() {
        return stockControllist;
    }

    public void setStockControllist(List<StockControl> stockControllist) {
        this.stockControllist = stockControllist;
    }



    public void addItem() {
        stockControlManager.add(stockControl);
        init();
    }

    public void deleteItem() {
        stockControlManager.deleteItem(stockControl);
        init();
    }

    public void updateItem() {
        stockControlManager.updateItem(stockControl);
        init();
    }
    
        

    
    public void alSeleccionarFila(SelectEvent event) {
                this.stockControl = (StockControl) event.getObject();

        FacesMessage msg = new FacesMessage("Teacher Selected id", String.valueOf(stockControl.getIdProduct()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println("StockControlBean > Seleccionar Fila > " + this.stockControl);

    }
    
    
    public void logSelectedItem() {
        System.out.println("StockControlBean > logSelectedItem  > " + this.stockControl);
    }
    
    


    
    
}
