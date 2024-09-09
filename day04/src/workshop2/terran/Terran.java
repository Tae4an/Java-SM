package workshop2.terran;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Terran extends Tribe {
    public Terran() {
        super("테란");
    }

    @Override
    public Unit createBasicUnit() {
        return new Marine();
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of("마린");
    }

    public Unit createUnit(String unitType) {
        switch (unitType.toLowerCase()) {
            case "마린":
                return new Marine();
            default:
                throw new IllegalArgumentException("알 수 없는 유닛 타입: " + unitType);
        }
    }
}