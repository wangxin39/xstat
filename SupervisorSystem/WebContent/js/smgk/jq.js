/* 选择网站时显示下拉菜单 */
function checkNet(){
	jQuery('pickNet').style.background = '#68a8e2';
	jQuery('pickNet').style.color = '#fff';
	jQuery('nets').style.display = 'block';
}

function checkedNet(){
	jQuery('pickNet').style.background = '#fff';
	jQuery('pickNet').style.color = '#000';
	jQuery('nets').style.display = 'none';
}

/* 选择具体网站时候鼠标经过和out时候相关 */
function eNet(netId){
	var netStyle = jQuery(netId).style;
	netStyle.background = '#cccccc';
	netStyle.color = '#fff';
}

function outNet(netId){
	var netStyle = jQuery(netId).style;
	netStyle.background = '#fff';
}

/* 点击相关网站的时候触发的函数 */
function everyNet(netId,oid,netName){
	jQuery.post("./ajaxtag.php",{cid:""+netId+"",oid:""+oid+""},function(data){
		if(data.length > 0){
			jQuery('#tag').html(data);
			jQuery('#whatNet').html(netName);
		}
	});
}

/* 展开全文 */
var info;
function unf(icon,con,tid,dcon){
	info = dcon;
	jQuery("#"+icon).hide(2000);
	jQuery("#"+con).show(2000);
	startLoad(dcon);
	jQuery.post("ajaxcontent.php",{tid:""+tid+""},function(data){
		if(data.length > 0){
			jQuery("#"+dcon).html(data);
		}
	});
}

function startLoad(d){
	jQuery("#"+d).ajaxStart(function(){
    	if(info == d){
			var start = "<div style='width:150px;height:40px;margin-left:180px;'>"+
							"<div style='width:24px;height:24px;float:left;margin-top:5px;'><img src='./images/loading.gif'></div>"+
							"<div class='start'>正在加载,请稍候...</div></div>";
			jQuery("#"+d).html(start);
    	}
	}).ajaxStop(function(){
	});
}

/* 收起全文 */
function f(icon,con){
	jQuery("#"+con).hide(2000);
	jQuery("#"+icon).show(2000);
}

/* 标签左右移动 */
function scroll_left(){
	jQuery('scroll_div').scrollLeft += 10;
}
function scroll_right(){
	jQuery('scroll_div').scrollLeft -= 10;
}

