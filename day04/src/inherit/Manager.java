package inherit;

public class Manager extends Employee{
    private double bonus;
    public Manager(){}

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(int empNo, String name, double salary, double bonus) {
        super(empNo, name, salary);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "empNo=" + getEmpNo() +
                ", name='" + getName()+ '\'' +
                ", salary=" + getSalary() + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public double getAnnSalary() {
        return super.getAnnSalary() + this.bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
