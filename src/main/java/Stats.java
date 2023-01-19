public class Stats {
    private double avgSalary;
    private double lowestSalary;
    private double highestSalary;
    private int itDepartment;
    private int supportDepartment;
    private int managementDepartment;

    public Stats(double avgSalary, double lowestSalary, double highestSalary,
                 int itDepartment, int supportDepartment, int managementDepartment) {
        this.avgSalary = avgSalary;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
        this.itDepartment = itDepartment;
        this.supportDepartment = supportDepartment;
        this.managementDepartment = managementDepartment;
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

    public int getItDepartment() {
        return itDepartment;
    }

    public int getSupportDepartment() {
        return supportDepartment;
    }

    public int getManagementDepartment() {
        return managementDepartment;
    }
}
