public class ContactInfo {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    long phoneNumber;
    String email;
    public ContactInfo(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getFullName(){
        return firstName+" "+lastName;
    }
}