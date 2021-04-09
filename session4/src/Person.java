public class Person {
    private String firstname;
    private String lastname;
    public Person(String fname,String lname){
        firstname=fname;
        lastname=lname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

