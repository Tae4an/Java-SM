package workshop2;

public abstract class AirUnit extends Unit {
    private int airSpeed;

    public AirUnit(String name, int maxHp, int damage, int armor, int airSpeed) {
        super(name, maxHp, damage, armor);
        this.airSpeed = airSpeed;
    }

    @Override
    public void move(int x, int y) {
        System.out.println(getName() + "이(가) 좌표 (" + x + ", " + y + ")로 비행합니다. 공중 이동 속도: " + airSpeed);
    }

    public int getAirSpeed() {
        return airSpeed;
    }

    protected void setAirSpeed(int airSpeed) {
        this.airSpeed = airSpeed;
    }
}