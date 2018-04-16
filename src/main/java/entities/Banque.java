package entities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class Banque {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		marshal();
		unMarshal();
		JAXBContext context = JAXBContext.newInstance(Compte.class);
		context.generateSchema(new SchemaOutputResolver(){// Le but est de prendre le modele( est le transformer en fichier xml
			@Override
			public Result createOutput(String namespaceUrl, String suggestedFileName)
			throws IOException{
				File f= new File("compte.xsd"); // permet de cerifier la conformite  car un xsd peut contenir des regles
				StreamResult result = new StreamResult(f);
				result.setSystemId(f.getName());
				return result;
			}
		});
      
	}
	  public static void  marshal()  throws Exception{
			JAXBContext content =JAXBContext.newInstance(Compte.class);
	       Marshaller marshaller=  content.createMarshaller();
	       marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	       Compte cp = new Compte(2,5000F,new Date());
	       marshaller.marshal(cp,new File("compte2.xml"));
	      }
	      
	      
	      public static void unMarshal()  throws Exception{
	  		JAXBContext jc=JAXBContext.newInstance(Compte.class);
	         Unmarshaller unmarshaller= jc.createUnmarshaller();
	         Compte cp = (Compte) unmarshaller.unmarshal(new File("compte2.xml"));
	         System.out.println(cp.getCode() + "-"+ cp.getSolde() +"-" + cp.getDateCreation());
	         
	        }

}
