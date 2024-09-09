package workshop2.terran;

import workshop2.AirUnit;
import workshop2.GroundUnit;
import workshop2.Unit;

public class Wraith extends AirUnit {
    private boolean cloaked;

    public Wraith() {
        super("레이스", 120, 8, 0, 6); // 이름, HP, 공격력, 방어력, 공중 이동 속도
        this.cloaked = false;
    }

    @Override
    public void specialAbility() {
        cloaked = !cloaked;
        if (cloaked) {
            System.out.println(getName() + "가 은신 모드를 활성화합니다.");
        } else {
            System.out.println(getName() + "가 은신 모드를 비활성화합니다.");
        }
    }

    @Override
    public void attack(Unit target) {
        if (target instanceof AirUnit) {
            super.attack(target);
        } else if (target instanceof GroundUnit) {
            int damage = getDamage() / 2; // 지상 유닛에 대한 공격력 감소
            int actualDamage = Math.max(1, damage - target.getArmor());
            target.takeDamage(actualDamage);
            System.out.println(getName() + "이(가) " + target.getName() + "을(를) 공격해 " + actualDamage + "의 데미지를 입혔습니다.");
        }
    }

    public boolean isCloaked() {
        return cloaked;
    }
}