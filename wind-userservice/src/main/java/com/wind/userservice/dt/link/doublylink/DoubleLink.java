package com.wind.userservice.dt.link.doublylink;

/**
 * 双向链表的链节点
 * @author qiang.wen
 * @date 2017年8月31日 上午10:28:15
 */
public class DoubleLink {

	private int data;
	
	private DoubleLink left;//左链节点的引用
	
	private DoubleLink right;//右链节点的引用
	
	public DoubleLink(int data){
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleLink getLeft() {
		return left;
	}

	public void setLeft(DoubleLink left) {
		this.left = left;
	}

	public DoubleLink getRight() {
		return right;
	}

	public void setRight(DoubleLink right) {
		this.right = right;
	}
	
}
