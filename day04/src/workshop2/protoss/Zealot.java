package workshop2.protoss;

import workshop2.GroundUnit;
import workshop2.Unit;

public class Zealot extends GroundUnit {
    private boolean chargeActivated;

    public Zealot() {
        super("질럿", 100, 8, 1, 2); // 이름, HP, 공격력, 방어력, 지상 스피드
        this.chargeActivated = false;
    }

    @Override
    public void specialAbility() {
        if (!chargeActivated) {
            System.out.println(getName() + "이(가) 차지 능력을 활성화합니다!");
            setGroundSpeed(getGroundSpeed() + 2);
            chargeActivated = true;
        } else {
            System.out.println(getName() + "의 차지 능력이 이미 활성화되어 있습니다.");
        }
    }

    @Override
    public void attack(Unit target) {
        int damage = getDamage();
        if (chargeActivated) {
            damage += 4; // 차지 활성화 시 추가 데미지
        }
        System.out.println(getName() + "이(가) " + target.getName() + "을(를) 공격합니다. 데미지: " + damage);
        target.takeDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString() + ", 차지 상태: " + (chargeActivated ? "활성화" : "비활성화");
    }
}