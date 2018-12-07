package com.dianhua.bang;

public class Util {
	
	    private static  String[] IPPFXS4;
	    private static  String[] IPPFXS5;
	    private static  String[] IPPFXS6;
	    private static String TAG;
	
	  static {
		  Util.IPPFXS4 = new String[]{"1790", "1791", "1793", "1795", "1796", "1797", "1799"};
		  Util.IPPFXS5 = new String[]{"12583", "12593", "12589", "12520", "10193", "11808"};
		  Util.IPPFXS6 = new String[]{"118321"};
		  Util.TAG = "Utils";
	    }
	
	public static String trimTelNum(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        String substring = Util.substring(str, 0, 6);
        String substring2 = Util.substring(str, 0, 5);
        String substring3 = substring(str, 0, 4);
        if (str.length() > 7 && ((substring(str, 5, 1).equals("0") || substring(str, 5, 1).equals("1") || substring(str, 5, 3).equals("400") || substring(str, 5, 3).equals("+86")) && (inArray(substring2, IPPFXS5) || inArray(substring3, IPPFXS4)))) {
            str = Util.substring(str, 5);
        } else if (str.length() > 8 && ((substring(str, 6, 1).equals("0") || substring(str, 6, 1).equals("1") || substring(str, 6, 3).equals("400") || substring(str, 6, 3).equals("+86")) && inArray(substring, IPPFXS6))) {
            str = substring(str, 6);
        }//FILENAME_SEQUENCE_SEPARATOR = "-";
        substring = str.replace("-", "").replace(" ", "");
        if (substring(substring, 0, 4).equals("0086")) {
            return substring(substring, 4);
        }
        if (substring(substring, 0, 3).equals("+86")) {
            return substring(substring, 3);
        }
        if (substring(substring, 0, 5).equals("00186")) {
            return substring(substring, 5);
        }
        return substring;
    }
	
	protected static String substring(String arg1, int arg2, int arg3) {
        String v0_2;
        int v0 = arg2 + arg3;
        try {
            v0_2 = arg1.substring(arg2, v0);
        }
        catch(Exception v0_1) {
            v0_2 = "";
        }

        return v0_2;
    }
	
    protected static String substring(String arg1, int arg2) {
        String v0_1;
        try {
            v0_1 = arg1.substring(arg2);
        }
        catch(Exception v0) {
            v0_1 = "";
        }

        return v0_1;
    }
    
    protected static boolean inArray(String arg4, String[] arg5) {
        boolean v0 = false;
        if(arg5 != null && arg5.length != 0 && arg4 != null) {
            int v2 = arg5.length;
            int v1 = 0;
            while(v1 < v2) {
                if(arg4.equals(arg5[v1])) {
                    v0 = true;
                }
                else {
                    ++v1;
                    continue;
                }

                return v0;
            }
        }

        return v0;
    }


}
