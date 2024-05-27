package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.LIFE_STEAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int i) {
        int amount = 13;
        if (boss.getHealth() <= 0) {
            System.out.println("Босс уже мертв. Невозможно украсть здоровье.");
            return;
        }

        if (boss.getHealth() < amount) {
            amount = boss.getHealth();
        }

        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        Hero hero = heroes[randomIndex];

        boss.setHealth(boss.getHealth() - amount);
        hero.setHealth(hero.getHealth() + amount);
        System.out.println(this.getName() + " украл " + amount + " здоровья у " + boss.getName() + " и передал его "
                + hero.getName());
    }
}
