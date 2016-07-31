package commerce.productmanagement.utility;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by adamm on 7/15/2016.
 */
public class ImageLoader {
    Context context;
    String url;
    ImageView imageView;
    Drawable errorDrawable;
    Drawable placeholderDrawable;

    public void load(Context context, String url, ImageView imageView, Drawable errorDrawable, Drawable placeholderDrawable) {
        this.context = context;
        this.url = url;
        this.imageView = imageView;
        this.errorDrawable = errorDrawable;
        this.placeholderDrawable = placeholderDrawable;

        Picasso.with(context).load(url).placeholder(placeholderDrawable).error(errorDrawable).into(imageView);
    }

    public void load(Context context, String url, ImageView imageView) {
        this.context = context;
        this.url = url;
        this.imageView = imageView;

        Picasso.with(context).load(url).into(imageView);
    }
}
