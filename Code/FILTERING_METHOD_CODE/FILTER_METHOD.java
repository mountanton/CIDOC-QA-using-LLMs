package filter_method;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mountant
 */
public class FILTER_METHOD {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String patternsSAAM = "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production))\n" +
"(crm:E22_Man-Made_Object)-->crm:P41i_was_classified_by-->(crm:E17_Type_Assignment)\n" +
"(crm:E22_Man-Made_Object)-->crm:P46_is_composed_of-->(crm:E18_Physical_Thing)\n" +
"(crm:E39_Actor-->crm:P129i_is_subject_of-->(crm:E33_Linguistic_Object)\n" +
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
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
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
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
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
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
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
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P92i_was_brought_into_existence_by-->(crm:E63_Beginning_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E39_Actor)-->crm:P93i_was_taken_out_of_existence_by-->(crm:E64_End_of_Existence)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
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

        
        String patternsKerameikos="(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E40_Legal_Body)-->foaf:homepage-->(void:Dataset)\n" +
"(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\n" +
"(crm:E4_Period)-->skos:changeNote-->dcterms:ProvenanceStatement\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E57_Material)-->skos:changeNote-->dcterms:ProvenanceStatement\n" +
"(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\n" +
"(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)\n" +
"(crm:E22_Man-Made_Object)-->kon:hasShape-->(kon:Shape)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n" +
"(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)\n" +
"(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E73_Information_Object)\n" +
"(crm:E22_Man-Made_Object)-->crmsci:O19i_was_object_found_by-->crmsci:S19_Encounter_Event\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\n" +
"(crm:E12_Production)-->crm:P32_used_general_technique-->(kon:Technique)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)\n" +
"(crm:E21_Person)-->org:hasMembership-->org:Membership\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E53_Place)-->skos:prefLabel-->{Literal}\n" +
"(crm:E53_Place)-->skos:exactMatch-->{Literal}\n" +
"(crm:E53_Place)-->skos:definition-->{Literal}\n" +
"(crm:E53_Place)-->skos:broader-->{Literal}\n" +
"(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E40_Legal_Body)-->skos:prefLabel-->{Literal}\n" +
"(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\n" +
"(crm:E40_Legal_Body)-->skos:definition-->{Literal}\n" +
"(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\n" +
"(crm:E4_Period)-->skos:prefLabel-->{Literal}\n" +
"(crm:E4_Period)-->skos:exactMatch-->{Literal}\n" +
"(crm:E4_Period)-->skos:definition-->{Literal}\n" +
"(crm:E57_Material)-->skos:prefLabel-->{Literal}\n" +
"(crm:E57_Material)-->skos:definition-->{Literal}\n" +
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\n" +
"(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\n" +
"(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E73_Information_Object)-->dcterms:format-->{Literal}\n" +
"(crm:E73_Information_Object)-->dcterms:conformsTo-->{Literal}\n" +
"(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\n" +
"(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\n" +
"(crm:E21_Person)-->skos:prefLabel-->{Literal}\n" +
"(crm:E21_Person)-->skos:exactMatch-->{Literal}\n" +
"(crm:E21_Person)-->skos:definition-->{Literal}\n" +
"(crm:E21_Person)-->rdfs:seeAlso-->{Literal}\n" +
"(crm:E21_Person)-->dcterms:source-->{Literal}\n" +
"(crm:E21_Person)-->rdfs:label-->{Literal}\n" +
"(crm:E74_Group)-->skos:prefLabel-->{Literal}\n" +
"(crm:E74_Group)-->skos:exactMatch-->{Literal}\n" +
"(crm:E74_Group)-->skos:definition-->{Literal}\n" +
"(crm:E74_Group)-->rdfs:seeAlso-->{Literal}\n" +
"(crm:E74_Group)-->rdfs:label-->{Literal}\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P32_used_general_technique-->(kon:Technique)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)-->org:hasMembership-->org:Membership\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:lat-->{Literal}\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:long-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->rdfs:label-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->(geo:SpatialThing)\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->{Literal}\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->{Literal}\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->{Literal}\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->crm:E52_Time-Span\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->crm:E52_Time-Span\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n" +
"(crmsci:S19_Encounter_Event)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->(geo:SpatiaLThing)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)";
        String ListOfClasses = "{crm:E53_Place, crm:E39_Actor}";
        String ListOfProperties = "{crm:P7_took_place_at, crm:P131_is_identified_by, crm:P107i_is_current_or_former_member_of}";
        String Q = "Q16. Which is the place of birth with the most artists?";

