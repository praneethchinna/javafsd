package flightreservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()	
	@JoinColumn(name="airline_id")
	private AirLines airline_id;
	
	@ManyToOne()	
	@JoinColumn(name="route_id")
	private Route route_id;
	private double price;
	private String arrival;
	private String departure;
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flights(int id, AirLines airline_id, Route route_id, double price)
	{
		super();
		this.id=id;
		this.airline_id = airline_id;
		this.route_id=route_id;
		this.price=price;
	}
	public Flights(AirLines airline_id, Route route_id, double price, String arrival, String departure) {
		super();
		this.airline_id = airline_id;
		this.route_id = route_id;
		this.price = price;
		this.arrival = arrival;
		this.departure = departure;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AirLines getAirline_id() {
		return airline_id;
	}
	public void setAirline_id(AirLines airline_id) {
		this.airline_id = airline_id;
	}
	public Route getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Route route_id) {
		this.route_id = route_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	@Override
	public String toString() {
		return "Flights [id=" + id + ", airline_id=" + airline_id + ", route_id=" + route_id + ", price=" + price
				+ ", arrival=" + arrival + ", departure=" + departure + "]";
	}
	
	

}
