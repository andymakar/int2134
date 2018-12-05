// Zachary Schoff
// 12 - 4 - 2018
// INT - 2134
// Client class that handles clients and all their attributes
package kapoof.testfile;
public class Client {
    private String firstName = "DEFAULT CLIENT FIRST NAME";
    private String lastName = "DEFAULT CLIENT LAST NAME";
    private String phoneNumber = "123 456 7890";
    private String address = "1234 DEFAULT STREET";
    private String email = "defaultemailaddress@gmail.com";
    private int count = 0;
    Client(){}
    Client(String newFirstName, String newLastName, String newPhoneNumber, String newAddress, String newEmail){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
        count = count++;
    }
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }
    public void setAddress(String newAddress){
        this.address = newAddress;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public int getCount() {
        return count;
    }
    public String toString(){
        return "_________________________\nFirst name: " + this.firstName + "\nLast name: " + this.lastName + "\nPhone number: " + this.phoneNumber + "\nAddress: " + this.address + "\n_________________________\n";
    }
    
}
