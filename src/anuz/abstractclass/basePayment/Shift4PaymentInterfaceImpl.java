package anuz.abstractclass.basePayment;

import anuz.interfaceEx.payment.IncrementAuthorizationRequest;
import anuz.interfaceEx.payment.SaleRequest;
import anuz.interfaceEx.payment.VoidRequest;

public class Shift4PaymentInterfaceImpl extends BasePaymentInterface{

	@Override
	public String voidM(VoidRequest request) {
		request.setRequest("Shift-Void");
		return(request.getRequest());
	}

	@Override
	public String priorAuthorationSale(SaleRequest request) {
		request.setRequest("Shift-PriorAuthorizationSale");
		return(request.getRequest());
	}

	@Override
	public String incrementAuthorization(IncrementAuthorizationRequest request) {
		request.setRequest("Shift-Increment-Authorization");
		return(request.getRequest());
	}

}
