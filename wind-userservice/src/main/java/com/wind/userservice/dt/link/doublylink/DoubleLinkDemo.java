package com.wind.userservice.dt.link.doublylink;

public class DoubleLinkDemo {

	public static void main(String[] args) {
		DouleLinkList linkList = new DouleLinkList();
		linkList.addFirst(1);
		linkList.addLast(2);
		linkList.addFirst(3);
		System.out.println(linkList.deleteFirst().getData());
		System.out.println(linkList.deleteFirst().getData());
		System.out.println(linkList.deleteFirst().getData());
	}
}
