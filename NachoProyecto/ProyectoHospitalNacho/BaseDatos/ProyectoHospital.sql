
CREATE TABLE IF NOT EXISTS "Habitaciones" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"NumHabitacion"	INTEGER NOT NULL UNIQUE,
	"Estado"	BOOLEAN NOT NULL
);
CREATE TABLE IF NOT EXISTS "Pacientes" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"Nombre"	TEXT,
	"Edad"	INTEGER NOT NULL,
	"Sexo"	BOOLEAN NOT NULL,
	"MotivoIngreso"	TEXT NOT NULL,
	"FechaIngreso"	TEXT NOT NULL,
	"IdDoctor"	INTEGER,
	"IdHabitacion"	INTEGER,
	FOREIGN KEY("IdDoctor") REFERENCES "Doctores",
	FOREIGN KEY("IdHabitacion") REFERENCES "Habitaciones"
);
CREATE TABLE IF NOT EXISTS "Doctores" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"Nombre"	TEXT NOT NULL,
	"NumColegiado"	INTEGER NOT NULL UNIQUE,
	"Edad"	INTEGER NOT NULL,
	"Sexo"	BOOLEAN,
	"IdDep"	INTEGER,
	FOREIGN KEY("IdDep") REFERENCES "Departamentos"
);
CREATE TABLE IF NOT EXISTS "EnfermerosPacientes" (
	"IdEnfermero"	INTEGER NOT NULL,
	"IdPaciente"	INTEGER NOT NULL,
	PRIMARY KEY("IdEnfermero","IdPaciente")
);
CREATE TABLE IF NOT EXISTS "Departamentos" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"Nombre"	TEXT NOT NULL UNIQUE,
	"NumEmpleados"	INTEGER
);
CREATE TABLE IF NOT EXISTS "Enfermeros" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"Nombre"	TEXT NOT NULL,
	"Edad"	INTEGER
);

