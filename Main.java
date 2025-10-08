package com.example.resume;

import org.apache.pdfbox.pdmodel.PDDocument; // PDF belgesi oluşturmak için
import org.apache.pdfbox.pdmodel.PDPage; // PDF sayfası oluşturmak için
import org.apache.pdfbox.pdmodel.PDPageContentStream; // Sayfa üzerine içerik yazmak için
import org.apache.pdfbox.pdmodel.common.PDRectangle; // Sayfa boyutlarını tanımlamak için
import org.apache.pdfbox.pdmodel.font.PDType0Font; // Unicode destekli font kullanmak için
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject; // Görsel eklemek için

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // PDF belgesi oluşturuluyor
        try (PDDocument document = new PDDocument()) {
            // A4 boyutunda yeni bir sayfa oluşturuluyor
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page); // Sayfa belgeye ekleniyor

            // Arial fontu ve profil fotoğrafı dosyadan yükleniyor
            PDType0Font font = PDType0Font.load(document, new File("src/main/resources/arial.ttf"));
            PDImageXObject image = PDImageXObject.createFromFile("src/main/resources/profile.jpg", document);

            // Sayfa üzerine içerik yazmak için akış başlatılıyor
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Profil fotoğrafı sayfaya çiziliyor (sol üst köşeye yakın)
            contentStream.drawImage(image, 50, 700, 100, 100);

            // İsim bilgisi yazılıyor
            contentStream.beginText();
            contentStream.setFont(font, 20); // Font boyutu 20
            contentStream.newLineAtOffset(170, 750); // Konumlandırma
            contentStream.showText("Emre Çelik");
            contentStream.endText();

            // Kişisel bilgiler yazılıyor
            contentStream.beginText();
            contentStream.setFont(font, 12); // Font boyutu 12
            contentStream.newLineAtOffset(170, 730);
            contentStream.showText("E-posta: emre.celik@gmail.com");
            contentStream.newLineAtOffset(0, -15); // Satır aralığı
            contentStream.showText("Telefon: +90 555 123 4567");
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Adres: Şükrüpaşa Mah. Cumhuriyet Cad. No:65 , Edirne, Türkiye");
            contentStream.endText();

            // "İş Deneyimleri" başlığı yazılıyor
            contentStream.beginText();
            contentStream.setFont(font, 14); // Font boyutu 14
            contentStream.newLineAtOffset(50, 650);
            contentStream.showText("İş Deneyimleri:");
            contentStream.endText();

            // İş deneyimleri listesi tanımlanıyor
            String[] jobs = {
                    "Yazılım Geliştirici - Google (2022 - 2024)",
                    "Stajyer Mühendis - Migros (2021 - 2022)",
                    "Freelance Web Developer - Kendi Projeleri (2020 - 2021)"
            };

            // Her iş deneyimi ayrı satıra yazdırılıyor
            int y = 630; // Başlangıç yüksekliği
            for (String job : jobs) {
                contentStream.beginText();
                contentStream.setFont(font, 12);
                contentStream.newLineAtOffset(60, y); // Soldan biraz içeride
                contentStream.showText("- " + job);
                contentStream.endText();
                y -= 20; // Her satır arasında boşluk bırakılıyor
            }

            // İçerik akışı kapatılıyor
            contentStream.close();

            // PDF dosyası kaydediliyor
            document.save("Emre_Celik_Ozgecmis.pdf");
            System.out.println("PDF başarıyla oluşturuldu.");
        } catch (IOException e) {
            // Hata durumunda mesaj yazdırılıyor
            System.err.println("Hata oluştu: " + e.getMessage());
        }
    }
}