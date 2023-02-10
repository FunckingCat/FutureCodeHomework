package org.future.code.homework.impl.hw4;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature implements Fightable{

    private String className = "Creature";
    private final String name;
    private Integer health;

    private final Integer damage;

    private final Double evasion;

    public Creature(String className, String name, Integer health, Integer damage, Double evasion) {
        this.name = name;
        this.className = className;
        this.health = health;
        this.damage = damage;
        this.evasion = evasion;
    }

    public Creature(Integer health, Integer damage, Double evasion) {
        this.name = "Creature #" + ThreadLocalRandom.current().nextInt();
        this.health = health;
        this.damage = damage;
        this.evasion = evasion;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getDamage() {
        return damage;
    }

    public Double getEvasion() {
        return evasion;
    }

    protected void heal(Integer healPoints) {
        this.health += healPoints;
        System.out.println(name + "полечился на " + healPoints + "HP");
    }

    @Override
    public void takeDamage(Creature creature) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (ThreadLocalRandom.current().nextInt(0, 100) <= evasion * 100) {
            System.out.println();
            System.out.println(name + " уклонился от атаки " + creature.name);
            System.out.println();
            return;
        }

        this.health -= creature.getDamage();
        System.out.println();
        System.out.println(name + " получает " + creature.damage + " от " + creature.name);
        System.out.println("У " + name + " " + this.health + " HP");
        System.out.println();
    }

    @Override
    public String getClassName() {
        return className;
    }
}
