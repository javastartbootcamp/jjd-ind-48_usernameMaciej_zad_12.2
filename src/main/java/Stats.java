public class Stats {
    private double avgSalary;
    private double lowestSalary;
    private double highestSalary;
    private int employeesDepartment;

    public Stats(double avgSalary, double lowestSalary, double highestSalary, int employeesDepartment) {
        this.avgSalary = avgSalary;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
        this.employeesDepartment = employeesDepartment;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public double getHighestSalary() {
        return highestSalary;
    }

    public int getEmployeesDepartment() {
        return employeesDepartment;
    }
}
