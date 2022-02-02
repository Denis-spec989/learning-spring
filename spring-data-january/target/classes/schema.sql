DROP TABLE IF EXISTS post;

CREATE TABLE post (
    post_id bigserial PRIMARY KEY,
--    user_id biginteger
    title varchar(100) NOT NULL,
    content text NOT NULL,
    dt_created timestamp NOT NULL,
    dt_updated timestamp
);

---
insert into post (title, content, dt_created, dt_updated)
	values ('Day 1', 'It''s all good!', current_timestamp - interval '2 days', null);
insert into post (title, content, dt_created, dt_updated)
	values ('Day 2', 'It''s all ok!', current_timestamp - interval '1 days', null);
insert into post (title, content, dt_created, dt_updated)
	values ('Day 3', 'It''s all bad!', current_timestamp, null);


select * from post;
