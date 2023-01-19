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

        double avgSalary = getAverageSalary(employees);
        System.out.println("Średnia wypłata: " + avgSalary);
        double lowestSalary = getLowestSalary(employees);
        System.out.println("Minimalna wypłata: " + lowestSalary);
        double highestSalary = getHighestSalary(employees);
        System.out.println("Maksymalna wypłata: " + highestSalary);
        int employeesDepartment = getEmployeesDepartment(employees, "IT");

        Stats stats = new Stats(avgSalary, lowestSalary, highestSalary, employeesDepartment);

        try {
            saveToFile("stats.txt", stats);
        } catch (IOException e) {
            System.err.println("Nie udało się dodać danych do pliku o nazwie: " + statsEmployeesFile);
        }
    }

    private static void saveToFile(String statsEmployeesFile, Stats stats) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(statsEmployeesFile));
        writer.write((int) stats.getAvgSalary());
        writer.newLine();
        writer.write((int) stats.getLowestSalary());
        writer.newLine();
        writer.write((int) stats.getHighestSalary());
        writer.newLine();
        writer.write(stats.getEmployeesDepartment());
        writer.newLine();
        writer.close();
    }

    private static int getEmployeesDepartment(Employee[] employees, String department) {
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
        return it + support + management;
    }

    private static double getHighestSalary(Employee[] employees) {
        double highestSalary = 0;
        for (Employee employee : employees) {
            if (highestSalary < employee.getSalary()) {
                highestSalary = employee.getSalary();
            }
        }
        return (int) highestSalary;
    }

    private static double getLowestSalary(Employee[] employees) {
        double lowestSalary = 0;
        for (Employee employee : employees) {
            if (lowestSalary > employee.getSalary()) {
                lowestSalary = employee.getSalary();
            } else if (lowestSalary < employee.getSalary()) {
                lowestSalary = employee.getSalary();
            }
        }
        return (int) lowestSalary;
    }

    private static double getAverageSalary(Employee[] employees) {
        double totalValue = 0;
        for (Employee employee : employees) {
            totalValue += employee.getSalary();
        }
        double avgSalaryResult = totalValue / employees.length;
        return (int) avgSalaryResult;
    }
}
