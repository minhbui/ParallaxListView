package minh.bui.parallaxlistviewdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import minh.bui.parallaxlistview.ParallaxListView;

/**
 * Created by minhbui on 22/04/15.
 */
public class DemoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ParallaxListView parallaxListView = (ParallaxListView) findViewById(R.id.parallaxListView);

        View header = getLayoutInflater().inflate(R.layout.parallax_header, null);
        parallaxListView.addParallaxHeader(header);

        DemoAdapter adapter = new DemoAdapter(this);
        parallaxListView.setAdapter(adapter);
    }

}
