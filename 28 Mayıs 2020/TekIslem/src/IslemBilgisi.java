// Kalıcı olmasını düşündüğümüz tüm sınıflar için JavaBean olarak yazmak büyük avantajlar sağlar.
public class IslemBilgisi {
    // IslemBilgisi nesneleri aşağıdaki verileri barındırır (contain)
    // Bu alanlar için üye (member),

    // Veri saklama, Kapsülleme - Data Hiding, Encapsulation
    // Veriyi erişimi sınırlandırmak, regüle etmek.
    private Double birinci;
    // private yapılan alanlar için okuma/yazma amaçlı iki tane fonksiyon yazıyoruz.
    // JavaBean mutabakatı(*) diyor ki - getXXX okuma, setXXX yazma amaçlıdır.
    private Double ikinci;
    private String secim;

    // Varsayılan yapıcı (Default constructor)
    // public IslemBilgisi(){ -
    public IslemBilgisi(){ // private özel bir anahtar sözcük
                            // - erişim sadece sınıfın içindeki fonksiyonlar ile sınırlı
        // Bir parametre olmaksızın, bu sınıftan "zararsız" bir nesne yaratır.
        // Her sınıfın içi boş veya nötr değerlerle bir nesnesi olmak zorunda değil.
        // Bu sınıfın özelinde böyle bir şey bulamadık
        setBirinci(0.0);
        setIkinci(0.0);
        setSecim("T");
    }

    // Yapıcı (inşacı, kurucu, Constructor, Bau).
    // Yapıcılar normal fonksiyonlar gibi defalarca çağrılmaz.
    // Bir kere çağrılır. Bir değer dönmez, işi nesneyi kurmak.
    public IslemBilgisi(Double b, Double i, String s) {
        // Tutarlılık koşulu nedir?
        // İki değerin var olması. birinci ve ikinci daima bir sayıya (nesneye) bağlanacak
        // Seçilen işlemin geçerli bir işlem olması. C, T, (E)ksiltme, (B)ölme, Karekök
        // TODO: b ve i referansları birer nesneye bağlı olmalı. Bağlı değillerse, yani herhangi birisi
        // null ise bir tür hata mesajı, arıza çıkartma yapmam gerekli.
        setBirinci(b); // b referansının gösterdiği nesneye bağladık.
        setIkinci(i); // i referansının gösterdiği nesneye bağladık.
        // TODO: s içeriği düzgün değilse bir tür hata mesajı, arıza çıkartma yapmam gerekli.
        setSecim(s); // s referansının gösterdiği nesneye bağladık.
    }
    // Yapıcının işi bittiği zaman, nesnenin tutarlı (Consistent) bir şekilde yapılandırıldığını anlarız.

    // Kopyalama yapıcısı (Copy constructor)
    // Bu sınıftan bir nesnenin, verilerini güvenli paylaşan yada paylaşmayan bir kopyasını yaratmak
    // IslemBilgisi yeni = new IslemBilgisi(eski); // yeni ve eski olarak iki nesne oldu.
    // yeni ve eskinin ikisinde de birinci, ikinci, secim var. Eskinin birincisinde değer değiştirsem,
    // yeniye ne olacak? Güvenli tanımı birindeki durum değişikliği, diğerini bozmayacak demek.
    public IslemBilgisi(IslemBilgisi oteki){
        // this anahtar sözcüğü, kendi nesnemize bağlı bir referanstır.
        this.setBirinci(oteki.getBirinci());
        this.setIkinci(oteki.getIkinci());
        this.setSecim(new String(oteki.getSecim())); // String kopyalama yapıcısına güvendim.
                    // ^ içeriği oteki.secim ile aynı ama "bağımsız" bir String nesnesi üretir.
                    // ayırmak istenenler için yeni nesne yaratılır.
    }

    // Bu sınıftan iki nesneyi içeriklerinin denkliği için karşılaştırmak
    // Denklik kuralını biz tanımlıyoruz. Bu bizim hakkımız.
    // Equals her durumda nasıl çalışmalı?
    // 1. a.equals(a) - true
    // 2. a.equals(null) - false
    // 3. a.equals(b) true vermiş ise b.equals(a) da true vermelidir.
    // 4. a.equals(b) false vermiş ise b.equals(a) da false vermelidir.
    public boolean equals(Object o){
        // ^ Mantıksal doğru yanlış için kullanılan tür
        // Boolean değerler true veya false olur.
        // equals(Object o) diye de yazılabilir - JavaBean mutabakatı böyle bekliyor.
        if (o == null){
            return false;
        }
        IslemBilgisi oteki = null;
        if (o instanceof IslemBilgisi) {
            oteki = (IslemBilgisi) o;
                            // Eğer o başka bir türün nesnesi ise hata gelebilir.
                            //  ^ parantez içine alınmış tür adı, sağındaki referansı o türün referansı gibi
                            // yorumlatıyor. o referansı ile gidilen adreste bulunan nesneyi IslemBilgisi
                            // nesnesi olarak yorumla diyor.
        }
        else {
            // Eğer o referansı benim kendi sınıfımdan bir nesneye bakmıyor ise
            // zaten karşılaştıracak bir şey yoktur. Denk değildir.
            return false;
        }
            // 0 numaralı kontrol eğer ikisi gerçekte aynı nesne ise, yani bellekte aynı yerde ise
        // daima denktirler çünkü eşit olan zaten denktir.
        if (this == oteki){
            //   ^ iki referansın içeriği eşit olması zaten aynı nesneye bakıyorlar demek
            return true;
        }
        if(this.birinci.equals(oteki.birinci)
                && this.ikinci.equals(oteki.ikinci)
                && this.secim.equals(oteki.secim) ) {
            // not: Barındırdığımız verinin sınıflarında equals varsa, onu kullanmak işimizi
            // kolaylaştırır.
            return true;
        }

        // Bu satıra ulaştıysak, biliyoruz ki yukarıdaki koşullar sağlanmadı. O zaman denk değiliz.
        return false;
    }


    public Double getBirinci() {
        return birinci;
    }

    // setXXX fonksiyonlarında kurallar olabilir.
    public void setBirinci(Double birinci) {
        this.birinci = birinci;
    }

    public Double getIkinci() {
        return ikinci;
    }

    public void setIkinci(Double ikinci) {
        this.ikinci = ikinci;
    }

    public String getSecim() {
        return secim;
    }

    // Kural: Gelen String, bizim uygunlar listesinde olmalı.
    public void setSecim(String secim) {
        // TODO: Gelenin uygunlar listesinde olduğunu kontrol et.
        this.secim = secim;
    }
}
