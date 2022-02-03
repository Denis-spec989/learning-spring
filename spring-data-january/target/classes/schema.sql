DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post;

CREATE TABLE post (
    post_id bigserial PRIMARY KEY,
--    user_id biginteger
    title varchar(100) NOT NULL,
    content text NOT NULL,
    dt_created timestamp NOT NULL,
    dt_updated timestamp
);

CREATE TABLE tag (
tag_id bigserial PRIMARY KEY,
name varchar(50) NOT NULL
);

CREATE TABLE comment (
comment_id bigserial PRIMARY KEY,
post_id bigint REFERENCES post(post_id) ON DELETE CASCADE,
content text,
dt_created timestamp,
dt_updated timestamp
);


CREATE TABLE post_tag (
post_id bigint REFERENCES post(post_id) ON DELETE CASCADE,
tag_id bigint REFERENCES tag(tag_id),
PRIMARY KEY(post_id, tag_id)
);

---
insert into post (title, content, dt_created, dt_updated)
	values ('Day 1', 'It''s all good!', current_timestamp - interval '2 days', null);
insert into post (title, content, dt_created, dt_updated)
	values ('Day 2', 'It''s all ok!', current_timestamp - interval '1 days', null);
insert into post (title, content, dt_created, dt_updated)
	values ('Day 3', 'It''s all bad!', current_timestamp, null);

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

insert into comment (post_id, content, dt_created)
    values (2, 'Nice!', current_timestamp);
insert into comment (post_id, content, dt_created)
    values (1, 'Awesome!', current_timestamp);
insert into comment (post_id, content, dt_created)
    values (1, 'Excellent!', current_timestamp);
insert into comment (post_id, content, dt_created)
    values (1, 'Wonderful!', current_timestamp);
insert into comment (post_id, content, dt_created)
    values (3, 'Disgusting!', current_timestamp);
insert into comment (post_id, content, dt_created)
    values (3, 'Atrocious!', current_timestamp);

select * from post;
select * from tag;
select * from post_tag;
select * from comment;
