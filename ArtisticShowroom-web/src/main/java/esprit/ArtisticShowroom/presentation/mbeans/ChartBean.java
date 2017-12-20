package esprit.ArtisticShowroom.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import esprit.ArtisticShowroom.services.IUserservices;

@ManagedBean
@ViewScoped
public class ChartBean {
	
	private BarChartModel barModel ;
	
	
	 @EJB
	 IUserservices userB;
	
	 
	 @PostConstruct
		public void init()
		{
			createBarModels();
			
		}
	 
	 private void createBarModels()
		{
			createBarModel();
		}
	 
	 public String createBarModel()
		{
			barModel = initBarModel();
			barModel.setTitle("Staus of Artist and Owner");
			barModel.setLegendPosition("ne");
			Axis xAxis = barModel.getAxis(AxisType.X);
			xAxis.setLabel("Type of user");
			Axis yAxis = barModel.getAxis(AxisType.Y);
			yAxis.setLabel("Number");
			
			yAxis.setMin(0);
			yAxis.setMax(5);
			
			return "NewFile.xhtml";
			
		}
		
		   private BarChartModel initBarModel(){
			   
			   BarChartModel model = new BarChartModel();
			   ChartSeries confirmedArtist = new ChartSeries();
			   ChartSeries noConfirmedArtist = new ChartSeries();
			   ChartSeries confirmedOwner = new ChartSeries();
			   ChartSeries noConfirmedOwner = new ChartSeries();
			   
	   		int n = userB.nbrartistconfirm();
	  		int m = userB.nbrartistnoconfirm();
	   		int p = userB.nbrownerconfirm();
	  		int q = userB.nbrownernoconfirm();
			   
	  			confirmedArtist.setLabel("Confirmed Artist");
	  			noConfirmedArtist.setLabel("No Confirmed Artist");
	  			confirmedOwner.setLabel("Confirmed Owner");
	  			noConfirmedOwner.setLabel("No Confirmed Owner");
		    	
	  			confirmedArtist.set("Confirm Artist", n);
	  			noConfirmedArtist.set("No Confirm Artist", m);
	  			confirmedOwner.set("Confirm Owner", p);
	  			noConfirmedOwner.set("No Confirm Owner", q);
		    	
		    	model.addSeries(confirmedArtist);
		    	model.addSeries(noConfirmedArtist);
		    	model.addSeries(confirmedOwner);
		    	model.addSeries(noConfirmedOwner);

		    	
		            return model;
		    	
		    }
		
		
		

		public BarChartModel getBarModel() {
			return barModel;
		}

		public void setBarModel(BarChartModel barModel) {
			this.barModel = barModel;
		}
		
			
		public String returntodash()
		
		{
			
			return "/profiles/dashboard?faces-redirect=true";
		}


}
