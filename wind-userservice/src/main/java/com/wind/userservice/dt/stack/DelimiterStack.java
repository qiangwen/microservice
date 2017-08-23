package com.wind.userservice.dt.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

/**
 * 该类实现检验字符串中的括号是否匹配 {[()]}
 * @author qiang.wen
 * @date 2017年8月23日 上午10:17:33
 */
public class DelimiterStack {

	
	public static void main(String[] args) throws Exception {
		String input;
		while (true) {
			input = readForConsole();
			checkStr(input);
		}
	}
	
	
	private static void checkStr(String input) {
		if(StringUtils.isEmpty(input)){
			return;
		}
		Statck s = new DelimiterStack().new Statck(input.length());
		for(int i=0; i<input.length(); i++){
			char c = input.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				s.push(c);
				break;
			case '}':
			case ']':
			case ')':
				char chx = s.pop();
				if(c=='}' && chx!='{' || c==']' && chx!='[' || c==')'&& chx!='('){
					System.out.println("ERROR,括号不匹配，当前字符为:" + c);
					return;
				}
				break;
			default:
				break;
			}
		}
		if(!s.isEmpty()){
			System.out.println("ERROR,还有括号未匹配完");
		}
	}




	private static String readForConsole() throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}




	class Statck{
		
		private int topIndex;
		
		private char[] charArr;
		
		private int maxLength;
		
		public Statck(int maxLength){
			this.maxLength = maxLength;
			this.topIndex  = -1;
			this.charArr = new char[maxLength];
		}
		
		public void push(char c){
			if(topIndex >= maxLength -1){
				throw new RuntimeException("无法入栈，已经到栈顶了");
			}else{
				charArr[++topIndex] = c;
			}
		}
		
		public char pop(){
			if(topIndex < 0){
				throw new RuntimeException("无法出栈，已经到栈底了");
			}
			return charArr[topIndex--];
		}
		
		public boolean isEmpty(){
			return topIndex == -1;
		}
		
	}
}
