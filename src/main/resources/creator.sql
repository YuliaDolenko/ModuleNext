CREATE TABLE Customer
(customer_ID INTEGER not NULL,
 name VARCHAR(30),
 surname VARCHAR(30),
 comment VARCHAR(30),
 discount VARCHAR(30),
 countBookings INTEGER(15),
 primary key(customer_ID),
 foreign key(customer_ID) references HotelRoom(id))