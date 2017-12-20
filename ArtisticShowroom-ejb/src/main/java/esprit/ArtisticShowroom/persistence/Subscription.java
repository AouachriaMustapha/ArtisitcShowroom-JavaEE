package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;



import javax.persistence.*;


@Entity

public class Subscription implements Serializable {

	
	private int id;
	private float price;	
	private String datedebut;
	private String datefin;
	private String etat;
	private String type;
	private Artist artist;
	
	private static final long serialVersionUID = 1L;

	public Subscription() {
		super();
	}  
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int Id) {
		this.id = Id;
	}   
	
	@ManyToOne
	public Artist getArtist() {
		return artist;
	}
	public Artist setArtist(Artist artist) {
		return this.artist = artist;
	}
	
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}

	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}



	
   
}
