# Step3

Bereksperimen sedikit dengan menambahkan sebuah EditText di sebelah kanan.

![Berdampingan dengan EditText](Screenshot-2.png)

Saya sedang membayangkan kalau yang di sebelah kanan itu adalah sebuah HTML, 
dan yang sebelah kiri adalah sebuah **Text Editor** yang sedang kita pakai untuk membuatnya, 
kelihatannya seperti ide yang baik.

Caranya gampang sekali, dengan mengubah _redundant loop_ yang membuat sejumlah TextView untuk sekedar demo itu
menjadi inisialisasi EditText, seperti yang di bagian bawah Main.java
```java
EditText et = new EditText(this);

// Dalam hal ini kita memaksakan bahwa EditText ini akan menempati 50% dari total lebar dari PARENT
// yang dalam hal ini adalah _root_ layout.
et.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0.5f));

// Kalau berikut ini tidak kita tambahkan, maka cursor akan ditempatkan di tengah-tengah text box,
// dan penampilannya akan lucu-lucu menjengkelkan.
et.setGravity(Gravity.TOP);

// setelah ini barulah kita menempatkan WebView, di bagian kanan layar
```

Implementasinya kurang lebih seperti gambar berikut:

![Berdampingan dengan WebView](Screenshot_20170224-190902.png)

Saya rasa sekarang saatnya mengupload sebuah _release_ untuk branch ini, supaya Anda maupun saya bisa mengevaluasi
hasilnya. Karena kita mengijinkan JavaScript melalui WebSettings dengan setJavaScriptEnabled(true), maka sekaligus tombol
**Button Test** di atas saya buat untuk contoh bahwa JavaScript berfungsi dengan baik dari dalam WebView.

Aplikasi tersebut, dalam tahap sekarang ini, hanya akan tampil dengan baik kalau kita menggunakan sebuah komputer (atau mungkin sebuah tablet),
dan kalau ditampilkan oleh sebuah ponsel panel di sebelah kanan tidak akan terlihat.

Hal ini karena desain kita tidak memperhatikan apa yang dinamakan **Responsive Design**.

Secara keseluruhan kita harus mengubah strategi layout kalau ingin mendukung pemakaian aplikasi ini dengan sebuah ponsel, dan kelihatannya
yang paling sederhana adalah menempatkan WebView dalam sebuah LinearLayout yang berorientasi VERTICAL, bersama dengan semua **View**
pendukungnya, termasuk, misalnya saja, **Back atau Home Button**, dengan demikian seandainya aplikasi kita sedang berada di dalam perangkat yang memiliki layar 
relatif kecil, tidak ada komponen yang tersembunyi.     

Tambahan lagi, sebaiknya kita juga meniadakan nilai-nilai absolut, seperti 500, yang saya gunakan di sini untuk menyederhanakan ilustrasi.

![WebView di sebelah kiri, dengan nlebar absolut 500 pixel](Screenshot_20170225-083642.png)

