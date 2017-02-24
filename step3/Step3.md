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

![Berdampingan dengan WebView](Screenshot-3.png)


:-)
