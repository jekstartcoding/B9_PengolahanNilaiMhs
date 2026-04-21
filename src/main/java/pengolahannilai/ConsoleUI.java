package pengolahannilai;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner input;
    private Validator validator;

    public ConsoleUI() {
        this.input = new Scanner(System.in);
        this.validator = new Validator();
    }

    public void tampilkanHeader() {
        System.out.println("==============================================");
        System.out.println("    PROGRAM PENGOLAHAN NILAI MAHASISWA");
        System.out.println("==============================================");
    }

    // Meminta input dan langsung memvalidasinya
    public double[] mintaInputNilai() {
        double tugas = 0, uts = 0, uas = 0;
        boolean dataValid = false;

        while (!dataValid) {
            System.out.println("\n--- Masukkan Data Nilai ---");
            System.out.print("Nilai Tugas (0-100) : ");
            tugas = this.input.nextDouble();

            System.out.print("Nilai UTS (0-100)   : ");
            uts = this.input.nextDouble();

            System.out.print("Nilai UAS (0-100)   : ");
            uas = this.input.nextDouble();

            if (this.validator.validasi(tugas, uts, uas)) {
                dataValid = true;
                System.out.println(">>> Data Valid! Memproses nilai...");
            } else {
                System.out.println(">>> ERROR: Data tidak valid! Pastikan nilai 0-100 dan tidak semuanya 0.");
                System.out.println(">>> Silakan input kembali.\n");
            }
        }
        // Mengembalikan array berisi 3 nilai yang sudah dijamin valid
        return new double[]{tugas, uts, uas};
    }

    // Menampilkan hasil dengan menerima objek NilaiMahasiswa
    public void tampilkanHasil(NilaiMahasiswa mhs) {
        System.out.println("\n==============================================");
        System.out.println("HASIL AKHIR MAHASISWA");
        System.out.println("==============================================");
        System.out.println("Nilai Akhir : " + mhs.getNilaiAkhir());
        System.out.println("Grade       : " + mhs.getGrade());
        System.out.println("Status      : " + mhs.getStatusKelulusan());
        System.out.println("==============================================\n");
    }

    public boolean tanyaLanjut() {
        System.out.print("Ingin memproses nilai mahasiswa lain? (Y/N): ");
        String pilihan = this.input.next();
        if (pilihan.equalsIgnoreCase("N")) {
            System.out.println("Program selesai dihentikan.");
            return false;
        }
        return true;
    }

    public void tutupScanner() {
        this.input.close();
    }
}