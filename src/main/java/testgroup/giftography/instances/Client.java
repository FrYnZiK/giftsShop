package testgroup.giftography.instances;

public class Client {
    private int id;
    private String firstName;
    private String secondName;
    private String address;
    private int phoneNumber;
    private String email;

    public Client(int id, String firstName, String secondName, String address, int phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Client(String firstName, String secondName, String address, int phoneNumber, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
