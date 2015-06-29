<h1> <font color='red'> Use Case Description </font> </h1>

<h2> <font color='green'> Use Case Name :  UC001 LOGIN </font></h2>
| **Primary Actor** | Administrator, Penyewa, Pemilik |
|:------------------|:--------------------------------|
| **Normal Flows**  | Aktor (pemilik gedung, penyewa gedung, administrator) memasukkan username dan password pada Form Login. Kemudian menekan tombol login.  Sistem akan mencocokkan username, password yang dimasukkan aktor dengan Daftar User. Setelah sistem menemukan data username dan password, maka sistem mengarahkan aktor ke halaman home page (backend). |
| **Alternative Flows**  | Jika aktor tidak memasukkan username dan password sesuai dengan Daftar User, maka sistem menampilkan jendela "Error Login". <br><br> Jika ada field yang kosong, sistem memunculan jendela error "Empty Field".  </tbody></table>


<h2> <font color='green'> Use Case Name :  UC002 LOGOUT </font></h2>
| **Primary Actor** | Administrator, Penyewa, Pemilik |
|:------------------|:--------------------------------|
| **Normal Flows**  | Aktor (administrator, pemilik gedung, penyewa gedung) menekan tombol logout dan sistem akan mematikan session aktor tersebut dan mengarahkan aktor ke halaman utama pengunjung. |
| **Alternative Flows**  | -                               |

<h2> <font color='green'> Use Case Name :   UC003 Melakukan registrasi akun baru </font></h2>
| **Primary Actor** | Administrator, Umum |
|:------------------|:--------------------|
| **Normal Flows**  | Aktor (Administrator, pengunjung) menekan tombol Tambah User  untuk menuju halaman Registrasi User. Sistem menampilkan Halaman  Registrasi User. Aktor mengisi field yang ada pada Halaman Registrasi User. Aktor menekan tombol Register. Sistem menyimpan data yang dikirim ke dalam Daftar User. Sistem menampilkan halaman "Success Saving" dan mengarahkan aktor ke halaman Daftar User. |
| **Alternative Flows**  |Jika ada field bertanda bintang (mandatory) yang kosong, maka sistem menampilkan halaman "Incomplete Field". Aktor mengisi kembali field yang kosong.  |

<h2> <font color='green'> Use Case Name :   UC004 Mengubah profil user (semua pengguna) </font></h2>
| **Primary Actor** | Administrator |
|:------------------|:--------------|
| **Normal Flows**  | Aktor (administrator) menekan menu User untuk menuju halaman Daftar User. Sistem menampilkan halaman Daftar User. Aktor memilih User yang akan dirubah profilnya dengan mencentang checkbox dan menekan tombol Ubah. Sistem menampilkan halaman Ubah User. Aktor mengisi  field yang ada pada halaman Ubah User. Setelah selesai, aktor menekan tombol Ubah. Sistem mencocokkan ID user yang sedang login dengan ID user pada Daftar User serta isi field password lama dengan data password lama aktor yang tersimpan pada Daftar User. Jika data tersebut sama, sistem mengganti data aktor pada Daftar User. Setelah tersimpan, sistem menampilkan halaman "Success Updating". Sistem mengarahkan aktor pada halaman Daftar User. |
| **Alternative Flows**  |Jika ada field bertanda bintang (mandatory) yang kosong, maka sistem menampilkan halaman "Incomplete Field".<br> Jika tidak ada data pada Daftar User yang sesuai dengan ID user dan  isi field password lama yang diisikan aktor pada halaman Ubah User, maka sistem menampilkan halaman "Invalid Password". Aktor menekan tombol kembali. Sistem mengarahkan aktor ke halaman Ubah User kembali. <br> Jika aktor membatalkan perubahan. maka aktor menekan tombol batalkan pada halaman Ubah User. Sistem akan mengarahkan aktor ke halaman Daftar User.</tbody></table>

