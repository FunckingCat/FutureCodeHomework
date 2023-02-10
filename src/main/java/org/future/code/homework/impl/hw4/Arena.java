package org.future.code.homework.impl.hw4;

import java.util.List;
import java.util.Objects;

public class Arena {

    public static void main(String[] args) {
        Troll troll = new Troll("Бориска");
        Elf elf = new Elf("Данилка");
        List<Fightable> creatures = List.of(troll, elf);

        while (!isSomeoneDead(creatures)) {
            for (Fightable attacker : creatures) {
                for (Fightable attacked : creatures) {
                    if (!Objects.equals(attacker.getClassName(), attacked.getClassName())) {
                        if (attacker instanceof Creature)
                            attacked.takeDamage((Creature) attacker);
                    }
                }
            }
        }

        System.out.println();
        for (Fightable fightable : creatures)
            System.out.println(fightable);

    }

    private static boolean isSomeoneDead(List<Fightable> creatures) {
        for (Fightable creature : creatures) {
            if (creature.isDead())
                return true;
        }
        return false;
    }



}
