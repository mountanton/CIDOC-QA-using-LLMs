function hideShow() {
    if (document.getElementById("pwd").type === "text") {
        document.getElementById("pwd").type = "password";
        document.getElementById("myB").value = "Show Password";
    } else {
        document.getElementById("pwd").type = "text";
        document.getElementById("myB").value = "Hide Password";
    }

}
var triples, jsonFile;

function convert(jsonData) {

    // Get the container element where the table will be inserted
    let container = document.getElementById("container");

    // Create the table element
    let table = document.createElement("table");

    // Get the keys (column names) of the first object in the JSON data
    let cols = Object.keys(jsonData[0]);

    // Create the header element
    let thead = document.createElement("thead");
    let tr = document.createElement("tr");

    // Loop through the column names and create header cells
    cols.forEach((item) => {
        let th = document.createElement("th");
        th.innerText = item; // Set the column name as the text of the header cell
        tr.appendChild(th); // Append the header cell to the header row
    });
    thead.appendChild(tr); // Append the header row to the header
    table.append(tr) // Append the header to the table

    // Loop through the JSON data and create table rows
    jsonData.forEach((item) => {
        let tr = document.createElement("tr");

        // Get the values of the current object in the JSON data
        let vals = Object.values(item);

        // Loop through the values and create table cells
        vals.forEach((elem) => {
            let td = document.createElement("td");
            td.innerText = elem; // Set the value as the text of the table cell
            tr.appendChild(td); // Append the table cell to the table row
        });
        table.appendChild(tr); // Append the table row to the table
    });
    container.appendChild(table) // Append the table to the container element
}

function setTriples(triples, model) {
    splitTriples = triples.split("\n");
    var cnt = 1;
    var flag = 0;

    var table1 = "<table  border=2><tr><th>Fact ID</th><th>Subject</th><th>Predicate</th><th>Object</th><th>Validation Button</th></tr>";
    for (var tr in splitTriples) {
        newTr = splitTriples[tr].split("> ");

        if (newTr.length >= 3) {
            var sub = newTr[0].replace("<", "");
            var prd = newTr[1].replace("<", "");
            var obj = newTr[2].replace("<", "");
            if (sub.startsWith("http")) {
                sub = "<a href=\"" + sub + "\">" + getSuffix(sub) + "</a>";
            }
            if (prd.startsWith("http")) {
                prd = "<a href=\"" + prd + "\">" + getSuffix(prd) + "</a>";
            }
            if (obj.startsWith("http")) {
                obj = "<a href=\"" + obj + "\">" + getSuffix(obj).replace("?", "") + "</a>";
            }
            flag = 1;
            table1 += "<tr><td>" + cnt++ + "</td><td>" + sub + "</td><td>" + prd + "</td><td>" + obj.split("^^")[0] + "</td><td>" +
                    "<button style='text-align: center;font-size:15px' class='button special'  onclick='submit(" + tr + ");'>Validate Fact</button> " + " </tr>";
        }
    }
    if (flag === 0) {
        document.getElementById("factsRetrieved").innerHTML = "<h2> No Triples Generated from ChatGPT: Please Try Again</h2><br>";
        // "<button style='text-align: center;font-size:15px' class='button special'  onclick='submit(" + getFactsFromGPT() + ");'>Please Try Again</button> " + " </tr>";
        document.getElementById("loader").style.display = "none";
    } else {
        document.getElementById("factsRetrieved").innerHTML = "<h2> Retrieved Facts from ChatGPT using " + model + "</h2>";
        document.getElementById("factsRetrieved").innerHTML += table1 + "</table> <button style='float:right; font-size:15px'  onclick='onDownloadTriples()'><u>Download Triples</u></button><br><br>";
        document.getElementById('validButton').style.visibility = 'visible';
        document.getElementById("loader").style.display = "none";
        document.getElementById('choiceKG').style.visibility = 'visible';
    }

}

