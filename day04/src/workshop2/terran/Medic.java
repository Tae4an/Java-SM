package workshop2.terran;

import workshop2.GroundUnit;
import workshop2.Unit;

public class Medic extends GroundUnit {
    private int healAmount;

    public Medic() {
        super("메딕", 60, 0, 1, 4); // 이름, HP, 공격력(0), 방어력, 지상 이동 속도
        this.healAmount = 10; // 치유량
    }

    public void heal(Unit target) {
        if (target == this) {
            System.out.println("메딕은 자신을 치유할 수 없습니다.");
            return;
        }
        int healedAmount = Math.min(healAmount, target.getMaxHp() - target.getHp());
        target.setHp(target.getHp() + healedAmount);
        System.out.println(getName() + "이(가) " + target.getName() + "을(를) " + healedAmount + "만큼 치유했습니다.");
    }

    @Override
    public void specialAbility() {
        System.out.println("메딕이 유닛들을 치유할 수 있습니다.");
    }

}