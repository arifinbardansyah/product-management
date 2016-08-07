package commerce.productmanagement.display.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.nlopez.smartadapters.views.BindableFrameLayout;

/**
 * kelas abstrak untuk mapping data dengan view. display di extends untuk memasukkan layout id dari item recycler view
 * proses pada saat binding untuk mapping view dengan data,
 * onViewInflated untuk inisialisasi view
 * @param <E> parameter kelas model
 */
public abstract class Display<E> extends BindableFrameLayout<E> {

    public Display(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void bind(E model) {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemAction(1000);
            }
        });
    }

    @Override
    public void onViewInflated() {
        super.onViewInflated();
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
