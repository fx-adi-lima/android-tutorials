# android-tutorials
Tutorials for creating android apps from within android-x86

# WebView Plus Editor
Tujuan utama dari branch ini adalah memanfaatkan kelengkapan WebView sebagai alat interaksi dengan user, terutama sekali karena dengan menggunakan WebView
kita dengan mudah bisa mengubah-ubah <i>User Interface</i> tanpa harus melakukan kompilasi ulang program.

Kalau diperhatikan struktur direktori yang ada di sini, ada sebuah tambahan, yakni **assets**, yang kalau dibuka isinya adalah sejumlah file seperti yang ada
dalam sebuah WebSite. Direktori ini nantinya akan dimasukkan secara lengkap ke dalam APK kita, dan akan diinstall ke dalam perangkat pengguna pada saat instalasi.

File-file di dalamnya bisa kita akses melalui URL **file:///android_asset/<nama_direktori>/nama_file**

Kalau ingin menyimpan dan menampilkan  halaman-halaman web yang kita buat, sebaiknya disimpan di dalam direktori  yang akan mengikuti nama **package** yang 
kita cantumkan di dalam **AndroidManifest.xml**. Misalnya saja, nama package kita adalah hu.pe.xaverius2017.tutorials.step3, maka kita bisa mencarinya dengan File Manager
di dalam direktori /data/data/hu.pe.xaverius2017.tutorials.step3/.

Biasanya di dalam situ selalu ada folder bernama 'files', tempatkan semua berkas yang Anda buat di situ, dan pasti akan bisa diakses oleh aplikasi kita.
