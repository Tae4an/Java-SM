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
        return List.of("SCV","마린", "메딕","레이스");
    }

    @Override
    public Unit createUnit(String unitType) {
        return switch (unitType.toLowerCase()) {
            case "scv" -> new SCV();
            case "마린" -> new Marine();
            case "메딕" -> new Medic();
            case "레이스" -> new Wraith();
            default -> throw new IllegalArgumentException("알 수 없는 테란 유닛 타입: " + unitType);
        };
    }
}