package workshop2;

public class Main {
    public static void main(String[] args) {
        Marine marine1 = new Marine();
        System.out.println(marine1);

        marine1.specialAbility();  // 스팀팩 사용
        System.out.println(marine1);

        Unit enemy = new Marine();  // 적 마린 생성
        marine1.attack(enemy);  // 스팀팩 상태에서 공격 (두 번 공격)
    }
}
