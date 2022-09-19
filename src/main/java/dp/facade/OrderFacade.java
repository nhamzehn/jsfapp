package dp.facade;

public class OrderFacade {

	public void placeOrder() {
		Product product = new Product();
		product.getProductDetails();

		Invoice invoice = new Invoice();
		invoice.sendInvoice();

		Payment payment = new Payment();
		payment.makePayment();

	}

}
