package com.kennyc.textdrawable

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import androidx.annotation.ColorInt

class TextDrawableBuilder(@TextDrawable.DrawableShape
                          private var shape: Int = TextDrawable.DRAWABLE_SHAPE_RECT) {

    constructor(shape: Int = TextDrawable.DRAWABLE_SHAPE_RECT, text: String) : this(shape) {
        this.text = text
    }

    constructor(shape: Int = TextDrawable.DRAWABLE_SHAPE_RECT, icon: Bitmap) : this(shape) {
        this.icon = icon
    }

    private var text: String? = null
    private var color = Color.GRAY
    private var borderThickness = 0f
    private var desiredHeight = -1
    private var desiredWidth = -1
    private var typeFace = Typeface.DEFAULT
    private var textColor = Color.WHITE
    private var textSize = 0f
    private var cornerRadius: Float = 0f
    private var icon: Bitmap? = null
    private var borderColor = color

    /**
     * Sets the width of the drawable
     *
     * @param width
     * @return
     */
    fun setWidth(width: Int): TextDrawableBuilder {
        this.desiredWidth = width
        return this
    }

    /**
     * Sets the height of the drawable
     *
     * @param height
     * @return
     */
    fun setHeight(height: Int): TextDrawableBuilder {
        this.desiredHeight = height
        return this
    }

    /**
     * Sets the text color to be used for the drawable. Will be ignored if [.setIcon] is called
     *
     * @param color
     * @return
     */
    fun setTextColor(@ColorInt color: Int): TextDrawableBuilder {
        this.textColor = color
        return this
    }

    /**
     * Sets the border thickness for the drawable. Defaults to 0
     *
     * @param thickness
     * @return
     */
    fun setBorderThickness(thickness: Float): TextDrawableBuilder {
        this.borderThickness = thickness
        return this
    }

    /**
     * Sets the typeface for the drawable
     *
     * @param tf
     * @return
     */
    fun setTypeface(tf: Typeface): TextDrawableBuilder {
        this.typeFace = tf
        return this
    }

    /**
     * Sets the text size of the drawable. Will be ignored if [.setIcon] is called
     *
     * @param size
     * @return
     */
    fun setTextSize(size: Float): TextDrawableBuilder {
        this.textSize = size
        return this
    }

    /**
     * Sets the [com.kennyc.textdrawable.TextDrawable.DrawableShape] to be used for the drawable
     *
     * @param shape
     * @return
     */
    fun setShape(@TextDrawable.DrawableShape shape: Int): TextDrawableBuilder {
        this.shape = shape
        return this
    }

    /**
     * Sets the corner radius for the drawable. Will be ignored unless the [com.kennyc.textdrawable.TextDrawable.DrawableShape] is
     * SHAPE_ROUND_RECT
     *
     * @param cornerRadius
     * @return
     */
    fun setCornerRadius(cornerRadius: Float): TextDrawableBuilder {
        this.cornerRadius = cornerRadius
        return this
    }

    /**
     * Sets the icon to be used for the drawable
     *
     * @param bitmap
     * @return
     */
    fun setIcon(bitmap: Bitmap): TextDrawableBuilder {
        this.text = null
        this.icon = bitmap
        return this
    }

    /**
     * Sets the text to be used for the drawable.
     *
     * @param text
     * @return
     */
    fun setText(text: String): TextDrawableBuilder {
        this.icon = null
        this.text = text
        return this
    }

    /**
     * Sets the color of the drawable
     *
     * @param color
     * @return
     */
    fun setColor(@ColorInt color: Int): TextDrawableBuilder {
        this.color = color
        return this
    }

    /**
     * Sets the color of the border
     * @param color
     * @return
     */
    fun setBorderColor(@ColorInt color: Int): TextDrawableBuilder {
        this.borderColor = color
        return this
    }

    /**
     * Returns the [TextDrawable]
     *
     * @return
     */
    fun build(): TextDrawable {
        return TextDrawable(shape = shape,
                color = color,
                textColor = textColor,
                cornerRadius = cornerRadius,
                textSize = textSize,
                desiredHeight = desiredHeight,
                desiredWidth = desiredWidth,
                borderThickness = borderThickness,
                borderColor = borderColor,
                typeFace = typeFace,
                text = text,
                icon = icon)
    }
}