import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
    Stream<Student> stream = studentStream.sorted(Comparator.comparingDouble(student -> student.getCoursesResults().get(name)));
    Student[] sort = stream.toArray(Student[]::new);
    return Stream.of(sort[sort.length - 2], sort[sort.length - 3]);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    Stream<Student> sectionStudent = studentStream.filter(student -> student.getSection() == section);
    return sectionStudent.map(student -> new Object[]{
            String.format("Student %s %s", student.getFirstName(), student.getLastName()),
            student.getCoursesResults().values().stream().reduce(0.0, Double::sum) / student.getCoursesResults().size()
    }).toArray();
  }

public int getNumberOfSuccessfulStudents(Stream<Student> studentStream){
  //TODO YOUR CODE HERE
  return (int) studentStream.filter(student -> student.getCoursesResults().values().stream()
          .allMatch(results -> results > 10)).count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    return studentStream.max(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName)).orElse(null);
  }

  public double getFullSum(Stream<Student> studentStream){
    //TODO YOUR CODE HERE
    return studentStream.mapToDouble(student -> student.getCoursesResults().values().stream().reduce(0.0, Double::sum)).reduce(0.0, Double::sum);
  }
}
