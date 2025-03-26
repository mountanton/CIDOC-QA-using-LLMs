/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var prefixes = "";
function getOnlySPARQLQuery() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // alert(xhr.responseText);
            document.getElementById("runButton").disabled = false;
            document.getElementById("prefixButton").disabled = false;
            prefixes = xhr.responseText.split("@@@")[0];
            var query = xhr.responseText.split("@@@")[1].trim();
            document.getElementById("sparql").value = query;//xhr.responseText;
        } else if (xhr.status !== 200) {
            $("#ajaxContent").html("User not exists");
        }
    };

    //  var data = $('#loginForm').serialize();
    document.getElementById("sparql").value = "";
    //alert('GetSPARQLQuery?query='+query)
    xhr.open('POST', 'GetOnlySPARQLQuery');
    xhr.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    xhr.send();
}

function showHidePrefixes() {
    var pref = document.getElementById("prefixButton");
    var prefVal = pref.innerHTML;
    if (prefVal === "Show Prefixes") {
        pref.innerHTML = "Hide Prefixes";
        document.getElementById("sparql").value = prefixes + "\n" + document.getElementById("sparql").value;
    } else {
        document.getElementById("sparql").value = document.getElementById("sparql").value.replace(prefixes + "\n", "");
        pref.innerHTML = "Show Prefixes";
    }
}

function change(id) {
    var kg = document.getElementById("kg");
    var kgvalue = kg.value;
    document.getElementById("question").innerHTML = "Who is the holder of each artwork";

    if (kgvalue === "saam") {
        if (id == 1) {
            document.getElementById("question").innerHTML = "Who is the holder of each artwork";
        } else if (id == 2) {
            document.getElementById("question").innerHTML = "Give me for each artist his birth place";
        } else if (id == 3) {
            document.getElementById("question").innerHTML = "When the production of an artwork ended";
        } else if (id == 4) {
            document.getElementById("question").innerHTML = "Give me the image of each artwork";
        } else if (id == 5) {
            document.getElementById("question").innerHTML = "I want all the pairs of artists that born in the same place";
        }

    } else if (kgvalue === "kerameikos") {
        if (id == 1) {
            document.getElementById("question").innerHTML = "Which is the shape of each artwork";
        } else if (id == 2) {
            document.getElementById("question").innerHTML = "Give me the number of artworks per shape";
        } else if (id == 3) {
            document.getElementById("question").innerHTML = "When the production of an artwork ended";
        } else if (id == 4) {
            document.getElementById("question").innerHTML = "Give me the influencer of each artist";
        } else if (id == 5) {
            document.getElementById("question").innerHTML = "Give me the 10 oldest artworks";
        }

    }
}

function changeExamples() {
    var kg = document.getElementById("kg");
    var kgvalue = kg.value;
    document.getElementById("factsRetrieved").style.display = "none";
    document.getElementById("msg").innerHTML = "";
    document.getElementById("sparql").value = "";
    if (kgvalue === "saam") {
        document.getElementById("question").innerHTML = "Give me for each artist his birth date";
        document.getElementById("example1").innerHTML = "Artwork Holder";
        document.getElementById("example2").innerHTML = "Artist Birth Place";
        document.getElementById("example3").innerHTML = "Artwork Production";
        document.getElementById("example4").innerHTML = "Artwork Image";
        document.getElementById("example5").innerHTML = "Pairs of Artist Birth";

    } else if (kgvalue === "kerameikos") {
        document.getElementById("question").innerHTML = "Give me the owner of each artwork";
        document.getElementById("example1").innerHTML = "Artwork Shape";
        document.getElementById("example2").innerHTML = "# of Artworks/Shape";
        document.getElementById("example3").innerHTML = "Artwork Production";
        document.getElementById("example4").innerHTML = "Influencers";
        document.getElementById("example5").innerHTML = "10 oldest artworks";
    }
}


function getSPARQLAnswer(kg) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            document.getElementById("factsRetrieved").style.display = "block";
            JSONToHTMLTable(json, "factsRetrieved");

            //
////var json=JSON.parse(xhr.responseText);
            //JSONToHTMLTable(json,"factsRetrieved");
            //  $("#ajaxContent").html("Successful Login");
        } else if (xhr.status !== 200) {
            alert("error")
            $("#ajaxContent").html("User not exists");

        }
    };
    //  var data = $('#loginForm').serialize();

    var query = document.getElementById("sparql").value;
    if (!query.includes("PREFIX")) {
        query = prefixes + "\n" + query;
    }
    document.getElementById("msg").innerHTML = "";
    document.getElementById("factsRetrieved").style.display = "none";
    //alert(query);
    //alert('GetSPARQLQuery?query='+query)
    xhr.open('POST', 'GetSPARQLAnswer?kg=' + kg)// + query);

    xhr.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    xhr.send(query);
}


