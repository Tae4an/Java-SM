package workshop2.terran;

import workshop2.GroundUnit;

public class Marine extends GroundUnit {
    private boolean stimpackActive;

    public Marine() {
        super("마린", 40, 6, 0, 4);  // 이름, 최대 HP, 기본 공격력, 방어력, 지상 이동 속도
        this.stimpackActive = false;
    }

    @Override
    public void specialAbility() {
        if (!stimpackActive && getHp() > 10) {  // 스팀팩 사용 조건
            stimpackActive = true;
            setHp(getHp() - 10);
            setDamage(getDamage() + 2);  // 공격력 증가
            setGroundSpeed(getGroundSpeed() + 2);  // 이동 속도 증가
            System.out.println(getName() + "이(가) 스팀팩을 사용했습니다! 공격력과 이동 속도가 증가, HP가 10 감소.");
        } else if (stimpackActive) {
            System.out.println(getName() + "은(는) 이미 스팀팩을 사용 중입니다!");
        } else {
            System.out.println(getName() + "은(는) 스팀팩을 사용하기에 HP가 부족합니다!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " \n| 스팀팩: " + (stimpackActive ? "활성화\n" : "비활성화\n") +
                "└─────────────────────────────────┘\n";
    }
}