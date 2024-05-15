<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation Bar</title>
<link rel="icon" type="image/jpeg"
	href="https://img.freepik.com/premium-vector/finance-diagram-business-icon-vector-illustration-template-design_658089-4418.jpg">

<style>
/* =========== Google Fonts ============ */
@import
	url("https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap")
	;

/* =============== Globals ============== */
* {
	font-family: "Ubuntu", sans-serif;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

:root {
	--blue: #2a2185;
	--white: #fff;
	--gray: #f5f5f5;
	--black1: #222;
	--black2: #999;
}

body {
	min-height: 100vh;
	overflow-x: hidden;
}

.container {
	position: relative;
	width: 100%;
}

/* =============== Navigation ================ */
.navigation {
	position: fixed;
	width: 280px;
	height: 100%;
	background: var(--blue);
	border-left: 10px solid var(--blue);
	transition: 0.5s;
	overflow: hidden;
}

.navigation.active {
	width: 80px;
}

.navigation ul {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
}

.navigation ul li {
	position: relative;
	width: 100%;
	list-style: none;
	border-top-left-radius: 30px;
	border-bottom-left-radius: 30px;
}

.navigation ul li:hover, .navigation ul li.hovered {
	background-color: var(--white);
}

.navigation ul li:nth-child(1) {
	margin-bottom: 40px;
	pointer-events: none;
}

.navigation ul li a {
	position: relative;
	display: block;
	width: 100%;
	display: flex;
	text-decoration: none;
	color: var(--white);
}

.navigation ul li:hover a, .navigation ul li.hovered a {
	color: var(--blue);
}

.navigation ul li a .icon {
	position: relative;
	display: block;
	min-width: 60px;
	height: 60px;
	line-height: 75px;
	text-align: center;
}

.navigation ul li a .icon ion-icon {
	font-size: 1.75rem;
}

.navigation ul li a .title {
	position: relative;
	display: block;
	padding: 0 10px;
	height: 60px;
	line-height: 60px;
	text-align: start;
	white-space: nowrap;
}

/* --------- curve outside ---------- */
.navigation ul li:hover a::before, .navigation ul li.hovered a::before {
	content: "";
	position: absolute;
	right: 0;
	top: -50px;
	width: 50px;
	height: 50px;
	background-color: transparent;
	border-radius: 50%;
	box-shadow: 35px 35px 0 10px var(--white);
	pointer-events: none;
}

.navigation ul li:hover a::after, .navigation ul li.hovered a::after {
	content: "";
	position: absolute;
	right: 0;
	bottom: -50px;
	width: 50px;
	height: 50px;
	background-color: transparent;
	border-radius: 50%;
	box-shadow: 35px -35px 0 10px var(--white);
	pointer-events: none;
}

/* ===================== Main ===================== */
.main {
	position: absolute;
	width: calc(100% - 300px);
	left: 300px;
	min-height: 100vh;
	background: var(--white);
	transition: 0.5s;
}

.main.active {
	width: calc(100% - 80px);
	left: 80px;
}

.topbar {
	width: 100%;
	height: 60px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 10px;
}

.toggle {
	position: relative;
	width: 60px;
	height: 60px;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 2.5rem;
	cursor: pointer;
}

.search {
	position: relative;
	width: 400px;
	margin: 0 10px;
}

.search label {
	position: relative;
	width: 100%;
}

.search label input {
	width: 100%;
	height: 40px;
	border-radius: 40px;
	padding: 5px 20px;
	padding-left: 35px;
	font-size: 18px;
	outline: none;
	border: 1px solid var(--black2);
}

.search label ion-icon {
	position: absolute;
	top: 0;
	left: 10px;
	font-size: 1.2rem;
}

.user {
	position: relative;
	width: 60px;
	height: 60px;
	border-radius: 50%;
	overflow: hidden;
	cursor: pointer;
}

.user img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	width: 111%;
	height: 111%;
}

/* ======================= Cards ====================== */
.cardBox {
	position: relative;
	width: 100%;
	padding: 20px;
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	grid-gap: 30px;
}

.cardBox .card {
	position: relative;
	background: var(--white);
	padding: 30px;
	border-radius: 20px;
	display: flex;
	justify-content: space-between;
	cursor: pointer;
	box-shadow: 0 7px 25px rgba(0, 0, 0, 0.08);
}

