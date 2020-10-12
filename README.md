<h2>LMS#loan-service APIs</h2>
<br>created date: 03 12, 2019, by SmartOSC Fintech | LMS team

********************************************************************************************************* 
# Technology
	> Spring Web
	> MongoDB
	> MySQL
	> Spring AOP
	> Spring Data with 
	> Swagger 2
	> Spring Cloud config (client) -- next version
	> Spring cloud bus amqp -- next version

### Features
	* Loan Management

### Integration
	* Auth-Services
	* other

### Docker build
	docker build -t lms/loan-service:v1.0.0 .
	docker tag lms/loan-service:v1.0.0 registry.developer.smartosc.vn/lms/loan-service:v1.0.0
	docker push registry.developer.smartosc.vn/lms/loan-service:v1.0.0

### Configuration & data

	+ [configuration] use K8s ConfigMap

### Unit Test
	gradlew build -x test to ignore unit tests
	gradlew bootRun  --> run application
	test one or many Class :   
	gradlew test --tests full_package_and_ClassName
	gradlew build test --tests *ClassName --> to test one or some classes  
	Browse APIs via swagger: http://localhost:8080/swagger-ui.html#
