package aeroplane;

public class EconomyClassPasssenger extends NonCrewPassenger {

    protected EconomyClassPasssenger(String firstName, String surname, int age) {
        super(firstName, surname, age);
    }

    @Override
    public String toString() {
        return super.toString() + " - Economy";
    }
}