.cardBox .card .numbers {
	position: relative;
	font-weight: 500;
	font-size: 2.5rem;
	color: var(--blue);
}

.cardBox .card .cardName {
	color: var(--black2);
	font-size: 1.1rem;
	margin-top: 5px;
}

.cardBox .card .iconBx {
	font-size: 3.5rem;
	color: var(--black2);
}

.cardBox .card:hover {
	background: var(--blue);
}

.cardBox .card:hover .numbers, .cardBox .card:hover .cardName, .cardBox .card:hover .iconBx
	{
	color: var(--white);
}

/* ================== Order Details List ============== */
.details {
	position: relative;
	width: 100%;
	padding: 20px;
	display: grid;
	grid-template-columns: 2fr 1fr;
	grid-gap: 30px;
	/* margin-top: 10px; */
}

.details .recentOrders {
	position: relative;
	display: grid;
	min-height: 500px;
	background: var(--white);
	padding: 20px;
	box-shadow: 0 7px 25px rgba(0, 0, 0, 0.08);
	border-radius: 20px;
}

.details .cardHeader {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
}

.cardHeader h2 {
	font-weight: 600;
	color: var(--blue);
}

.cardHeader .btn {
	position: relative;
	padding: 5px 10px;
	background: var(--blue);
	text-decoration: none;
	color: var(--white);
	border-radius: 6px;
}

.details table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

.details table thead td {
	font-weight: 600;
}

.details .recentOrders table tr {
	color: var(--black1);
	border-bottom: 1px solid rgba(0, 0, 0, 0.1);
}

.details .recentOrders table tr:last-child {
	border-bottom: none;
}

.details .recentOrders table tbody tr:hover {
	background: var(--blue);
	color: var(--white);
}

.details .recentOrders table tr td {
	padding: 10px;
}

.details .recentOrders table tr td:last-child {
	text-align: end;
}

.details .recentOrders table tr td:nth-child(2) {
	text-align: end;
}

.details .recentOrders table tr td:nth-child(3) {
	text-align: center;
}

.status.delivered {
	padding: 2px 4px;
	background: #8de02c;
	color: var(--white);
	border-radius: 4px;
	font-size: 14px;
	font-weight: 500;
}

.status.pending {
	padding: 2px 4px;
	background: #e9b10a;
	color: var(--white);
	border-radius: 4px;
	font-size: 14px;
	font-weight: 500;
}

.status.return {
	padding: 2px 4px;
	background: #f00;
	color: var(--white);
	border-radius: 4px;
	font-size: 14px;
	font-weight: 500;
}

.status.inProgress {
	padding: 2px 4px;
	background: #1795ce;
	color: var(--white);
	border-radius: 4px;
	font-size: 14px;
	font-weight: 500;
}

.recentCustomers {
	position: relative;
	display: grid;
	min-height: 500px;
	padding: 20px;
	background: var(--white);
	box-shadow: 0 7px 25px rgba(0, 0, 0, 0.08);
	border-radius: 20px;
}

.recentCustomers .imgBx {
	position: relative;
	width: 40px;
	height: 40px;
	border-radius: 50px;
	overflow: hidden;
}

.recentCustomers .imgBx img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.recentCustomers table tr td {
	padding: 12px 10px;
}

.recentCustomers table tr td h4 {
	font-size: 16px;
	font-weight: 500;
	line-height: 1.2rem;
}

.recentCustomers table tr td h4 span {
	font-size: 14px;
	color: var(--black2);
}

.recentCustomers table tr:hover {
	background: var(--blue);
	color: var(--white);
}

.recentCustomers table tr:hover td h4 span {
	color: var(--white);
}

/* ====================== Responsive Design ========================== */
@media ( max-width : 991px) {
	.navigation {
		left: -300px;
	}
	.navigation.active {
		width: 300px;
		left: 0;
	}
	.main {
		width: 100%;
		left: 0;
	}
	.main.active {
		left: 300px;
	}
	.cardBox {
		grid-template-columns: repeat(2, 1fr);
	}
}

@media ( max-width : 768px) {
	.details {
		grid-template-columns: 1fr;
	}
	.recentOrders {
		overflow-x: auto;
	}
	.status.inProgress {
		white-space: nowrap;
	}
}

