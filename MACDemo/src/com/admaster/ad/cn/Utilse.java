package com.admaster.ad.cn;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Utilse {
    private int[] a;
    private int b = 0;
    private int c = 0;

    public Utilse(byte[] bArr) {
        if (bArr.length < 5 || bArr.length >= 256) {
            System.out.println("Key length has to be between 5 and 255");
        }
        this.a = c(bArr);
    }

    private void a(int i, int i2, int[] iArr) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static byte[] Aesa(String str, byte[] bArr, int i) {

        try {
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i, 128)).getEncoded();

        }catch (Exception e){
            return null;
        }
    }

    private int[] c(byte[] bArr) {
        int i;
        int i2 = 0;
        int[] iArr = new int[256];
        for (i = 0; i < 256; i++) {
            iArr[i] = i;
        }
        i = 0;
        while (i2 < 256) {
            i = (((i + iArr[i2]) + bArr[i2 % bArr.length]) + 256) % 256;
            a(i2, i, iArr);
            i2++;
        }
        return iArr;
    }

    public byte[] a(byte[] bArr) {
        return b(bArr);
    }

    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
//        Log.i("DEMO","初始化数据库AAA：" + bArr.length);

        for (int i = 0; i < bArr.length; i++) {
            this.b = (this.b + 1) % 256;
            this.c = (this.c + this.a[this.b]) % 256;
            a(this.b, this.c, this.a);
            bArr2[i] = (byte) (this.a[(this.a[this.b] + this.a[this.c]) % 256] ^ bArr[i]);
//            Log.i("DEMO","初始化数据库：" + bArr2[i] +"位置:" +i );

//            if(i%4 == 0){
//
//            }

        }
        return bArr2;
    }

    public static int byteArrayToInt(byte[] byteArray) {
        int n = 0;
        try {
            ByteArrayInputStream byteInput = new ByteArrayInputStream(byteArray);
            DataInputStream dataInput = new DataInputStream(byteInput);
            n = dataInput.readInt();
            System.out.println("整数为： " + n);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }
}