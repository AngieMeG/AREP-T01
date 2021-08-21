var stockId = document.cookie.split("=")[1];
var infoStock;

fetch("./consult?id="+stockId)
.then(response => response.json().then(parsedJson => {
    infoStock = parsedJson;
    handleInfo();
}));

var table = function(infoTable) {
    var keys = Object.keys(infoTable);
    this.labels = ko.computed(function() {
        var array = ["Date"];
        let key = keys[0];
        for (let label of Object.keys(infoTable[key])) {
            array.push(label.split(" ")[1]);
        }
        return array;
    });

    this.values = ko.computed(function(){
        var rows = [];
        for (let key of keys) {
            let values = Object.values(infoTable[key]);
            values.unshift(key);
            rows.push(values);
        }
        return rows;
    });
}

var ViewModel = function () {
    this.id = ko.observable(stockId);
    this.table = new table(infoStock[Object.keys(infoStock)[1]]);
}

function drawChart(){
    var dataPoints = [];
    var options =  {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Close values record"
        },
        axisX: {
            valueFormatString: "DD MMM YYYY",
        },
        axisY: {
            titleFontSize: 24
        },
        data: [{
            type: "spline", 
            yValueFormatString: "$#,###.##",
            dataPoints: dataPoints
        }]
    };
    console.log();
    addData(infoStock[Object.keys(infoStock)[1]], options, dataPoints);
}

function addData(data, options, dataPoints) {
    for(let date of Object.keys(data)){
        console.log(data[date][Object.keys(data[date])[3]]);
        dataPoints.push({
            x: new Date(date),
            y: parseFloat(data[date][Object.keys(data[date])[3]])
        });
    }
    $("#chart").CanvasJSChart(options);
}

function handleInfo(){
    ko.applyBindings(new ViewModel());
    drawChart();
}



