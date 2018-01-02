package pl.java.scalatech.tests.web3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {

	public Trade(long id) {
	  this.id = id;
	}
	private Long id;
	private String symbol;
	private Float price;
	private Integer quantity;
	private Type type;
}