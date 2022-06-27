package flightreservation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airlines")
public class AirLines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String airline;
	private int total_seats;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy ="airline_id")	
	private List<Flights> flights;
	public AirLines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AirLines(String airline,int seats)
	{
		super();
		this.airline=airline;
		this.total_seats = seats;
	}
	public AirLines(int id,String airline, int seats) {
		super();
		this.id=id;
		this.airline = airline;
		this.total_seats = seats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getSeats() {
		return total_seats;
	}
	public void setSeats(int seats) {
		this.total_seats = seats;
	}
	
	public List<Flights> getFlights() {
		return flights;
	}
	public void setFlights(List<Flights> flights) {
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "AirLines [id=" + id + ", airline=" + airline + ", seats=" + total_seats + "]";
	}
	
	
}
