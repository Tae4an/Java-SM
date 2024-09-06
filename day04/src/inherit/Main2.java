package inherit;

public class Main2 {

    public static void main(String[] args) {
        Employee employee = new Manager(111,"qwer",1000,100);
        System.out.println(employee.toString());
        System.out.println(employee.getAnnSalary());
        /*
         하위 클래스의 함수 사용 불가
        System.out.println(employee.getBonus());

         */
    }
}
