<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>��й�ȣ Ȯ��</title>
	<link rel="stylesheet" href="/StrutsBoard/board/common/css/css.css" type="text/css">
	<script type="text/javascript">
	function locationURL(){
		if(widow.name=='modify')
			widow.opener.parent.location.href='modifyForm.action?no=<s:property value="no"/>&currentPage=<s:property value="currentPage"/>';
			else if(window.name == 'delete')
				{
				alert('�����Ǿ����ϴ�.');
				window.opener.parent.location.href='deleteAction.action?no=<s:property value="no"/>&currentPage=<s:property value="currentPage"/>';
				
				}
		window.close();
	}
	</script>
</head>
<body>

</body>
</html>