<h2> <font color='green'> Use Case Name :   UC005 Mengubah profil user (milik sendiri) </font></h2>
| **Primary Actor** | Pemilik, Penyewa |
|:------------------|:-----------------|
| **Normal Flows**  | Aktor (penyewa gedung, pemilik gedung) menekan menu User untuk menuju halaman Profil User. Sistem menampilkan halaman Profil User. Aktor menekan tombol Ubah. Sistem menampilkan halaman Ubah User. Aktor mengisi  field yang ada pada halaman Edit Akun. Setelah selesai, aktor menekan tombol Ubah. Sistem mencocokkan ID user yang sedang login dengan ID user pada Daftar User. Sistem mencocokkan isi field password lama dengan data password lama aktor yang tersimpan pada Daftar User. Jika data tersebut sama, sistem mengganti data aktor pada Daftar User. Setelah tersimpan, sistem menampilkan halaman "Success Updating". Sistem mengarahkan aktor pada halaman Profil User. |
| **Alternative Flows**  | Jika ada field bertanda bintang (mandatory) yang kosong, maka sistem menampilkan halaman "Incomplete Field".<br>Jika tidak ada data pada Daftar User yang sesuai dengan ID user dan  isi field password lama yang diisikan aktor pada halaman Ubah User, maka sistem menampilkan halaman "Invalid Password". Aktor menekan tombol kembali. Sistem mengarahkan aktor ke halaman Ubah User kembali.<br>Jika aktor membatalkan perubahan. maka aktor menekan tombol batalkan pada halaman Ubah User. Sistem akan mengarahkan aktor ke halaman Daftar User. </tbody></table>

<h2> <font color='green'> Use Case Name :   UC006 Melihat semua profil user </font></h2>
| **Primary Actor** | Administrator |
|:------------------|:--------------|
| **Normal Flows**  | Aktor (administrator) menekan menu User untuk menuju halaman Daftar User. Sistem menampilkan halaman Daftar User. Aktor memilih User yang akan dilihat detail profilnya. Sistem menampilkan halaman Detail Profil User.  |
| **Alternative Flows**  |  Untuk melihat profil user yang lain, aktor menekan tombol Kembali pada halaman Detail Profil User. |

<h2> <font color='green'> Use Case Name :   UC007 Melihat semua profil user </font></h2>
| **Primary Actor** | Pemilik, Penyewa |
|:------------------|:-----------------|
| **Normal Flows**  | Aktor (penyewa gedung, pemilik gedung) menekan menu User untuk menuju halaman Profil User. Sistem mencocokkan ID user yang sedang login dengan Daftar User. Sistem menampilkan halaman Profil User yang berisi informasi profil user yang sedang login. Aktor melihat profilnya sendiri.  |
| **Alternative Flows**  | Aktor menekan tombol kembali. Sistem mengarahkan aktor ke halaman Ubah User kembali.  |


<h2> <font color='green'> Use Case Name :   UC008 Menghapus profil pengguna </font></h2>
| **Primary Actor** | Admnistrator |
|:------------------|:-------------|
| **Normal Flows**  | Aktor (administrator) menekan menu User untuk menuju halaman Daftar User. Sistem menampilkan halaman Daftar User. Aktor memilih User yang akan dihapus menekan tombol Hapus.  Sistem menampilkan halaman "Delete Success". Aktor menekan tombol kembali. Sistem mengarahkan aktor ke halaman Daftar User. |
| **Alternative Flows**  | -            |

<h2> <font color='green'> Use Case Name :   UC009 Melakukan konfirmasi registrasi pengguna</font></h2>
| **Primary Actor** | Admnistrator |
|:------------------|:-------------|
| **Normal Flows**  | Aktor (administrator) menekan tombol Manajemen User. Sistem menampilkan halaman Daftar Akun (User). Aktor menekan tombol Konfirmasi Registrasi untuk melihat daftar pengunjung yang melakukan permintaan konfirmasi registrasi. Sistem menampilkan halaman Konfirmasi Registrasi. Aktor memilih user yang akan dikonfirmasi dan menekan tombol Terima untuk menyetujui registrasi akun. Sistem merubah status registrasi menjadi "Confirmed" pada Daftar User. Sistem menampilkan halaman "Success Confirmation" dengan pesan penerimaan registrasi. Sistem mengarahkan aktor ke halaman Konfirmasi Registrasi kembali. |
| **Alternative Flows**  | Jika aktor menolak registrasi, maka aktor menekan tombol Tolak pada halaman Konfirmasi Registrasi. Sistem akan menghapus data pada Daftar User dan setelah itu menampilkan halaman "Confirmation Response" dengan pesan penolakan registrasi. Aktor menekan kembali / konfirmasi lainnya. Sistem mengarahkan aktor ke halaman Konfirmasi Registrasi. |

