public class ParaIslemleri {
// Yardımcı sınıf, Utility class, utility elektrik su gibi alt yapı hizmetleridir.
// Utility bakan adam da usta, teknisyen, vs. Utility bakan sınıf da ParaBirimi sınıfının ustası

    // Yardımcı sınıfların genellikle "durumu" olmaz (stateless), nesnesi de yaratılmaz

    // static tanımlanan metod, sınıfın adı üzerinden çağrılabilir.
    public static ParaBirimi getParaUzeri(ParaBirimi verilen, ParaBirimi istenen){
        if (verilen.compareTo(istenen) < 0){
            // Para yetişmedi...
            return null; // İdeal çözüm değil.
        }
        else {
            // Para yeterli oldu.
            Integer benimKurusum = verilen.getTam() * 100 + verilen.getKurus();
            Integer otekiKurusu = istenen.getTam() * 100 + istenen.getKurus();
            Integer fark = benimKurusum - otekiKurusu;
            ParaBirimi uzeri = new ParaBirimi();
            uzeri.setTam(fark / 100);
            uzeri.setKurus(fark % 100);
            return uzeri;
        }

    }

}
