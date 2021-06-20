function drawChart() {
    var data = new google.visualization.DataTable();
    let names = new Array();
    let dates = new Array();
    for(let i = 0; i < stocks.length; i ++){
        if(!dates.includes(stocks[i].date.toString()))
            dates.push(stocks[i].date.toString())
    }
    data.addColumn('string', 'Date');
    for(let a = 0; a < stocks.length; a ++){
        if(!names.includes(stocks[a].name))
            names.push(stocks[a].name)
    }
    for(let b = 0; b < names.length; b ++){
        data.addColumn('number', String(names[b]))
    }
    stocks.sort(function (a, b){
        if(a.date > b.date){
            return 1;
        }
        if(a.date < b.date){
            return -1;
        }
        return 0;
    });
    let currentStockDate;
    data.addRows(dates.length);
    for(let c = 0; c < dates.length; c++){
        data.setCell(c, 0, dates[c]);
        for(let d = 1; d < names.length + 1; d++){
            for(let k = 0; k < stocks.length; k++){
                currentStockDate = stocks[k].date.toString();
                if(currentStockDate === dates[c] && stocks[k].name === names[d-1]){
                    data.setCell(c, d, stocks[k].cost);
                }
            }
        }
    }
    var options = {
        chart: {
            title: 'Stocks Chart',
            subtitle: 'Cost($)',
        }
    };
    var chart = new google.charts.Bar(document.getElementById('chart_div'));
    chart.draw(data, google.charts.Bar.convertOptions(options));
}