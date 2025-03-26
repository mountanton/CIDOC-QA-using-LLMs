/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author micha
 */
public class Resources_SAAM {
    
    public static String zeroshot="Please produce only a SPARQL query (without explanation) using the CIDOC-CRM ontology for the question ";
    
    public static String removePrefixes(String query){
        String newQuery=query.replace("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n","");
        newQuery=newQuery.replace("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n","");
        newQuery=newQuery.replace("PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n","");
        newQuery=newQuery.replace("PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n","");
        newQuery=newQuery.replace("PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n","");
        newQuery=newQuery.replace("PREFIX saam: <http://data.americanart.si.edu/>\n","");
        newQuery=newQuery.replace("PREFIX aat: <http://vocab.getty.edu/aat/>\n","");
        newQuery=newQuery.replace("PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n","");
        String finalQuery="";
        for(String k:newQuery.split("\n")){
            if(k.toLowerCase().contains("prefix")){
                continue;
            }
            else
                finalQuery+=k+"\n";
        }
        System.out.println(finalQuery);
        return finalQuery;
      //  return pref;
    }
          //          + "PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n"
           //         + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
             //       + "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
              //      + "PREFIX saam: <http://data.americanart.si.edu/>\n"
                //    + "PREFIX aat: <http://vocab.getty.edu/aat/> \n"
                  //  + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n \n";
    
