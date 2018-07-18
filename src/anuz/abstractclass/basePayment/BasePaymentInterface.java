package anuz.abstractclass.basePayment;

import anuz.interfaceEx.payment.AuthRequest;
import anuz.interfaceEx.payment.PaymentInterface;
import anuz.interfaceEx.payment.SaleRequest;

public abstract class BasePaymentInterface implements PaymentInterface{
	public String sale(SaleRequest request) {
		request.setRequest("Base-Sale");
		return(request.getRequest());
	}
	
	public String authorization(AuthRequest request) {
		request.setRequest("Base-Authorization");
		return(request.getRequest());
	}
}
