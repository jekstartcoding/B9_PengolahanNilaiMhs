package pengolahannilai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenentuGradeTest {

    private PenentuGrade penentuGrade;

    @BeforeEach
    public void setUp() {
        penentuGrade = new PenentuGrade();
    }

    // 1. Kumpulan Test untuk Ekspektasi Grade A (85 - 100)
    @Test
    public void testGradeA() {
        assertEquals("A", penentuGrade.tentukan(85.0), "Batas bawah A (85) harus A");
        assertEquals("A", penentuGrade.tentukan(96.0), "Nilai tengah A (96) harus A");
        assertEquals("A", penentuGrade.tentukan(100.0), "Nilai maksimal wajar (100) harus A");
    }

    // 2. Kumpulan Test untuk Ekspektasi Grade B (70 - 84)
    @Test
    public void testGradeB() {
        assertEquals("B", penentuGrade.tentukan(84.0), "Batas atas B (84) harus B");
        assertEquals("B", penentuGrade.tentukan(76.0), "Nilai tengah B (76) harus B");
        assertEquals("B", penentuGrade.tentukan(70.0), "Batas bawah B (70) harus B");
    }

    // 3. Kumpulan Test untuk Ekspektasi Grade C (60 - 69)
    @Test
    public void testGradeC() {
        assertEquals("C", penentuGrade.tentukan(69.0), "Batas atas C (69) harus C");
        assertEquals("C", penentuGrade.tentukan(67.0), "Nilai tengah C (67) harus C");
        assertEquals("C", penentuGrade.tentukan(60.0), "Batas bawah C (60) harus C");
    }

    // 4. Kumpulan Test untuk Ekspektasi Grade D (50 - 59)
    @Test
    public void testGradeD() {
        assertEquals("D", penentuGrade.tentukan(59.0), "Batas atas D (59) harus D");
        assertEquals("D", penentuGrade.tentukan(55.0), "Nilai tengah D (55) harus D");
        assertEquals("D", penentuGrade.tentukan(50.0), "Batas bawah D (50) harus D");
    }

    // 5. Kumpulan Test untuk Ekspektasi Grade E (0 - 49)
    @Test
    public void testGradeE() {
        assertEquals("E", penentuGrade.tentukan(49.0), "Batas atas E (49) harus E");
        assertEquals("E", penentuGrade.tentukan(33.0), "Nilai tengah E (33) harus E");
        assertEquals("E", penentuGrade.tentukan(0.0), "Nilai minimal wajar (0) harus E");
    }

    // 6. Kumpulan Test untuk Ekspektasi Nilai Di Luar Batas (Prevention Logic)
    @Test
    public void testNilaiTidakValid() {
        // Menguji Boundary Value di luar batas aman ( > 100 dan < 0 )
        assertEquals("Nilai tidak valid", penentuGrade.tentukan(110.0), "Nilai di atas 100 harus return 'Nilai tidak valid'");
        assertEquals("Nilai tidak valid", penentuGrade.tentukan(-5.0), "Nilai di bawah 0 harus return 'Nilai tidak valid'");
    }
}