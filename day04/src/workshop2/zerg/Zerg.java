package workshop2.zerg;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Zerg extends Tribe {
    public Zerg() {
        super("저그");
    }

    @Override
    public Unit createBasicUnit() {
        // 저그의 기본 유닛 (예: 저글링)을 생성하는 코드
        // 현재는 구현되지 않았으므로 null을 반환
        return null;
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of(); // 아직 구현된 유닛이 없음
    }
}