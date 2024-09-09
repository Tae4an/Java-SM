package workshop2.protoss;

import workshop2.Tribe;
import workshop2.Unit;

import java.util.List;

public class Protoss extends Tribe {

    public Protoss() {
        super("프로토스");
    }

    @Override
    public List<String> getAvailableUnits() {
        return List.of("프로브","질럿","드라곤","옵저버");
    }

    @Override
    public Unit createUnit(String unitType) {
        switch (unitType.toLowerCase()){
            case "프로브" ->{
               return new Probe();
            }
            case "질럿" -> {
                return  new Zealot();
            }
            case "드라군" -> {
                return  new Dragoon();
            }
            case "옵저버" ->{
                return new Observer();
            }
            default ->
                throw new IllegalArgumentException("알 수 없는 프로토스 유닛 타입: " + unitType);
        }
    }
}
