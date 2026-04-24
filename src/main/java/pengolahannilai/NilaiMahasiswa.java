package pengolahannilai;

public class NilaiMahasiswa {

    // Atribut (State)
    private double nilaiTugas;
    private double nilaiUts;
    private double nilaiUas;

    private double nilaiAkhir;
    private String grade;
    private String statusKelulusan;

    // Constructor untuk inisialisasi input awal
    public NilaiMahasiswa(double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public void nilaiSetter(double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    // Method 1: Manipulasi Nilai Akhir
    public void hitungNilaiAkhir() {
        Validator validator = new Validator();

        // Algoritma sama persis: Memastikan nilai valid sebelum dihitung
        if (!validator.validasi(this.nilaiTugas, this.nilaiUts, this.nilaiUas)) {
            this.nilaiAkhir = -1; // Set ke -1 jika tidak valid
        } else {
            double hasil = (0.3 * this.nilaiTugas) + (0.3 * this.nilaiUts) + (0.4 * this.nilaiUas);

            // Pengecekan jika nilai melebihi batas maksimal komputasi
            if (hasil > 100) {
                this.nilaiAkhir = -1;
            } else {
                this.nilaiAkhir = hasil; // Manipulasi atribut
            }
        }
    }

    // Method 2: Manipulasi Grade
    public void tentukanGrade() {
        // Algoritma sama persis: menggunakan this.nilaiAkhir yang sudah dihitung
        if(this.nilaiAkhir >= 0 && this.nilaiAkhir <= 100) {
            if (this.nilaiAkhir >= 85) {
                this.grade = "A";
            } else if (this.nilaiAkhir >= 70 && this.nilaiAkhir < 85) {
                this.grade = "B";
            } else if (this.nilaiAkhir >= 60 && this.nilaiAkhir < 70) {
                this.grade = "C";
            } else if (this.nilaiAkhir >= 50 && this.nilaiAkhir < 60) {
                this.grade = "D";
            } else {
                this.grade = "E";
            }
        } else {
            this.grade = "Nilai tidak valid";
        }
    }

    // Method 3: Manipulasi Status Kelulusan
    public void tentukanKelulusan() {
        // Algoritma sama persis
        if (this.nilaiAkhir >= 60) {
            this.statusKelulusan = "Lulus";
        } else {
            this.statusKelulusan = "Tidak Lulus";
        }
    }

    // ==========================================
    // GETTER METHODS (Untuk mengambil nilai atribut dari luar class)
    // ==========================================
    public double getNilaiAkhir() {
        return this.nilaiAkhir;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getStatusKelulusan() {
        return this.statusKelulusan;
    }
}