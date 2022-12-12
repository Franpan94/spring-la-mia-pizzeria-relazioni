package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizzeria;
import org.generation.italy.demo.serv.DrinkService;
import org.generation.italy.demo.serv.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzeriaService pizzeriaService;
	
	@Autowired
	private DrinkService drinkService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creazione pizze
		Pizzeria p1 = new Pizzeria("Da Ciccio", "https://garage.pizza/wp-content/uploads/2020/01/DSCF3889-2560x2560.jpeg", 15, "Una delle pizze più buone che ci sia, gustosa e saporita.");
		Pizzeria p2 = new Pizzeria("La più buona", "https://garage.pizza/wp-content/uploads/2020/12/DSCF3442-2560x2560.jpg", 12, "Non si può rifiutare una pizza del genere, solo gusto.");
		Pizzeria p3 = new Pizzeria("Bufalina", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg/800px-Eq_it-na_pizza-margherita_sep2005_sml.jpg", 10, "Pura mozzarella di bufala, una delizia.");
		Pizzeria p4 = new Pizzeria("Toccasana", "https://garage.pizza/wp-content/uploads/2020/10/DSCF6160-2560x2560.jpeg", 18, "Un vero e proprio toccasana, restituisce solo dolci sapori.");
		Pizzeria p5 = new Pizzeria("Vegetariana", "https://www.scattidigusto.it/wp-content/uploads/2021/07/pizzeria-50-Kalo-Ciro-Salvo-Napoli-pizza-Nerano.jpg", 13, "Se vuoi mantenerti leggero è la pizza giusta.");
		
		pizzeriaService.save(p1);
		pizzeriaService.save(p2);
		pizzeriaService.save(p3);
		pizzeriaService.save(p4);
		pizzeriaService.save(p5);
		
		//Leggiamo le pizze salvate
		List<Pizzeria> pizze = pizzeriaService.findAll();
		System.out.println(pizze);
		
		//Creazione drinks
		Drink d1 = new Drink("Gin-tonic", "https://winedharma.com/wine-dharma/uploads/2020/10/Gin-Tonic-cocktail-ricetta-cocktail-con-gin-e-acqua-tonica.-Gin-tonic-con-lime.jpg", "Una bevanda alcolica, neutra e digeribile.", 8);
		Drink d2 = new Drink("Donperignon", "https://media-verticommnetwork1.netdna-ssl.com/wines/dom-perignon-vintage-492333.jpg", "Una bevanda di alta qualità ottima per un buon aperitivo.", 450);
		Drink d3 = new Drink("Negroni", "https://www.bargiornale.it/wp-content/uploads/sites/4/2018/09/negroni.png", "Una bevanda molto alcolica, poco digeribile.", 10);
	    Drink d4 = new Drink("Spritz", "https://upload.wikimedia.org/wikipedia/commons/0/05/Spritz01.jpg", "Una bevanda leggermente alcolica, per ottimi aperitivi.", 9);
		Drink d5 = new Drink("Coca-cola", "https://www.topbevande.it/images/thumbs/0085545_coca-cola-original-33cl-confezione-da-24-barattoli-lattina_780.jpeg", "Una bevanda gassata e molto buona da bere in qualsiasi momento.", 3);
				
		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);
		drinkService.save(d5);
				
		//Leggiamo i nostri drinks
		List<Drink> drinks = drinkService.findAll();
		System.out.println(drinks);
	}
}
