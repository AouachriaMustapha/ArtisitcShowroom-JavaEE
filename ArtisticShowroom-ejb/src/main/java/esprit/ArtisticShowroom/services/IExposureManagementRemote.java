package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.ArtisticShowroom.persistence.Artwork;
import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.persistence.Survey;

@Remote
public interface IExposureManagementRemote {
	
	void AddExposure (Exposure exposure);
	void DeleteExposure (Exposure exposure);
	void ModifyExposure (Exposure exposure);
	void AffectArtwork(Exposure exposure, Artwork artwork);
	void AffectSpace (Exposure exposure, Space space);
	void AffectSurvey (Exposure exposure, Survey survey);
	Exposure FindExposure (int id);
	List <Exposure> RecoverListExposures();
	List <Exposure> FindExposureByDate (String dateExp);
	List <Exposure> FindExposureByAdressSpace (String adressSpace);
	List<Artwork> ListArtworks();
	List<Space> ListSpaces();
	List<Survey> ListSurveys();
	List<Space> RentalSpace();
	int NbreDispoSpace();
	int NbreNoDispoSpace();

}
