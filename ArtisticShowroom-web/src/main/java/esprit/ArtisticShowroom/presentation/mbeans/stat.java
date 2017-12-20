package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean
@ViewScoped
public class stat {
	
	private PieChartModel pieModel1;
	private List<Space> spaces;
	
	@EJB
	IExposureManagementLocal exposureLocal;
	
    @PostConstruct
    public void init() {
        
        spaces = new ArrayList<>();
        spaces = exposureLocal.ListSpaces();
        graph(spaces);
        
    }

    
    private void graph(List<Space> spaces){
    	pieModel1 = new PieChartModel();
    	
    	
    	for (Space space : spaces )
    	{ 
    		float n = space.getRentalPrice();
    		pieModel1.set(space.getName(), n);
    	}
    	
    	pieModel1.setTitle("Rental price spaces");
        pieModel1.setLegendPosition("w");
    	
    	
    	
    }


	public PieChartModel getPieModel1() {
		return pieModel1;
	}


	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}


	public List<Space> getSpaces() {
		return spaces;
	}


	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}



    
 

}
