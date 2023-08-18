package modelandservice;


import java.util.ArrayList;

public class Management extends Employee {

    // attributes
    // max => 100'000$
    private String name;
    private float maximumCostThreshold;
    private String positionInCompany = "CEO";
    // constructors



    public Management() {
    }

    public Management(String name, float maxCostAmountLimit) {
        this.name = name;
        this.maximumCostThreshold = maxCostAmountLimit;

    }

//    methods
    public void setMaxCostAmountLimit(Employee employee, float amount) {

        employee.setCostAmountLimit(amount);

    }

    public void assignPositionInCompany(Employee employee, String jobTitle) {
        employee.setPositionInCompany(jobTitle);
    }

    @Override
    public String toString() {

        return "Name: " + this.name
                + "\nJob Title: " + this.positionInCompany
                + "\nCost Request Limit: " + this.maximumCostThreshold;
    }

    public void addEmployee( Employee employee, ArrayList<Employee> listOfEmployees) {

        listOfEmployees.add(employee);

    }
}
