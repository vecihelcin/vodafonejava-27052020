import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String[] diziyeEkle(String[] katilimcilar, String girdi){
        System.out.println("Mevcut dizi uzunluğu:" + katilimcilar.length);
        String[] geciciYeni = new String[katilimcilar.length + 1];
        // geçiciYeni indeksleri 0, ...., katilimcilar.length ile biter ve hepsi < katilimcilar.length + 1
        // geçiciYeni indeksleri 0, ......, katilimcilar.length-1 olanlar eskileri,
        // katilimcilar.length yeni gelen (en sonda olduğu için)
        // 0 kişilik masa var, 1 ek kişi geldi, 1 kişilik masaya 0 kişiyi taşıdık, 1 kişi eklendi
        // 1 ""                1 ek kişi geldi, 2 ""             1      ""         1  ""
        // 2 ""                1 ""             3  ""            2      ""         1 ""
        /*
        for(int indeks=0; indeks < katilimcilar.length; indeks++){
            geciciYeni[indeks] = katilimcilar[indeks];
        }
        */
        System.arraycopy(katilimcilar,0,geciciYeni,0,katilimcilar.length);
        // Topluca referanslar kopyalandı.
        geciciYeni[katilimcilar.length] = girdi; // Son gelen eleman en sondaki boş alana girdi.
        return geciciYeni;
    }

    public static void main(String[] args) {
	// write your code here
        // Kullanıcıdan toplantıya katılacak olanların listesini alacağız.
        // "Tamam" yazıldığı zaman liste tamamlanmış olacak.

        Scanner girdiler = new Scanner(System.in);
        String girdi = ""; // Başlangıçta içi boş olsun.
        // Tamam girildiği zaman çıkmak istiyorum, Tamam girilmediği müddetçe devam
        String[] katilimcilar = new String[0]; // Başlangıçta kimse yok.
        Integer katilimciSayisi = 0;
        while(!"Tamam".equals(girdi)){
        //while("Tamam".equals(girdi) == false){
            System.out.println("Katılımcı ekleyin. Liste tamamlanmış ise Tamam yazın.");
            girdi = girdiler.next();
            if (girdi.equals("Tamam") == false) {
                // Listeye ekleyebilirim.
                katilimcilar = diziyeEkle(katilimcilar, girdi);
            }
        }
        System.out.println("Tüm katılımcılar.");
        for(String katilimci : katilimcilar)
            System.out.println(katilimci);

        String[] yedek = Arrays.copyOf(katilimcilar, katilimcilar.length);

        // compareTo yöntemi olan sınıfları sıralamak mümkündür.
        // a < b ve b < c ise a < c uygun olacak şekilde çalışıyorsa, standart algoritmalar ile sıralanır

        // Algoritmayı elle kodlama örneği olarak kullanılabilecekler
        // 1- Quicksort -- https://www.baeldung.com/java-quicksort -- Büyük uzun listeleri sıralamakta iyidir
        // 2- Insertion Sort -- https://www.baeldung.com/java-insertion-sort -- Göreli daha kısaları
        Arrays.sort(katilimcilar);
        System.out.println("Sıralanmış liste:");
        for(String katilimci : katilimcilar)
            System.out.println(katilimci);

        if ( Arrays.equals(katilimcilar, yedek) == true){
            System.out.println("Denk");
        }

        String metin =Arrays.deepToString(katilimcilar);
        System.out.println("Deep toString ile gelen: " + metin);
        // Örnek çıktı: [Ayça, Bora, Burak, Cem]

        // JPEGImage sınıf olsa. Nesneleri de 3-4 MB yer kaplıyor olsa?

        // Veri sakladığım, barındırdığım "barındırıcı" diye adlandıracağım genel bir kavramım var.
        // Soru: Sıralı şekilde durmaları şart mı? Sıra tanımlanacaksa nasıl tanımlanıyor?
        // Array için yanıt: Sıralı duracaklar. Sıra dediğimiz indeks değeridir. Başka bir sıra isteniyor ise,
        // elle sıralanacaktır. Alfanbetik sıra, büyük küçüğe, vb bir kritere göre sıralamak için işlem gerekli.
        // Arrays.sort çalışması için compareTo bulunması gerekli.

        // Soru: Tek bir elemana erişim için direkt nokta atış erişmek gerekli mi? Mümkün mü?
        // Array için yanıt: İndeksini biliyorsan, tek hamlede erişirsin. ...[i] Bilmiyorsan ararsın. Lineer arama tipik.
        // N tane eleman varsa bu arama en kötü N tane karşılaştırma işlemi demek. Ortalama? N/2 olabilir.

        // Soru: Bellek kullanımı nasıldır? Nasıl büyütürüz küçültürüz? Bu işlem yorucu mudur?
        // Array için yanıt: Eğer sadece referansları kopyalayacaksak, daha büyük/küçük bir yedek array yaratılır.
        // System.arraycopy ile blok kopyalama yapılır. Oldukça da hızlı olur.

        // Soru: Rastgele seçilmiş bir elemana erişmek ile spesifik konumdaki (ör en baş, en son) elemana erişmek arasında
        // fark varmı?
        // Array için yanıt: Erişim süresi açısından fark yok. Hepsi aynı şekilde indeks kullanıyor. Eğer bu elemanı
        // yapıdan kopartmak gibi bir iş yapılacaksa, o zaman konum, bellek değişiklikleri ile ilgili olarak farklı
        // şekilde kod çalıştırmaya neden olabilir. Ama etkisi düşüktür.

        // Array benzeri en temel yapı List isminde bir sınıf. Gelişmişler, Set, Table, ...

        List<String> isimler = Arrays.asList(katilimcilar);
        for(String katilimci : isimler){
            System.out.println(katilimci);
        }


    }
}
