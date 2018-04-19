package videogame;

// TODO: complete this class as part of Section A Question 3

public class Magician extends Entity implements SpellCaster {

    private final int STRENGTH_FACTOR = 2;

    public Magician(String name, int lifePoints) {
        super(name, lifePoints);
    }

    @Override
    public int minimumStrikeToDestroy() {
        return lifePoints;
    }

    @Override
    public int getStrength() {
        return STRENGTH_FACTOR * lifePoints;
    }
}
