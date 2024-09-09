package workshop2.protoss;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Protoss extends Tribe {
    public Protoss() {
        super("프로토스");
    }

    @Override
    public Unit createBasicUnit() {
        // 프로토스의 기본 유닛 (예: 질럿)을 생성하는 코드
        // 현재는 구현되지 않았으므로 null을 반환
        return null;
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of(); // 아직 구현된 유닛이 없음
    }
}