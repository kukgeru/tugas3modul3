# Aplikasi Pemesanan Restoran Sederhana

Aplikasi ini adalah simulasi pemesanan makanan di restoran menggunakan bahasa pemrograman Java. Program ini memungkinkan pengguna untuk memilih item dari menu, menambahkan jumlah pesanan, dan kemudian menampilkan nota total untuk pesanan tersebut.

## Fitur

- **Menambah Menu**: Menambahkan item makanan beserta harga ke dalam menu restoran.
- **Menambah Pesanan**: Pengguna dapat memilih item dari menu dan menentukan jumlahnya.
- **Nota Total**: Setelah pemesanan selesai, aplikasi akan menampilkan rincian pesanan dan total harga yang harus dibayar.

## Struktur Program

Program ini terdiri dari beberapa kelas utama:

### 1. Kelas `Menu`
Kelas ini berfungsi untuk menyimpan dan menampilkan daftar item menu makanan beserta harganya.

- **Atribut**:
    - `items`: Menyimpan nama makanan dan harganya menggunakan `HashMap`.

- **Metode**:
    - `tambahItem(String nama, int harga)`: Menambahkan item makanan baru beserta harganya.
    - `tampilkanMenu()`: Menampilkan semua item dalam menu ke layar.
    - `getItems()`: Mengembalikan daftar item menu.

### 2. Kelas `Pemesanan`
Kelas ini digunakan untuk menyimpan pesanan pelanggan dan menghitung total biaya.

- **Atribut**:
    - `pesanan`: Menyimpan nama makanan dan jumlah yang dipesan menggunakan `HashMap`.

- **Metode**:
    - `tambahPesanan(String namaMakanan, int jumlah, Menu menu)`: Menambahkan pesanan baru jika item tersebut ada dalam menu.
    - `hitungTotal(Menu menu)`: Menghitung total biaya dari semua item yang dipesan.
    - `getPesanan()`: Mengembalikan daftar pesanan.

### 3. Kelas `Restoran`
Kelas ini mengelola keseluruhan proses mulai dari menyiapkan menu hingga mencetak nota pemesanan.

- **Atribut**:
    - `menu`: Objek `Menu` yang menyimpan daftar makanan.
    - `pemesanan`: Objek `Pemesanan` yang menyimpan pesanan pelanggan.

- **Metode**:
    - `setupMenu()`: Mengisi menu dengan item makanan yang tersedia.
    - `buatPemesanan()`: Mengumpulkan pesanan dari pengguna melalui input.
    - `tampilkanNota()`: Menampilkan nota pemesanan dengan rincian setiap item dan total biaya.

### 4. Kelas `Main`
Kelas ini berfungsi sebagai titik masuk program.

- **Metode**:
    - `main(String[] args)`: Membuat objek `Restoran`, menyiapkan menu, mengumpulkan pesanan dari pengguna, dan menampilkan nota.

## Cara Menjalankan Program

1. Clone repositori ini dan buka file `Main.java` di IDE atau teks editor Anda.
2. Jalankan metode `main` dari kelas `Main`.
3. Program akan menampilkan menu makanan dan meminta pengguna untuk memasukkan pesanan.
4. Ketik "selesai" setelah semua pesanan selesai dimasukkan untuk menampilkan nota pesanan.

## Contoh Output

