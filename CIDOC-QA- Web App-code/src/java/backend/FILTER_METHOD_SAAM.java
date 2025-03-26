/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author mountant
 */
public class FILTER_METHOD_SAAM {

    public String predictionPhase(String query, String model) throws Exception{

        String prompt="You are given the following path patterns of the form  Class-->Property-->Class or Literal\\n" +
"crm:E22_Man-Made_Object-->crm:P108i_was_produced_by-->crm:E12_Production\\n" +
"crm:E22_Man-Made_Object-->crm:P41i_was_classified_by-->crm:E17_Type_Assignment\\n" +
"crm:E22_Man-Made_Object-->crm:P46_is_composed_of-->crm:E18_Physical_Thing\\n" +
"crm:E39_Actor-->crm:P129i_is_subject_of-->crm:E33_Linguistic_Object\\n" +
"crm:E22_Man-Made_Object-->crm:P129i_is_subject_of-->crm:E33_Linguistic_Object\\n" +
"crm:E22_Man-Made_Object-->crm:P67i_is_referred_to_by-->crm:E33_Linguistic_Object\\n" +
"crm:E22_Man-Made_Object-->crm:P102_has_title-->crm:E35_Title\\n" +
"crm:E22_Man-Made_Object-->foaf:depiction-->crm:E38_Image\\n" +
"crm:E12_Production-->crm:P14_carried_out_by-->crm:E39_Actor\\n" +
"crm:E22_Man-Made_Object-->crm:P52_has_current_owner-->crm:E40_Legal_Body\\n" +
"crm:E39_Actor-->crm:P1_is_identified_by-->crm:E42_Identifier\\n" +
"crm:E22_Man-Made_Object-->crm:P1_is_identified_by-->crm:E42_Identifier\\n" +
"crm:E64_End_of_Existence-->crm:P4_has_time-span-->crm:E52_Time-Span\\n" +
"crm:E63_Beginning_of_Existence-->crm:P4_has_time-span-->crm:E52_Time-Span\\n" +
"crm:E12_Production-->crm:P4_has_time-span-->crm:E52_Time-Span\\n" +
"crm:E63_Beginning_of_Existence-->crm:P7_took_place_at-->crm:E53_Place\\n" +
"crm:E64_End_of_Existence-->crm:P7_took_place_at-->crm:E53_Place\\n" +
"crm:E18_Physical_Thing-->crm:P43_has_dimension-->crm:E54_Dimension\\n" +
"crm:E82_Actor_Appellation-->crm:P2_has_type-->crm:E55_Type\\n" +
"crm:E54_Dimension-->crm:P2_has_type-->crm:E55_Type\\n" +
"crm:E22_Man-Made_Object-->crm:P2_has_type-->crm:E55_Type\\n" +
"crm:E17_Type_Assignment-->crm:P42_assigned-->crm:E55_Type\\n" +
"crm:E55_Type-->crm:P91_has_unit-->crm:E58_Measurement_Unit\\n" +
"crm:E39_Actor-->crm:P92i_was_brought_into_existence_by-->crm:E63_Beginning_of_Existence\\n" +
"crm:E39_Actor-->crm:P93i_was_taken_out_of_existence_by-->crm:E64_End_of_Existence\\n" +
"crm:E39_Actor-->crm:P107i_is_current_or_former_member_of-->crm:E74_Group\\n" +
"crm:E82_Actor_Appellation-->crm:P106_is_composed_of-->crm:E82_Actor_Appellation\\n" +
"crm:E39_Actor-->crm:P131_is_identified_by-->crm:E82_Actor_Appellation\\n" +
"crm:E22_Man-Made_Object-->foaf:homepage-->foaf:Document\\n" +
"crm:E52_Time-Span-->rdfs:label-->Literal\\n" +
"crm:E39_Actor-->rdfs:label-->Literal\\n" +
"crm:E42_Identifier-->rdfs:label-->Literal\\n" +
"crm:E74_Group-->rdfs:label-->Literal\\n" +
"crm:E53_Place-->rdfs:label-->Literal\\n" +
"crm:E40_Legal_Body-->rdfs:label-->Literal\\n" +
"crm:E18_Physical_Thing-->rdfs:label-->Literal\\n" +
"crm:E55_Type-->rdfs:label-->Literal\\n" +
"crm:E22_Man-Made_Object-->rdfs:label-->Literal\\n" +
"crm:E82_Actor_Appellation-->rdf:value-->Literal\\n" +
"crm:E33_Linguistic_Object-->rdf:value-->Literal\\n" +
"crm:E42_Identifier-->rdf:value-->Literal\\n" +
"crm:E35_Title-->rdf:value-->Literal\\n" +
"crm:E54_Dimension-->rdf:value-->Literal\\n" +
"crm:E40_Legal_Body-->skos:exactMatch-->Literal\\n" +
"crm:E33_Linguistic_Object-->crm:P2_has_type-->URI\\n" +
"crm:E82_Actor_Appellation-->crm:P2_has_type-->URI\\n" +
"crm:E42_Identifier-->crm:P2_has_type-->URI\\n" +
"crm:E74_Group-->crm:P2_has_type-->URI\\n" +
"crm:E55_Type-->crm:P2_has_type-->URI\\n" +
"crm:E35_Title-->crm:P2_has_type-->URI\\n" +
"crm:E52_Time-Span-->crm:P82a_begin_of_the_begin-->Literal\\n" +
"crm:E52_Time-Span-->crm:P82b_end_of_the_end-->Literal\\n" +
"crm:E55_Type-->skos:prefLabel-->Literal\\n" +
"crm:E55_Type-->skos:broadMatch-->Literal\\n" +
"crm:E58_Measurement_Unit-->skos:prefLabel-->Literal\\n" +
"crm:E17_Type_Assignment-->crm:P21_had_general_purpose-->Literal\\n" +
"give me the  classes and properties that will be used for answering the question: \\n" +
query +
" \\n" +
"I strictly want only the output below without any explanation in the following format:\\n" +
"List of Classes: {}\\n" +
"List of Properties:{}";
       Text2SPARQL text=new Text2SPARQL();
       String res=text.chatGPT_TURBO(prompt,model);
        System.out.println(res);
        return res;
    }
  
    
    public String FilteringPhase(String ListOfClasses, String ListOfProperties, String allPatterns,String query){
          ArrayList<String> patterns = new ArrayList<String>();
                ArrayList<String> properties = new ArrayList<String>();
                ArrayList<String> classes = new ArrayList<String>();

                for (String cl : ListOfClasses.replace(
                        "{", "").replace("}", "").split(",")) {
                    classes.add(cl.trim());
                }
                for (String pr : ListOfProperties.replace(
                        "{", "").replace("}", "").split(",")) {
                    if (pr.contains("-->"))
                        pr=pr.split("-->")[1];
                    properties.add(pr.trim());
                }
                for (String pattern : allPatterns.split(
                        "\n")) {
                    patterns.add(pattern);
                }
//                System.out.println(Q);
//                System.out.println(properties);
//                System.out.println(classes);
                FILTER_METHOD_SAAM FM = new FILTER_METHOD_SAAM();
                //System.out.println(properties);
                //System.out.println(patterns);
                //System.out.println(classes);
                String prompt = FM.filteringFinal(properties, classes, patterns, query);
                System.out.println(prompt.replace("\\n","\n"));
                return prompt;
            }

        
        
       
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
          FILTER_METHOD_SAAM fm=new FILTER_METHOD_SAAM();
          String query="I want all the pairs of artists that were born in the same place";
          String predictions=fm.predictionPhase(query,"gpt-3.5-turbo-16k");
          String ListOfClasses=""; 
          String ListOfProperties=""; 
          String[] split=predictions.split("List of Properties: ");
          if(split.length==2){
              ListOfClasses=split[0].replace("List of Classes: ","").trim();
              ListOfProperties=split[1].trim();
          }
          //System.out.println(ListOfClasses);
          //System.out.println(ListOfProperties);
          String finalPrompt=fm.FilteringPhase(ListOfClasses, ListOfProperties,Resources_SAAM.patternsSAAM,query);
          System.out.println(finalPrompt);
          
