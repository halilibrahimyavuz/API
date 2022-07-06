package Utilities.nilApi;

public class Customer {

	private String firstName;
	private String lastName;
	private String middleInitial;
	private String phoneNumber;
	private String address;
	private String email;
	private String ssn;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setMiddleInitial(String middleInitial){
		this.middleInitial = middleInitial;
	}

	public String getMiddleInitial(){
		return middleInitial;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public Customer() {
	}

	public Customer(String firstName, String lastName, String middleInitial, String phoneNumber, String address, String email, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.ssn = ssn;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",middleInitial = '" + middleInitial + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",address = '" + address + '\'' + 
			",email = '" + email + '\'' + 
			",ssn = '" + ssn + '\'' + 
			"}";
		}
}
