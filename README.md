# CIDOC QA using Large Language Models

This page contains the evaluation collection for answering natural questions  over CIDOC-CRM by using LLMs. 
In particular 100  natural questions (and the corresponding SPARQL queries) are provided  (of different radius or depth), which were produced by using the Smithsonian American Art Museum (SAAM) KG and the Kerameikos KG.

The evaluation collection is provided in different folders according to the type of the questions.

## A. SPARQL Queries for Creating the Patterns

### SPARQL Template for Path Patterns of Radius 1 (Triple Patterns)


```sparql
SELECT distinct ?class1 ?property ?class2
WHERE {
  ?subject1 ?property ?object1 . 
  ?subject1 a ?class1 . optional{?object1 a ?class2} 
 .filter(!regex(?property,rdf:type))
}
```
### SPARQL Template for Path Patterns of Radius 2 

```sparql
SELECT distinct ?class1 ?property ?class2  ?property2 ?class3
WHERE {
  ?subject1 ?property ?object1 . ?object1 ?property2 ?object2 .
  ?subject1 a ?class1 . ?object1 a ?class2
  optional{?object2 a ?class3} 
 .filter(regex(?property,"cidoc") && !regex(?property2,rdf:type))
}
```

