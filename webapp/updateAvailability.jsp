<html>
<body>
<h2>Hello World!</h2>
</body>
<a href="updatePrice.jsp"><button>update price</button></a>
<a href="updateAvailability.jsp"><button>update availability</button></a>
<a href="getByPrice.jsp"><button>Get By price</button></a>
<a href="getByBrand"><button>Get By Brand</button></a>
<form action="update-availability" method="post">
<br>Model Number: <input type="number" id="modelNumber" name="modelNumber"/>
<br>
Availability: 
<br>
  <input type="checkbox" id="vehicle1" name="availability" value="true">
  <label for="vehicle1">True</label><br>
  <input type="checkbox" id="vehicle2" name="availability" value="false">
  <label for="vehicle2">False</label><br>
<button type="submit" value="Submit">Submit</button>
<button type="reset" value="Reset">Reset</button>
</form>
</html>