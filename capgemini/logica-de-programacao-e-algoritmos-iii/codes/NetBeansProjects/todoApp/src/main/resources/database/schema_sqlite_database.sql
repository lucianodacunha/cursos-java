BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "projects" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"description"	TEXT,
	"createdAt"	TEXT,
	"updatedAt"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "tasks" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"completed"	INTEGER NOT NULL,
	"notes"	TEXT,
	"deadline"	TEXT NOT NULL,
	"createdAt"	TEXT NOT NULL,
	"updatedAt"	TEXT NOT NULL,
	"idProject"	BLOB NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("idProject") REFERENCES "projects"("id")
);
COMMIT;
