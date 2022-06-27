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
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String full_name;
	private String email;
	private String phone_number;
	private String address;
	private int age;
	private String gender;

	@OneToMany(cascade=CascadeType.ALL,mappedBy ="user_id")	
	private List<TransactionDetails> transactionDetails;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Users(String full_name, String email, String phone_number, String address, int age, String gender) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", full_name=" + full_name
				+ ", email=" + email + ", phone_number=" + phone_number + ", address=" + address + ", age=" + age
				+ ", gender=" + gender + ", transactionDetails=" + transactionDetails + "]";
	}

	
	
	
}
