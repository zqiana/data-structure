package com.admaster.ad.cn;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

public class TestNumber {
	
    private List<String> result = new LinkedList<>();
    private static int count = 0;

    public void main(){
        gene("132473",1);
        for(String s : result){
            System.out.println(s);
        }
    }
    //递归生成电话号码
    public String gene(String s,int level){
        if(level == 6){
        	count ++;
        	System.out.println(s);
        	System.out.println("个数：" + count);
	        createFile("/Users/ZhangQian/Desktop/numbertest/newtengxunceshi.txt", s.toString().getBytes());
//          result.add(s);
            return s;
        }
        for (int i = 0; i <= 9 ; i++) {
            gene(s+i,level+1);
        }
        return  s;
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


    public static void main(String[] args) {
        TestNumber t = new TestNumber();
        t.main();
    }
}
