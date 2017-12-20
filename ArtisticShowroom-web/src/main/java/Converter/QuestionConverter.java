package Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import esprit.ArtisticShowroom.presentation.mbeans.questionService;
import esprit.ArtisticShowroom.persistence.QuestionSurvey;

@FacesConverter("qesConv")
public class QuestionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() >= 0) {
            try {
            	questionService qes = (questionService) context.getExternalContext().getApplicationMap().get("questionService");
                return qes.getQuestions().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid question."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((QuestionSurvey) value).getId()-1);
        }
        else {
            return null;
        }
    } 

}
