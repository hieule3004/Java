import java.util.HashSet;
import java.util.Set;

public class Course {

	/* WRITE YOUR CODE HERE */

    private String name;
    private Set<Student> students;

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Postgraduate> getPostgraduates(String nameOfSupervisor) {
        Set<Postgraduate> postgraduates = new HashSet<>();
        for (Student student : students) {
            if (student instanceof Postgraduate) {
                Postgraduate postgraduate = ((Postgraduate) student);
                if (((Postgraduate) student).getSupervisor().getName().equals(nameOfSupervisor)) {
                    postgraduates.add(postgraduate);
                }
            }
        }
        return postgraduates;
    }
}
