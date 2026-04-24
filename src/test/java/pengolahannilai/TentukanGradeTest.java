package pengolahannilai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TentukanGradeTest {

    private NilaiMahasiswa mhs;

    @BeforeEach
    public void setUp() {
        // Objek dilahirkan satu kali sebelum setiap test dengan nilai default
        mhs = new NilaiMahasiswa(0, 0, 0);
    }

    // ======================
    // PATH 1 : Nilai di luar batas (Tidak Valid)
    // ======================

    @Test
    public void shouldReturnTidakValid_whenNilaiAkhirIsNegative() {
        // setup
        mhs.nilaiSetter(-5, -5, -5);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("Nilai tidak valid", result, "Expected invalid for negative value (-5)");
    }

    @Test
    public void shouldReturnTidakValid_whenNilaiAkhirExceeds100() {
        // setup
        mhs.nilaiSetter(110, 110, 110);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("Nilai tidak valid", result, "Expected invalid for value above 100 (110)");
    }

    // ======================
    // PATH 2 : Grade A (85 - 100)
    // ======================

    @Test
    public void shouldReturnGradeA_whenNilaiAkhirIsMaximumBoundary() {
        // setup
        mhs.nilaiSetter(100, 100, 100);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("A", result, "Expected Grade A for upper boundary (100)");
    }

    @Test
    public void shouldReturnGradeA_whenNilaiAkhirIsWithinRange() {
        // setup
        mhs.nilaiSetter(96, 96, 96);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("A", result, "Expected Grade A for normal range value (96)");
    }

    @Test
    public void shouldReturnGradeA_whenNilaiAkhirIsLowerBoundary() {
        // setup
        mhs.nilaiSetter(85, 85, 85);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("A", result, "Expected Grade A for lower boundary (85)");
    }

    // ======================
    // PATH 3 : Grade B (70 - 84)
    // ======================

    @Test
    public void shouldReturnGradeB_whenNilaiAkhirIsUpperBoundary() {
        // setup
        mhs.nilaiSetter(84, 84, 84);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("B", result, "Expected Grade B for upper boundary (84)");
    }

    @Test
    public void shouldReturnGradeB_whenNilaiAkhirIsWithinRange() {
        // setup
        mhs.nilaiSetter(76, 76, 76);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("B", result, "Expected Grade B for normal range value (76)");
    }

    @Test
    public void shouldReturnGradeB_whenNilaiAkhirIsLowerBoundary() {
        // setup
        mhs.nilaiSetter(70, 70, 70);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("B", result, "Expected Grade B for lower boundary (70)");
    }

    // ======================
    // PATH 4 : Grade C (60 - 69)
    // ======================

    @Test
    public void shouldReturnGradeC_whenNilaiAkhirIsUpperBoundary() {
        // setup
        mhs.nilaiSetter(69, 69, 69);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("C", result, "Expected Grade C for upper boundary (69)");
    }

    @Test
    public void shouldReturnGradeC_whenNilaiAkhirIsWithinRange() {
        // setup
        mhs.nilaiSetter(67, 67, 67);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("C", result, "Expected Grade C for normal range value (67)");
    }

    @Test
    public void shouldReturnGradeC_whenNilaiAkhirIsLowerBoundary() {
        // setup
        mhs.nilaiSetter(60, 60, 60);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("C", result, "Expected Grade C for lower boundary (60)");
    }

    // ======================
    // PATH 5 : Grade D (50 - 59)
    // ======================

    @Test
    public void shouldReturnGradeD_whenNilaiAkhirIsUpperBoundary() {
        // setup
        mhs.nilaiSetter(59, 59, 59);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("D", result, "Expected Grade D for upper boundary (59)");
    }

    @Test
    public void shouldReturnGradeD_whenNilaiAkhirIsWithinRange() {
        // setup
        mhs.nilaiSetter(55, 55, 55);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("D", result, "Expected Grade D for normal range value (55)");
    }

    @Test
    public void shouldReturnGradeD_whenNilaiAkhirIsLowerBoundary() {
        // setup
        mhs.nilaiSetter(50, 50, 50);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("D", result, "Expected Grade D for lower boundary (50)");
    }

    // ======================
    // PATH 6 : Grade E (0 - 49)
    // ======================

    @Test
    public void shouldReturnGradeE_whenNilaiAkhirIsUpperBoundary() {
        // setup
        mhs.nilaiSetter(49, 49, 49);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for upper boundary (49)");
    }

    @Test
    public void shouldReturnGradeE_whenNilaiAkhirIsWithinRange() {
        // setup
        mhs.nilaiSetter(33, 33, 33);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for normal range value (33)");
    }

    @Test
    public void shouldReturnGradeE_whenNilaiAkhirIsLowerBoundary() {
        // setup
        mhs.nilaiSetter(0, 0, 0);
        // Trik Khusus: Kita lewati hitungNilaiAkhir() agar nilai tidak diubah Validator menjadi -1.
        // Dengan begini, nilaiAkhir di dalam class tetap bertahan di angka 0.0 murni.

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for lower boundary (0)");
    }
}