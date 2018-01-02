package pl.java.scalatech.tests.web3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	public Order(long nextLong) {
		this.id = nextLong;
	}
	private Long  id;
	private Trade trade;
private Long timestamp;
}