package workshop2;
public abstract class Unit {
    private String name;
    private int hp;
    private int maxHp;
    private int damage;
    private int armor;

    public Unit(String name, int maxHp, int damage, int armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.armor = armor;
    }

    public abstract void move(int x, int y);

    public void attack(Unit target) {
        int damageDealt = Math.max(0, this.damage - target.getArmor());
        target.takeDamage(damageDealt);
        System.out.println(name + "이(가) " + target.getName() + "을(를) 공격해 " + damageDealt + "의 데미지를 입혔습니다.");
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
        System.out.println(name + "이(가) " + damage + "의 데미지를 입었습니다. 남은 HP: " + hp);
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getDamage() { return damage; }
    public int getArmor() { return armor; }

    public void setHp(int hp) { this.hp = Math.max(0, Math.min(maxHp, hp)); }
    public void setDamage(int damage) { this.damage = damage; }

    // 각 유닛의 특수 능력
    public abstract void specialAbility();

    @Override
    public String toString() {
        return String.format("┌─────────────────────────────────┐\n" +
                        "│ %-33s \n" +
                        "├─────────────────────────────────┤\n" +
                        "│ HP: %-5d / %-5d               \n" +
                        "│ 공격력: %-3d    방어력: %-3d      \n" +
                        "└─────────────────────────────────┘",
                name, hp, maxHp, damage, armor);
    }
}