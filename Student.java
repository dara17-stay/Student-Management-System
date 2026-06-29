import java.io.Serializable;

public class Student implements Serializable {

    private String matricNo;
    private String name;
    private String department;
    private int level;
    private double gpa;

    public Student(String matricNo, String name, String department, int level, double gpa) {
        this.matricNo = matricNo;
        this.name = name;
        this.department = department;
        this.level = level;
        this.gpa = gpa;
    }

    // Getters
    public String getMatricNo() {
        return matricNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getLevel() {
        return level;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getClassification() {

        if (gpa >= 4.50)
            return "First Class";
        else if (gpa >= 3.50)
            return "Second Class Upper";
        else if (gpa >= 2.40)
            return "Second Class Lower";
        else if (gpa >= 1.50)
            return "Third Class";
        else
            return "Pass";
    }

    @Override
    public String toString() {

        return String.format(
                "\nMatric No : %s\nName : %s\nDepartment : %s\nLevel : %d\nGPA : %.2f\nClassification : %s",
                matricNo,
                name,
                department,
                level,
                gpa,
                getClassification());
    }
}