<h2> <font color='green'> Use Case Name :   UC010 Menulis Informasi Gedung</font></h2>
| **Primary Actor** | Pemilik Gedung|
|:------------------|:--------------|
| **Normal Flows**  | Aktor (Pemilik Gedung) memilih menu informasi gedung dan sistem menampilkan halaman Daftar Informasi Gedung. Aktor memilih tombol Tambah Informasi dan sistem akan segera menampilkan Form Entri Informasi Gedung. Aktor harus menuliskan informasi lengkap pada semua field yang yang bertanda bintang (**). Setelah selesai menuliskan informasi tersebut, aktor menekan tombol Simpan, selanjutnya sistem akan menyimpan informasi tersebut pada Daftar Gedung. Setelah tersimpan, sistem akan menampilkan jendela "Success Saving".**|
| **Alternative Flows**  | Jika ada field bertanda bintang yang kosong, maka akan muncul jendela error "Empty Field" untuk menginstruksikan aktor mengisi semua field. Kemudian sistem mengarahkan aktor menuju Form Entri Informasi Gedung kembali.<br>Jika terdapat nama gedung dan id pemilik yang sama, maka sistem akan menampilkan halaman error yang berisi pesan bahwa Gedung sudah dimasukkan sebelumnya. Aktor menekan link kembali untuk kembali memasukkan gedung dengan nama lain. </tbody></table>

<h2> <font color='green'> Use Case Name :   UC011 Mengubah informasi gedung</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (Pemilik Gedung) memilih menu informasi gedung dan sistem menampilkan halaman Daftar Informasi Gedung (Backend). Aktor memilih dan mencentang gedung yang akan diubah dan menekan tombol Ubah, kemudian sistem akan menampilkan Form Ubah Informasi Gedung. Aktor harus menuliskan informasi lengkap pada semua field yang ada. Setelah selesai menuliskan informasi tersebut, aktor menekan tombol Ubah, selanjutnya sistem akan menyimpan informasi tersebut dalam Daftar Gedung. Setelah tersimpan, sistem menampilkan jendela "Success Updating" dan mengarahkan aktor pada halaman Daftar Informasi Gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> Jika ada field bertanda bintang (<b>) yang kosong, maka akan muncul jendela error "Empty Field" untuk menginstruksikan aktor mengisi semua field. Kemudian sistem mengarahkan aktor menuju Form Ubah Informasi Gedung kembali.</b><br> Jika terdapat nama gedung dan id pemilik yang sama dengan data pada Daftar Gedung, maka sistem akan menampilkan halaman error yang berisi pesan bahwa Gedung sudah dimasukkan sebelumnya. Aktor menekan link kembali untuk kembali memasukkan gedung dengan nama lain. </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name :   UC012 Menghapus informasi gedung</font></h2>
| **Primary Actor** | Administrator, Pemilik Gedung|
|:------------------|:-----------------------------|
| **Normal Flows**  | Aktor (Pemilik Gedung, Administrator) memilih menu informasi gedung dan sistem menampilkan halaman Daftar Informasi Gedung (Backend). Aktor memilih  gedung yang akan dihapus dan menekan tombol Hapus. Dan sistem akan memunculkan jendela Konfirmasi Hapus Gedung. Aktor menekan tombol Yakin. Sistem akan menghapus data dari Daftar Gedung Sistem menampilkan halaman Daftar Informasi Gedung. |
| **Alternative Flows**  | -                            |


