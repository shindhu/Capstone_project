<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>LearningDiary:AddBookByCategory</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	
	<div id="outerbody_table"> 
		<form action="addBookByCategory" method = "post">
			<input type="hidden" name="action" value="add-bookbycategory">
			
			 <div class="form-group">
				<label>Category ID</label><br>
				<input class="form-control" style="width:500px" type="text" name="category_id" value="${category.id }" ><br> 
			</div>
			
			 <%--<div class="from-group">
				<label>Category Name</label><br>
				<input class="form-control" style="width:500px" type="text" name="category_name" value="${ }" required placeholder="Category Name"><br>
				
				<c:out value="${categories}"></c:out>	
			</div> --%>

			<div class="from-group">	
				<label>Image</label>
				<input class="form-control" style="width:500px; font-size: 20;" type="text" name="image" value="${book.image }" placeholder="Paste the book image link from your browser"><br>
			</div>
			
			<div class="from-group">	
				<label>Name</label>
				<input class="form-control" style="width:500px; font-size: 20;" type="text" name="name" value="${book.name }" required placeholder="Book Title "><br>
			</div>
			
			<div class="from-group">	
				<label>Book Format</label>
				<input class="form-control" style="width:500px; font-size: 20;" type="text" name="book_format" value="${book.book_format }" placeholder="Book Format"><br>
			</div>
			
			<div class="from-group">	
				<label>Notes</label>
				<textarea class="form-control" style="width:1000px; font-size: 20;" rows="10"  name="notes" value="${book.notes }" placeholder="Your Notes"></textarea><br>
			</div>
			
			<label>&nbsp; </label>
			<input class="btn btn-primary active" type="submit" value="Save Book" id="submit">		
		</form>
		
	</div>
	
	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
	
</body>
</html>
