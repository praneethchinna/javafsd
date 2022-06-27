package flightreservation.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import flightreservation.entity.Admin;
import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Route;
import flightreservation.entity.TransactionDetails;
import flightreservation.entity.Users;

public class GetConnectionImpl  implements GetConnection{

	@Override
	public SessionFactory getConnected() {
	
		 SessionFactory factory
	     = new Configuration()
	           .configure("hibernate.cfg.xml")
	           .addAnnotatedClass(Users.class)
	           .addAnnotatedClass(Flights.class)
	           .addAnnotatedClass(TransactionDetails.class)
	           .addAnnotatedClass(Route.class)
	           .addAnnotatedClass(AirLines.class)
	           .addAnnotatedClass(Admin.class)
	            .buildSessionFactory();
		
		return factory;
	}
}
