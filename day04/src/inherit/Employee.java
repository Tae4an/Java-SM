package inherit;

public class Employee {
    private int empNo;
    private String name;
    private double salary;
    public Employee(){}

    public Employee(int empNo, String name, double salary) {
        this.empNo = empNo;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public double getAnnSalary(){
        return this.salary * 12 *0.92;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
