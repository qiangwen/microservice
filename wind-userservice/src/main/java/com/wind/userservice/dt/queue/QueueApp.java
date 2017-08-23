package com.wind.userservice.dt.queue;

/**
 * 模拟队列操作
 * @author qiang.wen
 * @date 2017年8月23日 下午2:31:04
 */
public class QueueApp {
	
	public static void main(String[] args) {
		Queue queue = new QueueApp().new Queue(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		System.out.println(queue.remove());
	}

	
	class Queue{
		private int maxSize;
		private int headIndex;
		private int tailIndex;
		private int[] queueArr;
		private int nitems;
		
		public Queue(int size){
			maxSize = size;
			headIndex = 0;
			tailIndex = -1;
			queueArr = new int[maxSize];
			nitems = 0;
		}
		
		public boolean isEmpty(){
			return nitems == 0;
		}
		
		public boolean isFull(){
			return nitems == maxSize;
		}
		
		public void add(int item){
			if(isFull()){
				System.out.println("队列已满");
				return;
			}
			if(tailIndex == maxSize -1){
				tailIndex = -1;
			}
			queueArr[++tailIndex] = item;
			nitems++;
		}
		
		public int remove(){
			if(isEmpty()){
				throw new RuntimeException("队列已空");
			}
			nitems--;
			if(headIndex == maxSize -1){
				headIndex = 0;
			}
			return queueArr[headIndex++];
		}
	}
}
