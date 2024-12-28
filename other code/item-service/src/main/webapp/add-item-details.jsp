<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ADD Item Dtails</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="css/add-item.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
  <div class="text">
    Add Item
  </div>
  <form action="ItemController">
    <div class="form-row">

      <div class="input-data">
        <input type="text" required name="model">
        <div class="underline"></div>
        <label>Model</label>
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="type">
        <div class="underline"></div>
        <label>Type</label>
      </div>
    </div>
    <div class="form-row">
      <div class="input-data">
        <input type="text" required name="Description">
        <div class="underline"></div>
        <label>Description</label>
      </div>
    </div>
     <input type="hidden" name="action" value="ADD_ITEM_DETAILS">
    <input type="hidden" value="${param.id}" name="id">
    <input type="submit" value="Add" class="button">
  </form>

  <p class="back">
    <a href="" >Back To Items</a>
  </p>
</div>
<!-- partial -->

</body>
</html>