package anuz.abstractclass.basePayment;

import anuz.interfaceEx.payment.IncrementAuthorizationRequest;
import anuz.interfaceEx.payment.SaleRequest;
import anuz.interfaceEx.payment.VoidRequest;

public class ElavonPaymentInterfaceImpl extends BasePaymentInterface{

	@Override
	public String voidM(VoidRequest request) {
		request.setRequest("Elavon-Void");
		return(request.getRequest());
	}

	@Override
	public String priorAuthorationSale(SaleRequest request) {
		request.setRequest("Elavon-PriorAuthorizationSale");
		return(request.getRequest());
	}

	@Override
	public String incrementAuthorization(IncrementAuthorizationRequest request) {
		request.setRequest("Elavon-Increment-Authorization");
		return(request.getRequest());
	}

}
