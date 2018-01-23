
function reloadTemperatures(city) {
    var temperatures = [];
    $.getJSON("/forecast/five-days/" + city, function (data) {
        var cityName = data.city;
        $.each(data.temperatures, function (key, value) {
            temperatures.push({
                x: new Date(value.forecastDate.year, value.forecastDate.monthValue, value.forecastDate.dayOfMonth,
                    value.forecastDate.hour, value.forecastDate.minute, value.forecastDate.second), y: value.temp});
        });
        var chart = new CanvasJS.Chart("chartTemperature", {
            title: {
                text: "Temperatures for " + cityName
            },
            zoomEnabled:true,
            axisX:{
                valueFormatString: "DD MMM,YY HH:mm",
                labelAngle: 45
            },
            data: [{
                name: "Temperatures",
                yValueFormatString: "#0.## °C",
                type: "line",
                dataPoints: temperatures,
            }]
        });
        chart.render();
    });
}

function reloadHumidities(city) {
    var humidities = [];
    $.getJSON("/forecast/five-days/" + city, function (data) {
        var cityName = data.city;
        $.each(data.temperatures, function (key, value) {
            humidities.push({
                x: new Date(value.forecastDate.year, value.forecastDate.monthValue, value.forecastDate.dayOfMonth,
                    value.forecastDate.hour, value.forecastDate.minute, value.forecastDate.second), y: value.humidity});
        });
        var chart = new CanvasJS.Chart("chartHumidity", {
            title: {
                text: "Humidity for " + cityName
            },
            zoomEnabled:true,
            axisX:{
                valueFormatString: "DD MMM,YY HH:mm",
                labelAngle: 45
            },
            data: [
                {
                    name: "Humidity",
                    //yValueFormatString: "#0## %",
                    type: "line",
                    dataPoints: humidities,
                }]
        });
        chart.render();
    });
}

function reloadPressure(city) {
    var pressures = [];
    $.getJSON("/forecast/five-days/" + city, function (data) {
        var cityName = data.city;
        $.each(data.temperatures, function (key, value) {
            pressures.push({
                x: new Date(value.forecastDate.year, value.forecastDate.monthValue, value.forecastDate.dayOfMonth,
                    value.forecastDate.hour, value.forecastDate.minute, value.forecastDate.second), y: value.pressure});
        });
        var chart = new CanvasJS.Chart("chartPressure", {
            title: {
                text: "Pressure for " + cityName
            },
            zoomEnabled:true,
            axisX:{
                valueFormatString: "DD MMM,YY HH:mm",
                labelAngle: 45
            },
            axisY:{
                minimum: 800,
                maximum: 1100,
                interval: 50
            },
            data: [
                {
                    name: "Humidity",
                    //yValueFormatString: "#0## %",
                    type: "line",
                    dataPoints: pressures,
                }]
        });
        chart.render();
    });
}

$(document).ready(function () {
    reloadTemperatures($( "#cities option:selected").text());
    reloadHumidities($( "#cities option:selected").text());
    reloadPressure($( "#cities option:selected").text());

    $("#cities").change(function() {
        reloadTemperatures($( "#cities option:selected").text());
        reloadHumidities($( "#cities option:selected").text());
        reloadPressure($( "#cities option:selected").text());
    })

});