<h2> <font color='green'> Use Case Name : UC013 Mencari informasi gedung berdasarkan kategori gedung</font></h2>
| **Primary Actor** | Administrator, Pemilik Gedung, Penyewa Gedung, Pengunjung|
|:------------------|:---------------------------------------------------------|
| **Normal Flows**  | Aktor (Pengunjung, Administrator, Pemilik Gedung, Penyewa Gedung) memilih menu Informasi Gedung. Sistem mengarahkan aktor ke halaman Daftar Informasi Gedung. Aktor menekan tombol Cari. Sistem menampilkan Form Cari Gedung. Aktor memilih kategori gedung. Sistem mencari data gedung berdasarkan kategori yang dimaksud dari Daftar Gedung dan menampilkannya pada halaman Daftar Informasi Gedung. |
| **Alternative Flows**  | Jika aktor adalah pengunjung, maka pencarian langsung dapat dilakukan pada halaman home (frontend) |

<h2> <font color='green'> Use Case Name : UC014 Mencari informasi gedung berdasarkan kategori harga</font></h2>
| **Primary Actor** | Administrator, Pemilik Gedung, Penyewa Gedung, Pengunjung|
|:------------------|:---------------------------------------------------------|
| **Normal Flows**  | Aktor (Pengunjung, Administrator, Pemilik Gedung, Penyewa Gedung) memilih menu Informasi Gedung. Sistem mengarahkan aktor ke halaman Daftar Informasi Gedung. Aktor menekan tombol Cari. Sistem menampilkan Form Cari Gedung. Aktor memilih kategori gedung. Sistem mencari data gedung berdasarkan kategori yang dimaksud dari Daftar Gedung dan menampilkannya pada halaman Daftar Informasi Gedung. |
| **Alternative Flows**  | Jika aktor adalah pengunjung, maka pencarian langsung dapat dilakukan pada halaman home (frontend) |

<h2> <font color='green'> Use Case Name : UC015 Menulis informasi sub gedung</font></h2>
| **Primary Actor** | Pemilik Gedung|
|:------------------|:--------------|
| **Normal Flows**  | Aktor (Administrator, pemilik) menuju halaman Daftar Sub Gedung dan memilih tombol tambah sub gedung. Lalu mengisi field pada halaman Tambah Sub Gedung secara lengkap. Setelah itu, aktor menyimpan informasi sub gedung tersebut dengan menekan tombol Simpan. Maka Sistem akan menyimpan informasi sub gedung dan akan dimunculkan halaman dengan pesan Sub Gedung berhasil ditambahkan.  |
| **Alternative Flows**  | Jika ada field bertanda bintang (mandatory field) yang belum diisi maka akan muncul pesan peringatan data tidak lengkap untuk menginstruksikan aktor mengisi semua field mandatory.<br><br>Jika sebelumnya ada subgedung dengan id_pemilik dan nama sub gedung yang sama dengan Daftar Sub Gedung yang telah ada, maka sistem akan menampilkan halaman pesan error bahwa tidak boleh memasukkan nama subgedung yang sama. </tbody></table>

<h2> <font color='green'> Use Case Name : UC016 Mengubah Informasi Sub Gedung</font></h2>
| **Primary Actor** | Pemilik Gedung|
|:------------------|:--------------|
| **Normal Flows**  | Aktor menuju halaman Daftar Sub Gedung. Aktor memilih sub gedung yang akan diubah, kemudian sistem akan menampilkan Form Ubah Sub Gedung. Aktor harus menuliskan informasi lengkap pada semua field bertanda bintang yang ada. Setelah selesai menuliskan informasi tersebut, aktor menekan tombol Ubah, selanjutnya sistem akan menyimpan informasi tersebut. Setelah tersimpan, aktor diarahkan ke halaman yang berisi form daftar sub gedung.  |
| **Alternative Flows**  | Jika ada field bertanda bintang (mandatory field) yang belum diisi maka akan muncul pesan peringatan data tidak lengkap untuk menginstruksikan aktor mengisi semua field mandatory.<br><br>Jika sebelumnya ada subgedung dengan id_pemilik dan nama sub gedung yang sama dengan Daftar Sub Gedung yang telah ada, maka sistem akan menampilkan halaman pesan error bahwa tidak boleh memasukkan nama subgedung yang sama. </tbody></table>

