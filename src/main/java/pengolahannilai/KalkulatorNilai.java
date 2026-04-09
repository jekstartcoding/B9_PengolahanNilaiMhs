package pengolahannilai;

public class KalkulatorNilai {

    // Bobot: Tugas 30%, UTS 30%, UAS 40%
    public double hitung(double tugas, double uts, double uas) {
        Validator validator = new Validator();

        // Memastikan nilai valid sebelum dihitung
        if (!validator.validasi(tugas, uts, uas)) {
            return -1; // Return error jika nilai tidak valid
        }

        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);

        // Pengecekan jika nilai melebihi batas maksimal komputasi
        if (nilaiAkhir > 100) {
            return -1; // Return error
        }

        return nilaiAkhir;
    }
}