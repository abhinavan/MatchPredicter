<!DOCTYPE HTML>

<html>
	<head>
		<title>Elements - Broadcast by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="subpage">
	
	
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
		<!-- Header -->
			<header id="header">
				<h1><a href="#">MATCH PREDICTER <span>by abhinav_an</span></a></h1>
				<a href="#menu">Menu</a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="index.html">Home</a></li>
					<li><a href="generic.html">Generic</a></li>
					<li><a href="elements.html">Elements</a></li>
				</ul>
			</nav>

		<!-- Main -->
	
			<div id="main">
			
				<%
					HttpSession userSession=request.getSession(false);
					String uname=(String)userSession.getValue("uname");
				%>
				<h4>Welcome <%=uname%></h4>
							
								<h3 align="center">FILL TEAMS</h3>
								

							<!-- Form -->				
								<form method="post" action="TeamController">
									<div class="row uniform">
										<div class="6u 12u$(xsmall)">
											<input type="text" name="fteam" id="fteam" value="" placeholder="FIRST TEAM" />
										</div>
										<div class="6u$ 12u$(xsmall)">
											<input type="text" name="steam" id="steam" value="" placeholder="SECOND TEAM" />
										</div>
									<div class="6u 12u$(xsmall)">
											<select name="stadium">
												<option value="wankhede stadium">Wankhede Stadium</option>
												<option value="chinnaswamy stadium">Chinnaswamy Stadium</option> 
												<option value="pune international cricket stadium">Pune International Cricket Stadium</option>
												<option value="rajiv gandhi international stadium">Rajiv Gandhi International Stadium</option>
											</select>
										</div>
										<div class="12u$">
											<ul class="actions">
												<li><input type="submit" value="START PREDICTION"/></li>
												<li><input type="reset" value="RESET" class="alt"/></li>
											</ul>
										</div>
									</div>
								</form>
				
							


		
				


	</body>
</html>