package com.kennyc.sample;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.TextDrawableBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1 = findViewById(R.id.test1);
        TextView tv2 = findViewById(R.id.test2);
        TextView tv3 = findViewById(R.id.test3);
        TextView tv4 = findViewById(R.id.test4);

        Drawable d1 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_OVAL,"A")
                .setHeight(250)
                .setWidth(250)
                .setColor(Color.BLUE)
                .build();

        tv1.setCompoundDrawablesWithIntrinsicBounds(d1, null, null, null);

        Drawable d2 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_OVAL)
                .setHeight(250)
                .setWidth(250)
                .setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .build();

        tv2.setCompoundDrawablesWithIntrinsicBounds(d2, null, null, null);

        Drawable d3 = new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_RECT,"A")
                .setHeight(250)
                .setWidth(250)
                .build();

        tv3.setCompoundDrawablesWithIntrinsicBounds(d3, null, null, null);

        Drawable d4 =
                new TextDrawableBuilder(TextDrawable.DRAWABLE_SHAPE_RECT)
                        .setHeight(250)
                        .setWidth(250)
                        .setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .build();

        tv4.setCompoundDrawablesWithIntrinsicBounds(d4, null, null, null);
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