@media ( max-width : 480px) {
	.cardBox {
		grid-template-columns: repeat(1, 1fr);
	}
	.cardHeader h2 {
		font-size: 20px;
	}
	.user {
		min-width: 40px;
	}
	.navigation {
		width: 100%;
		left: -100%;
		z-index: 1000;
	}
	.navigation.active {
		width: 100%;
		left: 0;
	}
	.toggle {
		z-index: 10001;
	}
	.main.active .toggle {
		color: #fff;
		position: fixed;
		right: 0;
		left: initial;
	}
}

.sub-menu-wrap {
	position: absolute;
	top: 100%;
	right: 10%;
	width: 320px;
	max-height: 0px;
	overflow: hidden;
	transition: max-height 0.5s;
	ackground-color: #eee;
	position: absolute;
	z-index: 100;
	display: none;
}

}
.sub-menu-wrap.open-menu {
	max-height: 400px;
}

.sub-menu {
	background: #fff;
	padding: 20px;
	margin: 10px;
	width: -webkit-fill-available;
	background-color: #eee;
	position: fixed;
	z-index: 100;
	border-radius: 10px;
	cursor: pointer;
	box-shadow: 0 7px 25px rgba(0, 0, 0, 0.08);
	background: var(--white);
	background: var(--white);
	border: 2px solid lavender;
}

.user-info {
	display: flex;
	align-items: center;
	z-index: 100;
}

.user-info h3 {
	font-weight: 500;
}

.user-info img {
	position: sticky;
	height: 60px;
	width: 60px;
	border-radius: 50%;
	margin-right: 15px;
}

.sub-menu hr {
	border: 0;
	height: 1px;
	width: 100%;
	background: #ccc;
	margin: 15px 0 10px;
}

.sub-menu-link {
	display: flex;
	align-items: center;
	text-decoration: none;
	color: #525252;
	margin: 12px 0;
}

.sub-menu-link p {
	width: 100%;
}

.sub-menu-link img {
	width: 40px;
	background: #e5e5e5;
	border-radius: 50%;
	padding: 8px;
	margin-right: 15px;
}

.sub-menu-link span {
	font-size: 22px;
}

.sub-menu-link:hover span {
	transform: translate(5px);
}

.sub-menu-link:hover p {
	font-weight: 600;
}

#sub1 {
	margin-left: 20.5px;
}

#sub2 {
	margin-left: 5px;
}

#sub3 {
	margin-left: 23px;
}

#sub4 {
	margin-left: 16px;
}

.con8 {
	right: 12px;
	top: 10px;
	position: absolute;
}

#cProfile {
	font-size: 25px;
}

