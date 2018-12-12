<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/javascript" src="jquery-1.10.2.js"></script>
<title>serializeArray()与serialize()</title>
<script type="text/javascript">
function onClik(){
  $("#results").html("serializeArray()与serialize()的区别如下：");
  var data1 = $("#form1").serializeArray(); //自动将form表单封装成json
  $("#results").append("<br/><b>serializeArray:</b>");
  $.each(data1, function(i, field){
    $("#results").append(field.name+":"+field.value+" ");
  });
  $("#results").append("<br/>");
  var data2 = $("#form1").serialize(); //自动将form表单封装成json
  $("#results").append("<b>serialize():</b>"+data2);
}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
 <p>进货人 :
  <label for="name"></label>
  <input type="text" name="name" id="name" />
 </p>
 <p>性别:
  <label for="sex"></label>
  <select name="sex" size="1" id="sex">
   <option value="男">男</option>
   <option value="女">女</option>
  </select>
 </p>
 <table width="708" border="1">
  <tr>
   <td width="185">商品名</td>
   <td width="205">商品数量</td>
   <td width="296">商品价格</td>
  </tr>
  <tr>
   <td><label for="pro_name"></label>
    <input type="text" name="pro_name" id="pro_name" /></td>
   <td><label for="pro_num"></label>
    <input type="text" name="pro_num" id="pro_num" /></td>
   <td><label for="pro_price"></label>
    <input type="text" name="pro_price" id="pro_price" /></td>
  </tr>
  <tr>
   <td><input type="text" name="pro_name2" id="pro_name2" /></td>
   <td><input type="text" name="pro_num2" id="pro_num2" /></td>
   <td><input type="text" name="pro_price2" id="pro_price2" /></td>
  </tr>
 </table>
 <p id="results"></p>
 <input type="button" name="submit" onclick="onClik();" value="提交"/>
</form>
</body>
</html>