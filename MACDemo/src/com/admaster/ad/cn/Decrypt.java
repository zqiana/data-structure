package com.admaster.ad.cn;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Decrypt {
    public static String a = "updata_bloom_cipher";
    private static String b = "bloom.cipher";
    private List<White> c = new ArrayList();
//    private Context d = ContextInstance.a().getCtx();
    private ReadWriteLock e = new ReentrantReadWriteLock();

    private void a(InputStream inputStream) {
        this.e.writeLock().lock();
        try {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            bArr = a(bArr);

//            Log.i("DEMO","初始化数据：" +byteArrayToInt(bArr));


            if (bArr != null) {
                available = bArr.length;
                while (true) {
                    White aVar = new White(bArr, bArr.length - available);
//                    Log.i("DEMO","初始化数据：" +aVar.toString());

                    this.c.add(aVar);
                    available -= aVar.a();
                    if (available <= 40) {
                        this.e.writeLock().unlock();
                        return;
                    }
                }
            }
        }catch (Exception e){

        }
        finally {
//            this.e.writeLock().unlock();
        }
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

    private byte[] a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        Object obj = new byte[(length - 8)];
        System.arraycopy(bArr, 8, obj, 0, length - 8);
        try {
            return new Utilse(Utilse.Aesa("1ZOc4lhJyOdL", bArr2, 10000)).a((byte[]) obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void e() {
        Iterator v1 = this.c.iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next();
//            Log.v("DEMO", "Flag:" + ((White)v0).c() + "--BF_len:" + ((White)v0).d());
        }
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

    public String a(String str) {
        this.e.readLock().lock();
        try {
            String c;
            for (White aVar : this.c) {
                if (aVar.a(str)) {
                    //如果在数据库里hash查询得到值得话，会返回对应的电话号码的标签
//                    Log.e("DEMO", "check_" + str + ":" + aVar.c());
                	System.out.println("check_" + str + ":" + aVar.c());
                	String tempStr = str+":"+aVar.c();
                	createFile("/Users/ZhangQian/Desktop/number/195.txt", tempStr.getBytes());
                	
                    if (!aVar.b()) {
                        c = aVar.c();
                        this.e.readLock().unlock();
                        return c;
                    }
                    c = null;
                    this.e.readLock().unlock();
                    return c;
                }
            }
            c = null;
            this.e.readLock().unlock();
            return c;
        } catch (Throwable th) {
            this.e.readLock().unlock();
            return "";
        }
    }

    public void a() {
        this.c.clear();
//        if (d) {
//            c();
//            Log.e("DEMO", "init---UpdataData");
//        } else {
////            loadFile();
//            Log.e("DEMO", "init---LocalData");
//        }
        e();
    }

    public void loadFile(String context) {
        try {
//            InputStream open = context.getAssets().open(b);
        	InputStream open = new FileInputStream(context);
            a(open);
            open.close();

            e();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void c() {
//        try {
//            InputStream openFileInput = ContextInstance.a().getCtx().openFileInput(a);
//            a(openFileInput);
//            openFileInput.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public boolean d(Context context) {
//        return new File(context.getFilesDir().getAbsolutePath() + File.separator + a).exists();
//    }
}