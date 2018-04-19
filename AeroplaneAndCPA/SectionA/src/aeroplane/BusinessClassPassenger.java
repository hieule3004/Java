package aeroplane;

public class BusinessClassPassenger extends NonCrewPassenger {

    private Luxury luxury;

    protected BusinessClassPassenger(String firstName, String surname, int age, Luxury luxury) {
        super(firstName, surname, age);
        this.luxury = luxury;
    }

    public Luxury getLuxury() {
        return luxury;
    }

    @Override
    public String toString() {
        return super.toString() + " - Business";
    }
}
