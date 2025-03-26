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
public class Resources_Kerameikos {

    public static String zeroshot = "Please produce only a SPARQL query (without explanation) using the CIDOC-CRM ontology for the question ";

    public static String removePrefixes(String query) {
        String newQuery = query.replace("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n", "");
        newQuery = newQuery.replace("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n", "");
        newQuery = newQuery.replace("PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n", "");
        newQuery = newQuery.replace("PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n", "");
        newQuery = newQuery.replace("PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n", "");
        newQuery = newQuery.replace("PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n", "");
        newQuery = newQuery.replace("PREFIX org: <http://www.w3.org/ns/org#>\n", "");
        newQuery = newQuery.replace("PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n", "");
        newQuery = newQuery.replace("PREFIX crmgeo: <http://www.ics.forth.gr/isl/CRMgeo/>\n", "");
        newQuery = newQuery.replace("PREFIX crmsci: <http://www.ics.forth.gr/isl/CRMsci/>\n", "");
        newQuery = newQuery.replace("PREFIX dcterms: <http://purl.org/dc/terms/>\n", "");
        newQuery = newQuery.replace("PREFIX kid: <http://kerameikos.org/id/>\n", "");
        newQuery = newQuery.replace("PREFIX kon: <http://kerameikos.org/ontology#>\n", "");
        newQuery = newQuery.replace("PREFIX crmarchaeo:	<http://www.cidoc-crm.org/cidoc-crm/CRMarchaeo/>\n", "");
        newQuery = newQuery.replace("PREFIX ogc: <http://www.opengis.net/ont/geosparql#>\n", "");
        newQuery = newQuery.replace("PREFIX edm: <http://www.europeana.eu/schemas/edm/>\n", "");
        newQuery = newQuery.replace("PREFIX prov: <http://www.w3.org/ns/prov#>\n", "");
        String finalQuery="";
        for(String k:newQuery.split("\n")){
            if(k.toLowerCase().contains("prefix")){
                continue;
            }
            else
                finalQuery+=k+"\n";
        }
        return finalQuery;
    }
    
