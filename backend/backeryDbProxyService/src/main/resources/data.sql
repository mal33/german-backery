-- https://stackoverflow.com/questions/72605646/jdbcsqlintegrityconstraintviolationexception-unique-index-or-primary-key-viola
-- H2 Database will take care of the ID generation
INSERT INTO users (id, userid, username, password) VALUES
(default, 'cf5d99d1-c0f2-41b1-af20-2b81bab712e6','admin', '$2a$10$m35NqOt8NTB7389c/o34x.wioJoq0Vh5Moh/t17m3T886yMp1cw7W');
INSERT INTO users (id, userid, username, password) VALUES
(default, 'b9138e34-8755-4dca-91ad-59396a64ee8d','customer', '$2a$10$DNEoAkla/PG9ukLS7P2OqOINIqWI9m.XR4LM3mNGlhqy6k6G8XXx2');

INSERT INTO articles (id, articleid, name, description) VALUES
    (default, '0c6e5ed1-f5ae-4bda-89aa-746d966e9843','Pretzel Bread', 'Pretzel bread is a delicious German bread that combines the soft texture of bread with the iconic pretzel taste. The crust is slightly crispy and has a deep, rich flavor that''s sure to satisfy your taste buds.');
INSERT INTO articles (id, articleid, name, description) VALUES
    (default, '1c8f42ab-f4cf-454a-b2cd-811d5d24abaf','Rye Bread', 'This classic German bread is made with a mix of rye flour and wheat flour, giving it a hearty texture and a slightly sour taste. It''s perfect for sandwiches, especially with meats and cheeses.');
INSERT INTO articles (id, articleid, name, description) VALUES
    (default, '8f633d1d-08c8-41ad-9a9d-ba5cd0210319','Pumpernickel Bread', 'This dense and chewy bread is made with a mix of rye flour and whole wheat flour, and is slow-baked to give it a deep, rich flavor. Pumpernickel is perfect for toasting and is great with cream cheese or smoked salmon.');
INSERT INTO articles (id, articleid, name, description) VALUES
    (default, '578cb8bb-a5c8-4d0e-9db9-78301801ac7c','Kaiser Roll', 'The Kaiser Roll is a traditional German bread roll that''s light and fluffy with a crispy crust. It''s perfect for making sandwiches or as a side with soup or salad.');
INSERT INTO articles (id, articleid, name, description) VALUES
    (default, '24c3145d-03bc-4f84-8942-3fef86ab0d09','Vollkornbrot', 'This hearty German bread is made with whole grain flour and is packed with fiber and nutrients. It has a dense texture and a nutty flavor that pairs well with a variety of toppings like butter, cheese, and jam.');

INSERT INTO orders (id, orderid, description) VALUES
(default, '218d1acf-2bdd-4b91-9380-d212d568c432', '50x Rye Bread');
INSERT INTO orders (id, orderid, description) VALUES
(default, '033b3d4c-bc58-4f16-b669-703fd12701d5', '1337x Pretzel Bread');
