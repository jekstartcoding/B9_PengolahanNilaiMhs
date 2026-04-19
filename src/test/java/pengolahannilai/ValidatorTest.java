package pengolahannilai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    // ======================
    // PATH 1 : Nilai Valid
    // ======================

    @Test
    public void shouldReturnTrue_whenValuesWithinNormalRange() {
        // setup
        double tugas = 50, uts = 50, uas = 50;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertTrue(result, "Expected valid data for normal range values");
    }

    @Test
    public void shouldReturnTrue_whenValuesAtUpperBoundary() {
        // setup
        double tugas = 100, uts = 100, uas = 100;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertTrue(result, "Expected valid data for upper boundary values (100)");
    }

    @Test
    public void shouldReturnTrue_whenValuesAtLowerBoundary() {
        // setup
        double tugas = 1, uts = 1, uas = 1;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertTrue(result, "Expected valid data for lower boundary values (1)");
    }

    // ======================
    // PATH 2 : Ada salah satu atau semua nilai negatif atau lebih dari 100
    // ======================

    @Test
    public void shouldReturnFalse_whenAllValuesNegative() {
        // setup
        double tugas = -1, uts = -1, uas = -1;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when all values are negative");
    }

    @Test
    public void shouldReturnFalse_whenAllValuesAbove100() {
        // setup
        double tugas = 101, uts = 101, uas = 101;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when all values exceed 100");
    }

    @Test
    public void shouldReturnFalse_whenUTSandUASInvalid() {
        // setup
        double tugas = 50, uts = -1, uas = -1;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when UTS and UAS are out of range");
    }

    @Test
    public void shouldReturnFalse_whenTugasAndUASInvalid() {
        // setup
        double tugas = -1, uts = 50, uas = -1;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when Tugas and UAS are out of range");
    }

    @Test
    public void shouldReturnFalse_whenTugasAndUTSInvalid() {
        // setup
        double tugas = -1, uts = -1, uas = 50;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when Tugas and UTS are out of range");
    }

    @Test
    public void shouldReturnFalse_whenUASInvalid() {
        // setup
        double tugas = 50, uts = 50, uas = -1;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when UAS is out of range");
    }

    @Test
    public void shouldReturnFalse_whenTugasInvalid() {
        // setup
        double tugas = -1, uts = 50, uas = 50;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when Tugas is out of range");
    }

    // ======================
    // PATH 3 : Semua nilai = 0
    // ======================

    @Test
    public void shouldReturnFalse_whenAllValuesZero() {
        // setup
        double tugas = 0, uts = 0, uas = 0;

        // exercise
        boolean result = validator.validasi(tugas, uts, uas);

        // verify
        assertFalse(result, "Expected invalid when all values are zero");
    }
}