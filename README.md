# _Wildlife Tracker_

#### _Epicodus Java, 9-30-16._

#### By _**Caleb Paul**_

## Description

_This program allows rangers to track wildlife sightings._
_Rangers can add, delete, and update info (location, age, health, time spotted) for sightings of Endangered and Non-Endangered animals._

## Specs

* Add Sighting:
  - Program will store Ranger Name, Notes, Location, and a Timestamp.

* Add Animal:
  - Program will store Animal Species, endangered/safe status, and health and age approximations.

* View Entries:
  - Program uses an sql join table command to show relevant sighting and animal info together.


## Known Bugs
* Program is currently incomplete.
  - Not all tests are passing currently.
  - No delete or update functionality currently.

## Setup

* Clone this repository.

* Type in terminal:
	`postgres`

* Open new terminal window & Type in PSQL:
	  `CREATE DATABASE wildlife_tracker;`

* Type in terminal:
	  `psql wildlife_tracker < wildlifeDB.sql`

* Type in terminal:
	`\c wildlife_tracker`

* Type in terminal:
	  `gradle run`

* Use web browser to navigate to:
	`localhost:4567`


## Contact

Twitter @calebpaulmusic

## Technologies Used

* Java

* Gradle

* Postgres

* SQL

* VelocityTemplateEngine

* JUnit

* Spark

### License

*This webpage is licensed under the GPL license.*

Copyright (c) 2016 _Caleb Paul_