.logoutB {
	position: relative;
	padding: 3px 7px;
	background: #ff0e0e;
	text-decoration: none;
	border-radius: 6px;
	color: #ffffff;
	font-size: 15px;
	border: solid;
	margin-left: -3px;
}
</style>
</head>
<body>
	<!-- =============== Navigation ================ -->
	<div class="container">
		<div class="navigation">
			<ul>
				<li><a href="dashboard-view"> <span class="icon"> <ion-icon
								name="qr-code-outline"></ion-icon>
					</span> <span class="title">StockMagnet</span>
				</a></li>

				<li><a href="dashboard-view"> <span class="icon"> <ion-icon
								name="home-outline"></ion-icon>
					</span> <span class="title">Dashboard</span>
				</a></li>
				<li><a href="category-list"> <span class="icon"> <ion-icon
								name="list-outline"></ion-icon>
					</span> <span class="title">Category</span>
				</a></li>
				<li><a href="Product-list"> <span class="icon"> <ion-icon
								name="layers-outline"></ion-icon>
					</span> <span class="title">Product</span>
				</a></li>

				<li><a href="customer-list"> <span class="icon"> <ion-icon
								name="people-outline"></ion-icon>
					</span> <span class="title">Customers</span>
				</a></li>

				<li><a href="supplier-list"> <span class="icon"> <ion-icon
								name="duplicate-outline"></ion-icon>
					</span> <span class="title">Supplier</span>
				</a></li>

				<li><a href="purchase-list"> <span class="icon"> <ion-icon
								name="cart-outline"></ion-icon>
					</span> <span class="title">Purchase Products</span>
				</a></li>

				<li><a href="outgoing.jsp"> <span class="icon"> <ion-icon
								name="trending-up-outline"></ion-icon>
					</span> <span class="title">Outgoing Products</span>
				</a></li>

				<li><a href="setting.jsp"> <span class="icon"> <ion-icon
								name="settings-outline"></ion-icon>
					</span> <span class="title">Settings</span>
				</a></li>

				<li><a href="login.jsp"
					onclick="return confirm('Are you sure you want to sign out?');">
						<span class="icon"> <ion-icon name="log-out-outline"></ion-icon>
					</span> <span class="title">Sign Out</span>
				</a></li>
			</ul>
		</div>

		<!-- ========================= Main ==================== -->
		<div class="main">
			<div class="topbar">
				<div class="toggle">
					<ion-icon name="menu-outline"></ion-icon>
				</div>

				<div class="search">
					<label> <input type="text" placeholder="Search here">
						<ion-icon name="search-outline"></ion-icon>
					</label>
				</div>
				<div class="user">
					<img
						src="https://img.freepik.com/premium-vector/man-avatar-glasses-young_594966-9.jpg"
						class="user_pic" onclick="toggleMenu()">
					<div>
						<!--User Profile-->
						<div class="sub-menu-wrap" id="subMenu">

							<div class="sub-menu">
								<div class="con8">
									<ion-icon name="close-circle-outline" id="cProfile"
										onclick="closetoggleMenu()"></ion-icon>
								</div>
								<div class="user-info">
									<img
										src="https://img.freepik.com/premium-vector/man-avatar-glasses-young_594966-9.jpg">
									<h2 style="font-size: x-large;">Admin Profile</h2>
								</div>
								<hr>
								    <label class="sub-menu-link">Name<ion-icon name="caret-forward-outline" id="sub1"></ion-icon>											
			                   			  <% // Retrieve username from session
										    String username = (String) request.getAttribute("username"); %>
											<% if (username != null) { %>
												<h2><%= username %>!</h2>
											<% } else { %> <p>Savidya Jayalath</p> <%}%>
									</label>
									<label class="sub-menu-link">Address<ion-icon
											name="caret-forward-outline" id="sub2"></ion-icon>
											
											<% // Retrieve address from session
										    String address = (String) request.getAttribute("username"); %>
											<% if (address != null) { %>
												<h2><%= address %>!</h2>
											<% } else { %> <p>Kurunegala</p> <%}%>
											</label>
									<label class="sub-menu-link">Email<ion-icon
											name="caret-forward-outline" id="sub3"></ion-icon> 
											<% // Retrieve Email from session
										    String email = (String) request.getAttribute("username"); %>
											<% if (username != null) { %>
												<h2><%= email %>!</h2>
											<% } else { %> <p>savidyajayalath@icloud.com</p> <%}%>
											</label>
									<label class="sub-menu-link">Phone<ion-icon
											name="caret-forward-outline" id="sub4"></ion-icon>
											<% // Retrieve phone from session
										    String phone = (String) request.getAttribute("username"); %>
											<% if (username != null) { %>
												<h2><%= phone %>!</h2>
											<% } else { %> <p>+94702869800</p> <%}%>
											</label>
								<a href="login.jsp"
									onclick="return confirm('Are you sure you want to sign out?');"><button
										class="logoutB">Sign Out</button></a>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ====== ionicons ======= -->
			<script type="module"
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
			<script nomodule
				src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

			<!-- Admin profile menu wrap -->
			<script> 
			function toggleMenu() {
				document.getElementById("subMenu").style.display = "block";
				//let subMenu = document.getElementById("subMenu");
				//subMenu.classList.toggle("open-menu");
			}
			
			function closetoggleMenu(){
				document.getElementById("subMenu").style.display = "none";				
			}
	<!-- add hovered class to selected list item -->
	let list1 = document.querySelectorAll(".navigation li");

	function activeLink() {
  	list1.forEach((item) => {
   	 item.classList.remove("hovered");
  	});
  	this.classList.add("hovered");
	}

	list1.forEach((item) => item.addEventListener("mouseover", activeLink));

	<!-- Menu Toggle -->
	let toggle = document.querySelector(".toggle");
	let navigation = document.querySelector(".navigation");
	let main = document.querySelector(".main");

	toggle.onclick = function () {
	  navigation.classList.toggle("active");
	  main.classList.toggle("active");
	};
</script>
</body>
</html>