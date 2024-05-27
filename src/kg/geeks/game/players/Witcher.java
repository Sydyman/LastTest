package kg.geeks.game.players;

public class Witcher extends Hero {

    private Hero resurrectedHero;

    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SACRAFICE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes, int i) {
        int witcherHp = this.getHealth();
        for (i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && this != heroes[i]) {

                resurrectedHero = heroes[i];
                heroes[i].setHealth(heroes[i].getHealth() + witcherHp);
                this.setHealth(0);

                System.out.println(this.getName() + " пожертвовал жизнью ради " + resurrectedHero.getName());
                return;
            }
        }
    }
}
