package widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by yzs on 2016/10/20.
 */

public class BobyListView extends ListView {
    public BobyListView(Context context) {
        this(context, null);
    }

    public BobyListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BobyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
