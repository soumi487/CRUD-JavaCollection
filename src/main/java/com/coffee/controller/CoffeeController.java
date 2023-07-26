package com.coffee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.entity.Coffee;

@RestController
public class CoffeeController {
	
	private List<Coffee>coffees=new ArrayList<>();

	public CoffeeController() {
		coffees.addAll(List.of(
				new Coffee("Nescafe"),
				new Coffee("Bru"),
				new Coffee("Tim Hortons"),
				new Coffee("Starbucks"),
				new Coffee("Dunken"),
				new Coffee("Costa")));
	
	}	
	@GetMapping("/coffee")
	//@RequestMapping(value ="/coffee",method= RequestMethod.GET)
	Iterable<Coffee> getCoffees()
	{
		return coffees;
	}
	
	//Avoid NPE->java 8 compatible coding
	@GetMapping("/coffee/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id)
	{
		for(Coffee c:coffees)
		{
			if(c.getId().equals(id))
			{
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	//POST-ING new Coffee is added
	@PostMapping("/coffee")
	Coffee postCoffee(@RequestBody Coffee coffee)
	{
		coffees.add(coffee);
		return coffee;
	}
	
	//Update--->By Put Method
	@PutMapping("/coffee/{id}")
	String putCoffee(@PathVariable String id)
	{
		for(Coffee c:coffees)
		{
			if(c.getId().equals(id))
			{
				c.setName("Continental Coffee");
				coffees.set(0, c);
			}
		}
		return "Updated";
	}
	
	@DeleteMapping("/coffee/{id}")
	String deleteCoffee(@PathVariable String id)
	{
		coffees.removeIf(x->x.getId().equals(id));
		return "The coffee with id "+id+" has been removed as I don't like it!!!!!";
	}

}

/*package com.coffee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping
	public String test()
	{
		return "Hi";
	}

}*/
