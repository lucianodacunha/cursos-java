CREATE TABLE VENDAS (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,	
	DATAVENDA DATE NOT NULL,
	CLIENTEID INTEGER NOT NULL,
	TOTALVENDA REAL NOT NULL,
	FOREIGN KEY (CLIENTEID) REFERENCES CLIENTES (ID));