package json.handsonpracticeproblem.jsonfromdatabase;

public class Employee {
    private String employeeID;
    private String name;


    // Constructor
    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;

    }

    // Getters and Setters
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