<h2> <font color='green'> Use Case Name : UC017 Menghapus informasi sub gedung</font></h2>
| **Primary Actor** | Pemilik Gedung|
|:------------------|:--------------|
| **Normal Flows**  | Aktor menuju halaman Daftar Sub Gedung. Aktor memilih gedung yang akan diubah, kemudian sistem akan menampilkan Form Daftar Sub Gedung. Aktor memilih Sub Gedung yang akan dihapus. Kemudian, sistem akan menampilkan Form Hapus Sub Gedung. Untuk menghapus, maka aktor harus menekan tombol Hapus. Dan setelah tombol hapus tersebut ditekan, maka akan muncul layar konfirmasi penghapusan Subi Gedung. Setelah berhasil menghapus, aktor akan diarahkan ke halaman Daftar Kategori Gedung. |
| **Alternative Flows**  | -             |

<h2> <font color='green'> Use Case Name : UC018 Melihat informasi sub gedung</font></h2>
| **Primary Actor** | Pengunjung, Administrator, Pemilik Gedung, atau Penyewa Gedung|
|:------------------|:--------------------------------------------------------------|
| **Normal Flows**  | Aktor (Pengunjung, Administrator, Pemilik Gedung, atau Penyewa Gedung) menuju Daftar Informasi Sub Gedung setelah sebelumnya memilih gedung yang dikehendaki untuk dilihat. |
| **Alternative Flows**  | Jika aktor adalah Pengunjung, maka tidak membutuhkan login. Pengunjung akan langsung diarahkan ke halaman yang berisi Form Daftar Informasi Sub Gedung(frontend)<br>Jika aktor adalah Administrator, Pemilik Gedung, dan Penyewa Gedung, maka harus melakukan login terlebih dahulu untuk masuk pada halaman Daftar Informasi Gedung (backend). </tbody></table>

