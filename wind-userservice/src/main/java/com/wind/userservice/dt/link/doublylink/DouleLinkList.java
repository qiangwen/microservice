package com.wind.userservice.dt.link.doublylink;

/**
 * 双向列表
 * @author qiang.wen
 * @date 2017年8月31日 下午1:52:45
 */
public class DouleLinkList {

	private DoubleLink first;
	
	private DoubleLink last;
	
	private int size;
	
	public DouleLinkList(){
		first = null;
		last = null;
		
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(int data){
		DoubleLink link = new DoubleLink(data);
		if(isEmpty()){
			last = link;
		}else{
			link.setRight(first);
			first.setLeft(link);
		}
		first = link;
		size ++;
	}
	
	public void addLast(int data){
		DoubleLink newLink = new DoubleLink(data);
		if(isEmpty()){
			first = newLink;
		}else{
			last.setRight(newLink);
			newLink.setLeft(last);
		}
		last = newLink;
		size ++;
	}
	
	public DoubleLink deleteFirst(){
		DoubleLink reLink = first;
		if(first.getRight() == null){
			last = null;
			first = null;
		}else{
			first.getRight().setLeft(null);
			first = first.getRight();
		}
		size --;
		return reLink;
	}
	
	public DoubleLink deleteLast(){
		DoubleLink retLink = last;
		if(last.getLeft() == null){
			last = null;
			first = null;
		}else{
			last.getLeft().setRight(null);
			last = last.getLeft();
		}
		size --;
		return retLink;
	}

	public DoubleLink getFirst() {
		return first;
	}

	public void setFirst(DoubleLink first) {
		this.first = first;
	}

	public DoubleLink getLast() {
		return last;
	}

	public void setLast(DoubleLink last) {
		this.last = last;
	}
	
	
	
}
