import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeesInfoReader {
    static Employee[] readFile(String employeesFile) throws FileNotFoundException {
        final int linesNumber = countLines(employeesFile);
        Employee[] employees = new Employee[linesNumber];
        try (Scanner scanner = new Scanner(new File(employeesFile))) {
            for (int i = 0; i < employees.length; i++) {
                String csvLine = scanner.nextLine();
                employees[i] = createEmployeeFromCsv(csvLine);
            }
        }
        return employees;
    }

    private static Employee createEmployeeFromCsv(String csvLine) {
        String[] data = csvLine.split(";");
        String firstName = data[0];
        String lastName = data[1];
        String pesel = data[2];
        String department = data[3];
        double salary = Double.parseDouble(data[4]);
        return new Employee(firstName, lastName, pesel, department, salary);
    }

    private static int countLines(String employeesFile) throws FileNotFoundException {
        int lines = 0;
        try (Scanner scanner = new Scanner(new File(employeesFile))) {
            while (scanner.hasNextLine()) {
                lines++;
                scanner.nextLine();
            }
        }
        return lines;
    }
}
