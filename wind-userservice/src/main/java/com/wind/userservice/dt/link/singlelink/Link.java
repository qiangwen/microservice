package com.wind.userservice.dt.link.singlelink;

/**
 * 链节点
 * @author qiang.wen
 * @date 2017年8月30日 下午2:33:42
 */
public class Link {

	private int x;
	
	private int y;
	
	private Link next;
	
	public Link(int x,int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}
	
	public void display(){
		System.out.println("x:"+ x +",y:" + y);
	}
	
}
