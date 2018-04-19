package aeroplane;

public class CrewMember extends Passenger {

    protected CrewMember(String firstName, String surname) {
        super(firstName, surname);
    }

    @Override
    public boolean isAdult() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Crew";
    }
}
