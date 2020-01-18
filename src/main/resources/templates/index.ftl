<!DOCTYPE html>
<html>
<body>
  <div class="starter-template">
     
			<h2>连接数据库 </h2>
			<form name="form"   action="login" method="POST"> <!-- 3 -->
				<div class="form-group">
					<label for="driver">链接地址</label>
					<input type="text" class="form-control" name="url" value="" placeholder="用户名称" />
				</div>
				<div class="form-group">
					<label for="driver">端口</label>
					<input type="text" class="form-control" name="port" value="" placeholder="用户名称" />
				</div>
				<div class="form-group">
					<label for="driver">数据库名称</label>
					<input type="text" class="form-control" name="dataName" value="" placeholder="用户名称" />
				</div>
				<div class="form-group">
					<label for="username">用户名</label>
					<input type="text" class="form-control" name="username" value="" placeholder="用户名称" />
				</div>
				<div class="form-group">
					<label for="password">密码</label>
					<input type="password" class="form-control" name="password" placeholder="密码" />
				</div>
				<input type="submit" id="login" value="Login" class="btn btn-primary" />
			</form>
      </div>
</body>
</html>