<h2> <font color='green'> Use Case Name : UC019 Menyewa gedung</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Penyewa Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (Penyewa Gedung)  menyewa gedung dengan menuju halaman informasi Gedung, kemudian sistem akan menampilkan seluruh daftar gedung yang ada. Aktor memilih data / gedung mana yang disewa. Kemudian setelah memilih Gedung, sistem mengarahkan aktor ke daftar sub gedung dari gedung yang dipilih. Sub gedung tersebut dilengkapi dengan status ketersediaan (sudah booked atau available). Untuk menyewa gedung, aktor harus mengisi semua field bertanda bintang  pada Form Penyewaan Baru. Baru kemudian aktor menekan tombol Sewa. Setelah itu sistem akan menampilkan pesan keberhasilan permintaan sewa. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> Jika ada field bertanda bintang yang kosong, maka akan muncul peringatan data tidak lengkap untuk menginstruksikan aktor mengisi semua field. <br>Jika tanggal akhir sewa yang dimasukkan adalah tanggal sebelum tanggal mulai sewa, maka sistem akan menampilkan halaman error yang berisi pesan bahwa "Waktu akhir penyewaan harus setelah waktu awal penyewaan".<br>Jika subgedung sedang disewa oleh penyewa lainnya, maka sistem akan mengarahkan aktor menuju halaman error yang berisi pesan bahwa Sub Gedung sedang disewa oleh penyewa lainnya. </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC020 Melakukan konfirmasi penyewaan</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung) melakukan konfirmasi penyewaan dengan menuju ke halaman manajemen penyewaan dahulu. Sistem memunculkan Form Daftar Permintaan Sewa. Aktor memilih pemrintaan yang akan dikonfirmasi. Untuk menerima permintaan sewa, aktor menekan tombol Terima. Sistem menampilkan pesan bahwa permintaan telah berhasil diterima. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> Jika aktor menolak permintaan sewa, maka aktor menekan tombol Tolak pada daftar pemrintaan sewa. Sistem mengarahkan aktor ke halaman pesan bahwa permintaan sewa berhasil ditolak. </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC021 Membatalkan penyewaan</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (penyewa gedung, administrator) membatalkan penyewaan dengan memilih salah satu daftar penyewaan pada Form Pembatalan Sewa yang terdapat di halaman Manajemen Penyewaan. Selanjutnya aktor menekan tombol Batalkan untuk langsung membatalkan sewa. Kemudian muncul layar konfirmasi apakah aktor benar - benar akan melakukan pembatalan. Aktor harus menekan tombol Yakin. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> -             </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC022 Menghapus histori penyewaan</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Administrator</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (Administrator) memilih penyewaan yang akan dihapus melalui daftar histori penyewaan. Setelah administrator memilih selanjutnya adalah menekan tombol Hapus dan sistem akan menghapus histori tersebut. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> -            </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC023 Melihat histori penyewaan (pemilik gedung)</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung, Administrator</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung, administrator) dapat melihat histori penyewaan dengan menuju ke halaman yang berisi Form Histori Penyewaan (pemilik gedung). Kemudian sistem akan menampilkan histori penyewaan yang pernah dikonfirmasi oleh pemilik gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> -                            </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC024 Melihat histori penyewaan (penyewa gedung)</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Penyewa Gedung, Administrator</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung, administrator) dapat melihat Administrasi yang pernah dilakukan  dengan menuju ke halaman yang berisi Daftar Administrasi Pembayaran Persewaan (Pemilik Gedung). Kemudian sistem akan menampilkan daftar administrasi pembayaran yang pernah dilakukan oleh penyewa gedung pada pemilik gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> -                            </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC025 Mengubah administrasi penyewaan</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung, administrator) menuju halaman yang Manajemen Administrasi. Sistem akan menampilkan Daftar Administrasi. Aktor memilik administrasi yang akan disetujui pembayarannya dengan menekan tombol Terima. Setelah itu sistem akan merubah administrasi penyewaan, yaitu dengan mengubah status pembayaran menjadi "diterima" dan mengurangi sisa pembayaran yang ada pada Daftar Sewa.  Kemudian sistem akan mengarahkan aktor pada halaman pesan bahwa perubahan telah dilakukan (pembayaran telah diterima). </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> Jika ada field bertanda bintang yang kosong, maka akan muncul peringatan data tidak lengkap untuk menginstruksikan aktor mengisi semua field.<br><br>Apabila aktor membatalkan penerimaan, aktor menekan tombol batalkan. Sistem akan mengarahkan aktor pada halaman daftar administrasi. </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC026 Melakukan konfirmasi pembayaran</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Penyewa Gedung</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (penyewa gedung, administrator) memilih salah satu dari Daftar Penyewaan Gedung dimana sudah dibayar melalui bank. Selanjutnya sistem akan mengarahkan aktor menuju form Konfirmasi Pembayaran Sewa Gedung dan mengisi semua field yang ada. Setelah itu, aktor menakan tombol Konfirm dan sistem akan mengirimkannya ke pemilik gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td> Jika ada field bertanda bintang yang kosong, sistem akan emnampilkan pesan eror bahwa field harus diisi lengkap.<br><br>Jika sisa bayar lebih besar daripada jumlah uang yang dibayarkan, sistem akan menampilkan pesan eror bahwa jumlah bayar harus kurang dari sisa bayar.</td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC027 Melihat administrasi penyewaan (pemilik gedung)</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Pemilik Gedung,Administrator</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung, administrator) memilih menu Manajemen Administrasi . Kemudian sistem akan menampilkan daftar administrasi pembayaran yang pernah dilakukan oleh penyewa gedung pada pemilik gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td>-                            </td></tr></tbody></table>

<h2> <font color='green'> Use Case Name : UC028 Melihat administrasi penyewaan (pemilik gedung)</font></h2>
<table><thead><th> <b>Primary Actor</b> </th><th> Penyewa Gedung, Administrator</th></thead><tbody>
<tr><td> <b>Normal Flows</b>  </td><td> Aktor (pemilik gedung, administrator) memilih menu Manajemen Administrasi . Kemudian sistem akan menampilkan daftar administrasi pembayaran yang pernah dilakukan oleh pemilik gedung pada pemilik gedung. </td></tr>
<tr><td> <b>Alternative Flows</b>  </td><td>-                             </td></tr></tbody></table>




