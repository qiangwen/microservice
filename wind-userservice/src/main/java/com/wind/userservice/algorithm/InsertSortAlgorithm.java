package com.wind.userservice.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序算法
 * 原理：已一个标记元素为界限，左边（我们以左边为例）为有序的，标记元素及右边的元素为无序的，
 * 我们要把右边无序的数据在左侧找到一个合适的位置进行插入
 * 如何找到索引是插入算法最关键的地方
 * 
 * 时间复杂度
 * 
 * @author qiang.wen
 * @date 2017年8月21日 下午12:36:04
 */
public class InsertSortAlgorithm {

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
		int temp;
		int j;
		for(int i=1; i<noSortedArr.length; i++){
			temp = noSortedArr[i];
			for(j=i; j>0; j--){
				if(temp < noSortedArr[j-1]){
					noSortedArr[j] = noSortedArr[j-1];
				}else{
					break;
				}
			}
			noSortedArr[j] = temp;
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
