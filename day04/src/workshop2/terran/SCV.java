package workshop2.terran;

import workshop2.GroundUnit;

public class SCV extends GroundUnit {
    public SCV() {
        super("SCV", 60, 5, 0,2); // 이름, HP, 공격력, 방어력
    }

    public void gatherResources() {
        System.out.println("SCV가 자원을 채취합니다.");
    }

    public void build(String structureName) {
        System.out.println("SCV가 " + structureName + "을(를) 건설합니다.");
    }

    @Override
    public void specialAbility() {
        System.out.println("SCV가 수리를 시작합니다.");
    }
}