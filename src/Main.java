import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Tamiya merepresentasikan sebuah model tamiya dengan atribut nama, harga, dan stok.
 */
class Tamiya {
    String nama;
    double harga;
    int stok;

    /**
     * Konstruktor untuk membuat objek Tamiya baru.
     *
     * @param nama  Nama tamiya.
     * @param harga Harga tamiya.
     * @param stok  Jumlah stok yang tersedia.
     */
    Tamiya(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    /**
     * Mengurangi stok tamiya berdasarkan jumlah yang diminta.
     *
     * @param jumlah Jumlah tamiya yang akan dikurangi dari stok.
     */
    void kurangiStok(int jumlah) {
        if (stok >= jumlah) stok -= jumlah;
        else System.out.println("Stok tidak cukup!");
    }

    /**
     * Mengembalikan representasi string dari objek Tamiya.
     *
     * @return String yang merepresentasikan nama, harga, dan stok tamiya.
     */
    @Override
    public String toString() {
        return nama + " - Rp" + harga + " (Stok: " + stok + ")";
    }
}

/**
 * Kelas utama untuk menjalankan program manajemen inventaris tamiya.
 */
public class Main {
    static ArrayList<Tamiya> inventaris = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * Menambahkan Tamiya baru ke dalam inventaris.
     */
    static void tambahTamiya() {
        System.out.print("Nama: ");
        String nama = scanner.next();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        inventaris.add(new Tamiya(nama, harga, stok));
    }

    /**
     * Menampilkan daftar semua Tamiya dalam inventaris.
     */
    static void tampilkanInventaris() {
        for (int i = 0; i < inventaris.size(); i++)
            System.out.println((i + 1) + ". " + inventaris.get(i));
    }

    /**
     * Melakukan penjualan Tamiya, mengurangi stok sesuai jumlah pembelian.
     * Menampilkan total harga jika stok mencukupi, atau pesan kesalahan jika tidak.
     */
    static void jualTamiya() {
        tampilkanInventaris();
        System.out.print("Pilih nomor Tamiya: ");
        int nomor = scanner.nextInt() - 1;
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        Tamiya tamiya = inventaris.get(nomor);
        if (tamiya.stok >= jumlah) {
            System.out.println("Total: Rp" + (tamiya.harga * jumlah));
            tamiya.kurangiStok(jumlah);
        } else System.out.println("Stok tidak cukup.");
    }

    /**
     * Metode utama untuk menjalankan program manajemen inventaris.
     * Memungkinkan pengguna untuk menambah, menampilkan, dan menjual Tamiya dalam inventaris.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Tambah Tamiya\n2. Tampilkan Inventaris\n3. Jual Tamiya\n4. Keluar");
            switch (scanner.nextInt()) {
                case 1 -> tambahTamiya();
                case 2 -> tampilkanInventaris();
                case 3 -> jualTamiya();
                case 4 -> running = false;
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
