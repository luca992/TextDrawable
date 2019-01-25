package com.amulyakhare.textdrawable

import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import androidx.annotation.ColorInt
import androidx.annotation.IntDef

class TextDrawable(
        // The Shape the drawable should take
        @DrawableShape val shape: Int = TextDrawable.DRAWABLE_SHAPE_RECT,
        // The solid fill color of the drawable
        @ColorInt var color: Int = Color.GRAY,
        // The color of the text for the drawable. Will be ignored if an icon is set
        @ColorInt var textColor: Int = Color.WHITE,
        // The corner radius for the drawable. Will be ignored if the shape is not a DRAWABLE_SHAPE_ROUND_RECT
        var cornerRadius: Float = 0F,
        // The text size for the text of the drawable. Will be ignored if an icon is set
        var textSize: Float = 0f,
        // The desired height of the drawable
        var desiredHeight: Int = -1,
        // The desired width of the drawable
        var desiredWidth: Int = -1,
        // The border thickness of the drawable
        var borderThickness: Float = 0F,
        // The typeface to use for the text of the drawable/ Will be ignored if an icon is set
        var typeFace: Typeface = Typeface.DEFAULT,
        // The text to use for the drawable. Will be ignored if an icon is set
        var text: String? = null,
        // The icon to use for the drawable. Will override any text that may have been set
        var icon: Bitmap? = null) : ShapeDrawable(getShapeDrawable(shape, cornerRadius)) {

    companion object {
        private const val SHADE_FACTOR = 0.9f

        const val DRAWABLE_SHAPE_RECT = 0

        const val DRAWABLE_SHAPE_ROUND_RECT = 1

        const val DRAWABLE_SHAPE_OVAL = 2

        private fun getShapeDrawable(@DrawableShape shape: Int, cornerRadius: Float): Shape {
            return when (shape) {
                DRAWABLE_SHAPE_ROUND_RECT -> {
                    val radii = floatArrayOf(cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius)
                    RoundRectShape(radii, null, null)
                }

                DRAWABLE_SHAPE_OVAL -> OvalShape()

                else -> RectShape()
            }
        }
    }

    @Retention(AnnotationRetention.SOURCE)
    @IntDef(DRAWABLE_SHAPE_RECT, DRAWABLE_SHAPE_ROUND_RECT, DRAWABLE_SHAPE_OVAL)
    annotation class DrawableShape

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val borderPaint = Paint()

    init {
        // text paint settings
        text?.takeIf { !it.isBlank() }?.apply {
            textPaint.color = textColor
            textPaint.style = Paint.Style.FILL
            textPaint.typeface = typeFace
            textPaint.textAlign = Paint.Align.CENTER
            textPaint.strokeWidth = borderThickness
        }

        // border paint settings
        borderPaint.color = getDarkerShade(color)
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderThickness

        // drawable paint color
        paint.color = color
    }

    override fun onDraw(shape: Shape, canvas: Canvas, paint: Paint) {
        super.onDraw(shape, canvas, paint)

        val r = bounds


        // draw border
        if (borderThickness > 0F) {
            drawBorder(canvas)
        }

        val count = canvas.save()
        if (icon == null) {
            canvas.translate(r.left.toFloat(), r.top.toFloat())
        }

        // draw text
        val width = if (desiredWidth <= 0) r.width() else desiredWidth
        val height = if (desiredHeight <= 0) r.height() else desiredHeight
        val fontSize = if (textSize <= 0) (Math.min(width, height) / 2).toFloat() else textSize

        icon?.let {
            canvas.drawBitmap(it, ((width - it.width) / 2).toFloat(), ((height - it.height) / 2).toFloat(), null)
        }

        text?.takeIf { !it.isBlank() }?.apply {
            textPaint.textSize = fontSize
            canvas.drawText(this, (width / 2).toFloat(), height / 2 - (textPaint.descent() + textPaint.ascent()) / 2, textPaint)

        }

        canvas.restoreToCount(count)
    }

    override fun setAlpha(alpha: Int) {
        textPaint.alpha = alpha
    }

    override fun setColorFilter(cf: ColorFilter?) {
        textPaint.colorFilter = cf
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun getIntrinsicWidth(): Int {
        return desiredWidth
    }

    override fun getIntrinsicHeight(): Int {
        return desiredHeight
    }

    /**
     * Converts the [TextDrawable] to a [Bitmap]
     *
     * @return
     */
    fun toBitmap(): Bitmap {
        val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        setBounds(0, 0, canvas.width, canvas.height)
        draw(canvas)
        return bitmap
    }

    private fun drawBorder(canvas: Canvas) {
        val rect = RectF(bounds)
        val inset = borderThickness / 2f
        rect.inset(inset, inset)

        when (shape) {
            DRAWABLE_SHAPE_ROUND_RECT -> canvas.drawRoundRect(rect, cornerRadius, cornerRadius, borderPaint)

            DRAWABLE_SHAPE_OVAL -> canvas.drawOval(rect, borderPaint)

            else -> canvas.drawRect(rect, borderPaint)
        }
    }

    private fun getDarkerShade(color: Int): Int {
        return Color.rgb((SHADE_FACTOR * Color.red(color)).toInt(),
                (SHADE_FACTOR * Color.green(color)).toInt(),
                (SHADE_FACTOR * Color.blue(color)).toInt())
    }
}