// You can add imports


import java.net.Inet4Address;
import java.util.concurrent.*;

public class ExamGrader {

    // You can add new methods, inner classes, etc.

    public interface RoundingFunction {
        int roundGrade(double grade);
    }


    public static class ExamQuestion {
        public double pointsObtained;
        public ExamQuestion nextQuestion;

        public ExamQuestion(double points, ExamQuestion next) {
            this.pointsObtained = points;
            this.nextQuestion = next;
        }

    }

    /**
     *  Write a method calculateExamGrade that calculates the grade
     *  obtained for an exam. The grade is the sum of the points
     *  obtained in all questions. The questions are provided in a
     *  linked list (class ExamQuestion).
     *
     *  However, the points are real numbers, while the exam grade
     *  is a natural number. To round the grade, the caller of this
     *  method provides a rounding function that you have to use
     *  to obtain the final result.
     *
     *  Look at the test "testWithTwoQuestions" to see how users will
     *  call this method.
     *
     *  You can assume that all points are positive numbers and that
     *  the list of questions is not empty.
     */
    public static int calculateExamGrade(ExamQuestion questions, RoundingFunction roundingFunction) {
         ExamQuestion pointer = questions;
         double sum = 0;
         while (pointer != null){
             sum += pointer.pointsObtained;
             pointer = pointer.nextQuestion;
         }
         return roundingFunction.roundGrade(sum);
    }


    /**
     * Write a method gradeExams that calculates the grades of two exams
     * using two threads to accelerate the grading (one exam graded per thread).
     * The method must return the two grades in an int array.
     * Like for the method calculateExamGrade, the caller of this method
     * provides a rounding function.
     *
     * Look at the test "testTwoShortExams" to see how users will
     * call this method.
     *
     * You MUST use threads (or a threadpool).
     * Catch (and ignore) all exceptions.
     */
    public static int[] gradeExams(ExamQuestion exam1, ExamQuestion exam2, RoundingFunction roundingFunction){
         ExecutorService executorService = Executors.newFixedThreadPool(2);
         Future<Integer> e1 = executorService.submit(()->calculateExamGrade(exam1,roundingFunction));
         Future<Integer> e2 = executorService.submit(()->calculateExamGrade(exam2,roundingFunction));
         int[] array = new int[2];
         try {
             array[0] = e1.get();
             array[1] = e2.get();
             executorService.shutdown();
             return array;
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         } catch (ExecutionException e) {
             throw new RuntimeException(e);
         }


    }
}

