package workshop2;

public abstract class Unit {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int damage;
    protected int armor;

    public Unit(String name, int maxHp, int damage, int armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.armor = armor;
    }

    public void attack(Unit target) {
        int damageDealt = Math.max(0, this.damage - target.armor);
        target.takeDamage(damageDealt);
        System.out.println(name + " attacked " + target.name + " for " + damageDealt + " damage");
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
        System.out.println(name + " took " + damage + " damage. Remaining HP: " + hp);
    }

    public void heal(int amount) {
        this.hp = Math.min(maxHp, this.hp + amount);
        System.out.println(name + " healed for " + amount + ". Current HP: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return String.format("┌─────────────────────────────────┐\n" +
                             "│ %-33s \n" +
                             "├─────────────────────────────────┤\n" +
                             "│ HP: %-5d / %-5d               \n" +
                             "│ Damage: %-3d    Armor: %-3d      \n" +
                             "└─────────────────────────────────┘",
                             name, hp, maxHp, damage, armor);
    }

    // 추상 메서드: 각 유닛의 특수 능력
    public abstract void specialAbility();
}