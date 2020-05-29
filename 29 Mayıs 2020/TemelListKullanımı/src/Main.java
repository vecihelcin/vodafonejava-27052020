import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner girdiler = new Scanner(System.in);
        String girdi = ""; // Başlangıçta içi boş olsun.
        // Tamam girildiği zaman çıkmak istiyorum, Tamam girilmediği müddetçe devam
        // String[] katilimcilar = new String[0]; // Başlangıçta kimse yok.

        List<String> katilimcilar = new LinkedList<String>();
        // ^ List of String, String Listesi
                                // List alternatifleri (standart kitaplıkta) iki tane: ArrayList ve LinkedList
                                // ArrayList tamponlu bir array kullanıyor.
                                // LinkedList ise 3 referanstan oluşan tren vagonları. önceki-sonraki vagon, veri
        /*
        while("Tamam".equals(girdi) == false){
            System.out.println("Katılımcı ekleyin. Bitirmek için Tamam yazabilirsiniz. ");
            girdi = girdiler.next();
            if ("Tamam".equals(girdi) == false) {
                katilimcilar.add(girdi);
                System.out.println("Mevcut katılımcılar:");
                System.out.println(katilimcilar);
            }
        }
        */
        do {
            System.out.println("Mevcut katılımcılar:");
            System.out.println(katilimcilar);
            System.out.println("Katılımcı ekleyin. Bitirmek için Tamam yazabilirsiniz. ");
            girdi = girdiler.next();
            if ("Tamam".equals(girdi) == false)
                katilimcilar.add(girdi);
        } while("Tamam".equals(girdi) == false);

        // Liste içinde arama yapmak
        int indeks = katilimcilar.indexOf("Ayça");
        System.out.println("İndeks:" + indeks);
        String isim = katilimcilar.get(indeks);
        for(String katilimci : katilimcilar){
            System.out.println("katılımcı:" + katilimci);
        }
        // Listeyi sıralamak
        katilimcilar.sort(String::compareTo); // String tuttuğumuz için hazırda bir fonksiyon var.
                                            // Karşılaştırma sınıfı (Comparator) yazsak o da olurdu.
        System.out.println("Sıralama sonrası:");
        System.out.println(katilimcilar);
        // İki listeyi birleştirmek
        // Not: Buradaki yöntem en yaygın yöntem, ancak özellikle büyük boyutlu listelerde daha hızlı çalışan
        // ancak kesinlikle thread-safe olmayan yöntemler de var.
        // Örnekler -- https://www.techiedelight.com/join-two-lists-java/
        List<String> ikinciListe = new ArrayList<String>();
        ikinciListe.add("Erdoğan");
        ikinciListe.add("Gizem");
        katilimcilar.addAll(ikinciListe);
        // Çalışması şöyle:
        for(String katilimci : ikinciListe){
            katilimcilar.add(katilimci);
        }
        System.out.println("Toplu ekleme sonrası:");
        System.out.println(katilimcilar);

        katilimcilar.remove("Bora");
        System.out.println("Çıkarma sonrası:");
        System.out.println(katilimcilar);

        katilimcilar.add("Bora");
        katilimcilar.add("Bora");
        System.out.println("Eklemeler sonrası:");
        System.out.println(katilimcilar);
        // Aynı nesne, bir listede birden fazla kere bulunabilir. Listedeki referansların nelere baktığı,
        // kontrol edilmiyor. Aynı şeye bakmasına bir engel yok.
        // Aynı nesne sadece bir kez kalsın istiyorsak, Set (Küme) sınıfını kullanmak gerekli.
        int indeks1 = katilimcilar.indexOf("Bora");
        int indeks2 = katilimcilar.indexOf("Bora");
        System.out.println("IndexOf örneği:");
        System.out.println("indeks1:"+indeks1+"indeks2:"+indeks2);
        // Aynı çıktı? -- indexOf her arama sonrası "hafızasını kaybeder". Her seferinde en baştan başlar.
        indeks1 = katilimcilar.lastIndexOf("Bora");
        indeks2 = katilimcilar.lastIndexOf("Bora");
        System.out.println("LastIndexOf örneği:");
        System.out.println("indeks1:"+indeks1+"indeks2:"+indeks2);

        // List'de bulamadığımız şeyleri Collections içinde bulmak mümkündür. Utility class.
        // Apache Commons, Google Guava kitaplık içinde de açık lisanslı Collection yardımcı sınıfları var.
        // Apache -- https://commons.apache.org/proper/commons-collections/

        }
}
