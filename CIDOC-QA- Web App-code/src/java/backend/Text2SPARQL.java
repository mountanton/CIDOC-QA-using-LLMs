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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author micha
 */
public class Text2SPARQL {

    private String url = "https://api.openai.com/v1/chat/completions";
    String key_35 = "ADD KEY";
    String keymini = "ADD KEY";
    String key4 = "ADD KEY";

    /**
     * Calls gpt turbo version without caring about conversation history
     */
    public String chatGPT_TURBO(String text, String model) throws Exception {

        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        String fkey = key_35;
        if (model.contains("mini")) {
            fkey = keymini;
        } else if (model.contains("4")) {
            fkey = key4;
        }
        System.out.println(fkey);
        con.setRequestProperty("Authorization", "Bearer " + fkey);

        JSONObject data = new JSONObject();
        data.put("model", model); //"gpt-4o-2024-08-06");

        data.put("messages", "[{'role': 'user', 'content': 'MyText'}]");
        data.put("temperature", 0.5);   //set it to 0.1 for max accuracy
        data.put("max_tokens", 2000);   //completion length

        String body = data.toString().replace("\"[", "[").replace("]\"", "]").replace("'", "\"").replace("MyText", text);
        System.out.println("query=" + body);
        con.setDoOutput(true);
        con.getOutputStream().write(body.toString().getBytes());

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {

            String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                    .reduce((a, b) -> a + b).get();

            return new JSONObject(output).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content").replace("```", "").replace("sparql", "");
        } else {   //possible token exceedance

            System.out.println("Error: " + responseCode);
            InputStream errorStream = con.getErrorStream();
            if (errorStream != null) {
                String errorOutput = new BufferedReader(new InputStreamReader(errorStream)).lines()
                        .reduce((a, b) -> a + b).orElse("");
                System.out.println("Error details: " + errorOutput);
                return "Failed: " + new JSONObject(errorOutput).getJSONObject("error").getString("message");
            }
        }
        return "Failed to fetch an answer from Chat-GPT";
    }

    public static void main(String[] args) throws Exception {
        Text2SPARQL t2spa = new Text2SPARQL();
        String res = "";
        try {
            res = t2spa.chatGPT_TURBO(Resources_SAAM.promptR1SAAM + "GET", "gpt-3.5-turbo-16k");
        } catch (ProtocolException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(res);
        SendSPARQLQuery query = new SendSPARQLQuery();
        String querys = ""
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "prefix saam: <http://data.americanart.si.edu/>\n"
                + "PREFIX aat: <http://vocab.getty.edu/aat/> \n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + res + " limit 100";
        System.out.println(querys);

        String res2 = query.SaamQuery(querys);
        System.out.println(res2);

    }
}
