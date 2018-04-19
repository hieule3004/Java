package videogame;

// TODO: complete this class as part of Section A Question 4

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TransportUnit extends Entity {

    private Set<Entity> transporting;
    private final int DAMAGE_PERCENTAGE = 50;
    private final int PERCENTAGE = 100;

    public TransportUnit(String name, int lifePoints) {
        super(name, lifePoints);
        this.transporting = new HashSet<>();
    }

    public void add(Entity entity) {
        transporting.add(entity);
    }

    @Override
    protected int propagateDamage(int damageAmount) {
        int totalDamage = super.propagateDamage(damageAmount);
        for (Entity entity : transporting) {
            totalDamage += entity.propagateDamage(damageAmount * DAMAGE_PERCENTAGE / PERCENTAGE);
        }
        return totalDamage;
    }

    @Override
    public int minimumStrikeToDestroy() {
        int max = lifePoints;
        for (Entity entity : transporting) {
            max = Math.max(max, entity.minimumStrikeToDestroy() * PERCENTAGE / DAMAGE_PERCENTAGE);
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString() + " transporting : [");
        for (Iterator<Entity> iterator = transporting.iterator(); iterator.hasNext();) {
            s.append(iterator.next().toString());
            if (iterator.hasNext()) {
                s.append(", ");
            }
        }
        s.append(']');
        return s.toString();
    }
}
