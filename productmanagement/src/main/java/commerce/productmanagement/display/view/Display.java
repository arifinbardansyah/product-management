package commerce.productmanagement.display.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.nlopez.smartadapters.views.BindableFrameLayout;

/**
 * Created by adamm on 7/30/2016.
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
    public void bind(E e) {
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
