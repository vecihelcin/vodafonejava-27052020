import java.util.Scanner;
// ^ Takip eden sınıfı CLASSPATH'e ekle çünkü bu dosya içinde kullanacağım.

// Main - Uygulamımızın giriş noktası

public class Main {
    //        ^ Sınıf adlarının ilk harfini büyük yazma adeti var.
    // Java'da her sınıf bir adet yeni tür (type) tanımlar.
    // Bir programda aynı isimle erişilen sadece 1 adet sınıf/tür olur.

    // main() uygulama çalıştırıldığında ilk çağrılacak yöntemdir (metod, fonksiyon).
    public static void main(String[] args) {
	    // write your code here
        System.out.println("Merhaba."); // ; bu satırın bir deyim olduğunu gösteriyor
        //            ^ println çağrılacak olan fonksiyon () solundaki kısma bakıldı.
        // println kimdir? sorusu - System'den out'dan println i bulalım
        // Nerede arıyorum? CLASSPATH içinde. Başka Java sınıflarının yerlerini gösterir.
        // Program çalışırken eklediklerimiz + standart kitaplık.
        System.out.println("Tekrar merhaba.");
        //                      ^ () içerisi parametre listesi. Buradaki parametre ile fonksiyonun
        //                      beklediği uyumlu olmalı.

        Scanner girdi = new Scanner(System.in);
                    //   ^ new sözcüğü bize yeni bir nesne yaratır. Nesnenin türünü takip
                    //  eden sınıfın adından anlar. Burada yeni bir Scanner nesnesi üretildi.
                    // Burada bazı detaylar var. bizim Scanner nesnesi System.in ile bir ilişki
                    // içinde. Nesne yaratılırken System.in kullanılacak.
        // System.out - Komut satırı çıktısı - İşletim sistemi stdout aygıtı
        // System.in - Komut satırı girdisi (klavye) - İşletim sistemi stdin aygıtı
        System.out.println("Adınız: ");
                        // ^Burada " " içerisindeki metin String sabit değeri (String literal)
        String ad;
        //     ^ ad bir referans. Bir tür etiket. Nesneye bir isim verir.
        // Her referansın işaret edeceği nesnenin türü referans tanımlanırken açıkça belirtilir.
        // String türü metin değerleri için kullanılır.
        ad = girdi.next();
                //   ^ Komut satırından girilen sıradaki içeriği bekleyecektir.
                // girdi referansının işaret ettiği bir Scanner nesnesi var. O nesneye eriştik.
                // Klavyeye yazılan metin, uzunluğu değişebilir bir bellek alanına yazılıyor.
                // İşletim sisteminde kullanılan kodlama (encoding) ile yazılıyor. Genelde UTF-8.
                // String türü değişken uzunlukta metinleri saklamak için ve işlemek için özellikleri
                // olan bir sınıf.
                // next komut satırından gelen metni yeni bir String nesnesi yaratıp içine doldurur.
                // Bize o nesneyi verir.
        //  ^ = Sağındaki nesneyi alır, solundaki referansa (ad) bağlar.
        // Bundan sonra ad dediğimizde referansın bağlandığı, işaret ettiği nesneye erişiriz.
        System.out.println("Merhaba, "+ad);
        // ad = girdi; // Tür uyumsuzluğu hatası
        String isim = ad;
        // isim diye yeni bir referans tanımladım. Ad referansı nereye bakıyorsa oraya bakmasını ayarladım.
        // İkisi de aynı nesneye ulaşacak.
        // REFERANS NESNENİN KENDİSİ DEĞİLDİR
        System.out.println("İkinci referans ile: "+isim);
        isim = null;
        //  ^ Referans üzerine null değerini yazdık. Nesne ile bağı koptu.
        System.out.println("İkinci referans ile: "+isim);
        System.out.println("Birinci referans ile: "+ad);
        ad = null;
        // Şu anda komut satırından okuduğumuz metni içeren String nesnesine bağlı referans kalmadı.
        // Java sanal makinesi (JVM) arka planda artık referans bağlı olmadığı için erişilemeyen nesneleri tarar,
        // bellekten kaldırır. Buna çöp toplama (garbage collection) deniyor.
        
        Integer i = 3;
        //        ^ Atama (= işareti) sağdaki sayı değerini soldaki referansın türüne (Integer)
        //       uyacak şekilde yeni bir nesne yaratarak bağlıyor.
        Integer j = new Integer(3);
        //            ^ Elle nesneyi açıkça göstererek yarattık. Gerisi aynı.
        // new Integer(3) - 2005 öncesi: 3 ilkelinin baytları, yeni yaratılan Integer nesnesi içine kopyalanıyordu
        //                - 2005 sonrası: 3 ilkeli zaten otomatik olarak Integer nesnesine dönüşüyor.
        //                               new Integer(3) -> new Integer( Integer nesnesi ) varolan nesnenin kopyası
        //                               yaratılsın. Kodu optimize ederken, derleyici bunu zaten bütünleştiriyor.
        //               - 2009 sonrası: Programcılar "uyarılsın" kod derlenirken, "Bu eskidi" diye bize uyarı geliyor.
        int k = 3;
        var m = 5; // Java 10. Değerden tür tahmini başladı. Detayını çok bilmediğimiz bir kitaplığın
                    // fonksiyonları ile oynarken öğrenme hızı kolaylığı sağlıyor. C# ve Python benzeri bir özellik
        // ^ int bir ilkel tür (primitive type). Bunun geleneksel anlamı ortada nesne yok, sadece baytlar var.
        // 2005'de Java 5 ile ilkel türleri sadece bir yazım biçimi haline getirdiler. Burada da Integer nesnesi var.
        Double d = 3.0; // Ondalık hanesi nokta karakteri. ABD ayarlarında.
        // Double, IEEE'nin double precision sayı saklama konulu standardına atfen double.
        Character c = 'b';
        // Tek bir karakteri saklamak için. Sabit değerler ise ' ' içinde. Tek tırnak, üstten kesme değil.
        // ASCII kodu, UTF kodu, vs kullanarak konabilecek karakterler de var. Varsayım UTF.

        j = 2; // i:3, j:2, k:3
        k = i + j; // k:5
        // ^ = bulunur, önce sağı çalışır, sonuç hesaplanır, en son sonuç = tarafından solun üzerine yazılır.
        // i ve j değerleri 3 ve 2 alındı, toplandı, 5 bulundu (sonuç) ve = tarafından sol tarafa (k) yazıldı.
        // Hepsi nesne olunca, esasında k referansı değeri 3 olan bir Integer nesnesine bağlıydı.
        // bu satırın sonunda değeri 5 olan başka bir Integer nesnesi yaratıldı, k referansı ona bağlandı.
        // Önceki nesne? Ona bağlı başka referans yoksa "çöp oldu temizlendi". (Aşırı sadeleştirme).

        // Amacımız işi doğru yapmak (Doğruluk - Correctness)

        m = k / 2 ; // 5 / 2 kaçtır? Dirsekli bölme
        //  5 | 2
        //    _____
        //  4 | 2
        // -----
        //  1
        System.out.println("m:" + m);
        var d2 = d / 2;
        System.out.println("d:" + d2);
        
    }
    // Bu küme parantezi kapatıldığı yere erişince,
    // Eşlenik { tan buraya kadar kısımda tanımlanan tüm yeni referanslar yok edilir.
    // girdi, ad, isim referansları yok edildi.
    // Eğer bu nedenle nesnelere hiç referans kalmadı ise nesneler de çöp toplamaya adaydır.

    // Kodu organize etmek için sebepler?
    // 1- Ekonomi (Tembellik) - Bir işi yapan kod "hatasız" olarak hazır olunca, o kodu bir daha yazmak istemeyiz.
    // bunun yerine, kodu yeniden kullanım (re-use) amaçlı erişilir kılmak isteriz. Çıktı: Kitaplık.
    // 2- Hata düzeltmeyi kolaylaştırmak - "Hatası tespit edilen kod" varsa, o kodun tekrar ettiği yerleri bulmak?
    // 3- Performans, vb bir niteliği sınamak (test) için sınama kapsamı oluşturmak - Dar kapsamlı, spesifik hedefli
    // test prosedürü kurabiliyorum.

    // Kod organizasyonu
    // 1- Fonksiyon/ Yöntem yazmak - Java'da sınıfın içindeki kodu organize etmek demek.
    // 2- Sınıf yazmak - Uygulama içindeki kodu organize etmek demek.


}
