package com.easytop.psm.utils;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *	操作提示工具类
 *	当用户操作成功或者失败时调用此类的方法返回页面弹框消息给用户
 */

@Component
public class HintTool {
	
	public void returnHint(String information,OutputStream out) {
		
		String mistake = "<html><head><meta http-equiv='Content-Type' content='text/html;charset=UTF-8'></head><script language='javascript'>alert('"
				+ information + "'); window.history.go(-1);</script></html>";
		try {
			out.write(mistake.getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void returnHintRefresh(String information, OutputStream out, String url) {
		
		String mistake = "<html><head><meta http-equiv='Content-Type' content='text/html;charset=UTF-8'></head><script language='javascript'>alert('"
				+ information + "');window.location.href='" + url + "'; </script></html>";
		try {
			out.write(mistake.getBytes());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
