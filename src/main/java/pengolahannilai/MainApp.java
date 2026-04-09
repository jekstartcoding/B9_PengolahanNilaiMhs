package pengolahannilai;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek dari masing-masing modul
        Validator validator = new Validator();
        KalkulatorNilai kalkulator = new KalkulatorNilai();
        PenentuGrade penentuGrade = new PenentuGrade();
        PenentuKelulusan penentuKelulusan = new PenentuKelulusan();

        boolean programBerjalan = true;

        System.out.println("==============================================");
        System.out.println("    PROGRAM PENGOLAHAN NILAI MAHASISWA");
        System.out.println("==============================================");

        while (programBerjalan) {
            double nilaiTugas = 0, nilaiUts = 0, nilaiUas = 0;
            boolean dataValid = false;

            // Loop input selama data belum divalidasi dengan benar
            while (!dataValid) {
                System.out.println("\n--- Masukkan Data Nilai ---");
                System.out.print("Nilai Tugas (0-100) : ");
                nilaiTugas = input.nextDouble();

                System.out.print("Nilai UTS (0-100)   : ");
                nilaiUts = input.nextDouble();

                System.out.print("Nilai UAS (0-100)   : ");
                nilaiUas = input.nextDouble();

                // Memanggil modul Validator
                if (validator.validasi(nilaiTugas, nilaiUts, nilaiUas)) {
                    dataValid = true;
                    System.out.println(">>> Data Valid! Memproses nilai...");
                } else {
                    System.out.println(">>> ERROR: Data tidak valid! Pastikan nilai 0-100 dan tidak semuanya 0.");
                    System.out.println(">>> Silakan input kembali.\n");
                }
            }

            // Memanggil modul-modul lainnya secara berurutan
            double hasilAkhir = kalkulator.hitung(nilaiTugas, nilaiUts, nilaiUas);
            String hasilGrade = penentuGrade.tentukan(hasilAkhir);
            String hasilStatus = penentuKelulusan.tentukan(hasilAkhir);

            // Menampilkan hasil ke terminal
            System.out.println("\n==============================================");
            System.out.println("HASIL AKHIR MAHASISWA");
            System.out.println("==============================================");
            System.out.println("Nilai Akhir : " + hasilAkhir);
            System.out.println("Grade       : " + hasilGrade);
            System.out.println("Status      : " + hasilStatus);
            System.out.println("==============================================\n");

            // Opsi pengulangan
            System.out.print("Ingin memproses nilai mahasiswa lain? (Y/N): ");
            String pilihan = input.next();

            if (pilihan.equalsIgnoreCase("N")) {
                programBerjalan = false;
                System.out.println("Program selesai dihentikan.");
            }
        }

        input.close();
    }
}