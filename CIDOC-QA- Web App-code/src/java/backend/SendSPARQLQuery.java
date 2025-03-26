/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public class SendSPARQLQuery {

    public String SaamQuery(String query) throws UnsupportedEncodingException, MalformedURLException, IOException {
        // //System.out.println(query);
        String sparqlQueryURL = "https://api.triplydb.com/datasets/smithsonian/american-art-museum/services/american-art-museum/sparql?output=json&query=" + URLEncoder.encode(query, "utf8");
        URL url = new URL(sparqlQueryURL);
        URLConnection con = url.openConnection();
        // String xml_content = "application/sparql-results+xml";
        //con.setRequestProperty("ACCEPT", xml_content);

        /* In case the Endpoint asks for username and password */
        InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf8");
        BufferedReader in = new BufferedReader(isr);

        String input;
        String resultsString = "";
        while ((input = in.readLine()) != null) {
            ////System.out.println(input);
            resultsString += input + "\n";

        }

        in.close();
        isr.close();
        is.close();
        //System.out.println(resultsString);
        return resultsString;

    }
    
    public String kerameikosQuery2(String query) throws UnsupportedEncodingException, MalformedURLException, IOException {
        // //System.out.println(query);
        String sparqlQueryURL = 
                "http://83.212.97.78:8890/sparql?default-graph-uri=http%3A%2F%2Fcidoc-crm.org%2FkerameikosTest&query="+URLEncoder.encode(query, "utf8")+"&format=text%2Ftab-separated-values&timeout=0&debug=on";
        URL url = new URL(sparqlQueryURL);
        URLConnection con = url.openConnection();
        // String xml_content = "application/sparql-results+xml";
        //con.setRequestProperty("ACCEPT", xml_content);

        /* In case the Endpoint asks for username and password */
        InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf8");
        BufferedReader in = new BufferedReader(isr);

        String input;
        String resultsString = "";
        boolean flag = false;
        ArrayList<String> varNames=new ArrayList<String>();
        int cnt=0;
        while ((input = in.readLine()) != null) {
            System.out.println(input);
            
            if(cnt==0){
                resultsString+="[";
                cnt=1;
                for(String x:input.split("\t")){
                    varNames.add(x);
                }
            }
            else{
                cnt++;
                String[] res=input.split("\t");
                resultsString+="{"; 
                for(int i=0;i<res.length;i++){
                    if(i+1==res.length){
                        resultsString+=varNames.get(i)+":"+res[i]+"\n},"; 
                    }
                    else{
                        resultsString+=varNames.get(i)+":"+res[i]+",\n";
                    }
                }
            }
        }
        if(cnt>1){
            resultsString=resultsString.substring(0,resultsString.length()-1)+"]";
        }
        else{
            resultsString="[]";
        }
        in.close();
        isr.close();
        is.close();
        //System.out.println(resultsString);
        return resultsString;

    }

    
    
    
//
    public String kerameikosQuery(String query) throws UnsupportedEncodingException, MalformedURLException, IOException {
        // //System.out.println(query);
        String sparqlQueryURL = "http://kerameikos.org/query?output=json&query=" + URLEncoder.encode(query, "utf8");
        URL url = new URL(sparqlQueryURL);
        URLConnection con = url.openConnection();
        // String xml_content = "application/sparql-results+xml";
        //con.setRequestProperty("ACCEPT", xml_content);

        /* In case the Endpoint asks for username and password */
        InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf8");
        BufferedReader in = new BufferedReader(isr);

        String input;
        String resultsString = "";
        boolean flag = false;
        while ((input = in.readLine()) != null) {
            ////System.out.println(input);
            if (input.contains("bindings")) {
                flag = true;
                resultsString = "[\n";
                continue;
            }
            if (input.contains("]")) {
                resultsString += "]";
                flag = false;
            }
            if (flag == false) {
                continue;
            }
            input = input.replace("https:", "https");

            input = input.replace("http:", "htp");
            if (input.contains(":")) {
                String[] split = input.split(":");
                resultsString += split[0] + ": \"" + split[split.length - 1].replace("https", "https:").replace("htp", "http:").split("\"")[1] + "\"";
                if(input.endsWith(",")){
                    resultsString+=",\n";
                }
                else{
                    resultsString+="\n";
                }
            } else {
                resultsString += input + "\n";
            }

        }

        in.close();
        isr.close();
        is.close();

        return resultsString;

    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        SendSPARQLQuery query = new SendSPARQLQuery();
        String querys = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> prefix crm: <http://www.cidoc-crm.org/cidoc-crm/> SELECT ?x ?l WHERE {  ?x crm:P7_took_place_at ?place .\n" +
"  ?place rdfs:label ?l } limit 100";
        System.out.println(querys);
        String res = query.kerameikosQuery(querys);
       // System.out.println(res);

//        
//      
//        String querys=""
//                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
//"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
//"PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n" +
//"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n" +
//"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
//"prefix saam: <http://data.americanart.si.edu/>\n" +
//"PREFIX aat: <http://vocab.getty.edu/aat/>"
//                + "SELECT ?artwork ?owner " +
//"WHERE {" +
//"  ?artwork crm:P52_has_current_owner ?owner ." +
//"} limit 100";
//        String res=query.SaamQuery(querys);
//         System.out.println(res);
        
    }
}
