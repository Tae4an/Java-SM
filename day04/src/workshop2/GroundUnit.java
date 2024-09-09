package workshop2;

public abstract class GroundUnit extends Unit {
    private int groundSpeed;

    public GroundUnit(String name, int maxHp, int damage, int armor, int groundSpeed) {
        super(name, maxHp, damage, armor);
        this.groundSpeed = groundSpeed;
    }
    @Override
    public void move(int x, int y) {
        System.out.println(getName() + "이(가) 좌표 (" + x + ", " + y + ")로 이동합니다. 지상 이동 속도: " + groundSpeed);
    }

    public int getGroundSpeed() {
        return groundSpeed;
    }

    protected void setGroundSpeed(int groundSpeed) {
        this.groundSpeed = groundSpeed;
    }
}