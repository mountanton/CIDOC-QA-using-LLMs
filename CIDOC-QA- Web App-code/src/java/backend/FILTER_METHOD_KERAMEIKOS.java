/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author micha
 */
public class FILTER_METHOD_KERAMEIKOS {
    
    public String predictionPhase(String query, String model) throws Exception{
        String prompt="You are given the following path patterns of the form  (Class)-->Property-->(Class) or {Literal}\\n" +
"###Triple Patterns\\n" +
"(crm:E53_Place)-->skos:changeNote-->(dcterms:ProvenanceStatement)\\n" +
"(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->geo:location-->(crmgeo:SP5_Geometric_Place_Expression)\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(crmgeo:SP5_Geometric_Place_Expression)\\n" +
"(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n" +
"(crm:E40_Legal_Body)-->skos:changeNote-->(dcterms:ProvenanceStatement)\\n" +
"(crm:E40_Legal_Body)-->foaf:homepage-->(void:Dataset)\\n" +
"(crm:E78_Collection)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\\n" +
"(crm:E4_Period)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E57_Material)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)\\n" +
"(crm:E22_Man-Made_Object)-->kon:hasShape-->kon:Shape\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\\n" +
"(crm:E22_Man-Made_Object)-->void:inDataset-->(void:Dataset)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E73_Information_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crmsci:O19i_was_object_found_by-->crmsci:S19_Encounter_Event\\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\\n" +
"(crm:E12_Production)-->crm:P32_used_general_technique-->kon:Technique\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person\\n" +
"(crm:E21_Person)-->org:hasMembership-->org:Membership\\n" +
"(crm:E21_Person)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->skos:broader-->(crm:E74_Group)\\n" +
"(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n" +
"(crm:E74_Group)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E74_Group)-->org:hasMembership-->org:Membership\\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E53_Place)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E53_Place)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E53_Place)-->skos:definition-->{Literal}\\n" +
"(crm:E53_Place)-->skos:broader-->{Literal}\\n" +
"(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E53_Place)-->skos:inScheme-->{Literal}\\n" +
"(crm:E53_Place)-->skos:closeMatch-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:definition-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:altLabel-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\\n" +
"(crm:E78_Collection)-->rdf:type-->{Literal}\\n" +
"(crm:E78_Collection)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E78_Collection)-->skos:definition-->{Literal}\\n" +
"(crm:E4_Period)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E4_Period)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E4_Period)-->skos:definition-->{Literal}\\n" +
"(crm:E57_Material)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E57_Material)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E57_Material)-->skos:definition-->{Literal}\\n" +
"(crm:E57_Material)-->skos:altLabel-->{Literal}\\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\\n" +
"(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\\n" +
"(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\\n" +
"(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E36_Visual_Item)-->dcterms:format-->{Literal}\\n" +
"(crm:E36_Visual_Item)-->dcterms:conformsTo-->{Literal}\\n" +
"(crm:E73_Information_Object)-->dcterms:format-->{Literal}\\n" +
"(crm:E73_Information_Object)-->dcterms:conformsTo-->{Literal}\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\\n" +
"(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\\n" +
"(crm:E21_Person)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E21_Person)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E21_Person)-->skos:definition-->{Literal}\\n" +
"(crm:E21_Person)-->rdfs:seeAlso-->{Literal}\\n" +
"(crm:E21_Person)-->dcterms:source-->{Literal}\\n" +
"(crm:E21_Person)-->rdfs:label-->{Literal}\\n" +
"(crm:E74_Group)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E74_Group)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E74_Group)-->skos:definition-->{Literal}\\n" +
"(crm:E74_Group)-->rdfs:seeAlso-->{Literal}\\n" +
"(crm:E74_Group)-->rdfs:label-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(crmgeo:SP5_Geometric_Place_Expression)\\n" +
"(crmgeo:SP5_Geometric_Place_Expression)-->geo:long-->{Literal}\\n" +
"(crmgeo:SP5_Geometric_Place_Expression)-->geo:lat-->{Literal}\\n" +
"###End of Triple Patterns\\n" +
"give me the  classes and properties that will be used for answering the question "+
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
                FILTER_METHOD_KERAMEIKOS FM = new FILTER_METHOD_KERAMEIKOS();
                //System.out.println(properties);
                //System.out.println(patterns);
                //System.out.println(classes);
                String prompt = FM.filteringFinal(properties, classes, patterns, query);
                System.out.println(prompt.replace("\\n","\n"));
                return prompt;
            }

        
        
       
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        
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
                + "For the  Before Christ years, the following format is used '-0XXX'^^xsd:gYear. By using properties and classes of the above patterns, \\n"
                + "and  by never putting a class as a property,  \\n"
                + "please generate only a SPARQL query (without explanation) for answering the question:\\n" + Q;
        //System.out.print(Q);
        System.out.print("\tRule A Size:" + allClassesPropertiesPatterns.size());
        System.out.print("\tRule B Size:" + (allPropertiesPatterns.size() + allClassesPatterns.size()));
        System.out.println("\tRule C Size:" + (anyPatterns.size()));

        return createPattern;
    }
}
