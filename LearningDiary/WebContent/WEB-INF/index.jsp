<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Learning Diary</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>
<style>
#heading {
	color: blue;
	text-align: center;
	font-family: cursive;
	font-size: 50px;
}

#row2 {
	text-align: center;
}
</style>
</head>

<body id="body_layout">
	<%@ include file="/WEB-INF/navbar.jsp"%>
	<div class="outerbody">
		<div id="heading">
			<p
				style="font-size: xx-large; font-family: sans-serif; font-stretch: extra-expanded; color: blue; font-weight: bolder;">

				LearningDiary</p>
		</div>

		<div class="row">
			<div class="col-md-2">
				<!-- <img src="images/book-tree.jpg" width="250px" height="650px"> -->
			</div>
			<div class="col-md-8" id="row2">
				<h3>Welcome to the LearningDiary!</h3>
				<br>
				<p style="text-align: justify;">

					<strong>What?</strong> One stop place to keep track of takeaways
					from your reading (both hard and digital). This is radically
					different than pure note taking or highlighting. For example, one
					book read by 5 folks can have five different learnings because it
					is very personal to each one of them as everybody sees the world
					differently. <br>
					<br> <strong>How?</strong> Securely organize and manage
					learnings in your personal online account. <br>
					<br> <strong>Why?</strong> Reflections of learnings from your
					reading gives you a very personal experience that can you go and
					revisit over time or reading them again. <br>
					<br>
					<a href="/LearningDiary/signup" style="color: blue;"> CLICK HERE TO SIGN-UP FOR FREE </a>
					 We will help you to keep your learnings organized by books and category. 
					<!--  LearningDiary does not have
					limitations to have category and books. <br> <br> Each
					Category track number of books you own as count. If you decide to
					delete category please make sure category is empty. <br> <br> -->
					

				</p>

			</div>
			<div class="col-md-2">
				<!-- <img src="images/book-tree.jpg" width="250px" height="650px" > -->
			</div>
		</div>
		<!-- rows div -->

		<div>
			<%@ include file="/WEB-INF/footer.jsp"%>
		</div>
	</div>
	<!-- end of index_outerbody div -->
</body>
</html>