package workshop2.protoss;

import workshop2.AirUnit;
import workshop2.Unit;

public class Observer extends AirUnit {
    private boolean cloaked;

    public Observer() {
        super("옵저버", 40, 0, 0, 3); // 이름, HP, 공격력, 방어력, 공중 스피드
        this.cloaked = true;
    }

    @Override
    public void specialAbility() {
        if (cloaked) {
            System.out.println(getName() + "이(가) 은신을 해제합니다.");
            cloaked = false;
        } else {
            System.out.println(getName() + "이(가) 은신합니다.");
            cloaked = true;
        }
    }

    public void detect() {
        System.out.println(getName() + "이(가) 주변의 은신 유닛을 탐지합니다.");
    }

    @Override
    public String toString() {
        return super.toString() + ", 은신 상태: " + (cloaked ? "활성화" : "비활성화");
    }
}