function submit() {
    document.getElementById("subButton").innerHTML = "Load..";
    document.getElementById("factsRetrieved").innerHTML="";
    var method = document.getElementById("method");
    var value = method.value;
    var output = document.getElementById("output");
    var value2 = output.value;
    var kg = document.getElementById("kg");
    var kgvalue = kg.value;

    var model = document.getElementById("model");
    var modelvalue = model.value;
    if (value2 === "directAnswer") {
        getAnswer(value, kgvalue, modelvalue);
    } else if (value2 === "onlySPARQL") {
        getSPARQL(value, kgvalue, modelvalue);
    } else if (value2 === "SPARQLAnswer") {
        getSPARQLAnswer();
    }
}

function run() {
    var kg = document.getElementById("kg");
    var kgvalue = kg.value;
    getSPARQLAnswer(kgvalue);
}

function getSPARQL(value, kg, model) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // alert(xhr.responseText);
            document.getElementById("runButton").disabled = false;
            document.getElementById("prefixButton").disabled = false;
            prefixes = xhr.responseText.split("@@@")[0];
            var query = xhr.responseText.split("@@@")[1].trim();
            document.getElementById("sparql").value = query;
            document.getElementById("subButton").innerHTML = "Run";
        } else if (xhr.status !== 200) {
            $("#ajaxContent").html("Error");
            document.getElementById("subButton").innerHTML = "Run";
        }
    };
    //  var data = $('#loginForm').serialize();

    document.getElementById("factsRetrieved").style.display = "none";
    document.getElementById("msg").innerHTML = "";
    document.getElementById("sparql").value = "";
    var query = document.getElementById("question").value;

    //alert('GetSPARQLQuery?query='+query)
    xhr.open('POST', 'GetSPARQLQuery?method=' + value + '&query=' + query + '&kg=' + kg + '&model=' + model);
    xhr.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    xhr.send();
}


function getAnswer(value, kg, model) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            //  alert(xhr.responseText);
            document.getElementById("runButton").disabled = false;
            document.getElementById("factsRetrieved").style.display = "block";
            var json = JSON.parse(xhr.responseText);
            JSONToHTMLTable(json, "factsRetrieved");
            getOnlySPARQLQuery();
            document.getElementById("subButton").innerHTML = "Run";

            //  $("#ajaxContent").html("Successful Login");
        } else if (xhr.status !== 200) {
            alert("error")
            document.getElementById("msg").innerHTML = "No Results: Error in SPARQL Endpoint";
            document.getElementById("subButton").innerHTML = "Run";
        }
    };
    //  var data = $('#loginForm').serialize(); 
    document.getElementById("factsRetrieved").style.display = "none";
    document.getElementById("sparql").value = "";
    document.getElementById("msg").innerHTML = "";
    var query = document.getElementById("question").value;
    //alert('GetAnswer?query=' + query)
    xhr.open('POST', 'GetAnswer?method=' + value + '&query=' + query + '&kg=' + kg + '&model=' + model);
    xhr.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    xhr.send();
}

function JSONToHTMLTable(jsonData, elementToBind) {
    var kg = document.getElementById("kg");
    var kgvalue = kg.value;

    if (jsonData.length === 0) {
        document.getElementById("msg").innerHTML = "No Results";
        return;
    } else
        document.getElementById("msg").innerHTML = "";
    //This Code gets all columns for header   and stored in array col
    var col = [];
    for (var i = 0; i < jsonData.length; i++) {
        for (var key in jsonData[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    //This Code creates HTML table
    var table = document.createElement("table");

    //This Code getsrows for header creader above.
    var tr = table.insertRow(-1);

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    //This Code adds data to table as rows
    for (var i = 0; i < jsonData.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            if (jsonData[i][col[j]].startsWith("http")) {
                if (kgvalue === "saam")
                    tabCell.innerHTML = "<a href='https://triplydb.com/smithsonian/american-art-museum/browser?resource=" + jsonData[i][col[j]] + "'>" + jsonData[i][col[j]] + "<a>";
                else {
                    tabCell.innerHTML = "<a href='" + jsonData[i][col[j]] + "'>" + jsonData[i][col[j]] + "<a>";

                }
            } else
                tabCell.innerHTML = jsonData[i][col[j]];
        }
    }

    //This Code gets the all columns for header
    var divContainer = document.getElementById(elementToBind);
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}