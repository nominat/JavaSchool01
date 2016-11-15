function addNewCity() {
    var newCityName = $("input[name = 'cityName']").val();

    $.ajax( {
        type: "POST",
        url:"/html/AddCity",
        data: "cityName=" + newCityName,
        dataType: "json",
        success : function (data) {
            if (data.success == true) {
                $("#addCityResult").text( data.cityName + " added successfull.");
                $("select[name = 'cityName1']").append($('<option>', { text: data.cityName }));
                $("select[name = 'cityName2']").append($('<option>', { text: data.cityName }));
            } else {
                $("#addCityResult").text( data.cityName + " already exists.");
            }
        }
    } );
}

function addNewCityMap() {
    var cityName1 = $("select[name = 'cityName1'] option:selected").text();
    var cityName2 = $("select[name = 'cityName2'] option:selected").text();
    var distance = $("input[name = 'distance']").val();

    var dataToSend = "cityName1=" + cityName1 + "&cityName2=" + cityName2 + "&distance=" + distance;
    $.ajax({
        type: "POST",
        url: "/html/AddDistance",
        data: dataToSend,
        dataType: "json",
        success: function (data) {
            if (data.success == true) {
                $("#addCityMapResult").text(data.cityMap + " added successfull.");
            } else {
                $("#addCityMapResult").text(data.cityMap + " already exists.");
            }
        }
    });
}

function addNewDriverStatus() {
    var newDriverStatus = $("input[name = 'driverStatus']").val();

    $.ajax( {
        type: "POST",
        url:"/html/AddDriverStatus",
        data: "driverStatus=" + newDriverStatus,
        dataType: "json",
        success : function (data) {
            $("#addDriverStatus").text( data.created + " added successfull.");
        }
    } );
}

function addNewCargoStatus() {
    var newCargoStatus = $("input[name = 'cargoStatus']").val();

    $.ajax( {
        type: "POST",
        url:"/html/CargoStatus",
        data: "cargoStatus=" + newCargoStatus,
        dataType: "json",
        success : function (data) {
            $("#addCargoStatus").text( data.created + " added successfull.");
        }
    } );
}

function addNewTruckStatus() {
    var newTruckStatus = $("input[name = 'truckStatus']").val();

    $.ajax( {
        type: "POST",
        url:"/html/TruckStatus",
        data: "truckStatus=" + newTruckStatus,
        dataType: "json",
        success : function (data) {
            $("#addTruckStatus").text( data.created + " added successfull.");
        }
    } );
}

function addNewTruck() {
    var cityName1 = $("select[name = 'truckNumber'] option:selected").text();  //TODO implement this part and create creation form
    var cityName2 = $("select[name = 'cityName2'] option:selected").text();
    var distance = $("input[name = 'distance']").val();

    var dataToSend = "cityName1=" + cityName1 + "&cityName2=" + cityName2 + "&distance=" + distance;
    $.ajax({
        type: "POST",
        url: "/html/AddDistance",
        data: dataToSend,
        dataType: "json",
        success: function (data) {
            if (data.success == true) {
                $("#addCityMapResult").text(data.cityMap + " added successfull.");
            } else {
                $("#addCityMapResult").text(data.cityMap + " already exists.");
            }
        }
    });
}