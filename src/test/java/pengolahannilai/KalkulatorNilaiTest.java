package pengolahannilai;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KalkulatorNilaiTest {

    KalkulatorNilai kalkulator = new KalkulatorNilai();

    // Test Case Valid
    @Test
    void testHitungNilaiValid() {
        double hasil = kalkulator.hitung(80, 85, 90);
        assertEquals(85.5, hasil, 0.01);  // expected = 0.3*80 + 0.3*85 + 0.4*90
    }

    // Test Case Invalid (ada nilai <0 atau >100)
    @Test
    void testHitungNilaiInvalid() {
        double hasil = kalkulator.hitung(80, -10, 90);
        assertEquals(-1, hasil);
    }

    // Test Case Semua nilai 0 → tidak valid
    @Test
    void testHitungSemuaNol() {
        double hasil = kalkulator.hitung(0, 0, 0);
        assertEquals(-1, hasil);
    }

    // Test Case Nilai Akhir > 100 → error
    @Test
    void testHitungLebihDari100() {
        double hasil = kalkulator.hitung(100, 100, 100);
        assertEquals(-1, hasil);
    }

    // Test Case Boundary (nilai tepat 0 dan 100)
    @Test
    void testHitungBoundary() {
        double hasil = kalkulator.hitung(0, 100, 100);
        assertEquals(70.0, hasil, 0.01);
    }
}