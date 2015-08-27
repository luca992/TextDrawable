package com.amulyakhare.textdrawable;

import java.util.Random;

/**
 * @author amulya
 * @datetime 14 Oct 2014, 5:20 PM
 */
public class MaterialColor {

    private static final int[] sColors = new int[]{
            0xffe57373,
            0xfff06292,
            0xffba68c8,
            0xff9575cd,
            0xff7986cb,
            0xff64b5f6,
            0xff4fc3f7,
            0xff4dd0e1,
            0xff4db6ac,
            0xff81c784,
            0xffaed581,
            0xffff8a65,
            0xffd4e157,
            0xffffd54f,
            0xffffb74d,
            0xffa1887f,
            0xff90a4ae
    };

    private static final Random sRandom = new Random(System.currentTimeMillis());

    public static int getRandomColor() {
        return sColors[sRandom.nextInt(sColors.length)];
    }

    public static int getColor(Object key) {
        return sColors[Math.abs(key.hashCode()) % sColors.length];
    }
}
