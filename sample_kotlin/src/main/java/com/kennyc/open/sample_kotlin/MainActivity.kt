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

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_OVAL,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.BLUE,
                textColor = Color.RED,
                text = "A")
                .apply { tv1.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_OVAL,
                desiredWidth = 250,
                desiredHeight = 250,
                borderColor = Color.GREEN,
                borderThickness = 20f,
                color = Color.RED,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))
                .apply { tv2.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_RECT,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.GREEN,
                text = "A")
                .apply { tv3.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_RECT,
                desiredWidth = 250,
                desiredHeight = 250,
                color = Color.YELLOW,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))
                .apply { tv4.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_ROUND_RECT,
                desiredHeight = 250,
                desiredWidth = 250,
                color = Color.MAGENTA,
                cornerRadius = 50f,
                text = "A")
                .apply { tv5.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }

        TextDrawable(shape = TextDrawable.DRAWABLE_SHAPE_ROUND_RECT,
                desiredWidth = 250,
                desiredHeight = 250,
                color = Color.LTGRAY,
                cornerRadius = 50f,
                icon = BitmapFactory.decodeResource(resources, R.drawable.ic_action_smiley))
                .apply { tv6.setCompoundDrawablesWithIntrinsicBounds(this, null, null, null) }
    }
}