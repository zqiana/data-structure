package com.admaster.ad.cn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pilars {

    public void abc(int totalNum, int countNum,int k) {
        int result = 0;

        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        while (start.size() > 0) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                result = start.get(start.size() - 1);
                start.remove(start.size() - 1);
                k = 0;
            } else {
                //System.out.println(start.get(k));
                start.remove(k);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    // 从键盘接收数据
        int totalNum = scan.nextInt();
        int start = scan.nextInt()-1;
        int countNum  = scan.nextInt();
        Pilars t  = new Pilars();
        t.abc(totalNum,countNum,start);
    }
}
