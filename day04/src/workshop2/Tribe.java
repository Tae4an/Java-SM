package workshop2;

import java.util.ArrayList;
import java.util.List;

public abstract class Tribe {
    protected String name;
    protected List<Unit> units;

    public Tribe(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public abstract Unit createBasicUnit();
    
    public abstract List<String> getAvailableUnits();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}




