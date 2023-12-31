	package eatitproject.eatitproject.models;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	public class Commande {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private double total;
	    private String state;
	    @ManyToMany
	    private List<Snack> snacks;

	    
	    public Commande(List<Snack> snacks) {
	        this.snacks = snacks;
	    }

	    public Commande() {
	    }
	    
	
			public Long getId() {
	        return id;
	    }
	
	    public void setId(Long id) {
	        this.id = id;
	    }
	
	
	    public void setTotal(double total2) {
	        this.total = total2;
	    }
	
	    public List<Snack> getSnacks() {
			return snacks;
		}

		public void setSnacks(List<Snack> snacks) {
			this.snacks = snacks;
		}

		public double getTotal() {
	        return total;
	    }

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	
	
	}
