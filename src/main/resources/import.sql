INSERT INTO terminal(bank, name, password, username, address_login, address_supply, update_stock_in_minute, update_stock_quantity) VALUES ('banco1', 'terminal1', 'password', 'admin', 'http://localhost:8080/login', 'http://localhost:8080/supply', 1, 1);

INSERT INTO stock(terminal_id, note_value, quantity) VALUES(1, 10, 1);
INSERT INTO stock(terminal_id, note_value, quantity) VALUES(1, 20, 1);
INSERT INTO stock(terminal_id, note_value, quantity) VALUES(1, 50, 1);
INSERT INTO stock(terminal_id, note_value, quantity) VALUES(1, 100, 1);

