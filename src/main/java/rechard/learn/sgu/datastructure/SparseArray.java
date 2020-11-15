package rechard.learn.sgu.datastructure;

import java.io.*;
import java.util.ArrayList;

/**
 * 1.二维数组转成稀疏数组
 * 2.稀疏数组转回二维数组
 * 3.稀疏数组保存到硬盘上
 * 4.硬盘上读出成稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int [][] arr=new int[10][10];
        arr[3][5]=1;
        arr[6][7]=2;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println("\n");
        }

        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]!=0)sum++;
            }
        }

        //第一行保存原数组里有几行几列几个值
        int [][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=arr.length;
        sparseArr[0][1]=arr[0].length;
        sparseArr[0][2]=sum;

        System.out.println("convert to sparse array:");
        int count=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]!=0){
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                    count++;
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
             System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println("sparse array convert back:");

        int arr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j <arr2[i].length ; j++) {
                System.out.printf("%d\t",arr2[i][j]);
            }
            System.out.println("\n");
        }

        System.out.println("save sparse array to d:/map.data");
        File file=new File("d:/map.data");

        FileOutputStream fos=null;
        try {
            file.createNewFile();
            fos=new FileOutputStream(file);
            byte[] bytes=new byte[sparseArr.length*3];
            int index=0;
            for (int i = 0; i < sparseArr.length;i++) {
                bytes[index++]=(byte)sparseArr[i][0];
                bytes[index++]=(byte)sparseArr[i][1];
                bytes[index++]=(byte)sparseArr[i][2];
            }
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("from d:/map.data back to sparse array");
        try (FileInputStream fis=new FileInputStream(file)){
           ArrayList<Byte> list=new ArrayList<>();
           byte b;
           while((b= (byte) fis.read())!=-1){
                    list.add(b);
            }
           int[][] backArry=new int[list.size()/3][3];
            for (int i = 0; i < list.size(); i++) {
                backArry[i/3][i%3]=list.get(i);
            }

            for (int i = 0; i < backArry.length; i++) {
                System.out.printf("%d\t%d\t%d\t\n",backArry[i][0],backArry[i][1],backArry[i][2]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
