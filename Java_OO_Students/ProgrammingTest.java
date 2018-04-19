import java.util.HashSet;

public class ProgrammingTest {

	/* WRITE YOUR CODE HERE */

    public static void main(String[] args) {
        Course course = new Course("Example Course", new HashSet<>());
        course.getStudents().add(new Undergraduate("gg4", "GG", "gg4", new Academic("Ricardo Rodriguez")));
        course.getStudents().add(new Undergraduate("pr3", "PR", "pr3", new Academic("Ismael Bento")));
        course.getStudents().add(new Postgraduate("te2", "TE", "te2", new Academic("Ricardo Rodriguez")));
        course.getStudents().add(new Postgraduate("yj34", "YJ", "yj34", new Academic("Ismael Bento")));
        course.getStudents().add(new Postgraduate("jj8", "JJ", "jj8", new Academic("Ismael Bento")));

        Notifier notifier = new Notifier(course.getPostgraduates("Ismael Bento"));
        notifier.doNotifyAll("You have been notified!");
    }

}
