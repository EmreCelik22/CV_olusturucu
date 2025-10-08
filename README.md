# CV_olusturucu

Bu proje, Java ve Apache PDFBox kütüphanesi kullanılarak oluşturulmuş basit bir PDF özgeçmiş (CV) oluşturucu uygulamasıdır.
Kullanıcı bilgilerini, profil fotoğrafını ve iş deneyimlerini alarak profesyonel bir özgeçmiş dosyası (Emre_Celik_Ozgecmis.pdf) üretir.

## Özellikler
-PDF dosyası oluşturma
- Metin ve başlık yazdırma
- Profil fotoğrafı ekleme
- Türkçe karakter desteği (Unicode font)
- İş deneyimlerini listeleme

  ## Kodun Çalışma Mantığı
+ PDDocument sınıfı ile yeni bir PDF belgesi oluşturulur.
+ PDPage eklenerek A4 boyutunda bir sayfa tanımlanır.
+ PDType0Font ile Unicode destekli Arial fontu yüklenir.
+ PDImageXObject kullanılarak profil fotoğrafı PDF’ye eklenir.
+ PDPageContentStream üzerinden metinler yazılır:
    * İsim, e-posta, telefon ve adres bilgileri
    * “İş Deneyimleri” başlığı
    * İş deneyimleri listesi (for döngüsü ile)
+ Tüm içerik tamamlandıktan sonra PDF “Emre_Celik_Ozgecmis.pdf” olarak kaydedilir.

## Gereksinimler
* Java 17 veya üzeri
* Apache PDFBox kütüphanesi
* arial.ttf ve profile.jpg dosyalarının resources klasöründe bulunması gerekir.

