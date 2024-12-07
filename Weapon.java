package rpg.inventory.items;

import rpg.enums.ItemType;

public class Weapon extends Item {
    private int attackPower; // Poder de ataque que proporciona el arma

    public Weapon(String name, int value, int attackPower) {
        super(name, value);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public ItemType getType() {
        return ItemType.WEAPON; // Retorna el tipo de ítem
    }
}
