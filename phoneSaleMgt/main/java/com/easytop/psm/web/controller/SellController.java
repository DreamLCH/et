package com.easytop.psm.web.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easytop.psm.model.Sell;
import com.easytop.psm.service.PhoneService;
import com.easytop.psm.service.RetailerService;
import com.easytop.psm.service.SellService;
import com.easytop.psm.utils.HintTool;
import com.easytop.psm.utils.ResultList;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *          销售控制层
 */
@Controller
public class SellController {

	// SellService接口，用于调用DAO层里的方法
	@Autowired
	private SellService sellService;

	// PhoneService接口，用于调用DAO层里的方法
	@Autowired
	private PhoneService phoneService;

	// RetailerService接口，用于调用DAO层里的方法
	@Autowired
	private RetailerService retailerService;

	// 消息提示工具类
	@Autowired
	private HintTool hintTool;


	
	
	/**
	 * 第一次访问JSP页面的时候页面的Sell对象没有传值，该方法添加了@ModelAttribute注解，访问该类任何方法都会先调用此方法
	 * 然后把对象传给页面，防止JSP页面报错
	 * 
	 * @return
	 */
	@ModelAttribute("sell")
	public Sell getSell() {
		return new Sell();
	}

	
	
	/**
	 * 查询销售录入时是否有对应的销售商名称手机品牌和型号
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/query/addSellDate")
	public String queryAddDate(ModelMap model) {

		// 查询页面显示所需的数据
		int num = retailerService.queryAllRecord(null);
		List retailerName = retailerService.queryAllRetailer(null, 0, num);
		ArrayList phoneBrand = phoneService.queryAllBrand();
		Map phoneMap = phoneService.queryAllData(phoneBrand);

		// 将数据设置到ModelMap对象中，在jsp页面可以用requestScope获取到数据
		model.addAttribute("retailerName", retailerName);
		model.addAttribute("phoneMap", phoneMap);

		return "addSell";
	}
	
	

	/**
	 * 录入销售信息
	 * 
	 * @Sell sell 自动赋值的销售对象
	 * @param error
	 *            校验后结果对象，可以判断校验是否有错误，错误信息也储存在该对象中
	 * @param out
	 *            字节输出流
	 * @return
	 * 
	 * 		在对象前面加上@Valid注解表示该需要校验
	 */
	@RequestMapping(value = "/add/sell", method = RequestMethod.POST)
	public String addSell(@Valid Sell sell, BindingResult error, OutputStream out,ModelMap model) {

		if (error.hasErrors()) {
			return queryAddDate(model);
			// 校验到用户有错误输入，重新返回到销售录入页面
		}
		// 调用添加方法
		sellService.addSell(sell);


		hintTool.returnHintRefresh("添加成功。", out, "/query/addSellDate");
		return null;
	}


	/**
	 * 删除销售信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete/sell")
	public Map<String, Object> deleteSell(int id) {

		sellService.deleteSell(id);

		Map<String, Object> result = new HashMap();
		result.put("result", true);

		return result;
	}
	
	
	/**
	 * 转发到销售查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/query/sell", method = RequestMethod.GET)
	public String querySell() {

		return "querySell";
	}


	/**
	 * 查询销售数据
	 * 
	 * @param search
	 *            搜索的参数
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示多少条数据
	 * @return
	 */
	@RequestMapping("/query/sell/get")
	@ResponseBody
	public ResultList<Map> getRetailerData(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		List<Map> sells = sellService.querySellData(search, offset, limit);

		// 将日期转成yyyy-MM-dd格式
		for (Map sell : sells) {
			Date date = (Date) sell.get("s_date");
			String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
			sell.put("s_date", dateStr);
		}

		// 拿到数据总记录数
		int total = sellService.queryAllRecord(search);

		return new ResultList<>(sells, total);

	}


	/**
	 * 查询所有销售商名称
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ajaxQuery/retailerName", method = RequestMethod.GET)
	public List ajaxQueryRetailerName() {

		List retailerName = sellService.queryAllRetailer();

		return retailerName;
	}


}
