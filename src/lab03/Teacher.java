package lab03;



public class Teacher extends Person  {
    private String courseName;

    public Teacher(String firstName, String lastName, String courseName,String emailAddress) {
        super(firstName, lastName,emailAddress);//dziedziczy konstuktor po klasie bazowej
        this.courseName = courseName;
    }
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);//dziedziczy konstuktor po klasie bazowej
        this.courseName = courseName;
    }
    public String courseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }


}
