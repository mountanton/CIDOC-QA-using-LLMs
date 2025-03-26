package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import backend.FILTER_METHOD_KERAMEIKOS;
import backend.FILTER_METHOD_SAAM;
import backend.Resources_Kerameikos;
import backend.Resources_SAAM;
import backend.SendSPARQLQuery;
import backend.Text2SPARQL;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author micha
 */
public class GetAnswer extends HttpServlet {

    String prefixes = ""
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n"
            + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
            + "PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX saam: <http://data.americanart.si.edu/>\n"
            + "PREFIX aat: <http://vocab.getty.edu/aat/> \n"
            + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n";
    String limit = " limit 500";

    String prefixesKerameikos = "PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>\n"
            + "PREFIX crmgeo: <http://www.ics.forth.gr/isl/CRMgeo/>\n"
            + "PREFIX crmsci: <http://www.ics.forth.gr/isl/CRMsci/>\n"
            + "PREFIX dcterms: <http://purl.org/dc/terms/>\n"
            + "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>\n"
            + "PREFIX kid: <http://kerameikos.org/id/>\n"
            + "PREFIX kon: <http://kerameikos.org/ontology#>\n"
            + "PREFIX org: <http://www.w3.org/ns/org#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n"
            + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
            + "PREFIX crmarchaeo:	<http://www.cidoc-crm.org/cidoc-crm/CRMarchaeo/>\n"
            + "PREFIX ogc:	<http://www.opengis.net/ont/geosparql#>\n"
            + "PREFIX rdfs:	<http://www.w3.org/2000/01/rdf-schema#>\n"
            + "PREFIX foaf:	<http://xmlns.com/foaf/0.1/>\n"
            + "PREFIX edm:	<http://www.europeana.eu/schemas/edm/>\n"
            + "PREFIX prov:	<http://www.w3.org/ns/prov#>\n";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("application/json;charset=UTF-8");
        //  request.setCharacterEncoding("ISO-8859-7");
        String query = request.getParameter("query");
        Text2SPARQL t2spa = new Text2SPARQL();
        SendSPARQLQuery fQuery = new SendSPARQLQuery();
        String querys = "";
        String method = request.getParameter("method");
        System.out.println("method");
        String kg = request.getParameter("kg");
        String res = "";
        String model = request.getParameter("model");
        System.out.println(model);

