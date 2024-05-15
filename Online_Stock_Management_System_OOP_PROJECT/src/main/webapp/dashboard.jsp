<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>StockMagnet - Stock Management System</title>

</head>

<body>
	<!--Link Navigation Bar-->
	<%@include file="navbar.jsp"%>

	<!-- ======================= Cards ================== -->
	<div class="cardBox">
		<a href="#" style="text-decoration: none;">
			<div class="card">
				<div>
					<div class="numbers">1,504</div>
					<div class="cardName">Daily Views</div>
				</div>

				<div class="iconBx">
					<ion-icon name="eye-outline"></ion-icon>
				</div>
			</div>
		</a> <a href="Product-list" style="text-decoration: none;">
			<div class="card">
				<div>
					<div class="numbers">68</div>
					<div class="cardName">Purchase Products</div>
				</div>

				<div class="iconBx">
					<ion-icon name="cart-outline"></ion-icon>
				</div>
			</div>
		</a> <a href="#" style="text-decoration: none;">
			<div class="card">
				<div>
					<div class="numbers">284</div>
					<div class="cardName">Comments</div>
				</div>

				<div class="iconBx">
					<ion-icon name="chatbubbles-outline"></ion-icon>
				</div>
			</div>
		</a> <a href="#" style="text-decoration: none;">
			<div class="card">
				<div>
					<div class="numbers">$7,842</div>
					<div class="cardName">Earning</div>
				</div>

				<div class="iconBx">
					<ion-icon name="cash-outline"></ion-icon>
				</div>
			</div>
		</a>
	</div>

	<!-- ================ Order Details List ================= -->
	<div class="details">
		<div class="recentOrders">
			<div class="cardHeader">
				<h2>Recent Orders</h2>
				<a href="purchase-list" class="btn">View All</a>
			</div>

			<table style="margin-top: -100px;">
				<thead>
					<tr>
						<td>Name</td>
						<td>Price</td>
						<td>Payment</td>
						<td>Status</td>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>Cosmetic</td>
						<td>$1200</td>
						<td>Paid</td>
						<td><span class="status delivered">Delivered</span></td>
					</tr>

					<tr>
						<td>Laptop</td>
						<td>$110</td>
						<td>Due</td>
						<td><span class="status pending">Pending</span></td>
					</tr>

					<tr>
						<td>Shirt</td>
						<td>$1200</td>
						<td>Paid</td>
						<td><span class="status return">Return</span></td>
					</tr>

					<tr>
						<td>Apple Watch</td>
						<td>$620</td>
						<td>Due</td>
						<td><span class="status inProgress">In Progress</span></td>
					</tr>

					<tr>
						<td>Pencil</td>
						<td>$1200</td>
						<td>Paid</td>
						<td><span class="status delivered">Delivered</span></td>
					</tr>

					<tr>
						<td>Chairs</td>
						<td>$110</td>
						<td>Due</td>
						<td><span class="status pending">Pending</span></td>
					</tr>

					<tr>
						<td>Liquors</td>
						<td>$1200</td>
						<td>Paid</td>
						<td><span class="status return">Return</span></td>
					</tr>

					<tr>
						<td>Addidas Shoes</td>
						<td>$620</td>
						<td>Due</td>
						<td><span class="status inProgress">In Progress</span></td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- ================= New Customers ================ -->
		<div class="recentCustomers">
			<div class="cardHeader">
				<h2>Recent Customers</h2>
			</div>

			<table>
				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/young-smiling-man-adam-avatar-3d-vector-people-character-illustration-cartoon-minimal-style_365941-687.jpg"
								alt="img">
						</div>
					</td>
					<td>
						<h4>
							Rohan<br> <span>India</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/happy-young-woman-watching-into-rounded-frame-isolated-white-illustration-render-style_365941-118.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Sofia<br> <span>Italy</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/3d-vector-diversity-young-man-avatar-icon-design_624031-151.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Matteo<br> <span>Italy</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/portrait-brunette-woman-avatar-female-person-vector-icon-adult-flat-style_605517-159.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Emily<br> <span>America</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/young-handsome-man-illustration_632498-25.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Jacob <br> <span>America</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/portrait-caucasian-woman-avatar-female-person-vector-icon-adult-flat-style-headshot_605517-25.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Gianna<br> <span>Italy</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/portrait-caucasian-woman-avatar-female-person-vector-icon-adult-flat-style-headshot_605517-26.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Arjun<br> <span>India</span>
						</h4>
					</td>
				</tr>

				<tr>
					<td width="60px">
						<div class="imgBx">
							<img
								src="https://img.freepik.com/premium-vector/frozen-queen-cartoon-avatar-game-character-young-white-haired-beautiful-woman-portrait-big-blue-anime-eyes-vector_526395-193.jpg"
								alt="">
						</div>
					</td>
					<td>
						<h4>
							Olivia<br> <span>America</span>
						</h4>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</div>
	</div>
	<script>
 // JavaScript code
    let list = document.querySelectorAll(".navigation li");

    function activeLink() {
        // Remove .hovered class from all list items
        list.forEach((item) => {
            item.classList.remove("hovered");
        });
        // Add .hovered class to the clicked list item
        this.classList.add("hovered");
    }

    // Add event listener to each list item
    list.forEach((item) => item.addEventListener("click", activeLink));

    </script>


</body>
</html>