     public static String ontoKerameikos = "You are given a set of properties and classes.\\n"
            + "#Properties###\\n"
            + "rdf:type\\n"
            + "rdfs:label\\n"
            + "rdfs:comment\\n"
            + "dcterms:created\\n"
            + "skos:prefLabel\\n"
            + "skos:exactMatch\\n"
            + "skos:inScheme\\n"
            + "org:hasMembership\\n"
            + "skos:definition\\n"
            + "skos:changeNote\\n"
            + "foaf:topic\\n"
            + "prov:wasGeneratedBy\\n"
            + "prov:activity\\n"
            + "rdfs:seeAlso\\n"
            + "skos:altLabel\\n"
            + "dcterms:source\\n"
            + "rdfs:subClassOf\\n"
            + "rdfs:isDefinedBy\\n"
            + "skos:broader\\n"
            + "dcterms:isReplacedBy\\n"
            + "geo:location\\n"
            + "crm:P168_place_is_defined_by\\n"
            + "osgeo:asGeoJSON\\n"
            + "dcterms:isPartOf\\n"
            + "crmgeo:asWKT\\n"
            + "geo:lat\\n"
            + "geo:long\\n"
            + "http://www.w3.org/ns/lemon/ontolex#otherForm\\n"
            + "skos:closeMatch\\n"
            + "foaf:homepage\\n"
            + "crm:P50_has_current_keeper\\n"
            + "dcterms:title\\n"
            + "dcterms:description\\n"
            + "dcterms:publisher\\n"
            + "dcterms:license\\n"
            + "void:dataDump\\n"
            + "dcterms:rights\\n"
            + "foaf:thumbnail\\n"
            + "skos:related\\n"
            + "skos:scopeNote\\n"
            + "rdfs:range\\n"
            + "rdfs:domain\\n"
            + "rdfs:subPropertyOf\\n"
            + "crm:P45_consists_of\\n"
            + "kon:hasShape\\n"
            + "crm:P108i_was_produced_by\\n"
            + "void:inDataset\\n"
            + "crm:P1_is_identified_by\\n"
            + "crm:P138i_has_representation\\n"
            + "dcterms:format\\n"
            + "crm:P129i_is_subject_of\\n"
            + "dcterms:conformsTo\\n"
            + "org:organization\\n"
            + "edm:begin\\n"
            + "dcterms:creator\\n"
            + "dcterms:contributor\\n"
            + "org:role\\n"
            + "edm:end\\n"
            + "crm:P190_has_symbolic_content\\n"
            + "crm:P2_has_type\\n"
            + "crm:P89_falls_within\\n"
            + "crmgeo:Q9_is_expressed_in_terms_of\\n"
            + "crm:P4_has_time-span\\n"
            + "crm:P82a_begin_of_the_begin\\n"
            + "crm:P82b_end_of_the_end\\n"
            + "crmsci:O19i_was_object_found_by\\n"
            + "crm:P15_was_influenced_by\\n"
            + "crm:P43_has_dimension\\n"
            + "dcterms:modified\\n"
            + "foaf:mbox\\n"
            + "foaf:name\\n"
            + "prov:atTime\\n"
            + "prov:wasAssociatedWith\\n"
            + "dcterms:type\\n"
            + "prov:used\\n"
            + "crm:P7_took_place_at\\n"
            + "crm:P10_falls_within\\n"
            + "crm:P90_has_value\\n"
            + "crm:P91_has_unit\\n"
            + "crm:P32_used_general_technique\\n"
            + "crm:P14_carried_out_by\\n"
            + "crm:P9_consists_of\\n"
            + "###End of Properties###\\n"
            + "###Classes###\\n"
            + "skos:ConceptScheme\\n"
            + "foaf:Person\\n"
            + "prov:Agent\\n"
            + "skos:Concept\\n"
            + "dcterms:ProvenanceStatement\\n"
            + "prov:Activity\\n"
            + "prov:Create\\n"
            + "prov:Modify\\n"
            + "kon:Shape\\n"
            + "geo:SpatialThing\\n"
            + "crm:E53_Place\\n"
            + "kon:Technique\\n"
            + "crm:E40_Legal_Body\\n"
            + "crm:E78_Collection\\n"
            + "crm:E4_Period\\n"
            + "kon:Ware\\n"
            + "kon:Style\\n"
            + "crm:E57_Material\\n"
            + "void:Dataset\\n"
            + "crm:E22_Man-Made_Object\\n"
            + "crm:E12_Production\\n"
            + "crm:E52_Time-Span\\n"
            + "org:Membership\\n"
            + "org:Organization\\n"
            + "prov:Entity\\n"
            + "org:Role\\n"
            + "crm:E33_E41_Linguistic_Appellation\\n"
            + "crm:E42_Identifier\\n"
            + "crm:E36_Visual_Item\\n"
            + "crm:E73_Information_Object\\n"
            + "crm:E54_Dimension\\n"
            + "crmsci:S19_Encounter_Event\\n"
            + "crmgeo:SP5_Geometric_Place_Expression\\n"
            + "crm:E21_Person\\n"
            + "crm:E74_Group\\n"
            + "###End of Classes###\\n"
            + "By using these properties and classes\\n"
            + "and  by never putting a class as a property,  \\n"
            + "please generate only a SPARQL query (without explanation) for answering the question ";

