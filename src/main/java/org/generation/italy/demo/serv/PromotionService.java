package org.generation.italy.demo.serv;

import org.generation.italy.demo.pojo.Promotion;
import org.generation.italy.demo.repo.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
     
	@Autowired
	private PromotionRepo promotionRepo;
	
	public void save(Promotion promotion) {
		
		promotionRepo.save(promotion);
	}
	
	public void findAll() {
		
		promotionRepo.findAll();
	}
	
	public void delete(Promotion promotion) {
		
		promotionRepo.delete(promotion);
	}
}
