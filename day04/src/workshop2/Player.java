package workshop2;

public class Player {
    private String name;
    private Tribe tribe;

    public Player(String name, Tribe tribe) {
        this.name = name;
        this.tribe = tribe;
    }

    public String getName() {
        return name;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public void createUnit(String unitType) {
        // 유닛 생성 시도
        try {
            // 종족의 유닛 생성 메소드 호출 및 새 유닛 생성
            Unit newUnit = tribe.createUnit(unitType);
            // 생성된 유닛을 플레이어의 유닛 목록에 추가
            tribe.addUnit(newUnit);
            // 유닛 생성 성공 메시지 출력
            System.out.println(name + "님이 " + newUnit.getName() + "을(를) 생성했습니다.");
        } catch (IllegalArgumentException e) {
            // 잘못된 유닛 타입 입력에 대한 예외 처리 및 에러 메시지 출력
            System.out.println(e.getMessage());
        }
    }

    public void showAvailableUnits() {
        System.out.println(name + "님이 생성할 수 있는 유닛 목록 (" + tribe.getName() + "):");
        for (String unitType : tribe.getAvailableUnits()) {
            System.out.println("- " + unitType);
        }
    }

    public void showUnits() {
        System.out.println(name + "님의 유닛 목록 (" + tribe.getName() + "):");
        for (Unit unit : tribe.getUnits()) {
            System.out.println("- " + unit.getName());
        }
    }

    @Override
    public String toString() {
        return "플레이어: " + name + " (종족: " + tribe + ")";
    }
}