import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final String employeesFile = "employees.csv";
        final String statsEmployeesFile = "employees.csv";

        Employee[] employees = new Employee[0];
        try {
            employees = EmployeesInfoReader.readFile("employees.csv");
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku o nazwie: " + employeesFile);
        }

        printAverageSalary(employees);
        printLowestSalary(employees);
        printHighestSalary(employees);
        printEmployeesDepartment(employees);
    }

    private static void saveToFile(Employee[] employees, String statsEmployeesFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(statsEmployeesFile));
        for (Employee employee : employees) {
            writer.write(employee.printAverageSalary(employees));
        }
    }

    private static void printEmployeesDepartment(Employee[] employees) {
        int it = 0;
        int support = 0;
        int management = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals("IT")) {
                it++;
            } else if (employee.getDepartment().equals("Support")) {
                support++;
            } else if (employee.getDepartment().equals("Management")) {
                management++;
            }
        }
        System.out.println("Liczba pracowników pracująca w IT: " + it);
        System.out.println("Liczba pracowników pracująca w Support: " + support);
        System.out.println("Liczba pracowników pracująca w Management: " + management);
    }

    private static void printHighestSalary(Employee[] employees) {
        double highestSalary = 0;
        for (Employee employee : employees) {
            if (highestSalary < employee.getSalary()) {
                highestSalary = employee.getSalary();
            }
        }
        System.out.println("Maksymalna wypłata: " + highestSalary);
    }

    private static void printLowestSalary(Employee[] employees) {
        double lowestSalary = 0;
        for (Employee employee : employees) {
            if (lowestSalary > employee.getSalary()) {
                lowestSalary = employee.getSalary();
            } else if (lowestSalary < employee.getSalary()) {
                lowestSalary = employee.getSalary();
            }
        }
        System.out.println("Minimalna wypłata: " + lowestSalary);
    }

    private static void printAverageSalary(Employee[] employees) {
        double totalValue = 0;
        for (Employee employee : employees) {
            totalValue += employee.getSalary();
        }
        double avgSalaryResult = totalValue / employees.length;
        System.out.println("Średnia wypłata: " + avgSalaryResult);
    }
}
