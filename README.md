# CIDOC QA using Large Language Models

This page contains the evaluation collection for answering natural questions  over CIDOC-CRM by using LLMs. 
In particular 100  natural questions (and the corresponding SPARQL queries) are provided  (of different radius or depth), which were produced by using the Smithsonian American Art Museum (SAAM) KG and the Kerameikos KG.

The evaluation collection is provided in different folders according to the type of the questions.

## A. SPARQL Queries for Creating the Patterns

### Pattern Templates of Radius 1



```sparql
SELECT distinct ?class1 ?property ?class2
WHERE {
  ?subject1 ?property ?object1 . 
  ?subject1 a ?class1 . optional{?object1 a ?class2} 
 .filter(!regex(?property,rdf:type))
}
```
