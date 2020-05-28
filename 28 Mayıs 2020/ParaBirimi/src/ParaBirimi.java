
// TODO: JavaBean haline getirmek.
public class ParaBirimi {
    // Bu sınıfın nesneleri durumlu (stateful)
    private Integer tam;
    private Integer kurus;

    // TODO: Yapıcılarını yazmak
    public ParaBirimi(){
        // Soru: 0 değerli bir para kaydı işlemleri bozar mı?
        // Analiz ile ve tasarım ile tutarlılığı teyit edilmelidir.
        tam = 0;
        kurus = 0;
    }

    public ParaBirimi(Integer tam, Integer kurus){
        // Tutarlılık: tam veya kurus negatif olamaz.
        if (tam >= 0 )
            this.tam = tam;
        else
            this.tam = 0; // Burada sıfırın güvenli bir değer olduğunu varsaydık.
        if (kurus >= 0)
            this.kurus = kurus;
        else
            this.kurus = 0; // Burada sıfırın güvenli bir değer olduğunu varsaydık.
    }

    public ParaBirimi(ParaBirimi oteki){
        this.tam = oteki.tam;
        this.kurus = oteki.kurus;
    }

    // TODO: Equals yazmak
    public boolean equals(Object o){
        if (o == null)
            return false;
        if (this == o)
            return true;
        ParaBirimi oteki = null;
        if (o instanceof ParaBirimi){
            oteki = (ParaBirimi) o;
        }
        else{
            return false;
        }
        // oteki referansına atama yapıldı
        if (this.tam.equals(oteki.tam) && this.kurus.equals(oteki.kurus))
            return true;
        // Buraya ulaşıldı ise denk değildir.
        return false;
    }

    public Integer compareTo(Object o){
        // ben küçüksem negatif, ben büyüksem pozitif, denksem sıfır dönerim
        // eğer sayısal değere dönüşen bir sınıf varsa, o değerlerin farkını döneriz olur biter.
        ParaBirimi oteki = null;
        if (o instanceof ParaBirimi){
            oteki = (ParaBirimi) o;
            // işlemlere devam.
            //Integer benimKurusum = this.getTam() * 100 + this.getKurus();
            //Integer otekiKurusu = oteki.getTam() * 100 + oteki.getKurus();
            //Integer fark = benimKurusum - otekiKurusu;
            // return fark;

            // Direkt sayıya dönüşemeseydi, önceliklendirmek yolu ile bakmak bir yol.
            Integer tamCompare = this.getTam().compareTo(oteki.getTam());
            if(tamCompare != 0){
                return tamCompare;
            }
            else { //tamCompare == 0 demek
                Integer kurusCompare = this.getKurus().compareTo(oteki.getKurus());
                return kurusCompare;
            }
        }
        else {
            return -1;
            // TODO: hata durumu
        }
    }

    // TODO: getXX setXX - otomatik oluşturuldu, sonra düzenlendi
    public Integer getTam() {
        return tam;
    }

    public void setTam(Integer tam) {
        // tutarlılık kuralı: tam negatif olamaz
        if (tam >= 0)
            this.tam = tam;
    }

    public Integer getKurus() {
        return kurus;
    }

    public void setKurus(Integer kurus) {
        // tutarlılık kuralı: kurus negatif olamaz
        if (kurus >= 0)
            this.kurus = kurus;
    }

    public void eksilt(ParaBirimi oteki) {
        // Bu işlem nesnenin içeriğini değiştiriyor.
        // Bu yöntem ile nesneler mutable (değişebilir) oldu, immutable (değişmez) olmadı.
        Integer benimKurusum = this.getTam() * 100 + this.getKurus();
        Integer otekiKurusu = oteki.getTam() * 100 + oteki.getKurus();
        Integer fark = benimKurusum - otekiKurusu;
        this.setTam(fark / 100);
        this.setKurus(fark % 100); // % mod alan operatör. Burada 100'e bölümden kalanı veriyor.
    }

    public ParaBirimi getParaUzeri(ParaBirimi oteki) {
        // Bu işlem nesnenin içeriğini değiştirmiyor. Yeni nesne yaratıyor.
        // Immutable olsun deniyor ise bu şekilde yeni nesne yaratacak şekilde kodluyoruz.
        Integer benimKurusum = this.getTam() * 100 + this.getKurus();
        Integer otekiKurusu = oteki.getTam() * 100 + oteki.getKurus();
        Integer fark = benimKurusum - otekiKurusu;
        ParaBirimi uzeri = new ParaBirimi();
        uzeri.setTam(fark / 100);
        uzeri.setKurus(fark % 100);
        return uzeri;
    }
}
