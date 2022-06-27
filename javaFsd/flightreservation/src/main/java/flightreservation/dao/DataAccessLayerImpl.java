package flightreservation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import flightreservation.entity.Admin;
import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Route;
import flightreservation.entity.TransactionDetails;
import flightreservation.entity.Users;
import flightreservation.util.GetConnection;
import flightreservation.util.GetConnectionImpl;

public class DataAccessLayerImpl implements DataAccessLayer {
private GetConnection getconnection;


	public DataAccessLayerImpl() {
		getconnection=new GetConnectionImpl();
}

	//Users data
	@Override
	public boolean createUser(Users users) {
		boolean temp=false;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
Transaction tx=session.beginTransaction();

	
int isCreated=(Integer) session.save(users);
		tx.commit();
		session.close();
		if(isCreated>0)
		{
			temp=true;
		}
		
		return temp;
	}

	@Override
	public Users getUserByName(String name) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
session.beginTransaction();
		
		Users users=(Users) session.createQuery("From Users where username = :username")
				  .setParameter("username", name)
				  .uniqueResult();
		
		//close transaction
		session.close();
		return users;
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

	
	//Flights data
	@Override
	public Flights getFlightsById(int id) {
		
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		Flights flights=session.get(Flights.class, id);
		
		session.close();
		return flights;
	}

	@Override
	public List<Flights> getAllFlights() {
		SessionFactory factory=getconnection.getConnected();
		
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		List<Flights> flightslist=session.createQuery("from Flights",Flights.class).list();
		
		//close transaction
		session.close();
		
		return flightslist;
	
	}
	
	

	
	
	@Override
	public boolean registerFlight(AirLines airlines,Route route,double price) {
		int isCreated;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
Transaction tx=session.beginTransaction();

	
Flights flights=new Flights();

flights.setAirline_id(airlines);
flights.setRoute_id(route);
flights.setPrice(price);
isCreated= (int) session.save(flights);
		tx.commit();
		session.close();
		
		if(isCreated!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void updateFlightsById(Flights flights) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	
		session.update(flights);
		 System.out.println("user is updated");
		
	
	 tx.commit();
	 session.close();
	}

	@Override
	public void deleteFlightsById(int id) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	Flights flights=session.get(Flights.class, id);
	if(flights!=null)
	{
		session.delete(flights);
		 System.out.println("flights is deleted");
	}
	 tx.commit();
	 session.close();
	}
	

	@Override
	public List<Flights> getFlightsByRoute(String from, String to) {
		List<Flights> flights = null;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	
	List<Route> route=(List<Route>)
	session.createQuery("From Route where source = :source and destination = :destination")
	.setParameter("source", from)
	.setParameter("destination",to).list();
	session.close();

	for (Route route2 : route)
	{
		
	 flights=route2.getFlights();
		
	}

return flights;
	}

	@Override
	public int getUserdIdFromName(String fullName) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	int id= (int)session.createQuery("SELECT u.id FROM Users u WHERE u.full_name=:fullname")
    .setParameter("fullname", fullName).uniqueResult();
	session.close();
		return id;
	}

	@Override
	public Users getUserById(int id) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	Users users=session.get(Users.class, id);
	
	session.close();
		return users;
	}
	//Transaction data
	@Override
	public int createTransaction(Flights flights, Users users, int setBooked, double totalFare, String date) {
		int isCreated;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
Transaction tx=session.beginTransaction();

	
TransactionDetails transaction=new TransactionDetails();

transaction.setFlight_d(flights);
transaction.setUser_id(users);
transaction.setSeats(setBooked);
transaction.setDate_of_journey(date);
transaction.setTotal_price(totalFare);
isCreated= (int) session.save(transaction);
		tx.commit();
		session.close();
		
		
		return isCreated;
	}

	@Override
	public TransactionDetails getDetasilsById(int userId) {
		TransactionDetails transactionDetails=null;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	
	transactionDetails=(TransactionDetails)
			session.createQuery("From TransactionDetails where user_id = "+userId)
			.uniqueResult();
			
			session.close();
			
			return transactionDetails;
	
	}
	//Airlines Business Logics
	@Override
	public boolean createAirline(AirLines airlines) {
		boolean temp=false;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
Transaction tx=session.beginTransaction();

	
int isCreated=(Integer) session.save(airlines);
		tx.commit();
		session.close();
		if(isCreated>0)
		{
			temp=true;
		}
		
		return temp;
	}

	@Override
	public List<AirLines> getAllAirLines() {
	SessionFactory factory=getconnection.getConnected();
		
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		List<AirLines> airLineslist=session.createQuery("from AirLines",AirLines.class).list();
		
		//close transaction
		session.close();
		
		return airLineslist;
	}

	@Override
	public void deleteAirlineById(int id) {
		
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	AirLines airLines=session.get(AirLines.class, id);
	if(airLines!=null)
	{
		session.delete(airLines);
		 System.out.println("user is deleted");
		
	}
	 tx.commit();
	 session.close();
			
	}

	@Override
	public void updateAirlineById(AirLines airlines) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	
		session.update(airlines);
		 System.out.println("user is updated");
		
	
	 tx.commit();
	 session.close();
	}

	@Override
	public AirLines getAirLinesById(int id) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	AirLines airLines=session.get(AirLines.class, id);
	
	session.close();
		return airLines;
	}

	//Route business Logics
	
	
	@Override
	public boolean createRoute(Route route) {
		
		boolean temp=false;
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
Transaction tx=session.beginTransaction();

	
int isCreated=(Integer) session.save(route);
		tx.commit();
		session.close();
		if(isCreated>0)
		{
			temp=true;
		}
		
		return temp;
	}

	@Override
	public List<Route> getAllRoute() {
SessionFactory factory=getconnection.getConnected();
		
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
		
		List<Route> routeList=session.createQuery("from Route",Route.class).list();
		
		//close transaction
		session.close();
		
		return routeList;
	}

	@Override
	public void deleteRouteById(int id) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	Route route=session.get(Route.class, id);
	if(route!=null)
	{
		session.delete(route);
		 System.out.println("route is deleted");
		
	}
	 tx.commit();
	 session.close();
		
	}

	@Override
	public void updateRoute(Route route) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	Transaction tx=session.beginTransaction();
	
		session.update(route);
		 System.out.println("user is updated");
		
	
	 tx.commit();
	 session.close();
	
	}

	@Override
	public Route getRouteById(int id) {
		SessionFactory factory=getconnection.getConnected();
		Session session=factory.getCurrentSession();
	session.beginTransaction();
	Route route=session.get(Route.class, id);
	
	session.close();
		return route;
	}

	//Admin logics
	@Override
	public boolean isValid(Admin admin) {
		String name=admin.getUsername();
		String password=admin.getPassword();
	boolean isvalid=false;
	SessionFactory factory=getconnection.getConnected();
	Session session=factory.getCurrentSession();
session.beginTransaction();
	List results = session.createQuery("from Admin a where a.username=:username AND a.password=:pass")
    .setParameter("username", name)
    .setParameter("pass", password).list();

    

    if ((results!=null) && (results.size()>0)){
        isvalid=true;
    }
    
		return isvalid;
	}

}
