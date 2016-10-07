--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: calebpaul
--

CREATE TABLE animals (
    id integer NOT NULL,
    species character varying,
    type character varying,
    sighting_id integer,
    age character varying,
    status character varying
);


ALTER TABLE animals OWNER TO calebpaul;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: calebpaul
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO calebpaul;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: calebpaul
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: calebpaul
--

CREATE TABLE sightings (
    id integer NOT NULL,
    ranger_names character varying,
    notes character varying,
    times_spotted timestamp without time zone,
    locations character varying
);


ALTER TABLE sightings OWNER TO calebpaul;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: calebpaul
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO calebpaul;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: calebpaul
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: calebpaul
--

COPY animals (id, species, type, sighting_id, age, status) FROM stdin;
58	Giant Eagle	endangered	77	young	healthy
57	Bear	safe	76	\N	\N
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: calebpaul
--

SELECT pg_catalog.setval('animals_id_seq', 59, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: calebpaul
--

COPY sightings (id, ranger_names, notes, times_spotted, locations) FROM stdin;
76	Walker	I have sweet boots	2016-10-06 15:41:58.124946	Texas
77	Aragorn	Saw some orcs and hobbits, also!	2016-10-06 15:42:37.452714	Middle Earth
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: calebpaul
--

SELECT pg_catalog.setval('sightings_id_seq', 79, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: calebpaul
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: calebpaul
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM calebpaul;
GRANT ALL ON SCHEMA public TO calebpaul;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

