package workshop2.terran;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Terran extends Tribe {
    public Terran() {
        super("테란");
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of("마린", "메딕");
    }

    @Override
    public Unit createUnit(String unitType) {
        switch (unitType.toLowerCase()) {
            case "마린":
                return new Marine();
            case "메딕":
                return new Medic();
            default:
                throw new IllegalArgumentException("알 수 없는 테란 유닛 타입: " + unitType);
        }
    }
}