    public static String promptR1SAAM="You are given the following path patterns of the form  (Class)-->Property-->(Class) or {Literal}\\n" +
"### Triple Patterns\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)\\n" +
"(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:depiction-->(crm:E38_Image)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P52_has_current_owner-->(crm:E40_Legal_Body)\\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\\n" +
"(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:homepage)-->foaf:Document)\\n" +
"(crm:E52_Time-Span)-->rdfs:label)-->{Literal}\\n" +
"(crm:E39_Actor)-->rdfs:label)-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdfs:label)-->{Literal}\\n" +
"(crm:E74_Group)-->rdfs:label)-->{Literal}\\n" +
"(crm:E53_Place)-->rdfs:label)-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->rdfs:label)-->{Literal}\\n" +
"(crm:E18_Physical_Thing)-->rdfs:label)-->{Literal}\\n" +
"(crm:E55_Type)-->rdfs:label)-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->rdfs:label)-->{Literal}\\n" +
"(crm:E82_Actor_Appellation)-->rdf:value)-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->rdf:value)-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdf:value)-->{Literal}\\n" +
"(crm:E35_Title)-->rdf:value)-->{Literal}\\n" +
"(crm:E54_Dimension)-->rdf:value)-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch)-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->crm:P2_has_type)-->URI\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type)-->URI\\n" +
"(crm:E42_Identifier)-->crm:P2_has_type)-->URI\\n" +
"(crm:E74_Group)-->crm:P2_has_type)-->URI\\n" +
"(crm:E55_Type)-->crm:P2_has_type)-->URI\\n" +
"(crm:E35_Title)-->crm:P2_has_type)-->URI\\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin)-->{Literal}\\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date})-->{Literal}\\n" +
"(crm:E55_Type)-->skos:prefLabel)-->{Literal}\\n" +
"(crm:E55_Type)-->skos:broadMatch)-->{Literal}\\n" +
"(crm:E58_Measurement_Unit)-->skos:prefLabel)-->{Literal}\\n" +
"(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose)-->{Literal}\\n" +
"### End of Triple Patterns\\n" +
"By using properties and classes from the above patterns,\\n" +
"and  by never putting a class as a property,  \\n" +
"please generate only a SPARQL query (without explanation) for answering the question ";

public static String promptOntoSAAM="You are given a set of properties and classes.\\n" +
"#Properties###\\n" +
"rdf:type\\n" +
"rdfs:subClassOf\\n" +
"rdfs:subPropertyOf\\n" +
"dct:created\\n" +
"dct:modified\\n" +
"rdfs:label\\n" +
"rdf:first\\n" +
"rdf:rest\\n" +
"rdfs:domain\\n" +
"rdfs:range\\n" +
"rdfs:comment\\n" +
"geo:asWKT\\n" +
"geo:hasGeometry\\n" +
"rdf:value\\n" +
"skos:exactMatch\\n" +
"crm:P106_is_composed_of\\n" +
"crm:P107i_is_current_or_former_member_of\\n" +
"crm:P129i_is_subject_of\\n" +
"crm:P131_is_identified_by\\n" +
"crm:P1_is_identified_by\\n" +
"crm:P2_has_type\\n" +
"crm:P4_has_time-span\\n" +
"crm:P7_took_place_at\\n" +
"crm:P82a_begin_of_the_begin\\n" +
"crm:P82b_end_of_the_end-->{Literal, xsd:date}\\n" +
"crm:P92i_was_brought_into_existence_by\\n" +
"crm:P93i_was_taken_out_of_existence_by\\n" +
"crm:P102_has_title\\n" +
"crm:P108i_was_produced_by\\n" +
"crm:P41i_was_classified_by\\n" +
"crm:P46_is_composed_of\\n" +
"crm:P52_has_current_owner\\n" +
"crm:P67i_is_referred_to_by\\n" +
"crm:P91_has_unit\\n" +
"foaf:depiction\\n" +
"foaf:homepage\\n" +
"skos:broadMatch\\n" +
"skos:prefLabel\\n" +
"crm:P14_carried_out_by\\n" +
"crm:P21_had_general_purpose\\n" +
"crm:P42_assigned\\n" +
"crm:P43_has_dimension\\n" +
"foaf:primaryTopic\\n" +
"foaf:page\\n" +
"###End of Properties###\\n" +
"###Classes###\\n" +
"geo:Geometry\\n" +
"wgs84:Feature\\n" +
"crm:E38_Image\\n" +
"foaf:Document\\n" +
"rdfs:Class\\n" +
"crm:E52_Time-Span\\n" +
"crm:E64_End_of_Existence\\n" +
"crm:E82_Actor_Appellation\\n" +
"crm:E39_Actor\\n" +
"crm:E33_Linguistic_Object\\n" +
"crm:E63_Beginning_of_Existence\\n" +
"crm:E42_Identifier\\n" +
"crm:E55_Type\\n" +
"crm:E74_Group\\n" +
"crm:E53_Place\\n" +
"crm:E40_Legal_Body\\n" +
"rdf:Property\\n" +
"crm:E12_Production\\n" +
"crm:E35_Title\\n" +
"crm:E17_Type_Assignment\\n" +
"crm:E18_Physical_Thing\\n" +
"crm:E54_Dimension\\n" +
"void:Dataset\\n" +
"crm:E22_Man-Made_Object\\n" +
"crm:E58_Measurement_Unit\\n" +
"void:DatasetDescription\\n" +
"sh:NodeShape\\n" +
"###End of Classes###\\n" +
"By using these properties and classes\\n" +
"and  by never putting a class as a property,  \\n" +
"please generate only a SPARQL query (without explanation) for answering the question ";
    
public static String promptR2SAAM="You are given the following patterns of the form (Class)-->Property-->(Class or {Literal})\\n" +
"and (Class)-->Property-->{Class}-->{Property}-->(Class) or {Literal} ,  \\n" +
"###Patterns\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production))\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)\\n" +
"(crm:E39_Actor-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:depiction-->(crm:E38_Image)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P52_has_current_owner-->(crm:E40_Legal_Body)\\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E82_Actor_Appellation-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\\n" +
"(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E82_Actor_Appellation-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:homepage-->(foaf:Document)\\n" +
"(crm:E52_Time-Span)-->rdfs:label-->{Literal}\\n" +
"(crm:E39_Actor)-->rdfs:label-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdfs:label-->{Literal}\\n" +
"(crm:E74_Group)-->rdfs:label-->{Literal}\\n" +
"(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->rdfs:label-->{Literal}\\n" +
"(crm:E18_Physical_Thing)-->rdfs:label-->{Literal}\\n" +
"(crm:E55_Type)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->rdfs:label-->{Literal}\\n" +
"(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdf:value-->{Literal}\\n" +
"(crm:E35_Title)-->rdf:value-->{Literal}\\n" +
"(crm:E54_Dimension)-->rdf:value-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\\n" +
"(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E74_Group)-->crm:P2_has_type-->URI\\n" +
"(crm:E55_Type)-->crm:P2_has_type-->URI\\n" +
"(crm:E35_Title)-->crm:P2_has_type-->URI\\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E55_Type)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E55_Type)-->skos:broadMatch-->{Literal}\\n" +
"(crm:E58_Measurement_Unit)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"###End of Patterns\\n" +
"By using the properties and classes of the above patterns,\\n" +
"and  by never putting a class as a property,  \\n" +
"please generate only a SPARQL query (without explanation) for answering the question ";
    

public  static    String patternsSAAM = "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)\n" +
"(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)\n" +
"(crm:E22_Man-Made_Object)-->foaf:depiction-->(crm:E38_Image)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\n" +
"(crm:E22_Man-Made_Object)-->crm:P52_has_current_owner-->(crm:E40_Legal_Body)\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\n" +
"(crm:E82_Actor_Appellation-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E22_Man-Made_Object)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\n" +
"(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\n" +
"(crm:E82_Actor_Appellation-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\n" +
"(crm:E22_Man-Made_Object)-->foaf:homepage-->(foaf:Document)\n" +
"(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E39_Actor)-->rdfs:label-->{Literal}\n" +
"(crm:E42_Identifier)-->rdfs:label-->{Literal}\n" +
"(crm:E74_Group)-->rdfs:label-->{Literal}\n" +
"(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E40_Legal_Body)-->rdfs:label-->{Literal}\n" +
"(crm:E18_Physical_Thing)-->rdfs:label-->{Literal}\n" +
"(crm:E55_Type)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->rdfs:label-->{Literal}\n" +
"(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\n" +
"(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\n" +
"(crm:E42_Identifier)-->rdf:value-->{Literal}\n" +
"(crm:E35_Title)-->rdf:value-->{Literal}\n" +
"(crm:E54_Dimension)-->rdf:value-->{Literal}\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\n" +
"(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\n" +
"(crm:E42_Identifier)-->crm:P2_has_type-->URI\n" +
"(crm:E74_Group)-->crm:P2_has_type-->URI\n" +
"(crm:E55_Type)-->crm:P2_has_type-->URI\n" +
"(crm:E35_Title)-->crm:P2_has_type-->URI\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E55_Type)-->skos:prefLabel-->{Literal}\n" +
"(crm:E55_Type)-->skos:broadMatch-->{Literal}\n" +
"(crm:E58_Measurement_Unit)-->skos:prefLabel-->{Literal}\n" +
"(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->URI\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->URI\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)-->crm:P2_has_type-->URI\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->URI\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdf:value-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->rdf:value-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->rdfs:label-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E58_Measurement_Unit)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->(crm:E53_Place)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->(crm:E53_Place)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdf:value-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdfs:label-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->rdfs:label-->{Literal}";

public static String promptR3SAAM="You are given the following path patterns of the form (Class)-->Property-->(Class) or {Literal},\\n" +
"(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}   and\\n" +
"(Class)-->Property-->(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}:\\n" +
"###Path Patterns\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)\\n" +
"(crm:E39_Actor-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:depiction-->(crm:E38_Image)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P52_has_current_owner-->(crm:E40_Legal_Body)\\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E82_Actor_Appellation-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\\n" +
"(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E82_Actor_Appellation-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->foaf:homepage-->(foaf:Document)\\n" +
"(crm:E52_Time-Span)-->rdfs:label-->{Literal}\\n" +
"(crm:E39_Actor)-->rdfs:label-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdfs:label-->{Literal}\\n" +
"(crm:E74_Group)-->rdfs:label-->{Literal}\\n" +
"(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->rdfs:label-->{Literal}\\n" +
"(crm:E18_Physical_Thing)-->rdfs:label-->{Literal}\\n" +
"(crm:E55_Type)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->rdfs:label-->{Literal}\\n" +
"(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\\n" +
"(crm:E42_Identifier)-->rdf:value-->{Literal}\\n" +
"(crm:E35_Title)-->rdf:value-->{Literal}\\n" +
"(crm:E54_Dimension)-->rdf:value-->{Literal}\\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\\n" +
"(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\\n" +
"(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E74_Group)-->crm:P2_has_type-->URI\\n" +
"(crm:E55_Type)-->crm:P2_has_type-->URI\\n" +
"(crm:E35_Title)-->crm:P2_has_type-->URI\\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E55_Type)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E55_Type)-->skos:broadMatch-->{Literal}\\n" +
"(crm:E58_Measurement_Unit)-->skos:prefLabel-->{Literal}\\n" +
"(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P102_has_title-->(crm:E35_Title)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P67i_is_referred_to_by-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P21_had_general_purpose-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->URI\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->URI\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->crm:P2_has_type-->URI\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->crm:P2_has_type-->URI\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:date}\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:date}-->{Literal}\\n" +
"(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->(crm:E55_Type)-->crm:P91_has_unit-->(crm:E58_Measurement_Unit)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)\\n" +
"(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->crm:P106_is_composed_of-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P131_is_identified_by-->(crm:E82_Actor_Appellation)-->rdf:value-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdf:value-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)-->rdf:value-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->rdf:value-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->rdfs:label-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P7_took_place_at-->(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P107i_is_current_or_former_member_of-->(crm:E74_Group)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)-->crm:P42_assigned-->(crm:E55_Type)-->rdfs:label-->{Literal}\\n" +
"###end of Path Patterns###\\n" +
"By using properties and classes of the above patterns,\\n" +
"and  by never putting a class as a property,  \\n" +
"please generate only a SPARQL query (without explanation) for answering the question ";
  
  
}
