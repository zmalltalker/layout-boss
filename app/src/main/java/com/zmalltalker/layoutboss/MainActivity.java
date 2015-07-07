package com.zmalltalker.layoutboss;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            TextView displayMetricsText = (TextView) getActivity().findViewById(R.id.display_metrics);
            DisplayMetrics metrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
            String metricsText = "The display is " + metrics.widthPixels + " px wide and " + metrics.heightPixels + " px tall. The DPI is "+
                    metrics.densityDpi + ", which means each dp equals " + metrics.density + "px";

            displayMetricsText.setText(metricsText);

            insertPixelSizeForText(R.id.text_12dp);
            insertPixelSizeForText(R.id.text_14dp);
            insertPixelSizeForText(R.id.text_16dp);
            insertPixelSizeForText(R.id.text_18dp);
            insertPixelSizeForText(R.id.text_21dp);
            insertPixelSizeForText(R.id.text_30dp);
            insertPixelSizeForText(R.id.text_40dp);
            insertPixelSizeForText(R.id.text_50dp);
//            TextView twentyOne = (TextView) getActivity().findViewById(R.id.text_21dp);
//            float widthInPixels = twentyOne.getTextSize();
//            twentyOne.setText(twentyOne.getText() + " (" + widthInPixels + " px)");

            TextView pixelsPerDip = (TextView) getActivity().findViewById(R.id.pixels_per_dip);
            pixelsPerDip.setText("1dp equals " + metrics.density + "px");

            TextView screenDimensions = (TextView) getActivity().findViewById(R.id.screen_dimensions);
            screenDimensions.setText("The screen is " + metrics.widthPixels/metrics.density + " dp wide and " + metrics.heightPixels/metrics.density + " dp tall");

            View fullWidth = getActivity().findViewById(R.id.full_width);
            TextView fullWidthText = (TextView) getActivity().findViewById(R.id.full_width_text);
            fullWidthText.setText(metrics.widthPixels + " pixels / " + metrics.widthPixels/metrics.density + " dp wide");
        }
        private void insertPixelSizeForText(int textViewId){
            TextView textView = (TextView) getActivity().findViewById(textViewId);
            float widthInPixels = textView.getTextSize();
            textView.setText(textView.getText() + " (" + widthInPixels + "px)");
        }
    }


}
