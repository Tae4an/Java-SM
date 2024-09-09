package workshop2;

import workshop2.protoss.Protoss;
import workshop2.terran.Terran;
import workshop2.zerg.Zerg;

public class Main {
    public static void main(String[] args) {
        // 플레이어 생성
        Player player1 = new Player("Player1", new Terran());
        Player player2 = new Player("Player2", new Protoss());
        Player player3 = new Player("Player3", new Zerg());

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);

        // 사용 가능한 유닛 목록 표시
        player1.showAvailableUnits();
        player2.showAvailableUnits();
        player3.showAvailableUnits();

        // 유닛 생성
        player1.createUnit("마린");
        player1.createUnit("마린");
        player1.createUnit("탱크"); // 존재하지 않는 유닛 타입
        player2.createUnit("질럿"); // 프로토스 유닛은 아직 구현되지 않았습니다
        player3.createUnit("저글링"); // 저그 유닛은 아직 구현되지 않았습니다



        // 유닛 목록 표시
        player1.showUnits();
        player2.showUnits();
        player3.showUnits();
    }
}
