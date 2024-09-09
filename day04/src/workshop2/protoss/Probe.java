package workshop2.protoss;

import workshop2.GroundUnit;

public class Probe  extends GroundUnit {

    public Probe() {
        super("프로브", 60, 0, 2,2); // 이름, HP, 공격력, 방어력, 지상 스피드
    }

    public void gatherResources() {
        System.out.println("프로브가 자원을 채취합니다.");
    }

    public void build(String structureName) {
        System.out.println("프로브가 " + structureName + "을(를) 건설합니다.");
    }


    @Override
    public void specialAbility() {
        System.out.println("프로브가 수리를 시작합니다.");
    }
}
