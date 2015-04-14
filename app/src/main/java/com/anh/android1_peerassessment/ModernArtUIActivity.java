package com.anh.android1_peerassessment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import static android.widget.SeekBar.OnSeekBarChangeListener;


public class ModernArtUIActivity extends ActionBarActivity {

    private OnSeekBarChangeListener seekBarChangeListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            float[] oneOneHsv = new float[3];
            float[] oneTwoHsv = new float[3];
            float[] oneThreeHsv = new float[3];
            float[] twoOneHsv = new float[3];
            float[] twoTwoHsv = new float[3];
            float[] threeOneHsv = new float[3];
            float[] threeTwoHsv = new float[3];

            // Transform colors value from int to hsv format
            Color.colorToHSV(oneOneColor, oneOneHsv);
            Color.colorToHSV(oneTwoColor, oneTwoHsv);
            Color.colorToHSV(oneThreeColor, oneThreeHsv);
            Color.colorToHSV(twoOneColor, twoOneHsv);
            Color.colorToHSV(twoTwoColor, twoTwoHsv);
            Color.colorToHSV(threeOneColor, threeOneHsv);
            Color.colorToHSV(threeTwoColor, threeTwoHsv);

            // Calculate changes
            oneOneHsv[0] = (oneOneHsv[0] + progress) % 360;
            oneTwoHsv[0] = (oneTwoHsv[0] + progress) % 360;
            oneThreeHsv[0] =(oneThreeHsv[0] + progress) % 360;
            twoOneHsv[0] = (twoOneHsv[0] + progress) % 360;
            twoTwoHsv[0] = (twoTwoHsv[0] + progress) % 360;
            threeOneHsv[0] =(threeOneHsv[0] + progress) % 360;
            threeTwoHsv[0] =(threeTwoHsv[0] + progress) % 360;

            // Set new Colors
            vOneOne.setBackgroundColor(Color.HSVToColor(oneOneHsv));
            vOneTwo.setBackgroundColor(Color.HSVToColor(oneTwoHsv));
            vOneThree.setBackgroundColor(Color.HSVToColor(oneThreeHsv));
            vTwoOne.setBackgroundColor(Color.HSVToColor(twoOneHsv));
            vTwoTwo.setBackgroundColor(Color.HSVToColor(twoTwoHsv));
            vThreeOne.setBackgroundColor(Color.HSVToColor(threeOneHsv));
            vThreeTwo.setBackgroundColor(Color.HSVToColor(threeTwoHsv));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private SeekBar seekBar;
    private View vOneOne;
    private View vOneTwo;
    private View vOneThree;
    private View vTwoOne;
    private View vTwoTwo;
    private View vThreeOne;
    private View vThreeTwo;

    private int oneOneColor;
    private int oneTwoColor;
    private int oneThreeColor;
    private int twoOneColor;
    private int twoTwoColor;
    private int threeOneColor;
    private int threeTwoColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modern_art_ui);

        // Init Views
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        vOneOne = findViewById(R.id.vOneOne);
        vOneTwo = findViewById(R.id.vOneTwo);
        vOneThree = findViewById(R.id.vOneThree);
        vTwoOne = findViewById(R.id.vTwoOne);
        vTwoTwo = findViewById(R.id.vTwoTwo);
        vThreeOne = findViewById(R.id.vThreeOne);
        vThreeTwo = findViewById(R.id.vThreeTwo);

        // Set Event to Views
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        // Get original Colors in Integer
        oneOneColor = ((ColorDrawable) vOneOne.getBackground()).getColor();
        oneTwoColor = ((ColorDrawable) vOneTwo.getBackground()).getColor();
        oneThreeColor = ((ColorDrawable) vOneThree.getBackground()).getColor();
        twoOneColor = ((ColorDrawable) vTwoOne.getBackground()).getColor();
        twoTwoColor = ((ColorDrawable) vTwoTwo.getBackground()).getColor();
        threeOneColor = ((ColorDrawable) vThreeOne.getBackground()).getColor();
        threeTwoColor = ((ColorDrawable) vThreeTwo.getBackground()).getColor();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modern_art_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