        File myObj = new File("TWO-STAGE_FILTERING_Kerameikos_Predictions.txt");
        Scanner myReader = new Scanner(myObj);
        int count = 0;

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (data.startsWith("List of Classes:")) {
                ListOfClasses = data.replace("List of Classes:", "");
            }
            if (data.startsWith("List of Properties:")) {
                ListOfProperties = data.replace("List of Properties:", "");
            }

            if (data.startsWith("Q") && count > 0) {
                ArrayList<String> patterns = new ArrayList<String>();
                ArrayList<String> properties = new ArrayList<String>();
                ArrayList<String> classes = new ArrayList<String>();

                for (String cl : ListOfClasses.replace(
                        "{", "").replace("}", "").split(",")) {
                    classes.add(cl.trim());
                }
                for (String pr : ListOfProperties.replace(
                        "{", "").replace("}", "").split(",")) {
                    properties.add(pr.trim());
                }
                for (String pattern : patternsKerameikos.split(
                        "\n")) {
                    patterns.add(pattern);
                }
//                System.out.println(Q);
//                System.out.println(properties);
//                System.out.println(classes);
                FILTER_METHOD FM = new FILTER_METHOD();

                String prompt = FM.filtering(properties, classes, patterns, Q);
                FileWriter myWriter = new FileWriter("KERAMEIKOS//"+Q.split("\\.")[0]+".txt");
                myWriter.write(prompt);
                myWriter.close();
                //System.out.println("Successfully wrote to the file.");
            }

            if (data.startsWith("Q") && count == 0) {
                count = 1;
            }
            if (data.startsWith("Q")) {
                Q = data;
            }
        }
        myReader.close();
    }

    public String filtering(ArrayList<String> properties, ArrayList<String> classes, ArrayList<String> patterns, String Q) {
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
        String createPattern = "You are given the following path patterns of the form (Class)-->Property-->(Class) or {Literal},\n" +
"(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}   and\n" +
"(Class)-->Property-->(Class)-->Property-->(Class)-->Property-->(Class) or {Literal}: \n###Path Patterns\n";
        if (allClassesPropertiesPatterns.size() > 0) {
            for (String patt : allClassesPropertiesPatterns) {
                createPattern += patt + "\n";
            }
        } else if (allPropertiesPatterns.size() > 0 || allClassesPatterns.size() > 0) {

            for (String patt : allPropertiesPatterns) {
                createPattern += patt + "\n";
            }
            for (String patt : allClassesPatterns) {
                if(!allPropertiesPatterns.contains(patt))
                createPattern += patt + "\n";
            }

        } else if (anyPatterns.size() > 0) {
            for (String patt : anyPatterns) {
                createPattern += patt + "\n";
            }

        }
        createPattern += "###end of Path Patterns###\n"
                + "By using properties and classes of the above patterns, \n"
                + "and  by never putting a class as a property,  \n"
                + "please generate only a SPARQL query (without explanation) for answering the question:\n" + Q.split("\\. ")[1];
        System.out.print(Q);
        System.out.print("\tRule A Size:" + allClassesPropertiesPatterns.size());
        System.out.print("\tRule B Size:" + (allPropertiesPatterns.size() + allClassesPatterns.size()));
        System.out.println("\tRule C Size:" + (anyPatterns.size()));

        return createPattern;
    }
}
