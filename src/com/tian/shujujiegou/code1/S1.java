package com.tian.shujujiegou.code1;

/**
 * N个数中求第K大的
 */
public class S1 {

     public static void main(String[] args){
          S1 s = new S1();
          int[] as = {1,2,3,4,5,6,7,8,9,10};
          System.out.println(s.paixu(as,2));
     }

     /**
      * 冒泡排序
      * @param as
      * @return
      */
     public int paixu(int [] as,int k){
          int temp = 0;
          for(int i = 0 ; i < as.length -1 ; i ++){
               for(int j = 0;j<as.length - i - 1;j++){
                    if(as[j]<as[j+1]){
                         temp = as[j+1];
                         as[j+1] = as[j];
                         as[j] = temp;
                    }
               }
          }
          return as[k-1];
     }

     public int kmax(int[] as,int k){
          int[] kas = new int[k];
          int temp = 0;

          //获取一个k的数据
          for(int i = 0 ; i < k ; i ++){
               kas[i] = as[i];
          }

          //k数据排序
          for (int i = 0; i < kas.length - 1; i++) {
               for (int j = 0; j < kas.length - i - 1 ; j++) {
                    if(kas[j]<kas[j+1]){
                         temp = kas[j+1];
                         kas[j+1] = kas[j];
                         as[j] = temp;
                    }
               }
          }

          for (int i = k; i < as.length ; i++) {
               if(as[i]<kas[k-1]){
                    continue;
               }else{

               }
          }
          return kas[0];
     }
}
