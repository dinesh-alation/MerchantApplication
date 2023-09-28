# MerchantApplication
Application Architecture
Controllers

MerchantUI Controller (MerchantUI.java):
Purpose: This controller handles merchant-related operations
Endpoints:
POST /merchant/register: Allows merchants to register with the Payment Gateway Simulator.
Request Handling:
registerMerchant(@RequestBody MerchantDTO merchantDTO): This method processes POST requests for merchant registration. It takes a MerchantDTO as the request body, containing merchant details such as name, email, business type, address, and phone.

PaymentGateway Controller (PaymentGateway.java):
Purpose: This controller handles payment-related operations, including making payment requests to the Payment Gateway Simulator and checking payment statuses.
Endpoints:
POST /payment/makePayment: Allows merchants to send payment requests to the Payment Gateway Simulator.
GET /payment/status/{paymentCode}: Allows merchants to check the status of a payment by providing a unique payment code in the URL.
Request Handling:
makePayment(@RequestBody PaymentDTO paymentDTO): This method processes POST requests for making payments. It takes a PaymentDTO as the request body, containing payment details such as merchant ID, amount, currency, and order ID.
checkPaymentStatus(@PathVariable String paymentCode): This method processes GET requests to check the status of a payment by a provided payment code.

DTOs (Data Transfer Objects)
MerchantDTO (MerchantDTO.java):
Purpose: This DTO (Data Transfer Object) is used to transfer merchant information between the client and the server for registration purposes.
Attributes:
merchantId: Unique identifier for the merchant.
name: Merchant's name.
email: Merchant's email address.
businessType: Type of the merchant's business.
address: Merchant's address.
phone: Merchant's phone number.
PaymentDTO (PaymentDTO.java):
Purpose: This DTO is used to transfer payment information between the client and the server for making payment requests.
Attributes:
merchantId: Unique identifier of the merchant initiating the payment.
amount: The amount of the payment.
currency: Currency of the payment.
orderId: Unique identifier for the order.

Service Interfaces
MerchantUIservice (MerchantUIservice.java):
Purpose: This interface defines the contract for merchant-related operations.
Methods:
createMerchant(MerchantDTO merchantDTO): This method is responsible for initiating the merchant registration process.
Paymentservice (Paymentservice.java):
Purpose: This interface defines the contract for payment-related operations.
Methods:
makePayment(PaymentDTO paymentDTO): This method initiates the payment process.
checkPaymentStatus(String paymentCode): This method checks the status of a payment.

Service Implementations
MerchantUIServiceImpl (MerchantUIServiceImpl.java):
Purpose: This service implementation is responsible for handling merchant-related operations.
Dependency: It uses the HttpUtils class to make HTTP POST requests to the Payment Gateway Simulator.
Methods:
createMerchant(MerchantDTO merchantDTO): Initiates the merchant registration process by making an HTTP POST request to the Payment Gateway Simulator's /merchant/register endpoint.
PaymentServiceImpl (PaymentServiceImpl.java):
Purpose: This service implementation handles payment-related operations.
Dependency: It also uses the HttpUtils class to make HTTP POST and GET requests to the Payment Gateway Simulator.
Methods:
makePayment(PaymentDTO paymentDTO): Initiates the payment process by making an HTTP POST request to the Payment Gateway Simulator's /payment/makePayment endpoint.
checkPaymentStatus(String paymentId): Checks the status of a payment by making an HTTP GET request to the Payment Gateway Simulator's /payment/status/{paymentCode} endpoint, where paymentId is the unique identifier of the payment.

Utils
HttpUtils (HttpUtils.java):
Purpose: This utility class provides methods for making HTTP GET and POST requests using WebClient.
Dependencies: It relies on Spring WebClient for handling HTTP requests.
Methods:
getAPICall(String url): Performs an HTTP GET request to the specified URL and returns the response.
postAPICall(Object object, String url): Performs an HTTP POST request with the provided object as the request body and returns the response.


**Workflow**
Merchant Registration
The Merchant UI application provides an API endpoint for merchants to register with the Payment Gateway Simulator.

A merchant sends a registration request with their details to the /merchant/register endpoint.
The Merchant UI Controller receives the registration request.
The MerchantUIServiceImpl sends an HTTP POST request to the Payment Gateway Simulator's /merchant/register endpoint using the HttpUtils utility.
The Payment Gateway Simulator checks if the merchant is already registered and responds with a registration success or failure message.
The response is returned to the merchant, indicating whether the registration was successful or not.

Payment Processing
A merchant initiates a payment request through the Merchant UI application, providing payment details.
The Merchant UI Controller receives the payment request.
The PaymentServiceImpl sends an HTTP POST request to the Payment Gateway Simulator's /payment/makePayment endpoint using the HttpUtils utility.
The Payment Gateway Simulator processes the payment request, simulating payment processing, and responds with a payment success or failure message.
The response is returned to the merchant, indicating whether the payment was successful or not.

Checking Payment Status
A merchant wants to check the status of a previous payment by providing the payment code.
The Merchant UI application sends an HTTP GET request to the Payment Gateway Simulator's /payment/status/{paymentCode} endpoint, where {paymentCode} is the unique identifier of the payment.
The Payment Gateway Simulator checks its database for the payment status associated with the provided payment code.
If the payment code is found, the Payment Gateway Simulator responds with the payment status (e.g., "Payment Successful" or "Payment Failed").
The response is returned to the merchant, displaying the status of the requested payment.

**Database Configuration**
spring.datasource.url: Database connection URL.
spring.datasource.username: Database username.
spring.datasource.password: Database password.
spring.datasource.driverClassName: Database driver class.
spring.jpa.hibernate.ddl-auto: Hibernate DDL auto mode (e.g., "update").
