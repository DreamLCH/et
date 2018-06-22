package com.easytop.psm.utils;



import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *分页逻辑处理类
 */
@Component
public class Paging {
	
	/**
	 * 用于储存从数据库所查询到的数据
	 */
	public ArrayList list = new ArrayList();
	public int num = 1;
	
	
	/**
	 * 获取数据总条数
	 * 
	 * @return
	 */
	public int getAmount() {
		return list.size();
	}
	
	
	/**
	 * 获取当前第几页为第几页
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}
	
	
	/**
	 * 把查询到的数据传入到arrayList集合里
	 * 
	 * @param arrayList	从数据库所查询到的数据
	 */
	public void setList(ArrayList arrayList) {
		list=arrayList;
	}
	
	
	/**
	 * 返回首页数据
	 * 
	 * @return
	 */
	public ArrayList first() {
		num=1;
		return getPagingData(0);
	}
	
	
	/**
	 * 返回上一页的数据
	 * 
	 * @return
	 */
	public ArrayList up() {
		if(num==1) {
			return getPagingData(0);
		}
		
		int temp = num*5-10;
		num--;
		return getPagingData(temp);
	}
	
	
	/**
	 * 返回下一页的数据
	 * 
	 * @return
	 */
	public ArrayList next(){
		
		int pagination = getPagination();
		 
		if(num==pagination) {
			return getPagingData(pagination*5-5);
		}
		
		int temp = num*5;
		num++;
		return getPagingData(temp);
	}
	
	
	/**
	 * 获取当前数据一共有多少页（每页5条数据）
	 * 
	 * 总数据条数%5==0吗？	当=0时，总页数就是总数据条数除以5。	不=0时，总页数就是总数据条数除以5+1。
	 * @return
	 */
	public int getPagination() {
		int amount = getAmount();
		int pagination = amount%5==0?amount/5:amount/5+1;
		return pagination;
	}
	
	
	/**
	 * 返回尾页数据
	 * 
	 * @return
	 */
	public ArrayList last(){
		int amount = getAmount();
		int pagination = amount%5==0?amount/5:amount/5+1;
		num=pagination;
		
		return getPagingData(pagination*5-5);
	}
	
	
	
	/**
	 * 获取分页后的数据
	 * 
	 * @param pagination	传入从ArrayList集合获取数据的起点位置（例如：首页就是（0-5）下标的数据，这时候传入的参数就是0）
	 * @return
	 */
	public ArrayList getPagingData(int pagination) {
		
		ArrayList temp = new ArrayList();
		int end = pagination+5;
		
		if(num==getPagination()) {
			end=list.size();
		}
		
		if(list.size()==0) {
			end=0;
		}
		
		for(int i=pagination; i<end; i++) {
			temp.add(list.get(i));
		}
		
		return temp;
	}

	
}
