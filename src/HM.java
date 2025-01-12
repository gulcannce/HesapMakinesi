import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HM {

    public class GelistirilmisHesapMakinesi {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean devamEt = true;

            while (devamEt) {
                System.out.println("Hangi işlemi yapmak istersiniz?");
                System.out.println("1. Toplama");
                System.out.println("2. Çıkarma");
                System.out.println("3. Çarpma");
                System.out.println("4. Bölme");
                System.out.println("5. Kare Alma");
                System.out.println("6. Karekök Alma");
                System.out.println("7. Yüzde Hesaplama");
                System.out.println("Çıkmak için 'C' tuşlayın.");

                String islem = scanner.next();

                switch (islem) {
                    case "1":
                        toplama(scanner);
                        break;
                    case "2":
                        cikarma(scanner);
                        break;
                    case "3":
                        carpma(scanner);
                        break;
                    case "4":
                        bolme(scanner);
                        break;
                    case "5":
                        kareAl(scanner);
                        break;
                    case "6":
                        karekokAl(scanner);
                        break;
                    case "7":
                        yuzdeHesapla(scanner);
                        break;
                    case "C":
                    case "c":
                        devamEt = false;
                        System.out.println("Programdan çıkılıyor...");
                        break;
                    default:
                        System.out.println("Hata: Geçersiz işlem seçtiniz.");
                }
            }

            scanner.close();
        }

        private static void toplama(Scanner scanner) {
            List<Double> sayilar = alSayilar(scanner);
            double toplam = 0;
            for (double sayi : sayilar) {
                toplam += sayi;
            }
            System.out.println("Toplam: " + toplam);
        }

        private static void cikarma(Scanner scanner) {
            List<Double> sayilar = alSayilar(scanner);
            if (sayilar.size() < 2) {
                System.out.println("Hata: En az iki sayı girmelisiniz.");
                return;
            }
            double sonuc = sayilar.get(0);
            for (int i = 1; i < sayilar.size(); i++) {
                sonuc -= sayilar.get(i);
            }
            System.out.println("Sonuç: " + sonuc);
        }

        private static void carpma(Scanner scanner) {
            List<Double> sayilar = alSayilar(scanner);
            double carpim = 1;
            for (double sayi : sayilar) {
                carpim *= sayi;
            }
            System.out.println("Çarpım: " + carpim);
        }

        private static void bolme(Scanner scanner) {
            List<Double> sayilar = alSayilar(scanner);
            if (sayilar.size() < 2) {
                System.out.println("Hata: En az iki sayı girmelisiniz.");
                return;
            }
            double sonuc = sayilar.get(0);
            for (int i = 1; i < sayilar.size(); i++) {
                if (sayilar.get(i) != 0) {
                    sonuc /= sayilar.get(i);
                } else {
                    System.out.println("Hata: Bir sayı sıfıra bölünemez.");
                    return;
                }
            }
            System.out.println("Sonuç: " + sonuc);
        }

        private static void kareAl(Scanner scanner) {
            System.out.println("Kare alınacak sayıyı giriniz:");
            double sayi = alSayi(scanner);
            double sonuc = Math.pow(sayi, 2);
            System.out.println("Sonuç: " + sonuc);
        }

        private static void karekokAl(Scanner scanner) {
            System.out.println("Karekök alınacak sayıyı giriniz:");
            double sayi = alSayi(scanner);
            if (sayi < 0) {
                System.out.println("Hata: Negatif bir sayının karekökü alınamaz.");
                return;
            }
            double sonuc = Math.sqrt(sayi);
            System.out.println("Sonuç: " + sonuc);
        }

        private static void yuzdeHesapla(Scanner scanner) {
            System.out.println("Yüzde hesaplamak istediğiniz sayıyı giriniz:");
            double sayi = alSayi(scanner);
            System.out.println("Hangi yüzdeyi hesaplamak istersiniz? (örn: 10 için 10 yazın)");
            double yuzde = alSayi(scanner);
            double sonuc = (sayi * yuzde) / 100;
            System.out.println("Sonuç: " + sonuc);
        }

        private static List<Double> alSayilar(Scanner scanner) {
            List<Double> sayilar = new ArrayList<>();
            System.out.println("Hesaplama için sayıları girin (çıkmak için 'C' tuşlayın):");
            while (true) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("C")) {
                    break;
                }
                try {
                    double sayi = Double.parseDouble(input);
                    sayilar.add(sayi);
                } catch (NumberFormatException e) {
                    System.out.println("Hata: Lütfen geçerli bir sayı giriniz.");
                }
            }
            return sayilar;
        }

        private static double alSayi(Scanner scanner) {
            double sayi;
            while (true) {
                try {
                    sayi = Double.parseDouble(scanner.next());
                    break; // geçerli bir sayı girilmişse döngüden çık
                } catch (NumberFormatException e) {
                    System.out.println("Hata: Lütfen geçerli bir sayı giriniz.");
                }
            }
            return sayi;
        }
    }
}
