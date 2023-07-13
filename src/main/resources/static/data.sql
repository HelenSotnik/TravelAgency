INSERT INTO roles (id, name)
VALUES (1, 'ADMIN'),(2, 'USER');

INSERT INTO hotels(id, description, location, name, review_score)
VALUES (1, 'Beautiful home hotel', 'Barbados Bathsheba', 'Laguna Villa', '3*'),
       (2, 'Gorgeous Sea hotel', 'Indonesia Bali', 'Bali Mitsys Hotel', '5*'),
       (3, 'Spectacular hotel in the Sri Lanka', 'Sri Lanka Gala', 'Gala Qeen Hotel', '4*'),
       (4, 'Amazing hotel in the heart of LA', 'USA Los Angeles (LA)', 'Lux and Spa Hotel', '5*'),
       (5, 'Breathtaking Corfu Hotel', 'Greece Corfu', 'Corfu Lux and Spa Hotel', '4*');

INSERT INTO rooms(id, name, price_per_night, hotel_id)
VALUES (1,'Sea view room with 2 bed', 120.50,1),
       (2,'Sea view room KingSize Bed + sofa', 105.50,1),
       (3,'Garden view room 1 KingSize bed', 90.50,1),
       (4,'Sea view room 2 bed', 135,2),
       (5,'Pool and Garden view room 1 bed', 100,2),
       (6,'Sea view room 2 bed', 130,3),
       (7,'Sea view room 2 bed king size and 2 baths', 150 ,3),
       (8,'Garden view room 1 bed', 85,4),
       (9,'Pool view room 1 bed', 95,4),
       (10,'Pool view room 2 bed', 115,5),
       (11,'Pool view room 1 bed', 100,5),
       (12,'Sea view room 2 bed + sofa', 137,5);

INSERT INTO users(id, email, first_name, last_name, password, role_id)
VALUES (1, 'manager@gmail.com', 'Yylia','Tigipko','1111',1),
       (2, 'user@gmail.com', 'Mihail','Demchenko','2222',2);
