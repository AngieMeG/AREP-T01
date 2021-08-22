var stockId = document.cookie.split("=")[1];
var infoStock;
var variation = "Daily";

fetch("./consult?id="+stockId+"&var="+variation)
.then(response => response.json().then(parsedJson => {
    infoStock = parsedJson;
    handleInfo();
}));

var table = function(infoTable) {
    var self = this;
    this.keys = ko.observableArray(Object.keys(infoTable));
    this.labels = ko.computed(function() {
        var array = ["Date"];
        let key = self.keys()[0];
        for (let label of Object.keys(infoTable[key])) {
            array.push(label.split(" ")[1]);
        }
        return array;
    });

    this.values = ko.computed(function(){
        var rows = [];
        for (let key of self.keys()) {
            let values = Object.values(infoTable[key]);
            values.unshift(key);
            rows.push(values);
        }
        return rows;
    });
}

var ViewModel = function () {
    var self = this;
    this.id = ko.observable(stockId);
    this.info = ko.observable(infoStock);
    this.table = ko.observable(new table(infoStock[Object.keys(infoStock)[1]]));
    this.updateVariation = function (item, event){
        let target = event.target;
        let selected = false;
        $(".options").children().toArray().forEach(function(element){
            if(target.id === element.id){
                element.disabled = true;
                $("#" + element.id).toggleClass("active");
                variation = element.innerHTML;
                selected = true;
            } else if(element.classList.contains("active")){
                element.disabled = false;
                $("#" + element.id).toggleClass("active");
            }
        });
        if (selected){
            fetch("./consult?id="+stockId+"&var="+variation)
            .then(response => response.json().then(parsedJson => {
                infoStock = parsedJson;
                self.updateProperties();
            }));
        }
    }
    this.updateProperties = function(){
        self.table(new table(infoStock[Object.keys(infoStock)[1]]));
        drawChart();
    }
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
            titleFontSize: 50
        },
        data: [{
            type: "spline", 
            yValueFormatString: "$#,###.##",
            dataPoints: dataPoints
        }]
    };
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

$("#submit").on("click", function(){
    window.location.replace("index.html");
})