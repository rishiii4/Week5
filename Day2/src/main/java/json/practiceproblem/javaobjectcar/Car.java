package json.practiceproblem.javaobjectcar;

public class Car {
    private String model;
    private String engine;

    // Default constructor (required for Jackson)
    public Car() {}

    // Parameterized constructor
    public Car(String model, String engine) {
        this.model = model;
        this.engine = engine;
    }

    // Getters and setters (required for Jackson)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}

