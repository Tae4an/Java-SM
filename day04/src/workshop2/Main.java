package workshop2;

import workshop2.terran.*;


public class Main {
    public static void main(String[] args) {
        // 테란 종족 생성
        Terran terran = new Terran();

        // 플레이어 생성
        Player player = new Player("TestPlayer", terran);
        System.out.println(player);
        System.out.println();

        // 유닛 생성
        System.out.println("유닛 생성------------------------");
        player.createUnit(1); // SCV 생성
        player.createUnit(2); // 마린 생성
        player.createUnit(3); // 메딕 생성
        player.showUnits();
        System.out.println();

        // SCV
        System.out.println("SCV 생성------------------------");
        SCV scv = (SCV) player.findUnit("SCV");
        scv.move(10, 20);
        scv.gatherResources();
        scv.build("배럭");
        System.out.println();

        // 마린
        System.out.println("마린 생성------------------------");
        Marine marine = (Marine) player.findUnit("마린");
        marine.move(30, 40);
        marine.attack(scv); // SCV를 대상으로 공격
        marine.specialAbility(); // 스팀팩 사용
        System.out.println();


        // 메딕
        System.out.println("메딕 생성------------------------");
        Medic medic = (Medic) player.findUnit("메딕");
        medic.move(50, 60);
        medic.heal(marine); // 마린 치유
        medic.specialAbility();
        System.out.println();

        // 레이스
        System.out.println("레이스 생성------------------------");
        Wraith wraith = new Wraith();
        wraith.move(70, 80);
        wraith.attack(marine);
        wraith.specialAbility(); // 은신 모드 활성화
        System.out.println();


        System.out.println("\n유닛 정보:");
        System.out.println(scv);
        System.out.println(marine);
        System.out.println(medic);
        System.out.println(wraith);

        // 플레이어의 모든 유닛 표시
        player.showUnits();
    }

}