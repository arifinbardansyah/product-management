package commerce.productmanagement.utility;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * kelas untuk menampilkan gambar yg bersumber dari url
 */
public class ImageLoader {
    /**
     * method untuk menampilkan gambar dari url
     * @param context parameter context dari activity
     * @param url url alamat gambar yg akan ditampilkan
     * @param imageView View imageview yg akan diisi oleh gambar
     * @param errorDrawable drawable pada saat gambar gagal di tampilkan
     * @param placeholderDrawable drawable pada saat gambar sedang dimuat
     */
    public void load(Context context, String url, ImageView imageView, Drawable errorDrawable, Drawable placeholderDrawable) {
        Picasso.with(context).load(url).placeholder(placeholderDrawable).error(errorDrawable).into(imageView);
    }

    /**
     * method untuk menampilkan gambar dari url
     * @param context parameter context dari activity
     * @param url url alamat gambar yg akan ditampilkan
     * @param imageView View imageview yg akan diisi oleh gambar
     */
    public void load(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).into(imageView);
    }
}
