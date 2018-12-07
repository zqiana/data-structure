package com.dianhua.bang;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CipherUtil {
    private static String TAG = "CipherUtil";

    public static String bD(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean B(String str, String str2) {
        if (str2 == null || str==null || !str2.equals(bE(str))) {
            return false;
        }
        return true;
    }

    public static String bE(String str) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        int i = 0;
        String str2 = null;
        File file = new File(str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    while (i != -1) {
                        i = fileInputStream.read(bArr);
                        if (i > 0) {
                            instance.update(bArr, 0, i);
                        }
                    }
                    str2 = u(instance.digest());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                
                return str2;
            }
        }
        return str2;
    }

    private static String u(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }
}