import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Kelas Menu
 class Menu {
    private Map<String, Integer> items;

    public Menu() {
        items = new HashMap<>();
    }

    public void tambahItem(String nama, int harga) {
        items.put(nama, harga);
    }

    public void tampilkanMenu() {
        System.out.println("Menu Makanan:");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": Rp " + entry.getValue());
        }
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}

// Kelas Pemesanan
class Pemesanan {
    private Map<String, Integer> pesanan;

    public Pemesanan() {
        pesanan = new HashMap<>();
    }

    public void tambahPesanan(String namaMakanan, int jumlah, Menu menu) {
        if (menu.getItems().containsKey(namaMakanan)) {
            pesanan.put(namaMakanan, pesanan.getOrDefault(namaMakanan, 0) + jumlah);
        } else {
            System.out.println(namaMakanan + " tidak ada dalam menu.");
        }
    }

    public int hitungTotal(Menu menu) {
            int total = 0;
            for (Map.Entry<String, Integer> entry : pesanan.entrySet()) {
                String nama = entry.getKey();
                int jumlah = entry.getValue();
                total += menu.getItems().get(nama) * jumlah;
            }
            return total;
        }

    public Map<String, Integer> getPesanan() {
        return pesanan;
    }
}

// Kelas Restoran
class Restoran {
    private Menu menu;
    private Pemesanan pemesanan;

    public Restoran() {
        menu = new Menu();
        pemesanan = new Pemesanan();
    }

    public void setupMenu() {
        menu.tambahItem("Nasi Goreng", 25000);
        menu.tambahItem("Ayam Penyet", 30000);
        menu.tambahItem("Sate Ayam", 20000);
        menu.tambahItem("Mie Goreng", 15000);
        menu.tambahItem("Es Teh", 5000);
    }

    public void buatPemesanan() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.tampilkanMenu();
            System.out.print("Masukkan nama makanan (atau 'selesai' untuk selesai): ");
            String namaMakanan = scanner.nextLine();
            if (namaMakanan.equalsIgnoreCase("selesai")) {
                break;
            }
            System.out.print("Masukkan jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            pemesanan.tambahPesanan(namaMakanan, jumlah, menu);
        }
    }

    public void tampilkanNota() {
        int total = pemesanan.hitungTotal(menu);
        System.out.println("\nNota Pemesanan:");

        pemesanan.getPesanan().forEach((nama, jumlah) -> {
            int harga = menu.getItems().get(nama);
            System.out.printf("%s: %d x Rp %d = Rp %d%n", nama, jumlah, harga, harga * jumlah);
        });

        System.out.println("Total: Rp " + total);
    }
}

// Kelas Utama
public class Main {
    public static void main(String[] args) {
        Restoran restoran = new Restoran();
        restoran.setupMenu();
        restoran.buatPemesanan();
        restoran.tampilkanNota();
    }
}