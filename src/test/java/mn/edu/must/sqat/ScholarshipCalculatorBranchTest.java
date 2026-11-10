package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Хэсэг B: хамрагдаагүй салаануудыг хааж Branch/Line 100% хүргэх тестүүд. */
class ScholarshipCalculatorBranchTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    // ---------- letterGrade ----------
    @Test
    void letterGrade_negativeScore_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGrade_scoreAbove100_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    @Test
    void letterGrade_score75_returnsC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void letterGrade_score65_returnsD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void letterGrade_score50_returnsF() {
        assertEquals("F", calc.letterGrade(50));
    }

    // ---------- gpa ----------
    @Test
    void gpa_nullScores_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpa_emptyScores_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void gpa_allFiveGrades_returns2() {
        // A=4, B=3, C=2, D=1, F=0 (switch-ийн default салаа) -> 10 / 5 = 2.0
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 50}), 1e-9);
    }

    // ---------- scholarship ----------
    @Test
    void scholarship_negativeGpa_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 15, false));
    }

    @Test
    void scholarship_gpaAbove4_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 15, false));
    }

    @Test
    void scholarship_negativeCredits_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    void scholarship_hasViolation_returns0() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }

    @Test
    void scholarship_highGpaLowCredits_returns70() {
        // голч >= 3.8 боловч кредит < 15 -> 100 биш, 70
        assertEquals(70, calc.scholarship(3.9, 13, false));
    }

    @Test
    void scholarship_gpa35credits10_returns50() {
        // голч >= 3.4 боловч кредит < 12 -> 50
        assertEquals(50, calc.scholarship(3.5, 10, false));
    }

    @Test
    void scholarship_gpa32credits20_returns50() {
        assertEquals(50, calc.scholarship(3.2, 20, false));
    }

    @Test
    void scholarship_gpa25credits20_returns0() {
        assertEquals(0, calc.scholarship(2.5, 20, false));
    }
}
