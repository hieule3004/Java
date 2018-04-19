package aeroplane;

public abstract class NonCrewPassenger extends Passenger {

    private final int age;

    protected NonCrewPassenger(String firstName, String surname, int age) {
        super(firstName, surname);
        assert age >= 0: "non-negative age";
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + age + ")";
    }
}
