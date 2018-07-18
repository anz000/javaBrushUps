package anuz.interfaceEx.payment;

/*
 * This is the interface for the payments 
 */
public interface PaymentInterface {

	public String sale(SaleRequest request);
	public String voidM(VoidRequest request); 
	public String authorization(AuthRequest request);
	public String priorAuthorationSale(SaleRequest request); 
	public String incrementAuthorization(IncrementAuthorizationRequest request); 
}
