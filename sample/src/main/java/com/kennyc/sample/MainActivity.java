package com.kennyc.sample;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kennyc.textdrawable.TextDrawable;
import com.kennyc.textdrawable.TextDrawableBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.test1);
        TextView tv2 = findViewById(R.id.test2);
        TextView tv3 = findViewById(R.id.test3);
        TextView tv4 = findViewById(R.id.test4);
        TextView tv5 = findViewById(R.id.test5);
        TextView tv6 = findViewById(R.id.test6);

        Drawable d1 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_OVAL, "A")
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.BLUE)
                .setTextColor(Color.RED)
                .build();

        tv1.setCompoundDrawablesWithIntrinsicBounds(d1, null, null, null);

        Drawable d2 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_OVAL)
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.RED)
                .setBorderColor(Color.GREEN)
                .setBorderThickness(20f)
                .setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_smiley))
                .build();

        tv2.setCompoundDrawablesWithIntrinsicBounds(d2, null, null, null);

        Drawable d3 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_RECT, "A")
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.GREEN)
                .build();

        tv3.setCompoundDrawablesWithIntrinsicBounds(d3, null, null, null);

        Drawable d4 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_RECT)
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.YELLOW)
                .setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_smiley))
                .build();

        tv4.setCompoundDrawablesWithIntrinsicBounds(d4, null, null, null);

        Drawable d5 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_ROUND_RECT, "A")
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.MAGENTA)
                .setCornerRadius(50f)
                .build();

        tv5.setCompoundDrawablesWithIntrinsicBounds(d5, null, null, null);

        Drawable d6 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_ROUND_RECT)
                .setHeight(250)
                .setWidth(250)
                .setCornerRadius(50f)
                .setColor(Color.LTGRAY)
                .setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_smiley))
                .build();

        tv6.setCompoundDrawablesWithIntrinsicBounds(d6, null, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
