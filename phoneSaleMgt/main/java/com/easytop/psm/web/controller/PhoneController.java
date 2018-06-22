package com.easytop.psm.web.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easytop.psm.model.Phone;
import com.easytop.psm.service.PhoneService;
import com.easytop.psm.utils.HintTool;
import com.easytop.psm.utils.ResultList;

/**
 * 
 * @author 梁琛华
 * @version 1.0 手机控制层
 */

@Controller
public class PhoneController {

	// PhoneService接口，用于调用DAO层里的方法
	@Autowired
	private PhoneService phoneService;

	// 消息提示工具类
	@Autowired
	private HintTool hintTool;


	/**
	 * 第一次访问JSP页面的时候页面的phone对象没有传值，该方法添加了@ModelAttribute注解，访问该类任何方法都会先调用此方法
	 * 然后把对象传给页面，防止JSP页面报错
	 * 
	 * @return
	 */
	@ModelAttribute("phone")
	public Phone getPhone() {
		return new Phone();
	}

	/**
	 * 访问添加手机JSP页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jsp/add/phone")
	public String AddPhone() {
		return "addPhone";
	}


	/**
	 * 添加手机
	 * 
	 * @param phone
	 *            自动赋值的手机对象
	 * @param error
	 *            校验后结果对象，可以判断校验是否有错误，错误信息也储存在该对象中
	 * @param out
	 *            字节输出流
	 * @return
	 * 
	 * 		在对象前面加上@Valid注解表示该需要校验
	 */
	@RequestMapping(value = "/add/phone", method = RequestMethod.POST)
	public String AddPhone(@Valid Phone phone, BindingResult error, OutputStream out) {

		if (error.hasErrors()) {
			// 校验到用户有错误输入，重新返回到手机添加页面
			return "addPhone";
		}

		// 调用添加方法
		Phone temp = phoneService.add(phone);

		if (temp == null) {
			// 添加成功
			hintTool.returnHintRefresh("添加成功。", out, "/jsp/add/phone");
		} else {
			// 添加失败
			hintTool.returnHint("添加失败，型号已存在。", out);
		}

		return null;
	}


	/**
	 * 查询手机转发页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query/phone", method = RequestMethod.GET)
	public String queryPhone() {
		// 转发到queryPhone.JSP页面
		return "queryPhone";
	}


	/**
	 * 查询手机型号是否存在
	 * 
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/phone/type", method = RequestMethod.GET)
	public Map<String, Object> queryPhoneType(String type) {

		Phone phone = phoneService.getPhoneByType(type);
		Map<String, Object> result = new HashMap();

		if (phone == null) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}

		return result;
	}


	/**
	 * 删除手机
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/phone")
	public Map<String, Object> deletePhone(int id) {

		phoneService.deletePhone(id);

		Map<String, Object> result = new HashMap();
		result.put("result", true);

		return result;
	}


	/**
	 * 查询手机数据
	 * 
	 * @param search
	 *            搜索的参数
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示多少条数据
	 * @return
	 */
	@RequestMapping("/query/phone/get")
	@ResponseBody
	public ResultList<Map> getPhoneData(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		List<Map> phones = phoneService.queryAllPhone(search, offset, limit);


		// 将日期转成yyyy-MM-dd格式
		for (Map phone : phones) {
			Date date = (Date) phone.get("t_date");
			String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
			phone.put("t_date", dateStr);
		}

		// 拿到数据总记录数
		int total = phoneService.queryAllRecord(search);

		return new ResultList<>(phones, total);

	}



	/**
	 * 查询所有手机的品牌
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/brand", method = RequestMethod.GET)
	public List queryBrand() {

		// 手机的所有品牌
		List arrayList = phoneService.queryAllBrand();

		return arrayList;
	}


}
