
package modelandservice;
import java.util.ArrayList;

public class Management extends Employee {

    public Management() {
    }

//    methods
    public void setMaxCostAmountLimit(Employee employee, float amount) {

        employee.setCostAmountLimit(amount);

    }

    public void assignPositionInCompany(Employee employee, String jobTitle) {
        employee.setPositionInCompany(jobTitle);
    }

    public void addEmployee( Employee employee, ArrayList<Employee> listOfEmployees) {

        listOfEmployees.add(employee);

    }
}
