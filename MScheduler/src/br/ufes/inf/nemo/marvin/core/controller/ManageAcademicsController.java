package br.ufes.inf.nemo.marvin.core.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.jena.datatypes.xsd.XSDDateTime;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdf.model.impl.ResourceImpl;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.nemo.marvin.core.application.ManageAcademicsService;
import br.ufes.inf.nemo.marvin.core.domain.Academic;

@Named
@SessionScoped
public class ManageAcademicsController extends CrudController<Academic> {

	@EJB
	private ManageAcademicsService manageAcademicsService;
	
	private String stringBuscaAcademics;
	
	private List<Academic> academicsList;
	
	private List<Academic> selectedParticipants;
	
	private String occupations;
	


	@Override
	protected CrudService<Academic> getCrudService() {
		return manageAcademicsService;
	}

	@Override
	protected void initFilters() {
		// TODO Auto-generated method stub
		addFilter(new LikeFilter("manageAcademics.filter.byName", "name", getI18nMessage("msgsCore", "manageAcademics.text.filter.byName")));
		
	}

	public void importAcademics(){
		
		String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
				+ "PREFIX wd: <http://www.wikidata.org/entity/> \n"
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/> \n"
				+ "PREFIX wikibase: <http://wikiba.se/ontology#> \n"
				+ "PREFIX bd: <http://www.bigdata.com/rdf#> \n"
				+ "SELECT ?b ?familia ?nome ?nNativo ?dataNasc ?gender ?bLabel\n"
				+ "WHERE { \n"
				+ "?b wdt:P106 wd:Q1622272 ; \n"
				+ " wdt:P735 ?n ; \n"
				+ " wdt:P734 ?f . \n"
				+ "?n rdfs:label ?nome. \n"
				+ "?f rdfs:label ?familia. \n"
				//+ "?b wdt:P106 wd:Q1622272 ; \n"
				+ "?b wdt:P1559 ?nNativo ; \n"
				+ " wdt:P569 ?dataNasc ; \n"
				+ " wdt:P21 ?gender. \n"
				+ "SERVICE wikibase:label { bd:serviceParam wikibase:language 'en'. } \n"
				+ "FILTER (LANG(?nome) = 'en') . \n"
				+ "FILTER (LANG(?familia) = 'en') . \n"
				+ "} \n"
				+ "LIMIT 10 \n";
			
		String query2 = "PREFIX wd: <http://www.wikidata.org/entity/> \n"
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/> \n"
				+ "PREFIX wikibase: <http://wikiba.se/ontology#> \n"
				+ "PREFIX bd: <http://www.bigdata.com/rdf#> \n"			
				+ "SELECT ?b ?dataNasc ?bLabel ?gender\n"
				+ "WHERE {   ?b wdt:P106 wd:Q1622272. \n"
				+ "?b wdt:P569 ?dataNasc ;\n"
				+ "wdt:P21 ?gender. \n" 
				+ "SERVICE wikibase:label { bd:serviceParam wikibase:language 'en'. }\n"
				+ "} \n"
				+ "LIMIT 20 \n";
		

		
			QueryExecution queryExecution =	QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query2);
			ResultSet results = queryExecution.execSelect();
		
			
			
		while(results.hasNext()) {
			
			QuerySolution querySolution = results.next();
			selectedEntity = new Academic();
			
			Literal literal;

			
			
			literal = querySolution.getLiteral("bLabel");
			selectedEntity.setName((String) literal.getLexicalForm());
			System.out.println("NAME SUBSTRING: "+selectedEntity.getName());
			
			//System.out.println(literal.asResource().getNameSpace().toString());
			
			String name = (String) literal.getLexicalForm();
			name = name.substring(0, name.indexOf(' '));
 			selectedEntity.setShortName(name);
 			System.out.println("SHORT NAME SUBSTRING: "+name);
 			System.out.println("SHORT NAME: "+selectedEntity.getShortName());
			
			literal = querySolution.getLiteral("dataNasc");
			Calendar birthdate = ((XSDDateTime) literal.getValue()).asCalendar();
			Date date = birthdate.getTime();
			selectedEntity.setBirthDate(date);
			
			String a = querySolution.getResource("gender").getLocalName().toString();
			if(a.compareTo("Q6581097")==0){	
				selectedEntity.setGender((Character)'M');
			}else if(a.compareTo("Q6581072")==0){
				selectedEntity.setGender((Character)'F');
			}
			
			
			Resource res = querySolution.getResource("b");
			selectedEntity.setWikidataId(res.getLocalName());
			
			
			
			save();
			
			
		}
		
		
	}
	
	public String discoverOccupations(){
		if (selectedEntity == null || selectedEntity.getWikidataId() == null || selectedEntity.getWikidataId().isEmpty()){return "";}
		
		String occupations = "";
		String id = selectedEntity.getWikidataId();
		
		String query = "PREFIX wd: <http://www.wikidata.org/entity/> "
				+ "PREFIX wdt: <http://www.wikidata.org/prop/direct/> "
				+ "PREFIX wikibase: <http://wikiba.se/ontology#> "
				+ "PREFIX bd: <http://www.bigdata.com/rdf#> "
				+ "SELECT ?occupationLabel WHERE { "
				+ " wd:"+id+" wdt:P106 ?occupation; "
				+ "  SERVICE wikibase:label { bd:serviceParam wikibase:language 'en'.}"
				+ "}";
		
		
		QueryExecution queryExecution =	QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);
		ResultSet results = queryExecution.execSelect();
		
		while(results.hasNext()) {
			
			QuerySolution querySolution = results.next();
			Literal literal = querySolution.getLiteral("occupationLabel");			
			occupations = occupations + literal.getLexicalForm() + "; ";		
			
		}		
		
		return occupations;		
	}

	
	public void retrieveAcademicsListByName() throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		if(stringBuscaAcademics != null){
			System.out.println(stringBuscaAcademics);
		}else{
			System.out.println("stringBuscaResources é null");
		}
		if (!stringBuscaAcademics.isEmpty()) {
			System.out.println("Buscando Academics "+stringBuscaAcademics);
			setAcademicsList(((ManageAcademicsService) getCrudService()).retrieveByName(stringBuscaAcademics));
		}
	}

	public ManageAcademicsService getManageAcademicsService() {
		return manageAcademicsService;
	}

	public void setManageAcademicsService(ManageAcademicsService manageAcademicsService) {
		this.manageAcademicsService = manageAcademicsService;
	}

	public String getStringBuscaAcademics() {
		return stringBuscaAcademics;
	}

	public void setStringBuscaAcademics(String stringBuscaAcademics) {
		this.stringBuscaAcademics = stringBuscaAcademics;
	}

	public List<Academic> getAcademicsList() {
		return academicsList;
	}

	public void setAcademicsList(List<Academic> academicsList) {
		this.academicsList = academicsList;
	}

	public List<Academic> getSelectedParticipants() {
		return selectedParticipants;
	}

	public void setSelectedParticipants(List<Academic> selectedParticipants) {
		this.selectedParticipants = selectedParticipants;
	}

	public String getOccupations() {
		return discoverOccupations();
	}

	public void setOccupations(String occupations) {
		this.occupations = occupations;
	}
	
	
}
