package org.future.code.homework.impl.hw4;

public class Troll extends Creature implements BaseTroll {

    public Troll(String name) {
        super(CLASS_NAME, CLASS_NAME + " " + name, HEALTH, DAMAGE, EVASION);
    }

    @Override
    public boolean isDead() {
        return this.getHealth() <= 0;
    }
}
