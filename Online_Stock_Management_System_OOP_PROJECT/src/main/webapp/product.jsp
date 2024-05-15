<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product</title>

<style>

/*Supplier.css*/
.button1, .button2, .button3 {
	display: inline-flex;
	height: 40px;
	padding: 0px -10px;
	background: #009578;
	border: none;
	border-radius: 5px;
	overflow: hidden;
	font-family: 'Quicksand', sans-serif;
	font-size: 16px;
	font-weight: 500;
	cursor: pointer;
	margin: 10px 1px 30px 10px;
	width: 220px;
	overflow: hidden !important;
}

.button1 :hover {
	background: #008168;
}

.button1 :active {
	background: #006e58;
}

.button2 {
	background: #ff4023;
}

.button2 :hover {
	background: #e11c0eeb;
}

.button2 :active {
	background: #cf291deb;
}

.button3 {
	background: #209ee0;
}

.button3 :hover {
	background: #1d8bc7;
}

.button3 :active {
	background: #186894;
}

.button__text, .button__icon {
	display: inline-flex;
	align-items: center;
	padding: 0 24px;
	color: #fff;
	height: 100%;
}

.button__icon {
	font-size: 1.5em;
	background-color: rgb(0, 0, 0, 0.08);
}

.container2 {
	position: relative;
	display: flex;
	flex-direction: column;
}

.box {
	position: relative;
	min-height: 500px;
	background: var(--white);
	padding: 20px;
	margin: 20px;
	margin-top: 10px;
	box-shadow: 0 7px 25px rgba(0, 0, 0, 0.12);
	border-radius: 20px;
}

h2 {
	font-weight: 600;
	font-size: 28px;
	color: var(--blue);
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}

th {
	background-color: #f2f2f2;
	color: #333;
}

/* CSS for the popup form */
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #fefefe;
	margin: 13% 25% 13% 35%;
	padding: 20px;
	border: 1px solid #888;
	width: 36%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-top: 10px;
}

input[type="text"], input[type="email"], input[type="tel"] {
	margin-bottom: 10px;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.btn-success {
	padding-top: 8px;
	transform: translate(-25px, 10px);
	width: 150px;
	height: 58px;
	color: #ffffff;
	text-decoration: none;
}

.navigation ul li a .icon {
	top: 15px;
}

.btn_E {
	position: relative;
	padding: 3px 7px;
	background: var(--blue);
	text-decoration: none;
	color: var(--white);
	border-radius: 6px;
	font-size: 16px;
}

.btn_D {
	position: relative;
	padding: 3px 7px;
	background: #ff4023;
	text-decoration: none;
	border-radius: 6px;
	color: #ffffff;
	font-size: 15px;
}
</style>
</head>

<body>
	<!--Link Navigation Bar-->
	<%@include file="navbar.jsp"%>

	<h2>&nbsp; &nbsp; &nbsp;List of Products</h2>
	<div class="container2">
		<div class="box">

			<!--Add suppliers button-->
			<button type="button" class="button1">
				<span class="button__icon"><ion-icon name="add-outline"></ion-icon></span>
				<span class="button__text"><a href="newProduct"
					class="btn-success">Add Product</a></span>
			</button>

			<!-- Table that contains supplier data -->
			<table id="supplierTable">
				<!-- Table content goes here -->
			</table>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>category</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct}">

						<tr>
							<td><c:out value="${product.id}" /></td>
							<td><c:out value="${product.name}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><c:out value="${product.qty}" /></td>
							<td><c:out value="${product.category}" /></td>
							<td><a href="editProduct?id=<c:out value='${product.id}' />"
								class="btn_E">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteProduct?id=<c:out value='${product.id}' />"
								class="btn_D" onclick="return confirmDelete(${product.id})">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script>
	function confirmDelete(id) {
        var result = confirm("Are you sure you want to delete this product?");
        if (result) {
            // Proceed with deletion
            window.location.href = "deleteproduct?id=" + id;
            return true; // Allow default behavior (deletion)
        } else {
            // Cancel deletion
            return false; // Prevent default behavior (deletion)
        }
    }
	</script>
</body>
</html>
