| HTTPS method | URL path                              | HTTP status code | description                                                    |
|--------------|---------------------------------------|------------------|----------------------------------------------------------------|
| POST         | /auth/signin                          | 200 (OK)         | to allow customer to sign in and get the JWT access token      |
| POST         | /auth/signup                          | 201 (CREATED)    | to allow customers to sign up in the system                    |
|              |                                       |                  |                                                                |
| GET          | /customer                             | 200 (OK)         | to get all customers information                               |
| PUT          | /customer                             | 200 (OK)         | to update a customers information                              |
| GET          | /customer/customerId                  | 200 (OK)         | to get a specificcustomers information                         |
|              |                                       |                  |                                                                |
| GET          | /order                                | 200 (OK)         | to get all orders information                                  |
| GET          | /oder/orderId                         | 200 (OK)         | to get a specific orders information                           |
| DELETE       | /order/orderId                        | 200 (OK)         | to delete an order                                             |
| GET          | /order/productOrder                   | 200 (OK)         | to get all product orders                                      |
| GET          | /order/productOrder/orderId           | 200 (Ok)         | to get a specific orders information                           |
| DELET        | /order/productOrder/orderId/productId | 200 (OK)         | to delete a product order                                      |
| PUT          | /order/productOrder                   | 200 (ok)         | to update a product orders information                         |
| POST         | /order/productOrders/customerId       | 201 (CREATED)    | to create a new product order for a specific customer or order |
|              |                                       |                  |                                                                |
| GET          | /product                              | 200 (ok)         | to get all products information                                |
| GET          | /product/productId                    | 200 (ok)         | to get a specific products information                         |
| PUT          | /product                              | 200 (Ok)         | to update a products information                               |
| DELETE       | /product/productId                    | 200 (ok)         | to delete a product                                            |
| POST         | /product                              | 201 (Created)    | to create a new product                                        |
|              |                                       |                  |                                                                |
| GET          | /stock                                | 200 (OK)         | to get all stocks information                                  |
| GET          | /stock/stockId                        | 200 (OK)         | to get a specific stocks information                           |
| PUT          | /stock                                | 200 (OK)         | to update a stocks information                                 |
| DELETE       | /stock/stockId                        | 200 (OK)         | to delete a stocks                                             |
| POST         | /stock/productId                      | 201 (CREATED)    | to create a new stock for a product                            |
