package br.ufes.inf.nemo.mscheduler.lod;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.inf.nemo.marvin.core.domain.Academic;
import br.ufes.inf.nemo.mscheduler.domain.Meeting;
import br.ufes.inf.nemo.mscheduler.persistence.MeetingDAO;

@WebServlet(urlPatterns = { "/data/meetings" })
public class ListPackagesInRdfServlet extends HttpServlet {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM- dd'T'HH:mm:ss");
	@EJB
	private MeetingDAO meetingDAO;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		
		resp.setContentType("text/xml");
		List<Meeting> packs = meetingDAO.retrieveAll();
		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/MScheduler/data/meeting/";
		String grNS = "https://www.wikidata.org/wiki/Q2761147#";// ou http://motools.sourceforge.net/event/event.html
		model.setNsPrefix("gr", grNS);
		/*
		* name
		initialDate
		endDate
		* theme
		* agenda
		minutes
		requester
		participants
		* room
		*/
		
		//Participant, StartTime, EndTime,MainSubject,Location
		Resource grMainSubject = ResourceFactory.createProperty(grNS + "P921"); //name ou theme ou agenda
		Resource grParticipant = ResourceFactory.createProperty(grNS + "P710"); //participants
		Resource grLocation = ResourceFactory.createProperty(grNS + "P276"); //room
		Resource grStartTime = ResourceFactory.createProperty(grNS + "P580"); //initialDate
		Resource grEndTime = ResourceFactory.createProperty(grNS + "P582"); //endDate
		
		
//		for (TourPackage pack : packs) {
//			model.createResource(myNS + pack.getId())
//				.addProperty(RDF.type, grOffering)
//				.addProperty(RDFS.label, pack.getName())
//				.addProperty(RDFS.comment, pack.getDescription())
//				.addLiteral(gravailabilityStarts,ResourceFactory.createTypedLiteral(df.format(pack.getBegin()),XSDDatatype.XSDdateTime))
//				.addLiteral(gravailabilityEnds,ResourceFactory.createTypedLiteral(df.format(pack.getEnd()),XSDDatatype.XSDdateTime))
//				.addProperty(grhasPriceSpecification, model.createResource()
//				.addProperty(RDF.type, grPriceSpecification)
//				.addLiteral(grhasCurrencyValue, pack.getPrice().floatValue()));
//		}
		
		
		for (Meeting pack : packs) {
			model.createResource(myNS + pack.getId())
				.addProperty(RDFS.label, pack.getName())			
				.addLiteral((Property)grMainSubject,(ResourceFactory.createTypedLiteral(pack.getTheme())))			
				.addLiteral((Property) grLocation,(ResourceFactory.createTypedLiteral("https://www.wikidata.org/wiki/Q168376")))			
				.addLiteral((Property) grStartTime,ResourceFactory.createTypedLiteral(df.format(pack.getInitialDate()),XSDDatatype.XSDdateTime))
				.addLiteral((Property) grEndTime,ResourceFactory.createTypedLiteral(df.format(pack.getEndDate()),XSDDatatype.XSDdateTime));
			//for (Academic academic : pack.getParticipants()) {
			//	model.addLiteral(grParticipant,null, ResourceFactory.createTypedLiteral(academic.getWikidataId()));// deve ser criado getWikiId com o valor de ?b			
			//}
		}
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
}