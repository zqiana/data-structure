package com.baidu.phone;

import java.io.Closeable;

public class cbm {

	
	 public static void a(Closeable arg1) {
	        if(arg1 != null) {
	            try {
	                arg1.close();
	            }
	            catch(Exception v0) {
	            }
	        }
	    }
}
