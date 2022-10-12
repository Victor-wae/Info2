import com.github.guillaumederval.javagrading.Grade;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HomeworkGradingTest {


    List<HomeworkGrading.Homework> oneHomework=Arrays.asList(new HomeworkGrading.Homework[]{
            new HomeworkGrading.Homework(5),
    });

    List<HomeworkGrading.Homework> twoHomeworks=Arrays.asList(new HomeworkGrading.Homework[]{
            new HomeworkGrading.Homework(5),
            new HomeworkGrading.Homework(15),
    });

    List<HomeworkGrading.Homework> sixHomeworks=Arrays.asList(new HomeworkGrading.Homework[]{
            new HomeworkGrading.Homework(5),
            new HomeworkGrading.Homework(15),
            new HomeworkGrading.Homework(7),
            new HomeworkGrading.Homework(12),
            new HomeworkGrading.Homework(1),
            new HomeworkGrading.Homework(14),
    });

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testSingleHomework() {
        HomeworkGrading twoAssistants=new HomeworkGrading();
        twoAssistants.startGrading(oneHomework);
        twoAssistants.waitForGrading();
        Assert.assertEquals(15, twoAssistants.getAverageGrade());
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testTwoHomeworks() {
        HomeworkGrading twoAssistants=new HomeworkGrading();
        twoAssistants.startGrading(twoHomeworks);
        twoAssistants.waitForGrading();
        Assert.assertEquals(10, twoAssistants.getAverageGrade());
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testSixHomeworks() {
        HomeworkGrading twoAssistants=new HomeworkGrading();
        twoAssistants.startGrading(sixHomeworks);

        // Grading takes time. At this moment, the grading should not be
        // already finished.
        Assert.assertNotEquals(6, twoAssistants.getNumberOfFinishedGradedHomeworks());

        // Check the final result
        twoAssistants.waitForGrading();
        Assert.assertEquals(11, twoAssistants.getAverageGrade());
    }

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testCancelGrading() {
        HomeworkGrading twoAssistants=new HomeworkGrading();
        twoAssistants.startGrading(sixHomeworks);

        // cancel grading
        twoAssistants.cancelGrading();
        twoAssistants.waitForGrading();

        // Since we have canceled immediately, the number of finished
        // homeworks should be less than 6.
        Assert.assertNotEquals(6, twoAssistants.getNumberOfFinishedGradedHomeworks());
    }

}