function getFactsFromGPT() {
    var model = "turbo";
    var modelName = "gpt-3.5-turbo-0301"
   // if (document.getElementById("DaVinci").checked == true) {
    //    model = "DaVinci"
    //    modelName = "text-davinci-003"
    //}
    const xhr = new XMLHttpRequest();
    document.getElementById("factsValidation").innerHTML = ""
    document.getElementById("factsRetrieved").innerHTML = "";
    document.getElementById('validButton').style.visibility = 'hidden';
    document.getElementById('choiceKG').style.visibility = 'hidden';
    document.getElementById("loader").style.display = "block";

    document.getElementById("antext2").style.display = "none";
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            triples = xhr.responseText;
            setTriples(triples, modelName);
        }
    });

    var entity = document.getElementById("entity").value;
    var numOfFacts = 3;
    var type = "Entity";
    if (document.getElementById("que").checked == true) {
        type = "Question";
    } else if (document.getElementById("txt").checked == true) {
        type = "Text";
    } else {
        if (document.getElementById("five").checked == true)
            numOfFacts = 5;
        else if (document.getElementById("ten").checked == true)
            numOfFacts = 10;
    }
    if (entity == "Who was the scorer in UEFA Euro 2004 Final" && model == "turbo") {
        triples = "<http://dbpedia.org/resource/UEFA_Euro_2004_Final> <http://dbpedia.org/ontology/goalScorer> <http://dbpedia.org/resource/Angelos_Basinas> .";
        setTriples(triples, modelName);
    } else {
        xhr.open("GET", "http://93.115.20.167:5000/getChatGPTFacts/" + entity.replace("?", "") + "/" + model + "/" + type + "/" + numOfFacts);
       // xhr.open("GET", "http://127.0.0.1:5000/getChatGPTFacts/" + entity + "/" + model + "/" + type + "/" + numOfFacts);
        xhr.setRequestHeader("Accept", "application/json");
        xhr.send();
    }
    //triples = '<http://dbpedia.org/resource/Thanasis_Veggos> <http://dbpedia.org/ontology/abstract> "Thanasis Veggos was a Greek actor and director, considered one of the most important figures of Greek comedy."@en .';
    //setTriples(triples,modelName);
}

function getSuffix(str) {
    if (!str.startsWith("http"))
        return str;
    var str2 = str.split("/")
    var str3 = str2[str2.length - 1].split("#")
    return str3[str3.length - 1].replace("_", " ");
}

