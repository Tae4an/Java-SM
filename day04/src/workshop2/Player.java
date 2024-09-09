package workshop2;

import workshop2.terran.SCV;

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

    public void createUnit(int select) {
        String unitType = null;
        if(select ==1) unitType = "SCV";
        else if(select == 2) unitType = "마린";
        else if(select == 3) unitType = "메딕";

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
        int i = 1;
        for (String unitType : tribe.getAvailableUnits()) {
            System.out.printf("[%d]" + unitType+"  ",i++);
        }
        System.out.println();
    }

    public void showUnits() {
        System.out.println(name + "님의 유닛 목록 (" + tribe.getName() + "):");
        int i = 1;
        for (Unit unit : tribe.getUnits()) {
            System.out.printf("[%d]" + unit.getName()+"  ",i++);
        }
        System.out.println();
    }

    public void gatherResources(String unitName) {
        Unit unit = findUnit(unitName);
        if (unit instanceof SCV) {
            ((SCV) unit).gatherResources();
        } else {
            System.out.println(unitName + "은(는) 자원을 채취할 수 없습니다.");
        }
    }

    public void buildStructure(String unitName, String structureName) {
        Unit unit = findUnit(unitName);
        if (unit instanceof SCV) {
            ((SCV) unit).build(structureName);
        } else {
            System.out.println(unitName + "은(는) 건물을 건설할 수 없습니다.");
        }
    }

    public Unit findUnit(String unitName) {
        for (Unit unit : tribe.getUnits()) {
            if (unit.getName().equalsIgnoreCase(unitName)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("해당 이름의 유닛을 찾을 수 없습니다: " + unitName);
    }

    @Override
    public String toString() {
        return "플레이어: " + name + " (종족: " + tribe + ")";
    }
}