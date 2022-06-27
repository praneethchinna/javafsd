package flightreservation.service;

import java.util.List;

import flightreservation.entity.Admin;
import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Route;
import flightreservation.entity.TransactionDetails;
import flightreservation.entity.Users;

public interface ServiceLayer {
	
	//Users data
	
public boolean createUser(Users users);
public Users getUserByName(String name);
public List<Users> getAllUsers();
public boolean deleteUserById(int id);
public boolean updateUserById(int id);
public int getUserdIdFromName(String fullName);
public Users getUserById(int id);

//Flights data
public Flights getFlightsById(int id);
public List<Flights> getAllFlights();
public boolean registerFlight(AirLines airlines,Route route,double price);
public void updateFlightsById(Flights flights);
public void deleteFlightsById(int id);
public List<Flights> getFlightsByRoute(String from,String to);

//Transaction data
public int createTransaction(Flights flights,Users users,int setBooked, double totalFare,String date);
public TransactionDetails getDetasilsById(int userId);

//Airlines Business Logics
public boolean createAirline(AirLines airlines);
public List<AirLines> getAllAirLines();
public void deleteAirlineById(int id);
public void updateAirlineById(AirLines airlines);
public AirLines getAirLinesById(int id);

//Route business Logics
public boolean createRoute(Route route);
public List<Route> getAllRoute();
public void deleteRouteById(int id);
public void updateRoute(Route route);
public Route getRouteById(int id);

//Admin logics
public boolean isValid(Admin admin);
}

