create table RegistroSolicitud_Registro (
	registroId LONG not null primary key,
	nombre VARCHAR(75) null,
	apellido VARCHAR(75) null,
	email VARCHAR(75) null,
	nacimiento DATE null,
	alta DATE null
);