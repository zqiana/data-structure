package com.baidu.phone;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class cbn {

	
	
	
	 public static byte[] a(byte[] arg3) {
	        byte[] v0_2;
	        GZIPOutputStream v1;
	        ByteArrayOutputStream v0_1;
	        Closeable v2 = null;
	        try {
	            v0_1 = new ByteArrayOutputStream();
	            v1 = new GZIPOutputStream(((OutputStream)v0_1));
	       
	            v1.write(arg3);
	            v1.flush();
	            v1.finish();
	            v0_2 = v0_1.toByteArray();
	            cbm.a(((Closeable)v1));
		        return v0_2;	        
		        
	        }
	        catch(Throwable v0) {
	        	
	        	return null;
	        }

	   
	       
	    }
	
	
}
