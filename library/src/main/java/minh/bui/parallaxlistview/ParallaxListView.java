package minh.bui.parallaxlistview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by minhbui on 22/04/15.
 */
public class ParallaxListView extends ListView implements AbsListView.OnScrollListener {

    private static final String TAG = ParallaxListView.class.getSimpleName();

    private OnScrollListener mScrollListener;
    private View mParallaxView;

    public ParallaxListView(Context context) {
        super(context);
        init();
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        super.setOnScrollListener(this);
    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {
        this.mScrollListener = l;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(mScrollListener != null)
            mScrollListener.onScrollStateChanged(view, scrollState);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        parallaxScroll();
        if(mScrollListener != null) {
            mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    public void addParallaxHeader(View view) {
        this.mParallaxView = view;
        addHeaderView(view);
    }

    private void parallaxScroll() {
        if(mParallaxView != null && getChildCount() > 0) {
            int top = -mParallaxView.getTop();
            if(top >= 0) {
                float offset = top / 2f;
                if(Build.VERSION.SDK_INT >= 11) {
                    doParallax(offset);
                } else {
                    doParallaxPreICS(offset);
                }
            }

        }
    }

    @SuppressWarnings("NewApi")
    private synchronized void doParallax(float offset) {
        mParallaxView.setTranslationY(offset);
    }

    private synchronized void doParallaxPreICS(float offset) {
        Animation animation = new TranslateAnimation(0, 0, offset, offset);
        animation.setDuration(0);
        animation.setFillAfter(true);
        mParallaxView.setAnimation(animation);
        animation.start();
    }

}
