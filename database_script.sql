-- Database: university

-- DROP DATABASE university;

CREATE DATABASE university
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    CONNECTION LIMIT = -1;


-- Table: public.course

-- DROP TABLE public.course;

CREATE TABLE public.course
(
    id          SERIAL                 NOT NULL PRIMARY KEY,
    title       character varying(255) NOT NULL,
    description character varying(255)
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.course
    OWNER TO postgres;


-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
    id   SERIAL                 NOT NULL PRIMARY KEY,
    name character varying(255) NOT NULL
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.student
    OWNER TO postgres;

-- Table: public.course_student

-- DROP TABLE public.course_student;

CREATE TABLE public.course_student
(
    course_id  int references course (id),
    student_id int references student (id),
    constraint id PRIMARY KEY (course_id, student_id)
)
    WITH (
        OIDS = FALSE
    );
ALTER TABLE public.course_student
    OWNER TO postgres;
