package Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.presentation.mbeans.surveyService;

@FacesConverter("surveyConv")
public class SurveyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() >= 0) {
            try {
            	surveyService survey = (surveyService) context.getExternalContext().getApplicationMap().get("surveyService");
                return survey.getSurveys().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid survey."));
            }
        }
        else {
            return null;
        }
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

        if(value != null) {
            return String.valueOf(((Survey) value).getId()-1);
        }
        else {
            return null;
        }
    } 

}
