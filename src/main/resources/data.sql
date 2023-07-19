INSERT INTO roles (name)
VALUES ('MANAGER'),
       ('USER');

INSERT INTO hotels(description, location, name, review_score)
VALUES ('Beautiful home hotel', 'Barbados Bathsheba', 'Laguna Villa', '3*'),
       ('Gorgeous Sea hotel', 'Indonesia Bali', 'Bali Mitsys Hotel', '5*'),
       ('Spectacular hotel in the Sri Lanka', 'Sri Lanka Gala', 'Gala Qeen Hotel', '4*'),
       ('Amazing hotel in the heart of LA', 'USA Los Angeles (LA)', 'Lux and Spa Hotel', '5*'),
       ('Breathtaking Corfu Hotel', 'Greece Corfu', 'Corfu Lux and Spa Hotel', '4*');

INSERT INTO rooms(name, price_per_night, hotel_id)
VALUES ('Sea view room with 2 bed', 120.50, 1),
       ('Sea view room KingSize Bed + sofa', 105.50, 1),
       ('Garden view room 1 KingSize bed', 90.50, 1),
       ('Sea view room 2 bed', 135, 2),
       ('Pool and Garden view room 1 bed', 100, 2),
       ('Sea view room 2 bed', 130, 3),
       ('Sea view room 2 bed king size and 2 baths', 150, 3),
       ('Garden view room 1 bed', 85, 4),
       ('Pool view room 1 bed', 95, 4),
       ('Pool view room 2 bed', 115, 5),
       ('Pool view room 1 bed', 100, 5),
       ('Sea view room 2 bed + sofa', 137, 5);

INSERT INTO users(email, first_name, last_name, password, role_id)
VALUES ('manager@gmail.com', 'Olga', 'Solovey', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1),
       ('user@gmail.com', 'Mihail', 'Demchenko', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2),
       ('tetiana@gmail.com', 'Tetiana', 'Mozhevenko', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2),
       ('yulia@gmail.com', 'Yylia', 'Tzvik', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2),
       ('margor@gmail.com', 'Margarita', 'Zozulia', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2),
       ('alex@gmail.com', 'Olexandr', 'Politov', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2);
