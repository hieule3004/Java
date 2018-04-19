package videogame;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GameReport {

	public static void main(String[] args) {

		// TODO: complete this method as part of Section A Question 5

		TransportUnit t1 = new TransportUnit("Falkor", 2500);
		TransportUnit t2 = new TransportUnit("Shadowfax", 350);
		Magician m1 = new Magician("Ged", 300);
		Magician m2 = new Magician("Dumbledore", 200);
		Magician m3 = new Magician("Saruman", 600);
		Magician m4 = new Magician("Harry", 18);
		Magician m5 = new Magician("Gandalf", 950);
		Magician m6 = new Magician("Gargamel", 200);
		t1.add(t2); t1.add(m1); t1.add(m2); t1.add(m3);
		t2.add(m4); t2.add(m5);

		System.out.println(t1);
		t1.applySpell(m6);
		System.out.println(t1);

		Magician m7 = new Magician("Your choice", t1.minimumStrikeToDestroy() / 2);

		t1.applySpell(m7);
		System.out.println(t1);

		List<Entity> deadList = Arrays.asList(t1, t2, m1, m2, m3, m4, m5);
		for (Entity entity : deadList) {
			assert !entity.isAlive(): entity + " is alive";
		}
		List<Entity> aliveList = Arrays.asList(m6, m7);
		for (Entity entity : aliveList) {
			assert entity.isAlive(): entity + "is not alive";
		}
	}

}
