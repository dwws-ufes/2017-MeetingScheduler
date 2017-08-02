//import java.io.IOException;
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.jena.rdf.model.Model;
//import org.apache.jena.rdf.model.ModelFactory;
//import org.apache.jena.rdf.model.Resource;
//import org.apache.jena.rdf.model.ResourceFactory;
//
//import br.ufes.inf.nemo.mscheduler.application.ManageMeetingsService;
//import br.ufes.inf.nemo.mscheduler.domain.Meeting;
//import br.ufes.inf.nemo.mscheduler.persistence.MeetingDAO;
//
//@WebServlet(urlPatterns = { "/data/tourpackages" })
//public
//class ListPackagesInRdfServlet extends HttpServlet {
//
//	@EJB
//	private TourPackageDAO tourPackageDAO;
//	
//	@EJB
//	private MeetingDAO meetingDAO; 
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws	ServletException, IOException {
//		resp.setContentType("text/xml");
//		
//		List<Meeting> meetings = meetingDAO.retrieveAll();
//		
//		Model model = ModelFactory.createDefaultModel();
//		String myNS = "http://localhost:8080/MScheduler/Meetings";
//		String grNS = "http://motools.sf.net/event/event.122.n3";
//		model.setNsPrefix("gr", grNS);
//		Resource grOffering = ResourceFactory.createResource(grNS + "Offering");
//		Resource grPriceSpecification = ResourceFactory.createResource(grNS
//				+ 
//				"PriceSpecification");
//		Property gravailabilityStarts = ResourceFactory.createProperty(grNS + 
//				"availabilityStarts");
//		Property gravailabilityEnds = ResourceFactory.createProperty(grNS + 
//				"availabilityEnds");
//		Property grhasPriceSpecification = ResourceFactory.createProperty(grNS + 
//						"hasPriceSpecification");
//		Property grhasCurrencyValue = ResourceFactory.createProperty(grNS + 
//				"hasCurrencyValue");
//		for (TourPackage pack : packs) {
//			model.createResource(myNS + pack.getId())
//			.addProperty(RDF.type, 
//					grOffering)
//			.addProperty(RDFS.label, pack.getName())
//			.addProperty(RDFS.comment, pack.getDescription())
//			.addLiteral(gravailabilityStarts, 
//					ResourceFactory.createTypedLiteral(df.format(pack.getBegin()), 
//							XSDDatatype.XSDdateTime))
//			.addLiteral(gr
//					availabilityEnds, 
//					ResourceFactory.createTypedLiteral(df.format(pack.getEnd()), 
//							XSDDatatype.XSDdateTime))
//			.addProperty(grhasPriceSpecification, model.createResource()
//					.addProperty(RDF.type, grPriceSpecification)
//					.addLiteral(grhasCurrencyValu
//							e, pack.getPrice().floatValue()));
//		}
//		try (PrintWriter out = resp.getWriter()) {
//			model.write(out, "RDF/XML");
//		}
//	}
//}