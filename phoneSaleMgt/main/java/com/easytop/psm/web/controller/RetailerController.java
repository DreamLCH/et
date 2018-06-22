package com.easytop.psm.web.controller;

import java.io.OutputStream;
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

import com.easytop.psm.model.Retailer;
import com.easytop.psm.service.RetailerService;
import com.easytop.psm.utils.HintTool;
import com.easytop.psm.utils.ResultList;

/**
 * 
 * @author 梁琛华
 * @version 1.0 销售商控制层
 */
@Controller
public class RetailerController {

	// RetailerService接口，用于调用DAO层里的方法
	@Autowired
	private RetailerService retailerService;

	// 消息提示工具类
	@Autowired
	private HintTool hintTool;

	
	/**
	 * 第一次访问JSP页面的时候页面的Retailer对象没有传值，该方法添加了@ModelAttribute注解，访问该类任何方法都会先调用此方法
	 * 然后把对象传给页面，防止JSP页面报错
	 * 
	 * @return
	 */
	@ModelAttribute("retailer")
	public Retailer getRetailer() {
		return new Retailer();
	}
	
	

	/**
	 * 访问添加销售商JSP页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jsp/add/retailer")
	public String AddRetailer() {
		return "addRetailer";
	}
	
	

	/**
	 * 
	 * @param retailer
	 *            自动赋值的销售商对象
	 * @param error
	 *            校验后结果对象，可以判断校验是否有错误，错误信息也储存在该对象中
	 * @param out
	 *            字节输出流
	 * @return
	 * 
	 * 		在对象前面加上@Valid注解表示该需要校验
	 */
	@RequestMapping(value = "/add/retailer", method = RequestMethod.POST)
	public String addRetailer(@Valid Retailer retailer, BindingResult error, OutputStream out) {

		if (error.hasErrors()) {
			// 校验到用户有错误输入，重新返回到销售商添加页面
			return "addRetailer";
		}

		// 调用添加方法
		Retailer temp = retailerService.addRetailer(retailer);

		if (temp == null) {
			// 添加成功
			hintTool.returnHintRefresh("添加成功。", out, "/jsp/add/retailer");
		} else {
			// 添加失败
			hintTool.returnHint("添加失败，你输入的销售商名称已存在。", out);
		}

		return null;
	}


	/**
	 * 查询销售商名称是否存在
	 * 
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/retailer/name", method = RequestMethod.GET)
	public Map<String, Object> queryRetailerName(String name) {

		Retailer retailer = retailerService.getRetailerByName(name);

		Map<String, Object> result = new HashMap();

		if (retailer == null) {
			result.put("result", true);
		} else {
			result.put("result", false);
		}

		return result;
	}
	

	/**
	 * 删除销售商
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/retailer")
	public Map<String, Object> deleteRetailer(int id) {

		retailerService.deleteRetailer(id);

		Map<String, Object> result = new HashMap();
		result.put("result", true);

		return result;
	}


	/**
	 * 
	 * 销售商查询页面转发
	 * 
	 * @return 转发到queryRetailer.JSP页面
	 */
	@RequestMapping(value = "/query/retailer", method = RequestMethod.GET)
	public String queryRetailer() {
		// 转发到queryRetailer.JSP页面
		return "queryRetailer";
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
	@RequestMapping("/query/retailer/get")
	@ResponseBody
	public ResultList<Map> getRetailerData(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		List<Map> retailerList = retailerService.queryAllRetailer(search, offset, limit);

		// 拿到数据总记录数
		int total = retailerService.queryAllRecord(search);

		return new ResultList<>(retailerList, total);

	}


	/**
	 * 查询所有销售区域
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/area", method = RequestMethod.GET)
	public List queryArea() {

		// 所有区域
		List areaList = retailerService.queryAllArea();

		return areaList;
	}

}
