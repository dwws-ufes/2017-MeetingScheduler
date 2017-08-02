package br.ufes.inf.nemo.mscheduler.lod;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObject;
import br.ufes.inf.nemo.marvin.core.application.ManageAcademicsService;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Stateful
@LocalBean
@Model
public class importAcademicData{
	
	@EJB
	private ManageAcademicsService manageAcademicsService;
	
	
	
	public ResultSet suggestDescription(){
		
		Academic academic;
		
		String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
				+ "PREFIX wd: <http://www.wikidata.org/entity/> \n"
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/> \n"
				+ "SELECT ?b ?familia ?nome ?nNativo ?dataNasc \n"
				+ "WHERE { \n"
				+ "?b wdt:P106 wd:Q1622272 ; \n"
				+ " wdt:P735 ?n ; \n"
				+ " wdt:P734 ?f . \n"
				+ "?n rdfs:label ?nome. \n"
				+ "?f rdfs:label ?familia. \n"
				+ "?b wdt:P106 wd:Q1622272 ; \n"
				+ " wdt:P1559 ?nNativo ; \n"
				+ " wdt:P569 ?dataNasc \n"
				+ "FILTER (LANG(?nome) = 'en') . \n"
				+ "FILTER (LANG(?familia) = 'en') . \n"
				+ "} \n"
				+ "LIMIT 100 \n";
					
			QueryExecution queryExecution =	QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);
			ResultSet results = queryExecution.execSelect();
			
			return results;
			
			//while(results.hasNext()) {
			//	QuerySolution querySolution = results.next();
				
				
				
			//	academic.setName(querySolution.getLiteral("nNativo").getValue().toString());
			//	academic.setShortName(querySolution.getLiteral("nome").getValue().toString());
				
				
			//	System.out.println(querySolution.getLiteral("nNativo").getValue().toString());
		//	}
		}



	public ManageAcademicsService getManageAcademicsService() {
		return manageAcademicsService;
	}
	public void setManageAcademicsService(ManageAcademicsService manageAcademicsService) {
		this.manageAcademicsService = manageAcademicsService;
	}
	
	
}

