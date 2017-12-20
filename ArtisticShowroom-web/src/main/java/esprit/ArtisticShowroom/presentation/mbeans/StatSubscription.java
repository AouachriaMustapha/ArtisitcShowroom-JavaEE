package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import esprit.ArtisticShowroom.persistence.Subscription;
import esprit.ArtisticShowroom.services.IsubscriptionLocal;

@ManagedBean
@ViewScoped
public class StatSubscription {
private BarChartModel barModel;
	
	@EJB
	IsubscriptionLocal subscriptionLocal;
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    private void createBarModels() {
        createBarModel();
    }
    
    private void createBarModel() {
    	barModel = initBarModel();
         
    	
    	barModel.setTitle("Number Of Types");
    	barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Type");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }
	
	   private BarChartModel initBarModel(){
		   
		   BarChartModel model = new BarChartModel();
		   ChartSeries Dispo = new ChartSeries();
		   ChartSeries NoDispo = new ChartSeries();
		   
   		int n = subscriptionLocal.NbreTypeSubscriptionClassic();
   		int m = subscriptionLocal.NbreTypeSubscriptionGold();
   		System.out.println(n);
   		System.out.println(m);
		   
		   Dispo.setLabel("Type Classic");
		   NoDispo.setLabel("Type Gold");
	    	
		   Dispo.set("Number Classic", n);
		   NoDispo.set("Number Gold", m);
	    	
	    	model.addSeries(Dispo);
	    	model.addSeries(NoDispo);

	    	
	            return model;
	    	
	    }

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
    
 

}