             Text2SPARQL t2spa = new Text2SPARQL();
        String res = "";
        try {
            res = t2spa.chatGPT_TURBO(finalPrompt,"gpt-3.5-turbo-16k");
        } catch (ProtocolException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(res);
        SendSPARQLQuery fQuery = new SendSPARQLQuery();
        String querys = ""
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
                + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
                + "PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n"
                + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
                + "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
                + "prefix saam: <http://data.americanart.si.edu/>\n"
                + "PREFIX aat: <http://vocab.getty.edu/aat/> \n" 
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + res+  " limit 100";
        String res2 = fQuery.SaamQuery(querys);
        System.out.println(res2);
          
    }

    public String filteringFinal(ArrayList<String> properties, ArrayList<String> classes, ArrayList<String> patterns, String Q) {
        List<String> allPropertiesPatterns = new ArrayList<String>();
        List<String> anyPatterns = new ArrayList<String>();
        List<String> allClassesPatterns = new ArrayList<String>();
        List<String> allClassesPropertiesPatterns = new ArrayList<String>();
        for (String x : patterns) {
            boolean flagProp = true, flagClass = true;
            for (String p : properties) {

                if (x.contains(p)) {
                    if(!anyPatterns.contains(x))
                    anyPatterns.add(x);
                } else {
                    flagProp = false;
                }
            }
            if (flagProp == true) {
                 if(!allPropertiesPatterns.contains(x))
                allPropertiesPatterns.add(x);
            }
            for (String c : classes) {
                if (x.contains(c) ) {
                     if(!anyPatterns.contains(x))
                    anyPatterns.add(x);
                } else {
                    flagClass = false;
                }
            }
            if (flagClass == true) {
                if(!allClassesPatterns.contains(x))
                allClassesPatterns.add(x);
            }
            if (flagProp == true && flagClass == true) {
                if(!allClassesPropertiesPatterns.contains(x))
                allClassesPropertiesPatterns.add(x);
            }
        }
        String createPattern = "You are given the following path patterns of the form (Class)-->Property-->(Class) or {Literal},\\n" +
"(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}   and\\n" +
"(Class)-->Property-->(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}: \\n###Path Patterns\\n";
        if (allClassesPropertiesPatterns.size() > 0) {
            for (String patt : allClassesPropertiesPatterns) {
                createPattern += patt + "\\n";
            }
        } else if (allPropertiesPatterns.size() > 0 || allClassesPatterns.size() > 0) {

            for (String patt : allPropertiesPatterns) {
                createPattern += patt + "\\n";
            }
            for (String patt : allClassesPatterns) {
                if(!allPropertiesPatterns.contains(patt))
                createPattern += patt + "\\n";
            }

        } else if (anyPatterns.size() > 0) {
            for (String patt : anyPatterns) {
                createPattern += patt + "\\n";
            }

        }
        createPattern += "###end of Path Patterns###\\n"
                + "For the place, the format is city, state, country for united states and city, country for the rest countries. By using properties and classes of the above patterns, \\n"
                + "and  by never putting a class as a property,  \\n"
                + "please generate only a SPARQL query (without explanation) for answering the question:\\n" + Q;
        //System.out.print(Q);
        System.out.print("\tRule A Size:" + allClassesPropertiesPatterns.size());
        System.out.print("\tRule B Size:" + (allPropertiesPatterns.size() + allClassesPatterns.size()));
        System.out.println("\tRule C Size:" + (anyPatterns.size()));

        return createPattern;
    }
}