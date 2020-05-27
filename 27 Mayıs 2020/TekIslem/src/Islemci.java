// En az 1 sorumluluk - 1 sınıf
// Sorumluluk - İşlemi seçerek yapmak sonucunu dönmek
public class Islemci {
    // 1 sorumluluk - 1 yöntem (fonksiyon)
    public Double islemYap(Double x, Double y, String secenek) {
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
        else if("K".equals(secenek)){
            // ^ Eğer "K" metin sabitinden dönüştürülen String nesnesinin "içeriği"
            // secim referansı ile erişilen String nesnesinin "içeriği" ile aynı ise
            // Varsayım (analizden geliyor): İlki ile ikinciis aynı olacakmış
            sonuc = Math.sqrt(x);
            //      ^Math sınıfı (standart kitaplık) içinden sqrt() işlevini çağırdık.
            // Eğer bir fonksiyon static olarak adlandırıldıysa, o sınıfın (Math) bir nesnesi olmaksızın
            // direkt olarak fonksiyon çağrılabilir.
        }
        // TODO: kalanları da yazacağız... B: Bölme, E: Eksiltme/Çıkarma, K: Karekök
        x = null; // Referans nesneden koptu ama fonksiyonun çağrıldığı yerde zaten o nesneye
        // bağlı bir referans daha vardı. Nesneyi sadece burada kaybettim.
        return sonuc; // Bu deyim fonksiyonun çağrıldığı yere bu sonucu dönecek
        // sonuc referansı bu fonksiyon içinde {} içinde yaratılan yeni bir nesneye bağlıydı.
        // Biz dışarıdaki bir referansa kopyalanması düşüncesi ile nesnenin adresini döndük.
        // return edilen tür ile yukarıdaki dönüş türü aynı (uyumlu) olmalı.

    }
}
