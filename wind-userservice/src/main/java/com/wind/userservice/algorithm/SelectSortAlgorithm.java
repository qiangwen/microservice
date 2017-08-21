package com.wind.userservice.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序算法
 * 原理：选择出最小的数据项和未排序的最左边的数据项交换
 * 步骤：
 * 1、从最左边开始，把下标为0的数据项标为最小值，用该值和下标为1的数据项进行比较，如果下标1的数据项值更小，则更新最小值为下标为1的数据项
 * ，遍历整个数据列表，得到最小值的索引，然后和下标为0的数据项交换，这样最小值已经在最左边。
 * 2、把开始下标右移一位，重复1的操作，这样每次结果最小的都和未排序的最左边的数据项进行交换，最左边的数据总是有序的
 * 
 * 不变性：最左边的数据总是有序的
 * 
 * @author qiang.wen
 * @date 2017年8月21日 上午9:58:40
 */
public class SelectSortAlgorithm {

	private static final Random random = new Random();

	public static void main(String[] args) {
		int[] noSortedArr = genIntArr(20);
		System.out.println("noSortedArr:" + Arrays.toString(noSortedArr));
		sortArr(noSortedArr);
		System.out.println("sortedArr:" + Arrays.toString(noSortedArr));
	}

	/**
	 * 
	 * @param noSortedArr
	 * @return
	 * @author qiang.wen
	 * @date 2017年8月18日 下午6:32:36
	 */
	private static void sortArr(int[] noSortedArr) {
		if(noSortedArr == null || noSortedArr.length == 0 || noSortedArr.length == 1){
			return;
		}
		int minIndex;
		for(int i=0; i<noSortedArr.length-1; i++){
			minIndex = i;
			for(int j=i+1; j<noSortedArr.length; j++){
				if(noSortedArr[j] < noSortedArr[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				noSortedArr[i] = noSortedArr[minIndex] + noSortedArr[i];
				noSortedArr[minIndex] = noSortedArr[i] - noSortedArr[minIndex];
				noSortedArr[i] = noSortedArr[i] - noSortedArr[minIndex];
			}
		}
	}

	/**
	 * 
	 * 构造特定长度的数组并赋值
	 * @param length
	 * @return
	 * @author qiang.wen
	 * @date 2017年8月18日 下午6:27:06
	 */
	private static int[] genIntArr(int length) {
		int[] arr = new int[length];
		for(int i=0; i<arr.length; i++){
			arr[i] = random.nextInt(1000);
		}
		return arr;
	}
}
