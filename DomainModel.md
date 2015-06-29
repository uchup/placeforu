<h1>Apa Itu Domain Model??</h1>
Setelah spesifikasi kebutuhan lunak kami rancang dan kami mendapatkan kebutuhan fungsional PlaceForU, maka selanjutnya kami merancang GUI desainnya. Kami juga telah membuat domain model untuk PlaceForU.

Domain model mendeskripsikan semua hal yang secara nyata berhubungan dengan _project_ kemudian direpresentasikan dalam bentuk grafik / diagram yang juga menghubungkan satu dengan yang lainnya.


<h1> Domain Model vs Use Case </h1>
Domain model harus dibuat terlebih dulu daripada use case karena domain model mencegah dari ambiguitas, misalnya dari segi penamaan. Contohnya adalah dalam kasus kami. Sebelumnya saya mencoba membuktikan kebenaran pernyataan ini. Saya membuat use case terlebih dahulu, baru kemudian membuat domain model. Ternyata, terdapat abiguitas penamaan use case. Misalnya, di use case saya menamai "Memperbarui akun", padahal di domain model akun terbagi menjadi akun penyewa gedung, akun pemilik gedung, dan akun admnistrator. Tentunya keempatnya berbeda. Akun penyewa gedung, akun pemilik gedung, dan akun admnistrator merupakan bagian / generalisasi dari akun.


<h1> Aggregate vs Generalization relationship </h1>
Sebenarnya saya ingin menjelaskannya melalui gambar, namun belum bisa caranya memasukkan gambar ke sini. Dalam kasus saya aggregate deskripsikan misalnya : **Gedung** memiliki **kategori gedung** dan **tipe gedung**. Jadi Relasi agregat merupakan relasi A has B, C, etc (A memiliki B.C, dst). Sedangkan relasi generalisasi adalah kasus akun yang telah saya jelaskan sebelumnya pada Domain Model vs Use Case bahwa **akun penyewa gedung, akun pemilik gedung, dan akun admnistrator** merupakan tipe / bagian dari **akun**. Jadi relasi generalisasi merupakan relasi _Both of B, C, etc are A_ .

berikut ini adalah link dari domain model yang telah kami buat

http://placeforu.googlecode.com/files/domain.JPG