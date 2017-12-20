package Converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import esprit.ArtisticShowroom.presentation.mbeans.spaceService;
import esprit.ArtisticShowroom.persistence.Space;

@FacesConverter("spaceConv")
public class SpaceConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() >= 0) {
            try {
            	spaceService space = (spaceService) context.getExternalContext().getApplicationMap().get("spaceService");
                return space.getSpaces().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid space."));
            }
        }
        else {
            return null;
        }
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

        if(value != null) {
            return String.valueOf(((Space) value).getId()-1);
        }
        else {
            return null;
        }
    } 

}
