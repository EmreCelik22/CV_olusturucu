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
1-PDDocument sınıfı ile yeni bir PDF belgesi oluşturulur.
2-PDPage eklenerek A4 boyutunda bir sayfa tanımlanır.
3-PDType0Font ile Unicode destekli Arial fontu yüklenir.
4-PDImageXObject kullanılarak profil fotoğrafı PDF’ye eklenir.
5-PDPageContentStream üzerinden metinler yazılır:
    *İsim, e-posta, telefon ve adres bilgileri
    *“İş Deneyimleri” başlığı
    *İş deneyimleri listesi (for döngüsü ile)
6-Tüm içerik tamamlandıktan sonra PDF “Emre_Celik_Ozgecmis.pdf” olarak kaydedilir.

## Gereksinimler
! Java 17 veya üzeri
! Apache PDFBox kütüphanesi
! arial.ttf ve profile.jpg dosyalarının resources klasöründe bulunması gerekir.