        if (kg.equals("saam")) {
            int i = 0;
            while (i <= 1) {
                if (method.equals("two-stage")) {
                    FILTER_METHOD_SAAM fm = new FILTER_METHOD_SAAM();
                    System.out.println(query);
                    String predictions = fm.predictionPhase(query, model);
                    String ListOfClasses = "";
                    String ListOfProperties = "";
                    String[] split = predictions.split("List of Properties: ");
                    if (split.length == 2) {
                        ListOfClasses = split[0].replace("List of Classes: ", "").trim();
                        ListOfProperties = split[1].trim();
                    }
                    //System.out.println(ListOfClasses);
                    //System.out.println(ListOfProperties);
                    String finalPrompt = fm.FilteringPhase(ListOfClasses, ListOfProperties, Resources_SAAM.patternsSAAM, query);
                    System.out.println(finalPrompt);

                    try {
                        res = t2spa.chatGPT_TURBO(finalPrompt, model);
                    } catch (ProtocolException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // System.out.println(res);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                    // System.out.println(querys);
                } else if (method.equals("zero-shot")) {

                    res = t2spa.chatGPT_TURBO(Resources_SAAM.zeroshot + query, model);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                } else if (method.equals("onto")) {
                    res = t2spa.chatGPT_TURBO(Resources_SAAM.promptOntoSAAM + query, model);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                } else if (method.equals("path1")) {
                    res = t2spa.chatGPT_TURBO(Resources_SAAM.promptR1SAAM + query, model);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                } else if (method.equals("path2")) {
                    res = t2spa.chatGPT_TURBO(Resources_SAAM.promptR2SAAM + query, model);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                } else if (method.equals("path3")) {
                    res = t2spa.chatGPT_TURBO(Resources_SAAM.promptR3SAAM + query, model);
                    querys = prefixes + Resources_SAAM.removePrefixes(res);
                }
                String querySave = this.prefixes + "@@@" + Resources_Kerameikos.removePrefixes(res);
                if (querys.toLowerCase().contains("limit") == false) {
                    querys = querys + limit;
                    querySave = querySave + limit;
                }

                String res2 = "";
                JSONArray data = new JSONArray("[]");
                try {
                    res2 = fQuery.SaamQuery(querys);
                    data = new JSONArray(res2);
                } catch (IOException E) {
                    System.out.println("error");
                }
                //System.out.println("###\n" + res2);

                if (data.toString().equals("[]")) {
                    System.out.println("It was the " + (i + 1) + " try");
                    i++;
                    if (i == 2) {
                        request.getSession(true).setAttribute("SPARQL", querySave);
                        //  String data = "";
                        response.getWriter().println(data);
                    }
                } else {
                    System.out.println("It was the " + (i + 1) + " try");
                    i = 2;
                    request.getSession(true).setAttribute("SPARQL", querySave);
                    //  String data = "";
                    response.getWriter().println(data);
                    break;
                }
            }
        } else if (kg.equals("kerameikos")) {
            int i = 0;
            while (i <= 1) {

                if (method.equals("two-stage")) {
                    FILTER_METHOD_KERAMEIKOS fm = new FILTER_METHOD_KERAMEIKOS();
                    System.out.println(query);
                    String predictions = fm.predictionPhase(query, model);
                    String ListOfClasses = "";
                    String ListOfProperties = "";
                    String[] split = predictions.split("List of Properties: ");
                    if (split.length == 2) {
                        ListOfClasses = split[0].replace("List of Classes: ", "").trim();
                        ListOfProperties = split[1].trim();
                    }
                    //System.out.println(ListOfClasses);
                    //System.out.println(ListOfProperties);
                    String finalPrompt = fm.FilteringPhase(ListOfClasses, ListOfProperties, Resources_Kerameikos.patternsKerameikos, query);
                    System.out.println(finalPrompt);

                    try {
                        res = t2spa.chatGPT_TURBO(finalPrompt, model);
                    } catch (ProtocolException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JSONException ex) {
                        Logger.getLogger(Text2SPARQL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(res);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                    System.out.println(querys);
                } else if (method.equals("zero-shot")) {
                    res = t2spa.chatGPT_TURBO(Resources_Kerameikos.zeroshot + query, model);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                } else if (method.equals("onto")) {
                    res = t2spa.chatGPT_TURBO(Resources_Kerameikos.ontoKerameikos + query, model);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                } else if (method.equals("path1")) {
                    res = t2spa.chatGPT_TURBO(Resources_Kerameikos.promptR1Kerameikos + query, model);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                } else if (method.equals("path2")) {
                    res = t2spa.chatGPT_TURBO(Resources_Kerameikos.promptR2Kerameikos + query, model);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                } else if (method.equals("path3")) {
                    res = t2spa.chatGPT_TURBO(Resources_Kerameikos.promptR3Kerameikos + query, model);
                    querys = this.prefixesKerameikos + Resources_Kerameikos.removePrefixes(res);
                }
                //else if (method.equals("path3")) {
                //    res = t2spa.chatGPT_TURBO(Resources_SAAM.promptR3SAAM + query);
                //   querys = prefixes + Resources_SAAM.removePrefixes(res);
                //}

                String querySave = this.prefixesKerameikos + "@@@" + Resources_Kerameikos.removePrefixes(res);
                if (querys.toLowerCase().contains("limit") == false) {
                    querys = querys + limit;
                    querySave = querySave + limit;
                }
                String res2 = "";
                JSONArray data = new JSONArray("[]");
                try {
                    res2 = fQuery.kerameikosQuery(querys);
                    data = new JSONArray(res2);
                } catch (IOException E) {
                    System.out.println("error");
                }

                //String res2 = fQuery.kerameikosQuery(querys);
                //System.out.println("###\n" + res2);
                //JSONArray data = new JSONArray(res2);
                if (data.toString().equals("[]")) {
                    System.out.println("It was the " + (i + 1) + " try");
                    i++;
                    if (i == 2) {
                        request.getSession(true).setAttribute("SPARQL", querySave);
                        //  String data = "";
                        response.getWriter().println(data);
                    }
                } else {
                    System.out.println("It was the " + (i + 1) + " try");
                    i = 2;
                    request.getSession(true).setAttribute("SPARQL", querySave);
                    //  String data = "";
                    response.getWriter().println(data);
                    break;
                }

            }

            //   request.getSession(true).setAttribute("SPARQL", querySave);
            //  String data = "";
            //  response.getWriter().println(data);
        }
        response.setStatus(200);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GetAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GetAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
