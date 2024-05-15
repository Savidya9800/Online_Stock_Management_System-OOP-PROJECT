<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Settings</title>
<!-- ======= Styles ====== -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&family=Roboto+Slab:wght@600&display=swap"
	rel="stylesheet">

<style>
.con {
	margin-left: 25%;
    margin-top: 3%;
    box-sizing: border-box;
    background-color: white;
    padding: 10px 50px;
    border-radius: 20px;
    box-shadow: 0 0 20px rgb(200, 200, 200);
    width: 600px;
    display: flex;
    gap: 2px;
    flex-direction: column;
    flex-wrap: wrap;
}

h1, h3 {
	font-family: "Roboto Slab";
	font-weight: 600;
}

span {
	font-weight: 500;
	font-family: "Poppins";
}


input[type="checkbox"] {
	display: none;
}

input[type="checkbox"]:checked+div .toggle-c {
	left: 30px;
	background-color: #3030;
	border-color: #30305C;
}

input[type="radio"] {
	border: 0px;
	width: 10%;
	height: 20px;
	accent-color: black;
}

.togg-label {
	display: flex;
	align-self: center;
	justify-content: space-between;
	margin:8px;
}

.flex {
	display: flex;
	gap: 5px;
}

.bottom {
	margin-top: 20px;
	margin-bottom: 30px;
}

.bottom:hover {
	text-decoration: underline;
}

label, input[type="radio"] {
	cursor: pointer;
}

.con5{
margin :5px;
}
</style>

</head>

<body>

	<!--Link Navigation Bar-->
	<%@include file="navbar.jsp"%>
	<div>
	<div class="con">
		<div>
			<h1>Settings</h1>
			<br>
		</div>
		<div>
			<div>
				<label for="togg-1" class="togg-label"> <span>Dark
						Mode</span> 
					<div>
						<button>ON</button>
						<button >OFF</button>
					</div>
				</label>
			</div>
			<div>
				<label for="togg-2" class="togg-label"> <span>Desktop
						Notification</span> 
					<div>
						<button>ON</button>
						<button>OFF</button>
					</div>
				</label>
			</div>
			<div>
				<label for="togg-3" class="togg-label"> <span>Focused
						Inbox</span> 
					<div>
						<button>ON</button>
						<button disabled>OFF</button> 
					</div>
				</label>
			</div>
		</div>
		<div>
			<h3 class="con5">Conversation View</h3>
		</div>
		<div>
			<label for="radio1" class="flex"> <input type="radio"
				name="Filter" id="radio1" checked> <span>Newest On Top</span>
			</label>
		</div>
		<div>
			<label for="radio2" class="flex"> <input type="radio"
				name="Filter" id="radio2"> <span>Newest On Bottom</span>
			</label>
		</div>
		<div>
			<label for="radio3" class="flex"> <input type="radio"
				name="Filter" id="radio3" > <span>Off</span>
			</label>
		</div>
		<div>
			<h3 class="con5">Navigation Panel</h3>
		</div>
		<div>
			<label for="radio4" class="flex"> <input type="radio"
				name="show-mode" id="radio4"> <span>Show On The Right</span>
			</label>
		</div>
		<div>
			<label for="radio5" class="flex"> <input type="radio"
				name="show-mode" id="radio5" checked> <span>Show On The Left</span>
			</label>
		</div>
		<div>
			<label for="radio6" class="flex"> <input type="radio"
				name="show-mode" id="radio6"> <span>Off</span>
			</label>
		</div>
		<div class="bottom">
			<span>View all settings....</span>
		</div>
	</div>
	</div>


	<!-- =========== Scripts =========  -->
	<script src="assets/js/main.js"></script>

	<!-- ====== ionicons ======= -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>
