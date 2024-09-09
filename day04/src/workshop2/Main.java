package workshop2;

import workshop2.protoss.Protoss;
import workshop2.terran.*;
import workshop2.protoss.*;


public class Main {
    public static void main(String[] args) {
        // 프로토스 플레이어 생성
        Player player = new Player("태산", new Protoss());
        System.out.println(player);
        System.out.println();

        // 유닛 생성
        System.out.println("유닛 생성------------------------");
        player.createUnit("프로브");
        player.createUnit("질럿");
        player.createUnit("드라군");
        player.createUnit("옵저버");
        player.showUnits();
        System.out.println();

        // 프로브
        System.out.println("프로브 테스트------------------------");
        Probe probe = (Probe) player.findUnit("프로브");
        probe.move(10, 20);
        probe.gatherResources();
        probe.build("파일런");
        System.out.println();

        // 질럿
        System.out.println("질럿 테스트------------------------");
        Zealot zealot = (Zealot) player.findUnit("질럿");
        zealot.move(30, 40);
        zealot.attack(probe); // 프로브를 대상으로 공격
        zealot.specialAbility(); // 차지 사용
        System.out.println();

        // 드라군
        System.out.println("드라군 테스트------------------------");
        Dragoon dragoon = (Dragoon) player.findUnit("드라군");
        dragoon.move(50, 60);
        dragoon.attack(zealot); // 질럿 공격
        dragoon.specialAbility();
        System.out.println();

        // 옵저버
        System.out.println("옵저버 테스트------------------------");
        Observer observer = (Observer) player.findUnit("옵저버");
        observer.move(70, 80);
        observer.specialAbility(); // 은신 모드 전환
        observer.detect(); // 탐지 능력 사용
        System.out.println();

        System.out.println("\n유닛 정보:");
        System.out.println(probe);
        System.out.println(zealot);
        System.out.println(dragoon);
        System.out.println(observer);

        player.showUnits();



//        // 테란 플레이어 생성
//        Player player = new Player("태산", new Terran());
//        System.out.println(player);
//        System.out.println();
//
//        // 유닛 생성
//        System.out.println("유닛 생성------------------------");
//        player.createUnit("SCV"); // SCV 생성
//        player.createUnit("마린"); // 마린 생성
//        player.createUnit("메딕"); // 메딕 생성
//        player.createUnit("레이스"); // 레이스 생성
//        player.showUnits();
//        System.out.println();
//
//        // SCV
//        System.out.println("SCV 생성------------------------");
//        SCV scv = (SCV) player.findUnit("SCV");
//        scv.move(10, 20);
//        scv.gatherResources();
//        scv.build("배럭");
//        System.out.println();
//
//        // 마린
//        System.out.println("마린 생성------------------------");
//        Marine marine = (Marine) player.findUnit("마린");
//        marine.move(30, 40);
//        marine.attack(scv); // SCV를 대상으로 공격
//        marine.specialAbility(); // 스팀팩 사용
//        System.out.println();
//
//
//        // 메딕
//        System.out.println("메딕 생성------------------------");
//        Medic medic = (Medic) player.findUnit("메딕");
//        medic.move(50, 60);
//        medic.heal(marine); // 마린 치유
//        medic.specialAbility();
//        System.out.println();
//
//        // 레이스
//        System.out.println("레이스 생성------------------------");
//        Wraith wraith = new Wraith();
//        wraith.move(70, 80);
//        wraith.attack(marine);
//        wraith.specialAbility(); // 은신 모드 활성화
//        System.out.println();
//
//
//        System.out.println("\n유닛 정보:");
//        System.out.println(scv);
//        System.out.println(marine);
//        System.out.println(medic);
//        System.out.println(wraith);
//
//        player.showUnits();
    }

}