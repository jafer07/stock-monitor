-- Ensure stock_user uses mysql_native_password
CREATE USER IF NOT EXISTS 'stock_user'@'%' IDENTIFIED BY '12345__';
ALTER USER 'stock_user'@'%' IDENTIFIED WITH mysql_native_password BY '12345__';
GRANT ALL PRIVILEGES ON stock_monitor.* TO 'stock_user'@'%';
FLUSH PRIVILEGES;

-- Ensure root user uses mysql_native_password
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Stock_Monitor1++';
FLUSH PRIVILEGES;