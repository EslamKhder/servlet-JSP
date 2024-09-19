<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Update Item</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Update Item
  </div>
  <form action="ItemController">
    <div class="form-row">
      
      <div class="input-data">
        <input type="text" name="nameItem" value="${existedItem.name}" required>
        <div class="underline"></div>
        <label>Name</label>
      </div>
      <div class="input-data">
        <input type="text" name="price" value="${existedItem.price}" required>
        <div class="underline"></div>
        <label>PRICE</label>
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" name="totalNumber" value="${existedItem.totalNumber}" required>
        <div class="underline"></div>
        <label>TOTAL_NUMBER</label>
      </div>

    </div>
    
    <input type="hidden" name="id" value="${existedItem.id}">
    <input type="hidden" name="action" value="UPDATE">
    
    <input type="submit" value="Update" class="button">
  </form>

  <p class="back">
    <a href="ItemController" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>