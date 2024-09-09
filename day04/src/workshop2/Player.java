package workshop2;

import workshop2.terran.Terran;

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
        if (tribe instanceof Terran) {
            try {
                Unit newUnit = ((Terran) tribe).createUnit(unitType);
                tribe.addUnit(newUnit);
                System.out.println(name + "님이 " + newUnit.getName() + "을(를) 생성했습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("해당 종족은 아직 유닛 생성 기능이 구현되지 않았습니다.");
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