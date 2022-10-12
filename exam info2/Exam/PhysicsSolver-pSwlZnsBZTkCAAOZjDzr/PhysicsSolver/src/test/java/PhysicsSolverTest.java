import com.github.guillaumederval.javagrading.Grade;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhysicsSolverTest {

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void testSlot() {
        PhysicsSolver.Slot s = new PhysicsSolver.Slot();
        assertFalse(s.hasValue());
        assertTrue(s.setValue(42));
        assertTrue(s.hasValue());      
        assertEquals(42, s.getValue(), 0.001);
        assertFalse(s.setValue(42));
        s.clearValue();
        assertFalse(s.hasValue());
    }

    @Test(expected = RuntimeException.class)
    @Grade(value = 1, cpuTimeout = 1000)
    public void testNoSlotValue() {
        PhysicsSolver.Slot s = new PhysicsSolver.Slot();
        s.getValue();
    }

}
