package pl.java.scalatech.es2;

import java.util.Date;

import org.springframework.data.repository.NoRepositoryBean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoRepositoryBean
public class TradeEvent {
private double amount;
private Date tradeExecutionTime;

}
