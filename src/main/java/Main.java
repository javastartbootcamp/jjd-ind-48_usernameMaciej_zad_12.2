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
        int itDepartment = getEmployeesDepartment(employees, "IT");
        System.out.println("Liczba pracowników z działu IT: " + itDepartment);
        int supportDepartment = getEmployeesDepartment(employees, "Support");
        System.out.println("Liczba pracowników z działu Support: " + supportDepartment);
        int managementDepartment = getEmployeesDepartment(employees, "Management");
        System.out.println("Liczba pracowników z działu Management: " + managementDepartment);

        Stats stats = new Stats(avgSalary, lowestSalary, highestSalary, itDepartment, supportDepartment, managementDepartment);

        try {
            saveToFile("stats.txt", stats);
        } catch (IOException e) {
            System.err.println("Nie udało się dodać danych do pliku o nazwie: " + statsEmployeesFile);
        }
    }

    private static void saveToFile(String statsEmployeesFile, Stats stats) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(statsEmployeesFile));
        writer.write("Średnia wypłata: ");
        writer.write(Double.toString(stats.getAvgSalary()));
        writer.newLine();
        writer.write("Minimalna wypłata: ");
        writer.write(Double.toString(stats.getLowestSalary()));
        writer.newLine();
        writer.write("Maksymalna wypłata: ");
        writer.write(Double.toString(stats.getHighestSalary()));
        writer.newLine();
        writer.write("Liczba pracowników z działu IT: " + Integer.toString(stats.getItDepartment()));
        writer.newLine();
        writer.write("Liczba pracowników z działu Support: " + Integer.toString(stats.getSupportDepartment()));
        writer.newLine();
        writer.write("Liczba pracowników z działu Management: " + Integer.toString(stats.getManagementDepartment()));
        writer.newLine();
        writer.close();
    }

    private static int getEmployeesDepartment(Employee[] employees, String department) {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                counter++;
            }
        }
        return counter;
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
