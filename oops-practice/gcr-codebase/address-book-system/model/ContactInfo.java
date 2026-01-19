import java.util.Objects;
public class ContactInfo {
    // Use Case 1 : Create contacts
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phoneNumber;
    private String email;
    public ContactInfo(String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInfo)) return false;
        ContactInfo person = (ContactInfo) o;
        return firstName.equalsIgnoreCase(person.firstName) && lastName.equalsIgnoreCase(person.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
    @Override
    public String toString() {
        return getFullName() + " | " + phoneNumber + " | " + email;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
}