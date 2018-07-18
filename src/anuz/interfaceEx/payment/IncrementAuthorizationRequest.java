package anuz.interfaceEx.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncrementAuthorizationRequest implements Request{
	private String request;
}
