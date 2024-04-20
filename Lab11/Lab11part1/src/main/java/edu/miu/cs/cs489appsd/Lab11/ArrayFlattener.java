package edu.miu.cs.cs489appsd.Lab11;

public class ArrayFlattener {


    public int[] flattenArray(int[][] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        int[] flattenedArray = new int[arr.length * arr[0].length];
        int k =0;
        for(int i=0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                flattenedArray[k] = arr[i][j];
                k++;
            }
        }
        return flattenedArray;
    }
}
