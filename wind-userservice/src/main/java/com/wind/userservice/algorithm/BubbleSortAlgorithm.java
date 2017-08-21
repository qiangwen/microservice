package com.wind.userservice.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序算法
 * 目标：最小的数据在左边，最大的数据在右边
 * 实现规则：
 * 假设有N个数据，索引从0到N-1
 * 1、比较索引为0和索引为1数的大小，如果左边的数大于右边的数，则让两个数交换位置
 * 2、比较索引为1和索引为2的数的大小，如果左边的数大于右边的数，则让两个数交换位置
 * 3、依次比较，到索引为N-2与N-1比较的时候，第一轮比较结束，最大的数在最右边
 * 4、重复1,2,3步 N-1次
 * 时间复杂度：大O表示法 O(N的2次方)
 * @author qiang.wen
 * @date 2017年8月18日 下午5:59:04
 */
public class BubbleSortAlgorithm {
	
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
		for(int i=1; i < noSortedArr.length; i++){
			for(int j=0; j < noSortedArr.length - i; j++){
				if(noSortedArr[j] > noSortedArr[j+1]){
					int temp = noSortedArr[j];
					noSortedArr[j] = noSortedArr[j+1];
					noSortedArr[j+1] = temp;
				}
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
