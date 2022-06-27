package flightreservation.entity;

public class UserDetails {
private static String date;
private static int travellers;
private static double totalPrice;
public static String getDate() {
	return date;
}
public static void setDate(String date) {
	UserDetails.date = date;
}
public static int getTravellers() {
	return travellers;
}
public static void setTravellers(int travellers) {
	UserDetails.travellers = travellers;
}
public static double getTotalPrice() {
	return totalPrice;
}
public static void setTotalPrice(double totalPrice) {
	UserDetails.totalPrice = totalPrice;
}

}
