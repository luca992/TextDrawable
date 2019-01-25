package com.kennyc.open.sample_kotlin

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kennyc.textdrawable.TextDrawable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv1: TextView = findViewById(R.id.test1)
        val tv2: TextView = findViewById(R.id.test2)
        val tv3: TextView = findViewById(R.id.test3)
        val tv4: TextView = findViewById(R.id.test4)
        val tv5: TextView = findViewById(R.id.test5)
        val tv6: TextView = findViewById(R.id.test6)

        val d1 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_OVAL,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.BLUE,
                textColor = Color.RED,
                text = "A")

        tv1.setCompoundDrawablesWithIntrinsicBounds(d1, null, null, null)

        val d2 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_OVAL,
                desiredWidth = 250,
                desiredHeight = 250,
                color = Color.RED,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))

        tv2.setCompoundDrawablesWithIntrinsicBounds(d2, null, null, null)

        val d3 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_RECT,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.GREEN,
                text = "A")

        tv3.setCompoundDrawablesWithIntrinsicBounds(d3, null, null, null)

        val d4 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_RECT,
                desiredWidth = 250,
                desiredHeight = 250,
                color = Color.YELLOW,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))

        tv4.setCompoundDrawablesWithIntrinsicBounds(d4, null, null, null)

        val d5 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_ROUND_RECT,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.MAGENTA,
                cornerRadius = 50f,
                text = "A")

        tv5.setCompoundDrawablesWithIntrinsicBounds(d5, null, null, null)

        val d6 = TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_ROUND_RECT,
                desiredWidth = 250,
                desiredHeight = 250,
                color = Color.LTGRAY,
                cornerRadius = 50f,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))

        tv6.setCompoundDrawablesWithIntrinsicBounds(d6, null, null, null)
    }
}
