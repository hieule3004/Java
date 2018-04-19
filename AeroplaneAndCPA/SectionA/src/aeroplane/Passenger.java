package aeroplane;

public abstract class Passenger {

	// TODO: Section A, Task 2

    private final String firstName;
    private final String surname;

    protected Passenger(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public abstract boolean isAdult();

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
