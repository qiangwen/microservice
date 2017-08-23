package com.wind.userservice.dt.stack;

/**
 * 数据结构-栈
 * 特点：后进先出
 * 本类使用数组实现栈的功能
 * @author qiang.wen
 * @date 2017年8月22日 下午4:03:07
 */
public class DTStack {

	private int[] stackArr;
	
	private int maxLength;
	
	private int topindex;
	
	public DTStack(int maxLength){
		this.maxLength = maxLength;
		stackArr = new int[maxLength];
		topindex = -1;
	}
	
	public void push(int element){
		if(topindex >= maxLength -1){
			System.out.println("数据不能入栈，已经到栈顶了");
		}else{
			stackArr[++topindex] = element;
		}
	}
	
	public void pop(){
		if(topindex < 0){
			System.out.println("数据不能出栈，已经到栈底了");
		}else{
			System.out.println("栈顶元素项为：" + this.stackArr[topindex]);
			topindex --;
		}
	}
	
	public void peek(){
		if(topindex < 0){
			System.out.println("当前栈已经清空，无数据可读取");
		}else{
			System.out.println("栈顶元素为：" + this.stackArr[topindex]);
		}
		
	}
	
	public static void main(String[] args) {
		DTStack dtStack = new DTStack(10);
		for(int i = 0; i<10; i++){
			dtStack.push(i+1);
		}
		for(int i=0; i<10; i++){
			dtStack.pop();
		}
		dtStack.pop();
		dtStack.peek();
	}
}
