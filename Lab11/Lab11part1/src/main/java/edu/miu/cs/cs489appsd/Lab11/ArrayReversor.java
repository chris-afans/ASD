package edu.miu.cs.cs489appsd.Lab11;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayReversor {

    private ArrayFlattener arrayFlattener;

    public ArrayReversor(ArrayFlattener arrayFlattener) {
        this.arrayFlattener = arrayFlattener;
    }

    public int[] reverseArray(int[][] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int[] array = arrayFlattener.flattenArray(arr);
        int[] reversedArray = new int[array.length];
        int j = 0;
        for(int i = array.length-1; i >= 0; i--){
            reversedArray[j] = array[i];
            j++;
        }
        return reversedArray;
    }
}
