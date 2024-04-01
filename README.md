![Screenshot 2024-04-01 191256](https://github.com/uk47kumar/shopping-api/assets/95838961/b746d323-dd8b-442a-b38d-54a356904a11)

E-R Diagram

So, In this application i am using h2 console, in_memory database.

Whenever the application starts it creates some table like User, Order, Coupons and Transaction.
For the sake of simplicity whenever the application starts by using data.sql file it inserting some data in user, coupon and order table for performing and testing the checking endpoints.

Couple of things should you know !

so, in this application couple things should you know like I am not using @Repository annotation because we know that Jpa internally user SimpleJpaRepository and SimpleJpaRepository already annotated by @Repository that why I am not using this annotation.

Also I am not using @Autowired because Lombok provide a annotation called @RequiredArgsConstructor so whenever I use this annotation there are no need of creating constructor and applying constructor dependency injection.


In this application most of the time I am using Lombok annotation like @Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor and @RequiredArgsConstructor for reducing Boiler plate codes.

Let's talk about Endpoints :
1. (GET) http://localhost:8080/fetchCoupons -- for getting the list of all available coupons
2. (POST) http://localhost:8080/{userId}/order?qty=10&coupon=OFF5 -- for placing order like this --> http://localhost:8080/1/order?qty=10&coupon=OFF5
3. (POST) http://localhost:8080/{userId}/{orderId}/pay?amount=950 -- for payment the placed order like this --> http://localhost:8080/1/1/pay?amount=950
4. (GET) http://localhost:8080/{userId}/orders -- for getting all the orders by a user like this --> http://localhost:8080/1/orders
5. (GET) http://localhost:8080/{userId}/orders/{orderId} -- for getting a single order by a user like this --> http://localhost:8080/1/orders/1
