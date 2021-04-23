package fr.gestionStock;

import java.math.BigDecimal;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gestionStock.persistance.entities.Categorie;
import fr.gestionStock.persistance.entities.Client;
import fr.gestionStock.persistance.service.CategorieService;
import fr.gestionStock.persistance.service.ClientService;


public class TestGestionStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ClientService clientService = ctx.getBean("clientServiceImpl", ClientService.class);
		
		Client clt = new Client();
		clt.setIdclient(new BigDecimal(17));
		clt.setCiviliteclient("mr");
		clt.setNomclient("Liam");
		clientService.add(clt);
		
		CategorieService categService = ctx.getBean("categorieServiceImpl", CategorieService.class);
		
		Categorie ca = new Categorie();
		ca.setIdcateg(new BigDecimal(15));
		ca.setCodecateg("45");
		ca.setLibellecateg("Produit Alimentaire");
		
		categService.add(ca);
		
		
		
		
		ctx.close();
	}

}
