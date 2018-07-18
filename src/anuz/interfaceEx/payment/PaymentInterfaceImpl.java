package anuz.interfaceEx.payment;

public class PaymentInterfaceImpl implements PaymentInterface {

	@Override
	public String sale(SaleRequest request) {
		request.setRequest("Sale");
		return(request.getRequest());
	}

	@Override
	public String voidM(VoidRequest request) {
		request.setRequest("Void");
		return(request.getRequest());

	}

	@Override
	public String authorization(AuthRequest request) {
		request.setRequest("Auth");
		return(request.getRequest());
	}

	@Override
	public String priorAuthorationSale(SaleRequest request) {
		request.setRequest("Sale");
		return(request.getRequest());
	}

	@Override
	public String incrementAuthorization(IncrementAuthorizationRequest request) {
		request.setRequest("IncrementalAuthorization");
		return(request.getRequest());

	}

}
