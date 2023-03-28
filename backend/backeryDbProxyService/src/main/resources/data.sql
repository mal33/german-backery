INSERT INTO "user" (id, username, password) VALUES
(1, 'admin', '$2a$10$m35NqOt8NTB7389c/o34x.wioJoq0Vh5Moh/t17m3T886yMp1cw7W');
INSERT INTO "user" (id, username, password) VALUES
(2, 'customer', '$2a$10$DNEoAkla/PG9ukLS7P2OqOINIqWI9m.XR4LM3mNGlhqy6k6G8XXx2');

INSERT INTO article (id, name, description) VALUES
    (1, 'Pretzel Bread', 'Pretzel bread is a delicious German bread that combines the soft texture of bread with the iconic pretzel taste. The crust is slightly crispy and has a deep, rich flavor that''s sure to satisfy your taste buds.');
INSERT INTO article (id, name, description) VALUES
    (2, 'Rye Bread', 'This classic German bread is made with a mix of rye flour and wheat flour, giving it a hearty texture and a slightly sour taste. It''s perfect for sandwiches, especially with meats and cheeses.');
INSERT INTO article (id, name, description) VALUES
    (3, 'Pumpernickel Bread', 'This dense and chewy bread is made with a mix of rye flour and whole wheat flour, and is slow-baked to give it a deep, rich flavor. Pumpernickel is perfect for toasting and is great with cream cheese or smoked salmon.');
INSERT INTO article (id, name, description) VALUES
    (4, 'Kaiser Roll', 'The Kaiser Roll is a traditional German bread roll that''s light and fluffy with a crispy crust. It''s perfect for making sandwiches or as a side with soup or salad.');
INSERT INTO article (id, name, description) VALUES
    (5, 'Vollkornbrot', 'This hearty German bread is made with whole grain flour and is packed with fiber and nutrients. It has a dense texture and a nutty flavor that pairs well with a variety of toppings like butter, cheese, and jam.');

INSERT INTO "order" (id, orderid, description) VALUES
(1, '218d1acf-2bdd-4b91-9380-d212d568c432', '50x Brötchen');
