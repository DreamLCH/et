

/**
 * 封装好的创建tr td的函数
 * 
 * @param jsObject	json转换的js对象
 * @param table		tbody标签对象
 * @param arr		数组，里面装着不需要显示的字段名称
 * @returns
 */
function setupTr(jsObject,table,arr,methods,url){
	//将tbody里的tr全部清空，不然数据会叠加
	table.html("");
	
	//循环遍历jsObject对象，获取集合里面的对象
	for (var i = 0; i < jsObject.length; i++) {

		var obj = jsObject[i];

		//创建tr设置样式
		var tr = $("<tr bgcolor='#FFFFFF' height=30 align='center'></tr>");

		
		//通过for in创建td标签，并把td添加到tr中
		for (let index in obj) {
			var is = true;
			//当对象字段里有不需要显示的字段时，把is设置为false，不创建td
			for(var j=0; j<arr.length; j++){
				if (index == arr[j]){
					is=false;
				}
			}
			//is为true时创建td
			if (is){
				tr.append("<td>"+obj[index]+"</td>");
			}
		}
		
		if(methods!=null){
			//再创建一个空的td加入到tr中对应表头的操作
			var deleteTd = $("<td class='a'>删除</td>");
			tr.append(deleteTd);
			
			deleteTd.bind("click",{content:obj,tr:tr},function(e){
				url = url+"?id="+e.data.content.id;
				$.getJSON(url,function(data){
					alert("删除成功。");
					methods(null);
				});
				
				e.data.tr.remove();
			});
		}
		 
		//把tr加入到tbody中
		table.append(tr);
	}
}



/**
 * 封装的setupOption函数，用于创建下拉框option
 * 
 * @param url	请求地址
 * @param selectId	下拉框select的id属性
 * @returns
 */
function setupOption(url,selectId){
	$.getJSON(url,function(jsObject) {
		
		var select = $("#"+selectId);
		
		select.html("");
		
		for(var brandName in jsObject){
			select.append("<option>"+jsObject[brandName]+"</option>");
		}
		
	})
}



