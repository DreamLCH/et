package com.easytop.psm.web.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easytop.psm.service.PhoneService;
import com.easytop.psm.service.RetailerService;
import com.easytop.psm.service.SellService;
import com.easytop.psm.utils.HintTool;
import com.easytop.psm.utils.Paging;
import com.easytop.psm.utils.ResultList;

/**
 * 
 * @author 梁琛华
 * @version 1.0
 *
 *          报表统计控制层
 */
@Controller
public class ReportFormStatisticsController {

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

	// 分页工具类
	@Autowired
	private Paging paging;

	
	
	/**
	 * 转发到按品牌统计
	 * 
	 * @return 转发到brandStatistics.JSP页面
	 */
	@RequestMapping(value = "/brandStatistics", method = RequestMethod.GET)
	public String brandStatistics() {

		return "brandStatistics";
	}



	/**
	 * 查询按品牌统计的表格数据
	 * 
	 * @param brand
	 *            品牌
	 * @param year
	 *            年份
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示多少条数据
	 * @return
	 */
	@RequestMapping("/query/brandStatistics")
	@ResponseBody
	public ResultList<Map> getRetailerData(@RequestParam(name = "brand", defaultValue = "华为") String brand,
			@RequestParam(name = "year", defaultValue = "2018") String year,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		List<Map> sells = sellService.queryAllSell(brand, year, offset, limit);

		// 将日期转成yyyy-MM-dd格式
		for (Map sell : sells) {
			Date dates = (Date) sell.get("s_date");
			String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(dates);
			sell.put("s_date", dateStr);
		}

		// 拿到数据总记录数
		int total = sellService.queryAllSellRecord(brand, year);

		return new ResultList<>(sells, total);

	}


	/**
	 * 查询报表图形需要显示的数据
	 * 
	 * @param brand
	 *            手机品牌
	 * @param year
	 *            日期（年份）
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/statisticsData", method = RequestMethod.GET)
	public Map queryStatisticsData(String brand, String year) {

		ArrayList phoneType = sellService.queryPhoneType(brand, year);
		Map sellMap = sellService.queryTypeNumber(phoneType, year);

		return sellMap;
	}

	
	
	/**
	 * 转发到按年份统计页面
	 * 
	 * @return 转发到yearStatistics.JSP页面
	 */
	@RequestMapping(value = "/yearStatistics", method = RequestMethod.GET)
	public String yearStatistics(String year, ModelMap model) {
		return "yearStatistics";
	}
	
	
	/**
	 * 按年份统计
	 * 
	 * @param year
	 *            日期（年份）
	 */
	@ResponseBody
	@RequestMapping(value = "/ajax/yearStatistics", method = RequestMethod.GET)
	public List ajaxYearStatistics(String year) {

		/**
		 * 判断变量是否为空，如果为空设置默认值
		 */
		if (year == null || year.equals("")) {
			year = "2018";
		}

		// 查询页面显示所需的数据
		ArrayList list = sellService.queryAllBrand();
		List sellList = sellService.queryAllNum(list, year);

		return sellList;
	}
	


	/**
	 * 按销售商统计转发页面
	 * 
	 * @return 转发到retailerStatistics.JSP页面
	 */
	@RequestMapping(value = "/retailerStatistics", method = RequestMethod.GET)
	public String retailerStatistics() {
		return "retailerStatistics";
	}
	
	

	/**
	 * 查询按销售商统计数据
	 * 
	 * @param year
	 *            年份
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示多少条数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/retailerStatistics", method = RequestMethod.GET)
	public ResultList<Map> queryRetailerStatistics(@RequestParam(name = "year", defaultValue = "2018") String year,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		// 查询页面显示所需的数据
		ArrayList list = sellService.querySalesVolume(year, offset, limit);

		// 拿到数据总记录数
		int total = sellService.queryAllRetailerRecord(year);

		return new ResultList<>(list, total);
	}


	/**
	 * 按区域统计转发页面
	 * 
	 * @return 转发到areaStatistics.JSP页面
	 */
	@RequestMapping(value = "/areaStatistics", method = RequestMethod.GET)
	public String areaStatistics() {
		return "areaStatistics";
	}


	/**
	 * 按区域统计
	 * 
	 * @param year
	 *            年份
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            显示多少条数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/areaStatistics", method = RequestMethod.GET)
	public ResultList<Map> queryAreaStatistics(@RequestParam(name = "year", defaultValue = "2018") String year,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "5") int limit) {

		// 查询页面显示所需的数据
		ArrayList list = sellService.queryAllArea(year, offset, limit);

		// 拿到数据总记录数
		int total = sellService.queryAllAreaRecord(year);

		return new ResultList<>(list, total);
	}



	/**
	 * 中英文切换转发方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mid")
	public String mid() {
		return "redirect:/query/phone";
	}



	/**
	 * 用戶重复提交,给弹框提示
	 * 
	 * @param out
	 * @return
	 */
	@RequestMapping(value = "/repeatSubmit")
	public String repeatSubmit(OutputStream out) {
		hintTool.returnHint("请勿重复提交。", out);
		return null;
	}
}
