package flightreservation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String source;
	private String destination;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy ="route_id")	
	private List<Flights> flights;

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}
	public Route(int id,String source, String destination) {
		super();
		this.id=id;
		this.source = source;
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Flights> getFlights() {
		return flights;
	}

	public void setFlights(List<Flights> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}
	
	
}
