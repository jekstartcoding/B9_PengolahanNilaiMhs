package pengolahannilai;

public class PenentuKelulusan {

    public String tentukan(double nilaiAkhir) {
        if (nilaiAkhir >= 60) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}