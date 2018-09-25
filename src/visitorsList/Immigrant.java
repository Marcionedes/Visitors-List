package visitorsList;

public class Immigrant {
    Integer id;
    String firstName;
    String lastName;
    String passport;
    String dateOfArrival;
    Immigrant next;
    Immigrant before;

    public Immigrant(Integer id, String fname, String lname, String passport, String dateofarrival) {
        this.id = id;
        firstName = fname;
        lastName = lname;
        this.passport = passport;
        dateOfArrival = dateofarrival;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public String getDateOfArrival() {
        return dateOfArrival;
    }
    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }
    public Immigrant getNext() {
        return next;
    }
    public void setNext(Immigrant next) {
        this.next = next;
    }
    public Immigrant getBefore() {
        return before;
    }
    public void setBefore(Immigrant before) {
        this.before = before;
    }
}

