package lab03;


import java.util.*;

public class Student extends Person {
    private String groupId;
    private List<Double> grades = new ArrayList<>();


    public Student(String firstName, String lastName, String emailAddress,String groupId) {
        super(firstName, lastName,emailAddress);//dziedziczy konstuktor po klasie bazowej
        this.groupId = groupId;
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);//dziedziczy konstuktor po klasie bazowej
    }



    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Double getGradesAverage(){
        double suma=0;
        int i=0;
        List<Double> grades1=getGrades();
        for( double oceny:grades1){
            suma=suma+oceny;
            i++;
        }

        return suma/i;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
}
