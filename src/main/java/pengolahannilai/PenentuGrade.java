package pengolahannilai;

public class PenentuGrade {

    public String tentukan(double nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70 && nilaiAkhir < 85) { // Kondisi eksplisit untuk CFG
            return "B";
        } else if (nilaiAkhir >= 60 && nilaiAkhir < 70) {
            return "C";
        } else if (nilaiAkhir >= 50 && nilaiAkhir < 60) {
            return "D";
        } else {
            return "E";
        }
    }
}