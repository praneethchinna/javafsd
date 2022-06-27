package flightreservation.service;

import java.util.List;

import flightreservation.dao.DataAccessLayer;
import flightreservation.dao.DataAccessLayerImpl;
import flightreservation.entity.Admin;
import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Route;
import flightreservation.entity.TransactionDetails;
import flightreservation.entity.Users;

public class ServiceLayerImpl implements ServiceLayer{
	
	private DataAccessLayer dao;

	public ServiceLayerImpl() {
		dao=new DataAccessLayerImpl();
	}

	@Override
	public boolean createUser(Users users) {
		// TODO Auto-generated method stub
		return dao.createUser(users);
	}

	@Override
	public Users getUserByName(String name) {
		
		return dao.getUserByName(name);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Flights getFlightsById(int id) {
		// TODO Auto-generated method stub
		return dao.getFlightsById(id);
	}

	@Override
	public List<Flights> getAllFlights() {
		// TODO Auto-generated method stub
		return dao.getAllFlights();
	}

	@Override
	public boolean registerFlight(AirLines airlines,Route route,double price) {
	
		return dao.registerFlight(airlines, route, price);
	}

	@Override
	public void updateFlightsById(Flights flights) {
		dao.updateFlightsById(flights);
		
	}

	@Override
	public void deleteFlightsById(int id) {
		dao.deleteFlightsById(id);
		
	}

	@Override
	public List<Flights> getFlightsByRoute(String from, String to) {
		
		return dao.getFlightsByRoute(from, to);
	}

	@Override
	public int getUserdIdFromName(String fullName) {


		return dao.getUserdIdFromName(fullName);
	}

	@Override
	public Users getUserById(int id) 
	{
		
		return dao.getUserById(id);	
	}

	@Override
	public int createTransaction(Flights flights, Users users, int setBooked, double totalFare, String date) {
	
		return dao.createTransaction(flights, users, setBooked, totalFare, date);
	}

	@Override
	public TransactionDetails getDetasilsById(int userId) {
		
		return dao.getDetasilsById(userId);
	}

	@Override
	public boolean createAirline(AirLines airlines) {
		// TODO Auto-generated method stub
		return dao.createAirline(airlines);
	}

	@Override
	public List<AirLines> getAllAirLines() {
		// TODO Auto-generated method stub
		return dao.getAllAirLines();
	}

	@Override
	public void deleteAirlineById(int id) {
		
		dao.deleteAirlineById(id);
	}

	@Override
	public void updateAirlineById(AirLines airlines) {

		dao.updateAirlineById(airlines);
		
	}

	@Override
	public AirLines getAirLinesById(int id) {
		
		return dao.getAirLinesById(id);
	}

	@Override
	public boolean createRoute(Route route) {
	
		return dao.createRoute(route);
	}

	@Override
	public List<Route> getAllRoute() {
		
		return dao.getAllRoute();
	}

	@Override
	public void deleteRouteById(int id) {
		dao.deleteRouteById(id);
		
	}

	@Override
	public void updateRoute(Route route) {

dao.updateRoute(route);
		
	}

	@Override
	public Route getRouteById(int id) {

		return dao.getRouteById(id);
	}

	@Override
	public boolean isValid(Admin admin) {
	
		return dao.isValid(admin);
	}

	

	

}
