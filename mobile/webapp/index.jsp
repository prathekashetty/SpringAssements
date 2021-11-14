<html>
<body>
<h2>Hello World!</h2>
</body>
<a href="updatePrice.jsp"><button>update price</button></a>
<a href="updateAvailability.jsp"><button>update availability</button></a>
<a href="getByPrice.jsp"><button>Get By price</button></a>
<a href="getByBrand.jsp"><button>Get By Brand</button></a>
<form action="save" method="post">
Brand Name: <input type="text" id="brandName" name="brandName"/>
<br>Type: <input type="text" id="type" name="type"/>
<br>RAM: <input type="number" id="ram" name="ram"/>
<br>ROM: <input type="number" id="rom" name="rom"/>
<br>Model Number: <input type="number" id="modelNumber" name="modelNumber"/>
<br>Price: <input type="number" id="price" name="price"/>
<br>Model Name: <input type="text" id="modelName" name="modelName"/>
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