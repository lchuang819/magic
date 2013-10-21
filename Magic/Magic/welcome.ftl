<style type="text/css">
        #the-table { border:1px solid #bbb;border-collapse:collapse;font:normal 12px tahoma, arial, helvetica, sans-serif; }
        #the-table td,#the-table th { border:1px solid #ccc;border-collapse:collapse;padding:5px; }
</style>

<table align="center" width="80%">
<tr height=100>
	<td align="center" valign="top">
	</td>
</tr>
<tr>
	<td align="center" valign="top">
		<table id="the-table" width="60%">
		<tbody>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">您登陆的账号:</td><td width="70%" align="left" bgcolor="#ffffff">${userInfo.userLoginId?default('')}</td></tr>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">&#24744;&#30340;&#35282;&#33394;&#20026;:</td><td width="70%" align="left" bgcolor="#ffffff">[角色]</td></tr>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">您上次登陆的IP地址:</td><td width="70%" align="left" bgcolor="#ffffff">${userInfo.lastClientIpAddress?default('')}</td></tr>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">您本次登陆的IP地址:</td><td width="70%" align="left" bgcolor="#ffffff">${userInfo.clientIpAddress?default('')}</td></tr>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">您上次登陆本系统的时间:</td><td width="70%" align="left" bgcolor="#ffffff">${userInfo.lastLoginDate?default('')}</td></tr>
			<tr><td width="30%" align="left" bgcolor="#f3f3f3">您上次退出本系统的时间:</td><td width="70%" align="left" bgcolor="#ffffff">${userInfo.lastLogoutDate?default('')}</td></tr>
		</tbody>
		</table>
	</td>
</tr>
</table>