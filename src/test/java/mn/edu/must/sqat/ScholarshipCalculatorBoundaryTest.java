package mn.edu.must.sqat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Хэсэг D: letterGrade-ийн зааг утгын тестүүд (спецификацитай тулгана). */
class ScholarshipCalculatorBoundaryTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @ParameterizedTest(name = "letterGrade({0}) = {1}")
    @CsvSource({
            "60,    D",
            "59.99, F",
            "69.99, D",
            "0,     F",
            "100,   A",
            "89.99, B",
            "90,    A"
    })
    void letterGrade_boundaryScore_matchesSpec(double score, String expected) {
        assertEquals(expected, calc.letterGrade(score));
    }
}
