package workshop2.zerg;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Zerg extends Tribe {
    public Zerg() {
        super("저그");
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of("저글링", "히드라리스크");
    }

    @Override
    public Unit createUnit(String unitType) {
        switch (unitType.toLowerCase()) {
            case "저글링":
//                return new Zergling();
            case "히드라리스크":
//                return new Hydralisk();
            default:
                throw new IllegalArgumentException("알 수 없는 저그 유닛 타입: " + unitType);
        }
    }
}