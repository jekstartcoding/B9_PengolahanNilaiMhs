package pengolahannilai;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TentukanGradeTest {

    // Perhatikan: Kita tidak menggunakan @BeforeEach di sini karena setiap test case
    // membutuhkan nilai instansiasi constructor NilaiMahasiswa yang berbeda-beda.

    // ======================
    // PATH 1 : Nilai di luar batas (Tidak Valid)
    // ======================

    @Test
    public void shouldReturnTidakValid_whenNilaiAkhirIsNegative() {
        // setup: Memasukkan nilai -5
        NilaiMahasiswa mhs = new NilaiMahasiswa(-5, -5, -5);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("Nilai tidak valid", result, "Expected invalid for negative value (-5)");
    }

    @Test
    public void shouldReturnTidakValid_whenNilaiAkhirExceeds100() {
        // setup: Memasukkan nilai 110
        NilaiMahasiswa mhs = new NilaiMahasiswa(110, 110, 110);
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
        NilaiMahasiswa mhs = new NilaiMahasiswa(100, 100, 100);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("A", result, "Expected Grade A for upper boundary (100)");
    }

    @Test
    public void shouldReturnGradeA_whenNilaiAkhirIsWithinARange() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(96, 96, 96);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("A", result, "Expected Grade A for normal range value (96)");
    }

    @Test
    public void shouldReturnGradeA_whenNilaiAkhirIsALowerBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(85, 85, 85);
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
    public void shouldReturnGradeB_whenNilaiAkhirIsBUpperBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(84, 84, 84);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("B", result, "Expected Grade B for upper boundary (84)");
    }

    @Test
    public void shouldReturnGradeB_whenNilaiAkhirIsWithinBRange() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(76, 76, 76);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("B", result, "Expected Grade B for normal range value (76)");
    }

    @Test
    public void shouldReturnGradeB_whenNilaiAkhirIsBLowerBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(70, 70, 70);
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
    public void shouldReturnGradeC_whenNilaiAkhirIsCUpperBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(69, 69, 69);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("C", result, "Expected Grade C for upper boundary (69)");
    }

    @Test
    public void shouldReturnGradeC_whenNilaiAkhirIsWithinCRange() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(67, 67, 67);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("C", result, "Expected Grade C for normal range value (67)");
    }

    @Test
    public void shouldReturnGradeC_whenNilaiAkhirIsCLowerBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(60, 60, 60);
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
    public void shouldReturnGradeD_whenNilaiAkhirIsDUpperBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(59, 59, 59);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("D", result, "Expected Grade D for upper boundary (59)");
    }

    @Test
    public void shouldReturnGradeD_whenNilaiAkhirIsWithinDRange() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(55, 55, 55);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("D", result, "Expected Grade D for normal range value (55)");
    }

    @Test
    public void shouldReturnGradeD_whenNilaiAkhirIsDLowerBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(50, 50, 50);
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
    public void shouldReturnGradeE_whenNilaiAkhirIsEUpperBoundary() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(49, 49, 49);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for upper boundary (49)");
    }

    @Test
    public void shouldReturnGradeE_whenNilaiAkhirIsWithinERange() {
        // setup
        NilaiMahasiswa mhs = new NilaiMahasiswa(33, 33, 33);
        mhs.hitungNilaiAkhir();

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for normal range value (33)");
    }

    @Test
    public void shouldReturnGradeE_whenNilaiAkhirIsELowerBoundary() {
        // setup
        // Trik Khusus: Kita sengaja TIDAK memanggil hitungNilaiAkhir() di sini.
        // Jika dipanggil, input (0,0,0) akan diubah jadi -1 oleh Validator.
        // Tanpa pemanggilan, nilaiAkhir akan tetap pada default Java yaitu 0.0 murni.
        NilaiMahasiswa mhs = new NilaiMahasiswa(0, 0, 0);

        // exercise
        mhs.tentukanGrade();
        String result = mhs.getGrade();

        // verify
        assertEquals("E", result, "Expected Grade E for lower boundary (0)");
    }
}