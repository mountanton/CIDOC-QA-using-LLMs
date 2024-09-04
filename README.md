# CIDOC QA using Large Language Models (LLMs)

This page contains the evaluation collection for answering natural questions  over CIDOC-CRM by using LLMs. 
In particular 100  natural questions (and the corresponding SPARQL queries) are provided  (of different radius or depth), which were produced by using the Smithsonian American Art Museum (SAAM) KG and the Kerameikos KG.

The evaluation collection is provided in different folders according to the type of the questions.

## A. SPARQL Queries for Creating the Patterns

### SPARQL Template for Path Patterns of Radius 1 (Triple Patterns)


```sparql
SELECT distinct ?class1 ?property ?class2
WHERE {
  ?subject1 ?property ?object1 . 
  ?subject1 a ?class1 .
  optional{?object1 a ?class2} 
 .filter(!regex(?property,rdf:type))
}
```
### SPARQL Template for Path Patterns of Radius 2 

```sparql
SELECT distinct ?class1 ?property ?class2  ?property2 ?class3
WHERE {
  ?subject1 ?property ?object1 .
  ?object1 ?property2 ?object2 .
  ?subject1 a ?class1 .
  ?object1 a ?class2
  optional{?object2 a ?class3} 
 .filter(regex(?property,"cidoc") && !regex(?property2,rdf:type))
}
```

### SPARQL Template for Path Patterns of Radius 3

```sparql
prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?class1 ?property ?class2  ?property2 ?class3 ?property3 ?class4
WHERE {
  ?subject1 ?property ?object1 .
  ?object1 ?property2 ?object2 .
  ?object2 ?property3 ?object3 .
  ?subject1 a ?class1 .
  ?object1 a ?class2 .
  ?object2 a ?class3
  optional{?object3 a ?class4} 
 .filter(regex(?property,"cidoc") && regex(?property2,"cidoc") && !regex(?property3,rdf:type))
}
```

### SPARQL Template for Path Patterns of Radius 4
```sparql
prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

SELECT distinct ?class1 ?property ?class2  ?property2 ?class3 ?property3 ?class4 ?property4 ?class5
WHERE {
  ?subject1 ?property ?object1 .
  ?object1 ?property2 ?object2 .
  ?object2 ?property3 ?object3 .
  ?object3 ?property4 ?object4 .
  ?subject1 a ?class1 .
  ?object1 a ?class2 .
  ?object2 a ?class3 .
  ?object3 a ?class4
  optional{?object4 a ?class5} 
 .filter(regex(?property,"cidoc") && regex(?property2,"cidoc")
  && regex(?property3,"cidoc")  && !regex(?property4,rdf:type))
}
```

## B. Evaluation Benchmark- Queries and Prompt Templates
In this page you can find the evaluation benchmark and the prompt templates for each method and KG.

## C. Evaluation Results  
In this page you can find all the generated queries for each method and the corresponding results in excel files.

## D. Code  
In this page you can find the code for sparql generation and filtering