    public static String promptR1Kerameikos = "You are given the following triple patterns of the form {Class}-->Property-->{Class} or (Literal)  \\n"
            + "###Path Patterns\\n"
            + "(crm:E53_Place}-->skos:changeNote-->{dcterms:ProvenanceStatement}\\n"
            + "{crm:E53_Place}-->geo:location-->{geo:SpatialThing}\\n"
            + "{crm:E53_Place}-->geo:location-->{crmgeo:SP5_Geometric_Place_Expression}\\n"
            + "{crm:E53_Place}-->crm:P168_place_is_defined_by-->{geo:SpatialThing}\\n"
            + "{crm:E53_Place}-->crm:P168_place_is_defined_by-->{crmgeo:SP5_Geometric_Place_Expression}\\n"
            + "{crm:E53_Place}-->skos:broader-->{crm:E53_Place}\\n"
            + "{crm:E53_Place}-->crm:P89_falls_within-->{crm:E53_Place}\\n"
            + "{crm:E40_Legal_Body}-->skos:changeNote-->{dcterms:ProvenanceStatement}\\n"
            + "{crm:E40_Legal_Body}-->foaf:homepage-->{void:Dataset}\\n"
            + "{crm:E78_Collection}-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "{crm:E78_Collection}-->crm:P50_has_current_keeper-->{crm:E40_Legal_Body}\\n"
            + "{crm:E4_Period}-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "{crm:E4_Period}-->crm:P4_has_time-span-->{crm:E52_Time-Span}\\n"
            + "{crm:E57_Material}-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "{crm:E57_Material}-->skos:broader-->{crm:E57_Material}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P50_has_current_keeper-->{crm:E40_Legal_Body}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P45_consists_of-->{crm:E57_Material}\\n"
            + "{crm:E22_Man-Made_Object}-->kon:hasShape-->kon:Shape\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P108i_was_produced_by-->{crm:E12_Production}\\n"
            + "{crm:E22_Man-Made_Object}-->void:inDataset-->{void:Dataset}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P1_is_identified_by-->{crm:E33_E41_Linguistic_Appellation}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P1_is_identified_by-->{crm:E42_Identifier}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P138i_has_representation-->{crm:E36_Visual_Item}\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P129i_is_subject_of-->{crm:E73_Information_Object}\\n"
            + "{crm:E22_Man-Made_Object}-->crmsci:O19i_was_object_found_by-->crmsci:S19_Encounter_Event\\n"
            + "{crm:E22_Man-Made_Object}-->crm:P43_has_dimension-->{crm:E54_Dimension}\\n"
            + "{crm:E12_Production}-->crm:P7_took_place_at-->{crm:E53_Place}\\n"
            + "{crm:E12_Production}-->crm:P4_has_time-span-->{crm:E52_Time-Span}\\n"
            + "{crm:E12_Production}-->crm:P10_falls_within-->{crm:E4_Period}\\n"
            + "{crm:E12_Production}-->crm:P32_used_general_technique-->kon:Technique\\n"
            + "{crm:E12_Production}-->crm:P14_carried_out_by-->{crm:E21_Person}\\n"
            + "{crm:E12_Production}-->crm:P14_carried_out_by-->{crm:E74_Group}\\n"
            + "{crm:E12_Production}-->crm:P9_consists_of-->{crm:E12_Production}\\n"
            + "{crm:E12_Production}-->crm:P14_carried_out_by-->{crm:E4_Period}\\n"
            + "{crm:E12_Production}-->crm:P14_carried_out_by-->foaf:Person\\n"
            + "{crm:E21_Person}-->org:hasMembership-->org:Membership\\n"
            + "{crm:E21_Person}-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "{crm:E21_Person}-->dcterms:isReplacedBy-->{crm:E21_Person}\\n"
            + "{crm:E21_Person}-->skos:broader-->{crm:E74_Group}\\n"
            + "{crm:E21_Person}-->skos:related-->{crm:E21_Person}\\n"
            + "{crm:E21_Person}-->crm:P15_was_influenced_by-->{crm:E21_Person}\\n"
            + "{crm:E21_Person}-->crm:P15_was_influenced_by-->{crm:E74_Group}\\n"
            + "{crm:E74_Group}-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "{crm:E74_Group}-->org:hasMembership-->org:Membership\\n"
            + "{crm:E74_Group}-->crm:P15_was_influenced_by-->{crm:E21_Person}\\n"
            + "{crm:E53_Place}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E53_Place}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E53_Place}-->skos:definition-->{Literal}\\n"
            + "{crm:E53_Place}-->skos:broader-->{Literal}\\n"
            + "{crm:E53_Place}-->rdfs:label-->{Literal}\\n"
            + "{crm:E53_Place}-->skos:inScheme-->{Literal}\\n"
            + "{crm:E53_Place}-->skos:closeMatch-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->skos:definition-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->foaf:homepage-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->skos:altLabel-->{Literal}\\n"
            + "{crm:E40_Legal_Body}-->foaf:thumbnail-->{Literal}\\n"
            + "{crm:E78_Collection}-->rdf:type-->{Literal}\\n"
            + "{crm:E78_Collection}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E78_Collection}-->skos:definition-->{Literal}\\n"
            + "{crm:E4_Period}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E4_Period}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E4_Period}-->skos:definition-->{Literal}\\n"
            + "{crm:E57_Material}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E57_Material}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E57_Material}-->skos:definition-->{Literal}\\n"
            + "{crm:E57_Material}-->skos:altLabel-->{Literal}\\n"
            + "{crm:E52_Time-Span}-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n"
            + "{crm:E52_Time-Span}-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n"
            + "{crm:E33_E41_Linguistic_Appellation}-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "{crm:E33_E41_Linguistic_Appellation}-->crm:P2_has_type-->{Literal}\\n"
            + "{crm:E42_Identifier}-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "{crm:E42_Identifier}-->crm:P2_has_type-->{Literal}\\n"
            + "{crm:E36_Visual_Item}-->dcterms:format-->{Literal}\\n"
            + "{crm:E36_Visual_Item}-->dcterms:conformsTo-->{Literal}\\n"
            + "{crm:E73_Information_Object}-->dcterms:format-->{Literal}\\n"
            + "{crm:E73_Information_Object}-->dcterms:conformsTo-->{Literal}\\n"
            + "{crm:E54_Dimension}-->crm:P2_has_type-->{Literal}\\n"
            + "{crm:E54_Dimension}-->crm:P90_has_value-->{Literal}\\n"
            + "{crm:E54_Dimension}-->crm:P91_has_unit-->{Literal}\\n"
            + "{crm:E21_Person}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E21_Person}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E21_Person}-->skos:definition-->{Literal}\\n"
            + "{crm:E21_Person}-->rdfs:seeAlso-->{Literal}\\n"
            + "{crm:E21_Person}-->dcterms:source-->{Literal}\\n"
            + "{crm:E21_Person}-->rdfs:label-->{Literal}\\n"
            + "{crm:E74_Group}-->skos:prefLabel-->{Literal}\\n"
            + "{crm:E74_Group}-->skos:exactMatch-->{Literal}\\n"
            + "{crm:E74_Group}-->skos:definition-->{Literal}\\n"
            + "{crm:E74_Group}-->rdfs:seeAlso-->{Literal}\\n"
            + "{crm:E74_Group}-->rdfs:label-->{Literal}\\n"
            + "{crm:E53_Place}-->crm:P168_place_is_defined_by-->{crmgeo:SP5_Geometric_Place_Expression}\\n"
            + "{crmgeo:SP5_Geometric_Place_Expression}-->geo:long-->(Literal)\\n"
            + "{crmgeo:SP5_Geometric_Place_Expression}-->geo:lat-->(Literal)\\n"
            + "###end of Path Patterns###\\n"
            + "By using properties and classes of the above patterns,\\n"
            + "and  by never putting a class as a property,  \\n"
            + "please generate only a SPARQL query (without explanation) for answering the question ";

