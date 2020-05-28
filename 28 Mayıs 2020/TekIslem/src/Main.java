import java.util.Scanner;

// Sorumluluk - Girdi Çıktı işlemleri
// System.in System.out kullanarak yerine getirilmektedir.
public class Main {

    // Tasarım - Önceden belirlenmiş (analizde) işleri/sorumlulukları
    // kodun içerisindeki bileşenlere dağıtmak.

    // Analiz: Ekrana iki sayı ve bir işlem için karakter girilir. Örnek
    // 3.5 2.0 C
    // Buradan ilk sayı ile ikinci sayı çarpılacak anlaşılır.
    // C: carpma, T: toplama, E: eksiltme, B: Bölme
    // Sonu ekrana yazılır.
    // Tüm sayıların gerçek sayı olduğu varsayılacaktır.

    // Tasarım: Bu işi yapmak için bazı sorumluluklar var:
    // 1- Ekrandaki girdiyi işleyip iki sayıyı kaydetmek,
    // 2- Ekrandeki girdiden hangi işlem yapılacağını seçmek
    // 3- Seçilen işlemi gerçekleştirmek
    // 4- Sonucu ekrana yazmak
    // Veriler?
    // Ekran girdisi? Sayıların saklanacağı değişken? İşlem seçiminin saklanacağı değişken?
    // İşlem sonucunun saklanacağı değişken.

    // İşlem yapma fonksiyonu
    // Girdileri birinci ve ikinci sayılar, işlem türünü ifade eden metin
    // Çıktısı: Sonuç
    public static Double islemYap(Double x, Double y, String secenek){
        //          ^ Dönüş türü var,
        // Fonksiyon çağrılırken x, y ve secenek referansları bir nesneye bağlı
        // diye varsayabilirim
        Double sonuc = null;
        // işlemler yapılacak, sonuc referansı bir nesneye bağlanacak
        if (secenek.equals("C")){
            // ^ secim referansı ile erişilen String nesnesinin "içeriği"
            // "C" metin sabitinden dönüştürülen (Java 5 üzeri) String nesnesinin "içeriği" ile aynı ise
            sonuc = x * y;
        }
        else if("T".equals(secenek)){
            // ^ Eüer "T" metin sabitinden dönüştürülen String nesnesinin "içeriği"
            // secim referansı ile erişilen String nesnesinin "içeriği" ile aynı ise
            sonuc = x + y;
        }
        x = null; // Referans nesneden koptu ama fonksiyonun çağrıldığı yerde zaten o nesneye
                    // bağlı bir referans daha vardı. Nesneyi sadece burada kaybettim.
        return sonuc; // Bu deyim fonksiyonun çağrıldığı yere bu sonucu dönecek
        // sonuc referansı bu fonksiyon içinde {} içinde yaratılan yeni bir nesneye bağlıydı.
        // Biz dışarıdaki bir referansa kopyalanması düşüncesi ile nesnenin adresini döndük.
        // return edilen tür ile yukarıdaki dönüş türü aynı (uyumlu) olmalı.
    }

    public static IslemBilgisi islemOku(){
        Double birinci, ikinci;
        String secim; // Tasarım değişikliği: Character yerine String oldu.
        // Double sonuc = null;

        // 1- Ekrandaki girdiyi işleyip iki sayıyı kaydetmek,
        // 2- Ekrandeki girdiden hangi işlem yapılacağını seçmek
        System.out.println("İki sayı ve bir işlem girin:");
        Scanner okusun = new Scanner(System.in);
        birinci = okusun.nextDouble();
        ikinci = okusun.nextDouble();
        secim = okusun.next(); // Sağ taraftaki kitaplık String üretiyor. Ben Character olarak tasarlamışım.
        // Ya kodun sağında bir "numara" çekeceğim ki tasarıma uysun. Yada tasarım değişecek.
        return new IslemBilgisi(birinci, ikinci, secim);
    }

    public static void main(String[] args) {
	// write your code here
        IslemBilgisi islemBilgisi = islemOku();
                            // ^ Bize yeni bir IslemBilgisi nesnesi yaratır.
        // IslemBilgisi deneme = new IslemBilgisi(); // private olan yapıcıya "erişemedi"

        // System.out.println("Birinci:" + birinci);
        // System.out.println("İkinci:" + ikinci);
        // System.out.println("Secim:" + secim);

        // 3- Seçilen işlemi gerçekleştirmek
        // sonuc = islemYap(birinci, ikinci, secim);
                //  ^ Görünür uzayda, adı islemYap olan bir fonksiyon aranır.
                // KEndi sınıfımız içinde çıktı: public static Double islemYap(...)
                // Burada çağrılırken verilen parametre listesi ile bulduğumuz beklediği liste eşleşti mi bakılır
                // Buradaki: Double, Double, String
                // Bulduğumuz yerdeki: Double, Double, String
                // Buradaki çağırırken kullandığımız referansların "içeriği" (nesnelerina adresi)
                // Fonksiyonun tanımındaki eşleştiği referansların üzerine yazılır ve fonksiyon kodu çalışır
                // İŞlevin işi bitip de return edilince, = sağ tarafında return edilen (dönülen) değer kalacak.
                // Bu örnekte sonucu tutan Double nesnesinin adresi dönüldü. = bu adresi sonuc referansına kopyaladı.
        Islemci isl = new Islemci();
        //birinci = 1.0;
        //System.out.println("Birinci:" + birinci);
        //System.out.println("islemBilgisi.birinci:" + islemBilgisi.birinci);
        Double sonuc = isl.islemYap(islemBilgisi);
            //        ^ Ararken fonksiyonun imzasına bakılıyor. İmza fonksiyon adı ve parametre listesi
            //          Çağırldığı yerde bunu IslemBilgisi nesnesi ile çağırmışız.
        // sonuc = isl.islemYap(birinci, ikinci, secim);
        //       ^ Eğer fonksiyon static değilse, onu çağırmak için sınıftan bir nesneye ihtiyaç vardır.
        //       O zaman o nesnee bağlı referans üzerinden çağırmamız gerekir.

        // Başka sınıfı kullanarak iş görmemiz - Kullanım - Use
        // Aynı sınıfı başka yerde kullanmamız, Yeniden kullanım - Reuse
        // 4- Sonucu ekrana yazmak
        System.out.println("Sonuc:" + sonuc);

        // Yukarıdaki dört satırı tek satıra gömdük. Hiç referans kullanmadık.
        // System.out.println("Sonuc:" + (new Islemci()).islemYap( islemOku() ));

    }
}
