package modelandservice;//        HAVE TO IMPLEMENT OOP_INHERITANCE
//        Organization has hierarchy CEO <- Division Director
//        <- Subdivision Manager <- Program Manager <- Project Manager.
//
//        Project Manager has the authorization to approve costs up to 500$,
//        Program Manager up to 2'000$, Subdivision Manager up to 5'000$,
//        Division Director up to 20'000$ and CEO up to 100'000$.
//
//        Choose your favorite OOP language and implement CLI application
//        using _Chain of Responsibility_ pattern (https://refactoring.guru/design-patterns/chain-of-responsibility)
//        CLI must take in as an input expense request amount and print out who did approve the request.


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

