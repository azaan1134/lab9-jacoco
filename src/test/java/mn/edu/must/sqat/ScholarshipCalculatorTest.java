package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Хэсэг A: зөвхөн хэвийн урсгалын (happy path) тестүүд. */
class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void letterGrade_score95_returnsA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGrade_score85_returnsB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void gpa_scores95and85_returns3point5() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9);
    }

    @Test
    void scholarship_gpa39credits16_returns100() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_gpa35credits13_returns70() {
        assertEquals(70, calc.scholarship(3.5, 13, false));
    }
}
