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
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.ISurveyManagementLocal;

@ManagedBean
@ViewScoped
public class statSurvey {
	
	private BarChartModel barModel;
	private List<Survey> surveys;
	private List<Long> lst;
	private List<Long> lst1;
	
	@EJB
	ISurveyManagementLocal surveyLocal;
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    private void createBarModels() {
        createBarModel();
    }
    
    private void createBarModel() {
    	barModel = initBarModel();
         
    	
    	barModel.setTitle("Answers of Questions");
    	barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Survey");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }
	
	   private BarChartModel initBarModel(){
		   
		   BarChartModel model = new BarChartModel();
		   ChartSeries Dispo = new ChartSeries();
		   ChartSeries NoDispo = new ChartSeries();
			surveys = new ArrayList<Survey>();
			lst = new ArrayList<>();
			lst1 = new ArrayList<>();
			lst = surveyLocal.countValidQuestion();
			lst1 = surveyLocal.countNoValidQuestion();
			surveys = surveyLocal.distinctSurveyQuestions();
		   
//   		int n = exposureLocal.NbreDispoSpace();
//   		int m = exposureLocal.NbreNoDispoSpace();
			
			   Dispo.setLabel("Affirmative Questions");
			   NoDispo.setLabel("Negative Questions");
		   
   		for (int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i));
			System.out.println(surveys.get(i));
			Dispo.set(surveys.get(i).getName(),lst.get(i));

		}
   		
   		for (int i=0;i<lst1.size();i++)
		{
			System.out.println(lst1.get(i));
			System.out.println(surveys.get(i));
			NoDispo.set(surveys.get(i).getName(),lst1.get(i));

		}
   		
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

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public List<Long> getLst() {
		return lst;
	}

	public void setLst(List<Long> lst) {
		this.lst = lst;
	}

	public List<Long> getLst1() {
		return lst1;
	}

	public void setLst1(List<Long> lst1) {
		this.lst1 = lst1;
	}
	


}
