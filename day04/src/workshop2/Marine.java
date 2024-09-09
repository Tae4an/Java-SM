package workshop2;

public class Marine extends Unit {
    private boolean stimpackActive;

    public Marine() {
        super("마린", 40, 6, 0);  // 이름, 최대 HP, 기본 공격력, 방어력
        this.stimpackActive = false;
    }

    @Override
    public void specialAbility() {
        if (!stimpackActive && hp > 10) {  // 스팀팩 사용 조건
            stimpackActive = true;
            hp -= 10;
            damage += 2;  // 공격력 증가
            System.out.println(name + "이(가) 스팀팩을 사용했습니다! 공격력이 증가했지만, HP가 10 감소했습니다.");
        } else if (stimpackActive) {
            System.out.println(name + "은(는) 이미 스팀팩을 사용 중입니다!");
        } else {
            System.out.println(name + "은(는) 스팀팩을 사용하기에 HP가 부족합니다!");
        }
    }

    @Override
    public void attack(Unit target) {
        super.attack(target);
        if (stimpackActive) {
            System.out.println(name + "이(가) 스팀팩 효과로 한 번 더 공격합니다!");
            super.attack(target);
        }
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        return baseInfo.substring(0, baseInfo.length() - 1) +  // 마지막 '┘' 제거
                String.format("\n│ 스팀팩: %-25s \n" +
                                "└─────────────────────────────────┘",
                        stimpackActive ? "활성화" : "비활성화");
    }
}