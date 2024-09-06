package inherit;

public class Main3 {
    public static void main(String[] args) {
        Employee [] employees = new Employee[4];

        employees[0] = new Employee(100,"a",1000);
        employees[1] = new Employee(101,"b",2000);
        employees[2] = new Manager(102,"c",3000,100);
        employees[3] = new Manager(103,"d",4000,200);

        for(Employee e : employees){
            System.out.println(e);
        }
    }
}
