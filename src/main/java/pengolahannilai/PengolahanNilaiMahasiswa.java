package pengolahannilai;

public class PengolahanNilaiMahasiswa {

    private ConsoleUI ui;

    public PengolahanNilaiMahasiswa() {
        // Menginstansiasi UI saat Controller dibuat
        this.ui = new ConsoleUI();
    }

    // Method utama yang mengatur alur jalannya aplikasi
    public void jalankanAplikasi() {
        this.ui.tampilkanHeader();

        boolean programBerjalan = true;

        while (programBerjalan) {
            // 1. Suruh UI minta input (UI otomatis memvalidasi)
            double[] inputNilai = this.ui.mintaInputNilai();

            // 2. Buat objek Model berdasarkan input tersebut
            NilaiMahasiswa mhs = new NilaiMahasiswa(inputNilai[0], inputNilai[1], inputNilai[2]);

            // 3. Suruh Model melakukan perhitungan (Manipulasi State)
            mhs.hitungNilaiAkhir();
            mhs.tentukanGrade();
            mhs.tentukanKelulusan();

            // 4. Suruh UI menampilkan hasil dari objek Model
            this.ui.tampilkanHasil(mhs);

            // 5. Suruh UI bertanya apakah ingin mengulang
            programBerjalan = this.ui.tanyaLanjut();
        }

        // Tutup scanner jika program selesai
        this.ui.tutupScanner();
    }
}