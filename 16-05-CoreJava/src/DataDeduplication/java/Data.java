package DataDeduplication.java;

public class Data {

    private int id;
    private String name;
    private String Email;
    private long phoneNumber;

    public Data(int id, String name, String email, long phoneNumber) {
        this.id = id;
        this.name = name;
        Email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                 id+","+name+","+Email+","+phoneNumber;

    }
}
