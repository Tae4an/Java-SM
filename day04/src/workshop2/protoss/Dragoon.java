package workshop2.protoss;

import workshop2.GroundUnit;
import workshop2.Unit;

public class Dragoon extends GroundUnit {
    private int range;

    public Dragoon() {
        super("드라군", 100, 20, 1, 1); // 이름, HP, 공격력, 방어력, 지상 스피드
        this.range = 4;
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + "이(가) 원거리 공격을 준비합니다.");
    }

    @Override
    public void attack(Unit target) {
        System.out.println(getName() + "이(가) " + target.getName() + "을(를) 원거리에서 공격합니다. 사거리: " + range);
        target.takeDamage(getDamage());
    }

    @Override
    public String toString() {
        return super.toString() + ", 사거리: " + range;
    }
}