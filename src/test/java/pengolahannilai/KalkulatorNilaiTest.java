package pengolahannilai;

import org.junit.jupiter.api.BeforeEach; // Tambahkan import ini
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalkulatorNilaiTest {

    // 1. Deklarasikan variabel objek di tingkat class (global untuk file ini)
    private KalkulatorNilai kalkulator;

    // 2. Gunakan @BeforeEach untuk melakukan instansiasi
    @BeforeEach
    public void setUp() {
        // Baris ini akan otomatis dijalankan SEBELUM testHitungNilaiNormal,
        // SEBELUM testHitungNilaiMaksimal, dan seterusnya.
        kalkulator = new KalkulatorNilai();
    }

    @Test
    public void testHitungNilaiNormal() {
        // Tidak perlu lagi menulis 'KalkulatorNilai kalkulator = new KalkulatorNilai();'
        double hasil = kalkulator.hitung(80.0, 80.0, 90.0);
        assertEquals(84.0, hasil, "Perhitungan nilai normal harus 84.0");
    }

    @Test
    public void testHitungNilaiMaksimal() {
        double hasil = kalkulator.hitung(100.0, 100.0, 100.0);
        assertEquals(100.0, hasil, "Perhitungan nilai maksimal harus 100.0");
    }

    @Test
    public void testHitungSemuaNilaiNol() {
        double hasil = kalkulator.hitung(0.0, 0.0, 0.0);
        assertEquals(-1.0, hasil, "Jika semua nilai 0, harus return error (-1.0)");
    }

    @Test
    public void testHitungNilaiLebihDariSeratus() {
        double hasil = kalkulator.hitung(105.0, 80.0, 90.0);
        assertEquals(-1.0, hasil, "Jika ada nilai > 100, harus return error (-1.0)");
    }

    @Test
    public void testHitungNilaiNegatif() {
        double hasil = kalkulator.hitung(80.0, 80.0, -10.0);
        assertEquals(-1.0, hasil, "Jika ada nilai negatif, harus return error (-1.0)");
    }
}