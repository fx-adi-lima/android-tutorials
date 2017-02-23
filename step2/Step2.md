# Prolog
Branch ini menggunakan Step1 sebagai base, tetapi tentunya memiliki implementasinya sendiri.
Dalam hal ini kita awalnya menggunakan LinearLayout sebagai container untuk semua control yang ada (dalam hal ini hanya sebuah TextView).
Bagian yang diganti dari Step1 adalah sbb:      
     1. AndroidManifest.xml     
     Ubah pada tag **package** step1 -> step2      
     Dan semua yang mengandung **step1** menjadi **step2**.     
     2. Build.sh            
     Ubah semua yang mengandung referensi ke step1 menjadi step2.     
     3. Main.java     
     Hampir semuanya baru, penjelasan dan detilnya digambarkan di bawah ini.
     
## Main.java
Kita membuat sebuah LinearLayout berorientasi **vertical** menjadi container bagi semua control yang akan dibuat dalam aplikasi ini.
Sebagai contoh dalam hal ini kita hanya menggunakan TextView, yang dibuat secara programatis dalam sebuah **for** loop.
```java
TextView tv = null;
for (int i = 0; i < 10; i++) {
    tv = new TextView(this);
    tv.setTextSize(20); // atau seberapa besar text yang diinginkan
    tv.setText("TextView nomor " + i + " dalam LinearLayout");
    ll.addView(tv);
}
```
Untuk membuat sebuah LinearLayout sendiri cukup sederhana, hanya diperlukan sebuah argumen, yaitu _context_ 
yang bertanggungjawab sebagai *controller* nya, dalam hal ini adalah *Activity* yang sedang aktif.     
```java
LinearLayout ll = new LinearLayout(this);
ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
ll.setOrientation(LinearLayout.VERTICAL);
setContentView(ll);
```
Saya rasa patut disinggung bahwa **import** statement untuk mendapatkan LayoutParams yang tepat bagi LinearLayout bisa jadi
bermasalah, karena masing-masing **class** keturunan **ViewGroup** memiliki LayoutParams yang khusus bagi diri mereka sendiri,
dalam hal ini selengkapnya adalah sbb:   
```java
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
```
Sampai di sini aplikasi seharusnya bisa dibuat dengan cara memanggil **build.sh** dari folder yang menjadi _project root_.
     Selengkapnya bisa dilihat dari directory tree branch ini sendiri, Anda bisa mengunduh source tree dalam bentuk zip, atau
     melakukan cloning dari source tree ini selengkapnya.

Semoga bermanfaat.
