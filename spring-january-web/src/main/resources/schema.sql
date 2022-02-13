DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS userm;

CREATE TABLE userm (
    user_id bigserial PRIMARY KEY,
    username varchar(20) NOT NULL unique,
    password varchar(20) NOT NULL,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    d_created timestamp NOT NULL,
    is_active boolean DEFAULT FALSE
);

CREATE TABLE post (
    post_id bigserial PRIMARY KEY,
    user_id bigint REFERENCES userm(user_id) ON DELETE CASCADE,
    title varchar(100) NOT NULL,
    content text NOT NULL,
    dt_created timestamp NOT NULL,
    dt_updated timestamp
);

CREATE TABLE tag (
tag_id bigserial PRIMARY KEY,
name varchar(50) NOT NULL
);

CREATE TABLE post_tag (
    post_id bigint REFERENCES post(post_id) ON DELETE CASCADE,
    tag_id bigint REFERENCES tag(tag_id) ON DELETE CASCADE,
    PRIMARY KEY (post_id, tag_id)
);


CREATE TABLE comment (
comment_id bigserial PRIMARY KEY,
user_id bigint REFERENCES userm(user_id) ON DELETE CASCADE,
post_id bigint REFERENCES post(post_id) ON DELETE CASCADE,
content text,
dt_created timestamp,
dt_updated timestamp
);


CREATE TABLE role (
role_id bigserial PRIMARY KEY,
name varchar(50) NOT NULL
);

CREATE TABLE user_role (
user_id bigint REFERENCES userm(user_id) ON DELETE CASCADE,
role_id bigint REFERENCES role(role_id) ON DELETE CASCADE,
PRIMARY KEY(user_id, role_id)
);

---
    insert into userm(username,password,first_name,last_name,d_created,is_active)
    values ('Denisspec','1234R','Denis','Ignatov',current_timestamp ,'true' );
        insert into userm(username,password,first_name,last_name,d_created,is_active)
    values ('AleshaPopovich57','AlechaPopovich1','Evgenii','Jmihov',current_timestamp ,'false' );

insert into post (user_id,title, content, dt_created, dt_updated)
	values (1,'Day 1', 'It''s all good!', current_timestamp - interval '2 days', null);
insert into post (user_id,title, content, dt_created, dt_updated)
	values (1,'Day 2', 'It''s all ok!', current_timestamp - interval '1 days', null);
insert into post (user_id,title, content, dt_created, dt_updated)
	values (2,'Day 1', 'It''s all bad!', current_timestamp, null);

insert into tag (name) values ('news');
insert into tag (name) values ('life');
insert into tag (name) values ('day');
insert into tag (name) values ('mood');
insert into tag (name) values ('ideas');
insert into tag (name) values ('thoughts');

insert into post_tag(post_id, tag_id) values (1, 1);
insert into post_tag(post_id, tag_id) values (1, 2);
insert into post_tag(post_id, tag_id) values (2, 3);
insert into post_tag(post_id, tag_id) values (2, 2);
insert into post_tag(post_id, tag_id) values (2, 1);
insert into post_tag(post_id, tag_id) values (2, 5);
insert into post_tag(post_id, tag_id) values (3, 3);
insert into post_tag(post_id, tag_id) values (3, 2);
insert into post_tag(post_id, tag_id) values (3, 6);



insert into comment (user_id,post_id, content, dt_created)
    values (1, 2, 'Nice!', current_timestamp);
insert into comment (user_id,post_id, content, dt_created)
    values (1, 1, 'Awesome!', current_timestamp);
insert into comment (user_id,post_id, content, dt_created)
    values (1, 1, 'Excellent!', current_timestamp);
insert into comment (user_id,post_id, content, dt_created)
    values (2, 1, 'Wonderful!', current_timestamp);
insert into comment (user_id,post_id, content, dt_created)
    values (2, 3, 'Disgusting!', current_timestamp);
insert into comment (user_id,post_id, content, dt_created)
    values (2, 3, 'Atrocious!', current_timestamp);

insert into role (name) values ('Admin');
insert into role (name) values ('Smurfik');
insert into role (name) values ('Proxodimec');

insert into user_role(user_id, role_id) values (1, 1);
insert into user_role(user_id, role_id) values (1, 2);
insert into user_role(user_id, role_id) values (2, 3);





select * from post;
select * from tag;
select * from post_tag;
select * from userm;
select * from user_role;
select * from role;