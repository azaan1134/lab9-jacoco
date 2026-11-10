package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Хэсэг C: gpa() давталтын 0 / 1 / 2+ заагийн тестүүд. */
class ScholarshipCalculatorLoopTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void gpaLoop_zeroIterations_emptyArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[0]));
    }

    @Test
    void gpaLoop_zeroIterations_nullArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpaLoop_oneIteration_score95_returns4() {
        assertEquals(4.0, calc.gpa(new double[]{95}), 1e-9);
    }

    @Test
    void gpaLoop_manyIterations_fourScores_returns2point5() {
        // 4 + 3 + 2 + 1 = 10, 10 / 4 = 2.5
        assertEquals(2.5, calc.gpa(new double[]{95, 85, 75, 65}), 1e-9);
    }
}
