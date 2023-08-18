package modelandservice;

public class Employee {
    // attributes
    private String aliasName;
    private String positionInCompany;
    private float costAmountLimit;


    // constructor

    public Employee() {
    }

    public Employee(String name) {
        this.aliasName = name;
        this.positionInCompany = "unknown";
        this.costAmountLimit = 0;

    }

    // getters and setters
    public String getAliasName() {
        return aliasName;
    }

    protected void setPositionInCompany(String positionInCompany) {
        this.positionInCompany = positionInCompany;
    }


    protected void setCostAmountLimit(float amount) {

        this.costAmountLimit = amount;

    }
    public float getCostAmountLimit() {
        return costAmountLimit;
    }

    public String getPositionInCompany() {
        return positionInCompany;
    }


    // logic
    public boolean canApproveThisCostRequest(Employee employee, float requestedCostAmount) {

        return requestedCostAmount <= employee.costAmountLimit;
    }

    @Override
    public String toString() {

        return "Name: " + getAliasName()
                + "\nJob Title: " + getPositionInCompany()
                + "\nCost Request Limit: " + getCostAmountLimit();
    }
}

