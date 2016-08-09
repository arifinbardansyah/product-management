# product-management
library ini berfungsi untuk mengambil data dari API dan menampilkan data kedalam tampilan recyclerview. terdapat fitur searching filter dan sorting untuk data yg disimpan kedalam database oleh library ini juga image loader untuk manampilkan image yg terdapat pada url. untuk menampilkan data menjadi tampilan kedalam recyclerview programmer cukup membuat model dan view yg dibutuhkan oleh library ini.

Instalasi
---------
Untuk menggunakan library ini lakukan instalasi pada build.gradle(project) dengan menambahkan:
```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "io.realm:realm-gradle-plugin:1.1.0"
    }
}
```
Setelah itu tambahkan plugin pada build.gradle(app) dengan:
```
apply plugin: 'realm-android'
```
Juga tambahkan project management library di dependencies
```
compile 'commerce.productmanagement:productmanagement:1.1.6'
```

Configuring
-----------
Untuk dapat menggunakan database local yang disediakan realm beri lakukan configurasi pada aplikasi dengan menambahkan property pada manifest
```
android:name="commerce.productmanagement.utility.BaseApplication"
```

Model
-----
Data yang akan disimpan pada database membutuhkan model untuk mapping dengan data dan membuat schema, pada kelas model dibutuhkan extend RealmModel agar data tersimpat dan dapat di query, berikut contoh kelas model:
```
public class Produk extends RealmObject {
    @PrimaryKey
    String _id;
    String product;
    String brand;
    float rating;
    int jumlah_review;
    double harga;
    int diskon;
    double harga_diskon;
    String deskripsi;
    String detail;
    String spesifikasi;
    String image;
    String category;
    
    //getter dan setter
}
```

Using Product Management Library
--------------------------------
Controller pada library product management dapat berfungsi sebagai mangambil data dari APIdengan menggunakan method Get atau Post dan menampilkan data kedalam bentuk recycler view, mengambil data dari api datap dilakukan dengan membuat object dari kelas controller dan memanggil method getData atau postData, method ini akan memberikan return berupa List dari model yang diambil dari API, berikut cara penggunaan method getData dan postData:
```
Controller controller = new Controller();
try {
//getData method
    List<Produk> produks = controller.getData(yourUrl,Model.class);
            
//postData method
    List<Child> children = controller.postData(yourUrl,paremeter,value, Model.class);
} catch (ExecutionException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
    e.printStackTrace();
}
```
Pada method getData dibutuhkan parameter get API dan class Model, sedangkan pada method postData terdapat parameter tambahan sebagai parameter post dan value post.
Untuk method displayData dibutuhkan view RecycleView yang tambahkan pada layout activity, lalu inisialisasi pada activity.java, setelah itu buat layout untuk item yang akan diisi oleh data, buat juga View yang di extend Display<E> untuk inisialisasi view dan mapping view dengan data, berikut contoh kelas View:
```
public class CategoryView extends Display<Category> {
    TextView textView;

    public CategoryView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.template_category_view;
    }

    @Override
    public void bind(Category category) {
        super.bind(category);
        textView.setText(category.getCategory());
    }

    @Override
    public void onViewInflated() {
        super.onViewInflated();
        textView = (TextView) findViewById(R.id.template_category_text);
    }
}
```
Inisialisasi view dilakukan pada method onViewInflated(), lalu masukkan id layout item yang dibuat pada method getLayoutId(). Method bind() digunakan untuk mapping view dengan data yang diambil.
Untuk menampilkan data dengan menggunakan method displayData dari kelas Controller dibutuhkan parameter. Berikut contoh penggunaak method displayData:
```
controller.displayData(context, listProduct, Product.class, ProductView.class, recyclerView, new ViewEventListener() {
    @Override
    public void onViewEvent(int i, Object o, int i1, View view) {}});
```
Parameter yang dibutuhkan pada method ini adalah context, data berupa List, kelas model, kelas view yang tadi dibuat, recycler view pada layout activity, dan ViewEventListener() untuk aksi ketika item di click.

Image Loader
------------
Library ini terdapat fungsi untuk memuat gambar dari url dan menampilkannya. untuk penggunaannya dapat dilihat dibawah ini:
```
ImageLoader imageLoader = new ImageLoader();
imageLoader.load(context,model.getImage(),imageView);
```

Creating Object, Write, and Transaction
---------------------------------------
Library ini mendukung penyimpanan data dalam database. Untuk penggunaan fungsi buat objek dan penulisan kedalam database selengkapnya ada pada dokumentasi realm pada creating object, write, dan transaction.

Search, Filter, dan Sort
------------------------
Untuk Search dibutuhkan list yang telah terisi data dan tersimpan di database. Fungsi Search membutuhkan inisialisasi realm, kelas model, parameter, dan value search. Method searching akan mereturnkan RealmResults dari kelas model. Berikut penggunaan Search:
```
Search search = new Search();
RealmResults<Produkh> realmResults1 = search.searchingOR(realm, Produkh.class, "product", value );
```
Untuk Filter dibutuhkan list yang telah terisi dan tersimpan di database. Fungsi Filter membutuhkan inisialisasi realm, kelas model, parameter, dan value filter. Method filterOR, filterAND, dan filterBetween akan mereturnkan RealmResults dari kelas model. Berikut penggunaan Filter:
```
Filter filter = new Filter();
RealmResults<Produkh> realmResults = filter.filterOR(realm,Produkh.class,"category",child);

Filter filter = new Filter();
RealmResults<Produkh> realmResults = filter.filterAND(realm,Produkh.class,"category",child);

Filter filter = new Filter();
RealmResults<Produkh> realmResults = filter.filterBetween(realm,Produkh.class,"harga",from,to);
```
Untuk Sort dibutuhkan list RealmResults dari kelas model. Fungsi Sort membutuhkan inisialisasi RealmResults, kelas model, parameter, dan ascending atau descending. Method Sort akan mereturnkan RealmResults dari kelas model. Berikut penggunaan Sort:
```
Sort sort = new Sort();
RealmResults<Produkh> realmResults2 = sort.sorting(realmResults,Produkh.class,"brand",true);
```

This Library include
Gson
Okhttp3
SmartAdapters
Picasso
Realm