    public static String promptR2Kerameikos = "You are given the following path patterns of the form (Class)-->Property-->(Class) or {Literal}\\n"
            + "and (Class)-->Property-->(Class)-->Property-->(Class) or {Literal}  \\n"
            + "###Path Patterns\\n"
            + "(crm:E53_Place)-->skos:changeNote-->(dcterms:ProvenanceStatement)\\n"
            + "(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n"
            + "(crm:E53_Place)-->geo:location-->(crmgeo:SP5_Geometric_Place_Expression)\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(crmgeo:SP5_Geometric_Place_Expression)\\n"
            + "(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n"
            + "(crm:E40_Legal_Body)-->skos:changeNote-->(dcterms:ProvenanceStatement)\\n"
            + "(crm:E40_Legal_Body)-->foaf:homepage-->(void:Dataset)\\n"
            + "(crm:E78_Collection)-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\\n"
            + "(crm:E4_Period)-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n"
            + "(crm:E57_Material)-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)\\n"
            + "(crm:E22_Man-Made_Object)-->kon:hasShape-->kon:Shape\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\\n"
            + "(crm:E22_Man-Made_Object)-->void:inDataset-->(void:Dataset)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E73_Information_Object)\\n"
            + "(crm:E22_Man-Made_Object)-->crmsci:O19i_was_object_found_by-->crmsci:S19_Encounter_Event\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n"
            + "(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\\n"
            + "(crm:E12_Production)-->crm:P32_used_general_technique-->kon:Technique\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person\\n"
            + "(crm:E21_Person)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E21_Person)-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n"
            + "(crm:E21_Person)-->skos:broader-->(crm:E74_Group)\\n"
            + "(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n"
            + "(crm:E74_Group)-->skos:changeNote-->dcterms:ProvenanceStatement\\n"
            + "(crm:E74_Group)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n"
            + "(crm:E53_Place)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E53_Place)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E53_Place)-->skos:definition-->{Literal}\\n"
            + "(crm:E53_Place)-->skos:broader-->{Literal}\\n"
            + "(crm:E53_Place)-->rdfs:label-->{Literal}\\n"
            + "(crm:E53_Place)-->skos:inScheme-->{Literal}\\n"
            + "(crm:E53_Place)-->skos:closeMatch-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->skos:definition-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->skos:altLabel-->{Literal}\\n"
            + "(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\\n"
            + "(crm:E78_Collection)-->rdf:type-->{Literal}\\n"
            + "(crm:E78_Collection)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E78_Collection)-->skos:definition-->{Literal}\\n"
            + "(crm:E4_Period)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E4_Period)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E4_Period)-->skos:definition-->{Literal}\\n"
            + "(crm:E57_Material)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E57_Material)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E57_Material)-->skos:definition-->{Literal}\\n"
            + "(crm:E57_Material)-->skos:altLabel-->{Literal}\\n"
            + "(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n"
            + "(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n"
            + "(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E36_Visual_Item)-->dcterms:format-->{Literal}\\n"
            + "(crm:E36_Visual_Item)-->dcterms:conformsTo-->{Literal}\\n"
            + "(crm:E73_Information_Object)-->dcterms:format-->{Literal}\\n"
            + "(crm:E73_Information_Object)-->dcterms:conformsTo-->{Literal}\\n"
            + "(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\\n"
            + "(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\\n"
            + "(crm:E21_Person)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E21_Person)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E21_Person)-->skos:definition-->{Literal}\\n"
            + "(crm:E21_Person)-->rdfs:seeAlso-->{Literal}\\n"
            + "(crm:E21_Person)-->dcterms:source-->{Literal}\\n"
            + "(crm:E21_Person)-->rdfs:label-->{Literal}\\n"
            + "(crm:E74_Group)-->skos:prefLabel-->{Literal}\\n"
            + "(crm:E74_Group)-->skos:exactMatch-->{Literal}\\n"
            + "(crm:E74_Group)-->skos:definition-->{Literal}\\n"
            + "(crm:E74_Group)-->rdfs:seeAlso-->{Literal}\\n"
            + "(crm:E74_Group)-->rdfs:label-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P32_used_general_technique-->kon:Technique\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n"
            + "(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person-->dcterms:isReplacedBy-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n"
            + "crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->dcterms:conformsTo-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->dcterms:format-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->rdf:type-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(crmgeo:SP5_Geometric_Place_Expression)-->geo:lat-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:lat-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression-->geo:long-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:long-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n"
            + "(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->rdfs:label-->{Literal}\\n"
            + "###end of Path Patterns###\\n"
            + "By using properties and classes of the above patters, \\n"
            + "and  by never putting a class as a property,  \\n"
            + "please generate only a SPARQL query {without explanation} for answering the question ";

