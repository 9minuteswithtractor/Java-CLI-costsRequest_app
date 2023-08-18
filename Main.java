
import java.util.Scanner;
import java.util.ArrayList;

import modelandservice.Employee;
import modelandservice.Management;

/**
 * // HAVE TO IMPLEMENT OOP_INHERITANCE
 * Organization has hierarchy CEO <- Division Director
 * <- Subdivision Manager <- Program Manager <- Project Manager.
 * <p>
 * Project Manager has the authorization to approve costs up to 500$,
 * Program Manager up to 2'000$, Subdivision Manager up to 5'000$,
 * Division Director up to 20'000$ and CEO up to 100'000$.
 * <p>
 * Choose your favorite OOP language and implement CLI application
 * using _Chain of Responsibility_ pattern (https://refactoring.guru/design-patterns/chain-of-responsibility)
 * CLI must take in as an input expense request amount and print out who did approve the request.
 * -
 */


/**
 * notes:
 * Names are random and have been generated automatically with gpt...
 * 1. John Smith
 * 2. Sarah Johnson
 * 3. David Williams
 * 4. Jennifer Brown
 * 5. Michael Davis
 * 6. Lisa Anderson
 * 7. Robert Taylor
 * 8. Jessica Martinez
 * 9. Matthew Wilson
 * 10. Amanda Thompson
 */

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();


        Management employmentProcess = new Management();
        Employee chiefExecutiveOfficer = new Employee("John Smith");
        employmentProcess.assignPositionInCompany(chiefExecutiveOfficer, "CEO");
        employmentProcess.setMaxCostAmountLimit(chiefExecutiveOfficer, 100_000);
        employmentProcess.addEmployee(chiefExecutiveOfficer, employeeList);


        Employee divisionDirector = new Employee("Sarah Johnson");
        employmentProcess.assignPositionInCompany(divisionDirector, "Division Director");
        employmentProcess.setMaxCostAmountLimit(divisionDirector, 20_000);
        employmentProcess.addEmployee(divisionDirector, employeeList);

        Employee subDivisionManager = new Employee("Robert Taylor");
        employmentProcess.assignPositionInCompany(subDivisionManager, "Subdivision Manager");
        employmentProcess.setMaxCostAmountLimit(subDivisionManager, 5_000);
        employmentProcess.addEmployee(subDivisionManager, employeeList);


        Employee programManager = new Employee("Amanda Thompson");
        employmentProcess.assignPositionInCompany(programManager, "Program Manager");
        employmentProcess.setMaxCostAmountLimit(programManager, 2_000);
        employmentProcess.addEmployee(programManager, employeeList);

        Employee projectManager = new Employee("Alex Hall");
        employmentProcess.assignPositionInCompany(projectManager, "Project Manager");
        employmentProcess.setMaxCostAmountLimit(projectManager, 5_00);
        employmentProcess.addEmployee(projectManager, employeeList);

        float requestedAmount = 0;
        boolean canContinue = false;
        while (!canContinue) {
            System.out.print("Enter amount of costs You need to approve?: ");
            try {
                requestedAmount = Float.valueOf(scan.nextLine());
                canContinue = true;

            } catch (Exception err) {
                System.out.println("Enter valid number!");
            }
        }


        ArrayList<Employee> authorizedToApprove = new ArrayList<>();

        // FIXME => potential BUG => early crash if amount > 100_000
        int lastInChain = employeeList.size() -1 ; // have to check if this can approve

        for (int i = 0; i < employeeList.size(); i++) {

            boolean canApprove = employeeList.get(i).canApproveThisCostRequest(employeeList.get(i), requestedAmount);
//            boolean isInRangeOfAllLimits =
            if (canApprove) {
                authorizedToApprove.add(employeeList.get(i));

                // if the last person in chain cannot approve
            }



        }
//        if (employeeList.get(lastInChain).getCostAmountLimit() < requestedAmount){
//
//            System.out.println("Unfortunately this amount is over the limit ...");
//            System.out.println("Try to lower the costs!");
//
//        }



        String personWhoWillApprove = "";
        String jobTitleWhoWillApprove = "";

        Employee theOneWhoCanApprove = authorizedToApprove.get(0);
        float theAmountOfApproval = authorizedToApprove.get(0).getCostAmountLimit();

        for (int i = 0; i < authorizedToApprove.size(); i++) {

            if (authorizedToApprove.get(i).getCostAmountLimit() <= theOneWhoCanApprove.getCostAmountLimit()) {
                theAmountOfApproval = authorizedToApprove.get(i).getCostAmountLimit();
                personWhoWillApprove = authorizedToApprove.get(i).getAliasName();
                jobTitleWhoWillApprove = authorizedToApprove.get(i).getPositionInCompany();
            }
        }

        System.out.println();
        System.out.println("Expense authorization range cap: " + theAmountOfApproval);
        System.out.println("The right person for this authorization: "
                + personWhoWillApprove + " ( " + jobTitleWhoWillApprove + " )");

        scan.close();
    }
}





