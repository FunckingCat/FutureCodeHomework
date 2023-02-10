package org.future.code.homework.impl.hw4;

import java.util.concurrent.ThreadLocalRandom;

public class Elf extends Creature implements BaseElf {

    public Elf(String name) {
        super(CLASS_NAME, CLASS_NAME + " " + name, HEALTH, DAMAGE, EVASION);
    }
    @Override
    protected void heal(Integer healPoints) {
        super.heal(healPoints);
    }

    @Override
    public boolean isDead() {
        if (this.getHealth() < 0 && ThreadLocalRandom.current().nextInt() % 2 == 0)
            heal(30);
        return false;
    }


}
