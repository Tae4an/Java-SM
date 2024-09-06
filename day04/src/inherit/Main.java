package inherit;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(100,"Taesan",5000);
        Manager manager = new Manager(101,"Taesan2",5000,500);

        System.out.println(employee.getSalary());
        System.out.println(manager.getSalary());
        System.out.println(manager.getBonus());

        System.out.println(employee.getAnnSalary());
        System.out.println(manager.getAnnSalary());

        System.out.println(employee.toString());
        System.out.println(manager.toString());
    }
}