    public static String patternsKerameikos = "(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E40_Legal_Body)-->foaf:homepage-->(void:Dataset)\n"
            + "(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\n"
            + "(crm:E4_Period)-->skos:changeNote-->dcterms:ProvenanceStatement\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E57_Material)-->skos:changeNote-->dcterms:ProvenanceStatement\n"
            + "(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)\n"
            + "(crm:E22_Man-Made_Object)-->kon:hasShape-->(kon:Shape)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P129i_is_subject_of-->(crm:E73_Information_Object)\n"
            + "(crm:E22_Man-Made_Object)-->crmsci:O19i_was_object_found_by-->crmsci:S19_Encounter_Event\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\n"
            + "(crm:E12_Production)-->crm:P32_used_general_technique-->(kon:Technique)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)\n"
            + "(crm:E21_Person)-->org:hasMembership-->org:Membership\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E53_Place)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E53_Place)-->skos:exactMatch-->{Literal}\n"
            + "(crm:E53_Place)-->skos:definition-->{Literal}\n"
            + "(crm:E53_Place)-->skos:broader-->{Literal}\n"
            + "(crm:E53_Place)-->rdfs:label-->{Literal}\n"
            + "(crm:E40_Legal_Body)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E40_Legal_Body)-->skos:exactMatch-->{Literal}\n"
            + "(crm:E40_Legal_Body)-->skos:definition-->{Literal}\n"
            + "(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\n"
            + "(crm:E4_Period)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E4_Period)-->skos:exactMatch-->{Literal}\n"
            + "(crm:E4_Period)-->skos:definition-->{Literal}\n"
            + "(crm:E57_Material)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E57_Material)-->skos:definition-->{Literal}\n"
            + "(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\n"
            + "(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\n"
            + "(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\n"
            + "(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\n"
            + "(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E73_Information_Object)-->dcterms:format-->{Literal}\n"
            + "(crm:E73_Information_Object)-->dcterms:conformsTo-->{Literal}\n"
            + "(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\n"
            + "(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\n"
            + "(crm:E21_Person)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E21_Person)-->skos:exactMatch-->{Literal}\n"
            + "(crm:E21_Person)-->skos:definition-->{Literal}\n"
            + "(crm:E21_Person)-->rdfs:seeAlso-->{Literal}\n"
            + "(crm:E21_Person)-->dcterms:source-->{Literal}\n"
            + "(crm:E21_Person)-->rdfs:label-->{Literal}\n"
            + "(crm:E74_Group)-->skos:prefLabel-->{Literal}\n"
            + "(crm:E74_Group)-->skos:exactMatch-->{Literal}\n"
            + "(crm:E74_Group)-->skos:definition-->{Literal}\n"
            + "(crm:E74_Group)-->rdfs:seeAlso-->{Literal}\n"
            + "(crm:E74_Group)-->rdfs:label-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P32_used_general_technique-->(kon:Technique)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n"
            + "crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)-->org:hasMembership-->org:Membership\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->org:Membership\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:lat-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:long-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\n"
            + "(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\n"
            + "(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->rdfs:label-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->(geo:SpatialThing)\n"
            + "crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->{Literal}\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->{Literal}\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(foaf:Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->crm:E52_Time-Span\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->crm:E52_Time-Span\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\n"
            + "(crmsci:S19_Encounter_Event)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->(geo:SpatiaLThing)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\n"
            + "(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\n"
            + "(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n"
            + "(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\n"
            + "(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)";

