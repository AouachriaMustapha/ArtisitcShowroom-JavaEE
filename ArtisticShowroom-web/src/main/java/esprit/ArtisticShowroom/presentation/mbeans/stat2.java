package esprit.ArtisticShowroom.presentation.mbeans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean
@ViewScoped
public class stat2 {

	private BarChartModel barModel;
	
	@EJB
	IExposureManagementLocal exposureLocal;
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    private void createBarModels() {
        createBarModel();
    }
    
    private void createBarModel() {
    	barModel = initBarModel();
         
    	
    	barModel.setTitle("Disponibility of spaces");
    	barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Disponibility");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
	
	   private BarChartModel initBarModel(){
		   
		   BarChartModel model = new BarChartModel();
		   ChartSeries Dispo = new ChartSeries();
		   ChartSeries NoDispo = new ChartSeries();
		   
   		int n = exposureLocal.NbreDispoSpace();
   		int m = exposureLocal.NbreNoDispoSpace();
		   
		   Dispo.setLabel("Space Dispo");
		   NoDispo.setLabel("Space No Dispo");
	    	
		   Dispo.set("Disponible Spaces", n);
		   NoDispo.set("No Disponible Spaces", m);
	    	
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
