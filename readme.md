Sistem ini mensimulasikan sebuah "Gateway" di mana seorang tenaga medis (misal: Dokter Umum atau Dokter Spesialis) mencoba mengakses data profil pasien (V1 atau V2). Sistem akan mengecek **Clearance Level** dari peminta data dan membandingkannya dengan **Security Level** dari data rekam medis tersebut.

Jika level akses peminta lebih rendah dari level keamanan data, sistem tidak akan menolak akses secara total, melainkan menerapkan mekanisme **Masking** (penyensoran) pada data-data sensitif secara otomatis menggunakan Polimorfisme.

Skenario A (Akses Ditolak/Masking pada V1): Dokter Level 1 meminta Data V1 (Level 2). Hasilnya: Data privat diubah menjadi ******.

Skenario B (Akses Diterima pada V2): Dokter Level 3 meminta Data V2 (Level 3). Hasilnya: Data ditampilkan secara utuh.

Skenario C (Akses Ditolak/Masking pada V2): Dokter Level 1 meminta Data V2 (Level 3). Hasilnya: Data privat diubah menjadi ****** dan Diagnosa Khusus diubah menjadi [DATA DILINDUNGI].