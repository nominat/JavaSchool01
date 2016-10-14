<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 10-Oct-16
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Admin Configuration page</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="/jumbotron.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <![endif]-->
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Java school project</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</div>


<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-2">
            <h3>Create new city</h3>
            <div>
                <p><input type="text"  class="form-control"  name="cityName" value="" placeholder="city name"></p>
                <button onclick="addNewCity()" class="btn btn-primary">Add City</button>
                <p> <div id="addCityResult"> </div> </p>
            </div>
        </div>
        <div class="col-md-2">
            <h3>Set distance between cities</h3>
                <div id="loading"> <img src="img/spin.gif"> </div>
                <p><select name="cityName1" class="form-control hide" size="1"> </select> </p>
                <p><select name="cityName2" class="form-control hide" size="1"> </select> </p>
                <!--<p><input type="text"  class="form-control" name="cityName1" value="" placeholder="city 1 name"></p>
                <p><input type="text"  class="form-control" name="cityName2" value="" placeholder="city 2 name"></p> -->
                <p><input type="text"  class="form-control  hide" name="distance" value="" placeholder="Distance between cities"></p>
            <button onclick="addNewCityMap()" class="btn btn-primary">Add City</button>
                <p> <div id="addCityMapResult"> </div> </p>
        </div>
        <div class="col-md-2">
            <h3>Create new driver status</h3>
            <div>
                <p><input type="text"  class="form-control"  name="driverStatus" value="" placeholder="Driver Status"></p>
                <button onclick="addNewDriverStatus()" class="btn btn-primary">Add driver status</button>
                <p> <div id="addDriverStatus"> </div> </p>
            </div>
        </div>
        <div class="col-md-2">
            <h3>Create new cargo status</h3>
            <div>
                <p><input type="text"  class="form-control"  name="cargoStatus" value="" placeholder="Cargo Status"></p>
                <button onclick="addNewCargoStatus()" class="btn btn-primary">Add cargo status</button>
                <p> <div id="addCargoStatus"> </div> </p>
            </div>
        </div>
        <div class="col-md-2">
            <h3>Create new truck status</h3>
            <div>
                <p><input type="text"  class="form-control"  name="truckStatus" value="" placeholder="Truck Status"></p>
                <button onclick="addNewTruckStatus()" class="btn btn-primary">Add truck status</button>
                <p> <div id="addTruckStatus"> </div> </p>
            </div>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; Ilya Nominat</p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="js/requests.js"></script>
<script>
    $.get("/html/GetCities",
        function (data) {
            var selectOptions = [];
            for (var i=0, len = data.cities.length; i< len; i++) {
                selectOptions.push('<option>' + data.cities[i] + '</option>');
            }
            $("select[name = 'cityName1']").html(selectOptions.join(''));
            $("select[name = 'cityName2']").html(selectOptions.join(''));
            $('#loading').addClass('hide');
            $("select[name = 'cityName1']").removeClass('hide');
            $("select[name = 'cityName2']").removeClass('hide');
            $("input[name = 'distance']").removeClass('hide');
        }, "json");
</script>

</body>
</html>