package flightreservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()	
	@JoinColumn(name="user_id")
	private Users user_id;
	
	@ManyToOne()	
	@JoinColumn(name="flight_id")
	private Flights flight_d;
	private int seats;
	private String date_of_journey;
	private double total_price;
	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDetails(Users user_id, Flights flight_d, int seats, String date_of_journey, double total_price) {
		super();
		this.user_id = user_id;
		this.flight_d = flight_d;
		this.seats = seats;
		this.date_of_journey = date_of_journey;
		this.total_price = total_price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser_id() {
		return user_id;
	}
	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}
	public Flights getFlight_d() {
		return flight_d;
	}
	public void setFlight_d(Flights flight_d) {
		this.flight_d = flight_d;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getDate_of_journey() {
		return date_of_journey;
	}
	public void setDate_of_journey(String date_of_journey) {
		this.date_of_journey = date_of_journey;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", user_id=" + user_id + ", flight_d=" + flight_d + ", seats=" + seats
				+ ", date_of_journey=" + date_of_journey + ", total_price=" + total_price + "]";
	}

	
}
