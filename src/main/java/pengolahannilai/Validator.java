package pengolahannilai;

public class Validator {

    // Mengembalikan true jika data valid, false jika tidak valid
    public boolean validasi(double tugas, double uts, double uas) {
        // Jika ada nilai < 0 atau > 100, maka tidak valid
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }

        // Jika semua nilai = 0, anggap belum input (tidak valid)
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }

        return true;
    }
}