<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	*{margin: 0; padding: 0;}
	#div{width:350px; height:550px; margin: -275px 0; position:absolute;; top:50%;}
	ul{list-style:none;}
	li{width:180px; height:30px; text-align:center; line-height:30px; margin: 0 85px; border-radius:25px; box-shadow:1px 1px 1px #333333;}
	#div a{text-decoration:none; color:#000;}
	.head{height:40px; line-height:40px; margin-top:5px; background:#1E90FF; color:#FFFFFF; border-radius:25px;}
	.lis:after{ content: ""; background:red; width:180px; height:30px; display:none; margin-top:-30px; box-shadow:1px 1px 1px #333333; border-radius:25px; background:#87CEEB; color:#FFFFFF;}
	.lis:hover:after{ display: block;}
</style>
	<div id="div">
		<ul>
			<li class="head">手机管理</li>
			<a href="/phoneAdd"><li class="lis">手机添加</li></a>
			<a href="/QueryPhoneServlet"><li class="lis">手机查询</li></a>
		</ul>
		<ul>
			<li class="head">销售商管理</li>
			<a href="/retailerAdd"><li class="lis">销售商添加</li></a>
			<a href="/QueryRetailerServlet"><li class="lis">销售商查询</li></a>
		</ul>
		<ul>
			<li class="head">销售管理</li>
			<a href="/SellQueryTranspondServlet"><li class="lis">销售录入</li></a>
			<a href="/QuerySellServlet"><li class="lis">销售查询</li></a>
		</ul>
		<ul>
			<li class="head">销售统计</li>
			<a href="/BrandStatisticsServlet"><li class="lis">按品牌统计</li></a>
			<a href="/YearStatistics"><li class="lis">按月份统计</li></a>
			<a href="/RetailerStatisticsServlet"><li class="lis">按销售商统计</li></a>
			<a href="/AreaStatisticsServlet"><li class="lis">按区域统计</li></a>
		</ul>
	</div>