function submit(triple = - 1) {
    var kg = "DBpedia";
    if (document.getElementById("LODsyndesis").checked == true) {
        kg = "LODsyndesis";
    }
    const xhr = new XMLHttpRequest();
    document.getElementById("factsValidation").innerHTML = ""

    document.getElementById("antext2").style.display = "block";
    document.getElementById("loader2").style.display = "block";

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            //

            document.getElementById("loader2").style.display = "none";

            var cnt = 1;
            if (triple != -1)
                cnt = triple + 1
            jsonFile = xhr.responseText;
            const obj = JSON.parse(xhr.responseText);
            console.log(obj);
            document.getElementById("factsValidation").innerHTML += "<h2>Facts Validation from the " + kg + " KG</h2><br>";
            for (const key in obj) {
                var gptFact = getSuffix(obj[key].chatGPT_fact.subject) + " " + getSuffix(obj[key].chatGPT_fact.predicate) + " " + getSuffix(obj[key].chatGPT_fact.object).split("^^")[0];
                document.getElementById("factsValidation").innerHTML += "<h3> ChatGPT Fact " + cnt + ": " + gptFact + "</h3><br>";

                cnt++;
                kgfacts = obj[key].KG_Facts
                if (kgfacts == "Entity Not Found in the KG")
                    document.getElementById("factsValidation").innerHTML += "<br><b>Entity " + "<a href=\"" + obj[key].chatGPT_fact.subject + "\">" + getSuffix(obj[key].chatGPT_fact.subject) + "</a>" + "  Not Found in the KG</b>";
                else {
                    var table = "<table border=2><tr><th>Rank</th><th>Subject</th><th>Predicate</th><th>Object</th><th>Provenance</th><th>Similarity</th><th>Rule</th></tr>";
                    var rank = 1;
                    for (const key2 in kgfacts) {
                        var subj = kgfacts[key2].subject;
                        var prd = kgfacts[key2].predicate;
                        var objec = kgfacts[key2].object;
                        if (subj.startsWith("http")) {
                            subj = "<a href=\"" + subj + "\">" + getSuffix(subj) + "</a>";
                        }
                        if (prd.startsWith("http")) {


                            if (kgfacts[key2].type == "Same Object - Different Predicate" || kgfacts[key2].type == "Most Similar Triples") {
                                prd = "<a style='color:orange' href=\"" + prd + "\" >" + getSuffix(prd) + "</a>";
                            } else
                                prd = "<a href=\"" + prd + "\">" + getSuffix(prd) + "</a>";

                        }
                        if (objec.startsWith("http")) {

                            if (kgfacts[key2].type == "Same Predicate - Different Object" || kgfacts[key2].type == "Most Similar Triples") {
                                objec = "<a style='color:orange' href=\"" + objec + "\" >" + getSuffix(objec) + "</a>";
                            } else
                                objec = "<a href=\"" + objec + "\">" + getSuffix(objec) + "</a>";
                        } else {
                            if (kgfacts[key2].type == "Same Predicate - Different Object") {
                                objec = "<span style='color:orange;'>" + objec + "</span>";
                            }
                        }


                        table += "<tr><td>" + rank++ + "</td><td>" + subj + "</td><td>" + prd + "</td><td>" + objec + "</td><td>" + kgfacts[key2].provenance + "</td><td>" + kgfacts[key2].threshold + "</td><td>" + kgfacts[key2].type + "</td></tr>";
                        var status = ""
                        if (kgfacts[key2].type == "Same or Equivalent Triple")
                            status = "<br><span style='color:green;font-size: 20px;'>Verified Correctly (Same or Equivalent Triple Found)</span>";
                        else if (kgfacts[key2].type == "Same Predicate - Different Object")
                            status = "<br>Same Predicate - <span style='color:orange;font-size: 20px;'>" + "Different Object" + "</span> Found";
                        else if (kgfacts[key2].type == "Same Object - Different Predicate")
                            status = "<br>Same Object - <span style='color:orange;font-size: 20px;'>" + "Different Predicate" + "</span> Found";
                        else
                            status = "<br><span style='color:orange;font-size: 20px;'>" + kgfacts[key2].type + "</span> Found";
                        var KGFact = kgfacts[key2].threshold + " " + kgfacts[key2].subject + " " + kgfacts[key2].predicate + " " + kgfacts[key2].object + " " + kgfacts[key2].provenance + " " + kgfacts[key2].type;


                    }
                    table += "</table>";
                    document.getElementById("factsValidation").innerHTML += status + "<br>";
                    //document.getElementById("factsValidation").innerHTML += "<br>Relevant Facts in the KG";

                    document.getElementById("factsValidation").innerHTML += table + "<br>";
                }
            }


            document.getElementById("factsValidation").innerHTML += "<br> <button class='button special' onclick='onDownload()'>Download JSON File</button>";
        }
    });

        xhr.open("POST", "http://93.115.20.167:5000/factChecking/" + kg);
    
   // xhr.open("POST", " http://127.0.0.1:5000/factChecking/" + kg);
    xhr.setRequestHeader("Accept", "application/json");
    var data = triples //'<http://dbpedia.org/resource/Knossios> <http://dbpedia.org/ontology/country> <http://dbpedia.org/resource/Greece> .\n<http://dbpedia.org/resource/Knossos> <http://dbpedia.org/ontology/elevation> "80"^^<http://www.w3.org/2001/XMLSchema#float> .'
    //triples
    if (triple != -1)
        data = triples.split("\n")[triple];
    xhr.send(data);
}

function download(content, fileName, contentType) {
    const a = document.createElement("a");
    const file = new Blob([content], {type: contentType});
    a.href = URL.createObjectURL(file);
    a.download = fileName;
    a.click();
}

function onDownload() {
    download(jsonFile, "validatedTriples.json", "text/plain");
}

function onDownloadTriples() {
    download(triples, "receivedTriples.nt", "text/plain");
}


document.getElementById("loader").style.display = "none";
document.getElementById('choiceKG').style.visibility = 'hidden';
document.getElementById("loader2").style.display = "none";

document.getElementById("antext2").style.display = "none";
//document.getElementById("prefetched").style.display = "none";
document.getElementById("number").style.display = "none";
runOnStart();

function runOnStart() {
    const urlParams = new URLSearchParams(location.search);

    for (const [key, value] of urlParams) {
        if (key==="text"){
           document.getElementById("entity").value=value;
           document.getElementById("txt").checked = true;
           //getFactsFromGPT();
           
        }
    }

}

function defaultEntity() {
    document.getElementById("entity").value = "El Greco";
    document.getElementById("number").style.display = "block";
    //  document.getElementById("prefetched").style.display = "block";
}


function defaultQuestion() {
    document.getElementById("entity").value = "Who was the scorer in UEFA Euro 2004 Final";
    document.getElementById("number").style.display = "none";
    // document.getElementById("prefetched").style.display = "none";
}

function defaultText() {
    document.getElementById("entity").value = "The Godfather is an American crime film directed by Francis Ford Coppola and produced by Albert S. Ruddy, based on Mario Puzo's best-selling novel of the same name";
    document.getElementById("number").style.display = "none";
    // document.getElementById("prefetched").style.display = "none";
}