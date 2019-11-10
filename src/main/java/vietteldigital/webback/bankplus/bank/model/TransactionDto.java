package vietteldigital.webback.bankplus.bank.model;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

	private String name;

	private String mark;

	private String ft;

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
}
