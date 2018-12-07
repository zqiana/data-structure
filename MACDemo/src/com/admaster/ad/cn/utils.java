package com.admaster.ad.cn;



public final class utils {
    public static int a(CharSequence charSequence, int i, int i2, int i3) {

//        Log.i("DEMO","查询数据库比对电话号码：" + charSequence);
//        Log.i("DEMO","查询数据库比对电话号码：" + i);
//        Log.i("DEMO","查询数据库比对电话号码：" + i2);
//        Log.i("DEMO","查询数据库比对电话号码：" + i3);

        int charAt;
        int i4 = i + i2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = i3;
        while (i < i4) {
            int i9;
            int i10;
            int i11 = i + 1;
            char charAt2 = charSequence.charAt(i);
            if (charAt2 < '') {
                i9 = charAt2;
                i10 = i11;
                i11 = 8;
            } else if (charAt2 < 'ࠀ') {
                i9 = (((charAt2 & 63) | 128) << 8) | ((charAt2 >> 6) | 192);
                i10 = i11;
                i11 = 16;
            } else if (charAt2 < '?' || charAt2 > '?' || i11 >= i4) {
                i9 = (((charAt2 & 63) | 128) << 16) | (((charAt2 >> 12) | 224) | ((((charAt2 >> 6) & 63) | 128) << 8));
                i10 = i11;
                i11 = 24;
            } else {
                i9 = i11 + 1;
                charAt = (charSequence.charAt(i11) & 1023) + ((charAt2 - 55232) << 10);
                i11 = 32;
                i10 = i9;
                i9 = (((((charAt >> 18) | 240) & 255) | ((((charAt >> 12) & 63) | 128) << 8)) | ((((charAt >> 6) & 63) | 128) << 16)) | (((charAt & 63) | 128) << 24);
            }
            int i12 = i7 | (i9 << i6);
            charAt = i6 + i11;
            int i13;
            if (charAt >= 32) {
                i12 *= -862048943;
                i12 = (((i12 >>> 17) | (i12 << 15)) * 461845907) ^ i8;
                i8 = -430675100 + (((i12 >>> 19) | (i12 << 13)) * 5);
                i12 = charAt - 32;
                i13 = i5 + 4;
                i5 = i12;
                i12 = i12 != 0 ? i9 >>> (i11 - i12) : 0;
                charAt = i13;
            } else {
                i13 = i5;
                i5 = charAt;
                charAt = i13;
            }
            i6 = i5;
            i7 = i12;
            i = i10;
            i5 = charAt;
        }
        if (i6 > 0) {
            i5 += i6 >> 3;
            charAt = -862048943 * i7;
            i8 ^= ((charAt >>> 17) | (charAt << 15)) * 461845907;
        }
        charAt = i8 ^ i5;
        charAt = (charAt ^ (charAt >>> 16)) * -2048144789;
        charAt = (charAt ^ (charAt >>> 13)) * -1028477387;


        return charAt ^ (charAt >>> 16);
    }
}