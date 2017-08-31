package com.wind.userservice.dt.link.singlelink;

/**
 * 单链表
 * 特点：
 * 1、每个链节点含有下一个节点的引用
 * 2、链表本身包含第一个链节点的引用 
 * 使用时，插入和删除通常在链头操作
 * @author qiang.wen
 * @date 2017年8月30日 下午2:54:10
 */
public class SingleLink {

	private Link first;
	
	public SingleLink(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int x, int y){
		Link link = new Link(x, y);
		link.setNext(first);
		first = link;
	}
	
	public Link deleteFirst(){
		if(isEmpty()){
			return null;
		}
		Link temp = first;
		first = temp.getNext();
		return temp;
	}
	
	public void displayList(){
		Link curr = first;
		while(curr != null){
			curr.display();
			curr = curr.getNext();
		}
	}
	

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}
	
}