            public static String promptR3Kerameikos="You are given the following path patterns of the form (Class)-->Property-->(Class)-->...-->(Class) or {Literal}  \\n" +
"###Path Patterns\\n" +
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
"(crm:E21_Person)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E21_Person)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->skos:broader-->(crm:E74_Group)\\n" +
"(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n" +
"(crm:E74_Group)-->skos:changeNote-->dcterms:ProvenanceStatement\\n" +
"(crm:E74_Group)-->org:hasMembership-->(org:Membership)\\n" +
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
"(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n" +
"(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n" +
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
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P32_used_general_technique-->kon:Technique\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P45_consists_of-->(crm:E57_Material)-->skos:broader-->(crm:E57_Material)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->org:hasMembership-->(org:Membership)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->dcterms:conformsTo-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->dcterms:format-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P138i_has_representation-->(crm:E36_Visual_Item)-->rdf:type-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression-->geo:lat-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:lat-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression-->geo:long-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->geo:long-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P190_has_symbolic_content-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P190_has_symbolic_content-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E33_E41_Linguistic_Appellation)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P1_is_identified_by-->(crm:E42_Identifier)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P2_has_type-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P90_has_value-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P43_has_dimension-->(crm:E54_Dimension)-->crm:P91_has_unit-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n" +
"(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n" +
"(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n" +
"(crm:E78_Collection)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:homepage-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P50_has_current_keeper-->(crm:E40_Legal_Body)-->foaf:thumbnail-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->rdfs:label-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->foaf:Person-->dcterms:isReplacedBy-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->(crm:E21_Person)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->skos:related-->(crm:E21_Person)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82a_begin_of_the_begin-->{Literal, xsd:gYear}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P4_has_time-span-->(crm:E52_Time-Span)-->crm:P82b_end_of_the_end-->{Literal, xsd:gYear}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->(crm:E52_Time-Span)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->skos:broader-->(crm:E53_Place)\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->(crm:E74_Group)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression-->dcterms:isPartOf-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->crmgeo:SP5_Geometric_Place_Expression\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)-->dcterms:isPartOf-->(geo:SpatialThing)\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->(geo:SpatialThing)\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->(geo:SpatialThing)\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P10_falls_within-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E4_Period)-->crm:P4_has_time-span-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P7_took_place_at-->(crm:E53_Place)-->geo:location-->{Literal}\\n" +
"(crm:E22_Man-Made_Object)-->crm:P108i_was_produced_by-->(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->{Literal}\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->{Literal}\\n" +
"crmsci:S19_Encounter_Event-->crm:P7_took_place_at-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P168_place_is_defined_by-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->{Literal}\\n" +
"(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->crm:P89_falls_within-->(crm:E53_Place)-->geo:location-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E21_Person)-->crm:P15_was_influenced_by-->{Literal}\\n" +
"(crm:E12_Production)-->crm:P9_consists_of-->(crm:E12_Production)-->crm:P14_carried_out_by-->(crm:E74_Group)-->crm:P15_was_influenced_by-->{Literal}\\n" +
"###end of Path Patterns###\\n" +
"By using properties and classes from the above patterns,\\n" +
"and  by never putting a class as a property,  \\n" +
"please generate only a SPARQL query (without explanation) for answering the question ";
}
