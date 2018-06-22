package com.easytop.psm.utils;

import java.util.List;

/***
 * 返回的结果集
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class ResultList<T> {

	private List<T> result;

	private int total;

	public ResultList(List<T> result, int total) {
		super();
		this.result = result;
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResultList [result=" + result + ", total=" + total + "]";
	}

}
