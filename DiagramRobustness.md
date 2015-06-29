### Robustness Analysis ###
Robustness Analysis  membantu untuk menjembatani gap (batasan) dari analisis desain yg sebenarnya. Menganalisa text use case dan mengidentifikasi anggapan awal dari objek untuk setiap use case. Robustness Diagram ini diklasifikasikan ke dalam : boundary object, entity object (objek entitas), dan Controller (dimana biasanya berfungsi sebagai kata kerja atau aktivitas). Analisis dilakukan dengan cara membuat robustness diagram yang menghubungkan antara analisis dan desain.

### 3 Stereotype Diagram Robustness ###
Ada 3 kelas stereotype yaitu :
1. boundary objek : interface antara sistem dan dunia luar. boundary objek seperti layar atau halaman web (layar presentasi dimana aktor melakukan interaksi)
2. objek entitas : kelas dari domain model
3. controlers: perekat antara boundary objek dan objek entitas

Diagram robustness pada dasarnya adalah UML disederhanakan komunikasi / kolaborasi diagram yang menggunakan simbol grafis yang digambarkan dalam Gambar.Diagram robustness menggambarkan  beberapa jenis konsep:

1. Aktor = adalah konsep yang sama sebagai aktor pada diagram use case UML.

2. Boundary objek =  mewakili unsur-unsur perangkat lunak seperti layar, laporan, halaman HTML, atau antarmuka sistem yang berinteraksi dengan aktor. Juga disebut elemen antarmuka.

3. control elementt = berfungsi sebagai perekat antara boundary elemen dan entity element, menerapkan logika yang diperlukan untuk mengelola berbagai unsur dan interaksinya. Juga dikenal sebagai elemen proses atau hanya sebagai pengendali. Hal ini penting untuk memahami bahwa kita mungkin memutuskan untuk mengimplementasikan pengendali dalam desain sebagai sesuatu selain objek. Banyak controller cukup sederhana untuk diimplementasikan sebagai sebuah metode dari suatu entitas atau boundary class misalnya.

4. Entity object = adalah jenis entitas yang biasanya ditemukan dalam model konseptual, seperti tabel Mahasiswa dan Seminar.



### Diagram Robustness PlaceForU ###
Diagram robustness ini, kami buat dengan gabungan antara use case text dan desain GUI yang telah dibuat sebelumnya. Untuk melihat diagram robustness nya maka dapat dilihat pada file attach pada comment Issues di bagian diagram robustness dan diagram sequence.