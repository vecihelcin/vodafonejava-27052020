public class Main {

    public static void main(String[] args) {
	// write your code here
        String bora1 = "Bora Güngören";
                    // ^ String sabit değerinden nesne nasıl üretilir?
                    // JVM içinde bir String havuzu var. "Bora Güngören" metni de buraya girer.
                    // Bu havuz dev bir Character dizisi (Array). Başlangıcı "Bora Güngören" olan, 13 karakterlik
                    // bir sekans söz konusu, bu sekansa bakan bir dizi oluşturulur. String nesnesi bunu barındırır.
                    // String nesnesine bakan referans bora1 olarak atanır.
        String bora3 = "Bora Güngören";
                    // ^ Önceden havuzda bulunan bir metin. Bunu eklerken aslında yeni bellek kullanmıyorum.
        String bora2 = new String("Bora Güngören");
                    //  ^ Bana yeni bir bellek alanı açılıyor. İçine "Bora Güngören" konuyor.
        String bora4 = "Bora";
                    //  ^ Bu metin havuza daha önceden eklenen "Bora Güngören" içinde olduğundan havuzun içinden gelir.
        if ("Bora Güngören".equals(bora2)){
            // ^ Buradaki sabit metin, nasıl olsa bir String nesnesine dönüşecek.
            // ..
        }

        if( (new String("Bora Güngören")).equals(bora2) ){
            // ^ Burada yeni bellek alanı açıldı.
            //..
        }

        if(bora3.equals(bora2)){
            // ^ bora3 referansı gerçekte bir nesneye bağlı olmasa (null olsa)
            // program çökebilirdi.
        }

        String urunKodu = "UKT-1568-RD-79403-78-TR";
                        //  ^ UKT Üretici, RD ürün ailesi TR hangi ülke için olduğu
                        // 1568 üretici ile ilgili bir tanımlayıcı
                        // 79403 ürün türü, 78 varyantı
        // 1- İçerikte arama yapmak. Ya bir metin içinde var mı yok mu merak ediyorumdur. Yada yerini merak ediyorumdur.
        if(urunKodu.contains("UKT")){
            System.out.println("Üretici koduna göre üreticimiz UKT");
            if (urunKodu.contains("RD")){
                System.out.println("Ürün ailesi de RD");
                if(urunKodu.endsWith("TR")){
                    System.out.println("Ürün Türkiye pazarı için üretilmiş.");
                }
                else {
                    System.out.println("Ürün başka ülke için üretilmiş.");
                }
            }
        }
        // 2- İçeriğin bir parçasını sökmek. Burada ya spesifik bir sınırlar içini merak ediyoruz yada tüm metni
        // parçalara bölmek istiyoruz.
        // "UKT-1568-RD-79403-78-TR"
        //  U:0 -:3 1:4 -9 R:10 -:11 7:12'ten başlayan 5 karakterlik bir yer.
        // Buradaki uzunlukların 3 karakter 5 karakter olacağından emin miyim?
        String urunTuru = urunKodu.substring(12,17); // Elle sayınca yanlış saymaya dikkat.
                        // ^ Mevcut ve havuzdaki bir metin parçasının, içindeki bir bölümü gösterdi.
                        // Yeni bellek kullandı mı? Hayır.
        System.out.println("Ürün türü:" + urunTuru);
        // Formatını biliyor olabiliriz. - ile ayrılan parçalarda dördüncü elemandır.
        String[] urunKoduParcalari = urunKodu.split("-");
                                    // Birden fazla parça üretti. Ama bu parçaların hepsi, var olan, havuzdaki
                                    // metnin parçası. Yeni bellek kullandı mı? Hayır. Sadece, String[] için olan
                                    // ek yük var. length değişkeni, her parçaya birer referans.
        urunTuru = urunKoduParcalari[3]; // indeks:3, esasında dördüncü
        String mesaj = "Ürün türü:" + urunTuru;
        System.out.println("Ürün türü:" + urunTuru);
                                    //  ^ + işareti solundaki ve sağındaki iki String'i bir araya getirip
                                    // yeni bir tane üretir. "Ürün türü:79403" metni var. Buradaki geçici kaldı.
                                    // String mesaj = ... olanda ise referansa bağlandığı için bellekte kalıcı.
                                    // havuzda "Ürün türü:" vardı.
        // String + ile birleştirme, dosya okunan her yerde, barkod işlemede, (XML) web servisleri
        // "<tag>metin</tag>"

        StringBuffer mesajTamponu = new StringBuffer("Ürün türü:");
                                    // ^Buradaki metin, ortak havuza girmez. Normal Character dizisi olarak görülür.
                                    // Buradaki işlemler bu nedenle daha hızlı gerçekleşir. Üretilen dizi, en az 16
                                    //    karakter, eğer bir metinle başlatılmış ise onun uzunluğu + 16.
        mesajTamponu.append(urunTuru);
                        // ^ eklenen metin tampona sığdığı için yeni bellek alışveriş olmadı.
        System.out.println(mesajTamponu.toString());

        StringBuffer tampon = new StringBuffer(500); // Başlangıç olarak 500 (Unicode UTF-16) karakteri için yer.
        // .. çalışıldı. artık boyu değişmeyecek.
        tampon.trimToSize(); // fazlalıklarını at.

        // StringBuffer "thread-safe" bir sınıftır.

        // StringBuilder "thread-safe" olmayan bir StringBuffer olarak görülebilir.
        StringBuilder mesajTamponu2 = new StringBuilder("Ürün türü");
        mesajTamponu2.append(urunTuru);
        // ^ eklenen metin tampona sığdığı için yeni bellek alışveriş olmadı.
        System.out.println(mesajTamponu2.toString());

        String bolBeni="Bora Güngören, Ankara, 1979, TCKN: 12345678901";
        String[] parcalar = bolBeni.split(",");
        // İndeksle kafamı yormadan, dizideki tüm elemanları işlemek istiyorsam
        for(String siradaki : parcalar){ // for String siradaki in parcalar... for..in
                                        // parcalar içindeki her bir siradaki
            System.out.println("Sıradaki eleman:" + siradaki.trim());
                                                    // ^ String nesnesi üzerinden trim() yapıyoruz.
                                                    // String immutable olduğu için trim() aslında
                                                    // bize yeni, başındaki-sonundaki boşluklar temizlenmiş String
                                                    // verdi
            // Lineer arama, tüm elemanlara bakmak, işimize "yarayanı" seçip işlemektir.
            if(siradaki.contains("TCKN")){
                // Beklediğim format "TCKN: ...."
                String[] tcknDizisi = siradaki.split(": "); // oluşturulan dizi "TCKN" ve "1234....01" olacak
                                                    // ^": " yani hem ":" hem " " ayraç karakteri oldu.
                                                    // SAdece ":" olsaydı, " 1234..." olarak ayrılırdı
                String tckn = tcknDizisi[1]; // 0 indeksli olan ilk, 1 indeksli olan sıradaki
                // String tckn = tcknDizisi[1].trim(); // " ..." şeklinde başlasaydı trim() gerekecekti.
                System.out.println("TCKN ayrıldı. Değeri:" + tckn);
            }
        }

        String[] parcalar2 = {"UX", "12", "DR", "32", "34", "UF", "TK","75"};

        // Lineer arama yaparken, hedef kriteri bilimndiği için, bazen arama sınırları değiştirilir.
        // for(int i=0; i<parcalar2.length; i++){ // Orijinali
        for(int i=1; i+2<parcalar2.length; i++){
            // ^index ilkel değişkeni sadece bu for döngüsü içinde görülecek şekilde tanımlı
            // döngü i<.... koşulu sağlandıkça sürecek
            // döngünün her turu sonunda i++ işletilecek, yani i'nin değeri 1 artacak.
            String siradaki = parcalar2[i];
            // Diyelim ki içinde U geçen parçadan "1 öncekini" bulmamız gerekiyor.
            // Göreceli bir konumdan bahsediyoruz. Göreceli demek, bir çapa var demek.
            if(siradaki.contains("U") && i-1>=0){
                int hedefIndeks = i-1;
                String hedef = parcalar2[hedefIndeks];
            }
            // diyelim ki "TK" 2 sonrası bir eleman arıyoruz.
            if(siradaki.equals("TK") && i+2 < parcalar2.length){
                int hedefIndeks = i+2;
                String hedef = parcalar2[hedefIndeks];
            }
        }

        // İki for aynı gibi gözükmekle birlikte indeksli olana ihtiyaç bakidir.
        for(String siradaki : parcalar2){
            if(siradaki.contains("U")){
                // Soru sıradaki indeksi kaç?
                int hedefIndeks = 0;
                for(int i =0; i<parcalar2.length; i++)
                    if(siradaki == parcalar2[i]){
                        hedefIndeks = i;
                    }
                // for in yapmanın amacından saptık.
            }
        }

        // İndeks kullanmak için sebepler, bir veya birden fazla indeksi bilinen elemana göreceli konumları işlemek içindir
        // ...'dan önce, ...'dan sonra, ... ile ... arasında

        // birinci arama ilkinin indeksi bulunur - baslangic
        // ikinci arama ikincinin indeksi bulunur - son
        // Döngü ile işlenir
        // for(int indeks = baslangic; indekss <= son; indeks++) {} // böyle bir döngü


    }
}
