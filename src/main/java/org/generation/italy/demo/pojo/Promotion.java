package org.generation.italy.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column
    private LocalDate startDate;
    
    @NotNull
    @Column
    private LocalDate finishDate;
    
    @OneToMany(mappedBy = "promotion", cascade = CascadeType.REMOVE)
    private List<Pizzeria> pizze;
    
    @NotEmpty
    @Column
    String name;
    
    public Promotion() {
    	
    }
    
    public Promotion(LocalDate startDate, LocalDate finishDate, String name) {
    	setStartDate(startDate);
    	setFinishDate(finishDate);
    	setName(name);
    }

	public List<Pizzeria> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizzeria> pizze) {
		this.pizze = pizze;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
