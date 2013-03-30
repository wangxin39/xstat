	window.onload = function() {				
		setInterval(updateShowTime,1000); 
	}	
	function updateShowTime() {
		var now = new Date();
		var year = now.getYear();
		var month = (now.getMonth()+1);
		var day = now.getDate();
		var hours = now.getHours();
		var minutes = now.getMinutes();
		var seconds = now.getSeconds();

		var s = "当前时间:"+year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
		document.getElementById('showtime').innerHTML = s;
	}