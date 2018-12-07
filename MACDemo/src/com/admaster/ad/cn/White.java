package com.admaster.ad.cn;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class White {
    public static String a = "white_flag";
    private String b;
    private int c;
    private int[] d;
    private int e;
    private byte[] f;

    public White(byte[] bArr, int i) {
//        Log.i("DEMO","解密后每个标签的数组的长度：" + i );

        try {
            byte[] bArr2 = new byte[32];
            System.arraycopy(bArr, i, bArr2, 0, 32);
            int i2 = i + 32;
            bArr2 = a(bArr2);
            if (bArr2 == null) {
                this.b = a;
            } else {
                this.b = new String(bArr2, "utf-8");

                //电话标签写入文件
                createFile("/mnt/sdcard/11111.txt",bArr2);
            }
            byte[] obj = new byte[4];
            System.arraycopy(bArr, i2, obj, 0, 4);
            i2 += 4;
            this.c = a((byte[]) obj, 0);
            obj = new byte[(this.c * 4)];
            System.arraycopy(bArr, i2, obj, 0, this.c * 4);
            i2 += this.c * 4;
            this.d = b((byte[]) obj, this.c);

            obj = new byte[4];
            System.arraycopy(bArr, i2, obj, 0, 4);

            for(int j = 0; j <obj.length; j++){
//                Log.i("DEMO","解密后数组的字节内容：" + byteArrayToInt(obj));
            }
            i2 += 4;
            this.e = a((byte[]) obj, 0);
            this.f = new byte[this.e];
            System.arraycopy(bArr, i2, this.f, 0, this.e);

//            createFile("/mnt/sdcard/aaa.txt",this.f);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int byteArrayToInt(byte[] byteArray) {
        int n = 0;
        try {
            ByteArrayInputStream byteInput = new ByteArrayInputStream(byteArray);
            DataInputStream dataInput = new DataInputStream(byteInput);
            n = dataInput.readInt();
//            n = dataInput.readUnsignedShort();
            System.out.println("整数为： " + n);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    //将byte数组写入文件
    public void createFile(String path, byte[] content) {

        try{
            FileOutputStream fos = new FileOutputStream(path,true);
            fos.write(content);
            fos.write("\r\n".getBytes());
            fos.close();
        }catch (Exception e){

        }


    }
    
    
    
    
    
    
    public static void WriteFile(String path,String content){
    	try {
    		FileOutputStream fileOutputStream = new FileOutputStream(path,true);
    		fileOutputStream.write(content.getBytes());
    		fileOutputStream.flush();
    		fileOutputStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    


    public static int a(byte[] bArr, int i) {
        return (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
    }

    private byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length && bArr[i] != (byte) 0) {
            i++;
        }
        if (i == 0) {
            return null;
        }
        byte[] obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }

    private int[] b(byte[] bArr, int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = a(bArr, i2 * 4);
        }
        return iArr;
    }

    public int a() {
        return (((this.c * 4) + 36) + 4) + this.e;
    }

    //判断电话号码是不是黑名单的函数
    public boolean a(String str) {

//        boolean Flag = checkHash(1733306928);

//        Log.i("DEMO","手机号hash测试：" + Flag);

        for (int i = 0; i < this.c; i++) {
            int a = utils.a(str, 0, str.length(), this.d[i]);
//            Log.i("DEMO","手机号hash" + a);

            long j = (long) a;
            if (a < 0) {
                j = 4294967295L & ((long) a);
            }
            int i2 = (int) (j % ((long) (this.e * 8)));

            //得到手机号的hash值，去库里面进行判断，如果等于0,说明库里没有匹配到手机号
            if (((this.f[i2 / 8] >> (i2 % 8)) & 1) == 0) {
//                Log.i("DEMO","this.f[i2 / 8]" + i2 % 8);
//                Log.i("DEMO","this.f[i2 / 8]XXXX" + f[i2 / 8]);

                return false;
            }
        }
        return true;
    }


    //自定义hash值校验
    public  boolean checkHash(int hashcode){

        long j = (long) hashcode;
        if(hashcode < 0){
            j = 4294967295L & ((long) hashcode);
        }

        int i2 = (int) (j % ((long) (this.e * 8)));
        if (((this.f[i2 / 8] >> (i2 % 8)) & 1) == 0) {
//                Log.i("DEMO","this.f[i2 / 8]" + i2 % 8);
//                Log.i("DEMO","this.f[i2 / 8]XXXX" + f[i2 / 8]);
            return false;
        }else {
            return  true;
        }

    }

    public boolean b() {
        return a.equals(this.b);
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append("\r\n");
        stringBuffer.append("mSeedNumber:" + this.c);
        stringBuffer.append("\r\n");
        stringBuffer.append("mDataLength:" + this.e);
        return stringBuffer.toString();
    }
}