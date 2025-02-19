package csvdatahandling.advanced.convertcsv;

class Student {
    private String name;
    private int age;
    private double gpa;

    // Constructor
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
}

