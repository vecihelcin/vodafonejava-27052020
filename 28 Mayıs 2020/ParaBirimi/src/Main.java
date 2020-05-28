public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Başlangıçta 9,70 TL'niz var.");
        ParaBirimi benimParam = new ParaBirimi(9,70);
        System.out.println("Bir kahve alınacak.9 TL 50 Kr");
        ParaBirimi kahveParasi = new ParaBirimi(9,50);
        // Alışveriş
        // 1- Paramız yeterli mi?
        // 2- Para üzeri nasıl üretilecek? A- Benimparam güncellensin. B- Fark kadar yeni nesne üretilsin
        // Integer benimKurusum = benimParam.getTam() *100 + benimParam.getKurus();
        // ^ var yazınca türü tahmin etmeye çalışır. Java 10 iile gelmişti. Direkt türü (Integer) yazabiliriz.
        // Integer kahveKurusu = kahveParasi.getTam() * 100 + kahveParasi.getKurus();
        if (benimParam.compareTo(kahveParasi) > 0 ){
            // param yetti.

            // A- Benimparam güncellensin
            benimParam.eksilt(kahveParasi); // Soru: Artırmak için de yazacak mıyız?

            // B- Benimparam için bir para üzeri üretilsin.
            ParaBirimi paraUzeri = benimParam.getParaUzeri(kahveParasi);
            // Para üzeri benim paramın yeni, güncellenmiş hali
            benimParam = paraUzeri; // Eski nesneye bağlantı koptu.

            //B- 2. Yolu.
            ParaBirimi uzeri = ParaIslemleri.getParaUzeri(benimParam,kahveParasi);
                                // ^ Sınıfın adı üzerinden çağrıldı.
            if (uzeri == null){
                //
            }
            else {
                benimParam = uzeri;
            }
        }

        // Bunu böleceğiz
        String bolBeni = "Birinci İkinci Üçüncü Dördüncü";
                    //    ^ Bu bir sabit değer. 3 veya 5 yazmaktan bir farkı yok.
                    //  ^ Atama ile soldaki referansa bağlanan String nesnesinin içeriği ileride değişir mi değişmez mi?
                    // String sınıfı immutable mıdır değil midir?
        String[] parcalar = bolBeni.split(" ");
        System.out.println("Dizi boyutu:" + parcalar.length);
        Integer indeks = 0;
                    // ^Baş sıfır
        // Yürüme. Baştan sona yürüdük.
        while (indeks < parcalar.length){
            // indekslerimiz asla dizi uzunluğu kadar olmuyor, hep küçük oluyor. Çünkü 0'dan başladık.
            System.out.println("İndeks:" + indeks + "Değer: "+parcalar[indeks]);
                                                            // parcalar isimli Array'in başından bu yana
                                                            // indeks kadar adım atınca varılan yerdeki nesne
                                            // ^ Başlangıçtan bu yana atılan adım sayısı
            indeks = indeks + 1;
            // Adım atınca adımı bir artırıyorum.
        }

        System.out.println("İşlemden sonra:" + bolBeni);
        String yeni = bolBeni.replaceAll(" ","#");
        System.out.println("Yeni:" + yeni);
        System.out.println("İşlemden sonra:" + bolBeni);
        // String immutable olduğu için, genelde yeni üretileni eski referansla kullanmak için atama yapılır.
        bolBeni = yeni;
        // abcString = abcString.......(); // Çok yaygın.

        // Bunları birleştireceğiz.
        String birlestir1 = "Birinci";
        String birlestir2 = "İkinci";

        // Bir sürü metnin başına ekleyeceğiz.
        String hitap = "Sayın";





    }
}
