create table users (
	user_id serial NOT NULL, 
	firstname varchar(100),
	lastname varchar(100),
	email varchar(256),
	primary key (user_id)
	
);

create table address (
	id serial NOT NULL, 
	user_id bigint NOT NULL,
	address varchar(256),
	city varchar(100),
	state varchar(100),
	zipcode varchar(10),
	type varchar(10),
	foreign key (user_id) references users(user_id)
);