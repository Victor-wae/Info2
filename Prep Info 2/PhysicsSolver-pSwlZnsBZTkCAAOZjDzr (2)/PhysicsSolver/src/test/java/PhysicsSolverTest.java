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
    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test3() {
        PhysicsSolver.Slot s = new PhysicsSolver.Slot();
        PhysicsSolver.Slot m = new PhysicsSolver.Slot();
        PhysicsSolver.Slot n = new PhysicsSolver.Slot();
        m.setValue(2.0);
        PhysicsSolver.Multiplication p = new PhysicsSolver.Multiplication();
        p.setFactor1(m);
        p.setFactor2(n);
        p.setProduct(s);
        assertFalse(p.update());
    }
    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test4() {
        PhysicsSolver.Slot s = new PhysicsSolver.Slot();
        PhysicsSolver.Slot m = new PhysicsSolver.Slot();
        PhysicsSolver.Slot n = new PhysicsSolver.Slot();
        m.setValue(2.0);
        n.setValue(2.0);
        PhysicsSolver.Multiplication p = new PhysicsSolver.Multiplication();
        p.setFactor1(m);
        p.setFactor2(n);
        p.setProduct(s);
        assertTrue(p.update());
        assertFalse(p.update());
        p.clearValues();
    }

}
