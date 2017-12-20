package Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import esprit.ArtisticShowroom.persistence.Exposure;

@FacesConverter("expConv")
public class ExposureConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Exposure exposure = new Exposure();
		exposure.setStartDate(value);
		return exposure;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Exposure) value).getStartDate();
	}

}
