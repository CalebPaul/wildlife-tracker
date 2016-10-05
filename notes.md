## Your independent project this week will be evaluated on the following criteria:
* An interface or inherited class provides similar content in different classes. DONE
* Database timestamps are included for each sighting. DONE
* At least two Exceptions can be thrown and caught.
* Constants are used in at least one class. DONE
* Previous standards are met (see below).
* Project demonstrates an understanding of concepts covered this week. You can discuss your code and concepts behind it with an instructor using the correct terminology.
* Project is in a polished, portfolio-ready state.
* Application works as expected.

# Wildlife Tracker
You have been asked to build an application that allows Rangers to track wildlife sightings in the area.
## The application must track two categories of wildlife:
### Animals
### At the very least, require:
- id DONE
- name DONE
### Endangered Animals
Due to their dwindling numbers, Rangers must record additional information about EndangeredAnimals:
- id
- name

- health
- Use constants to define options like "healthy", "ill", and "okay".

- age (an estimated guess by the ranger)
- Use constants to define options like "newborn", "young", or "adult".

## Each time an animal species of either category is seen, a Sighting must be reported:
- Sightings
* When wildlife is spotted, a Ranger submits a form to record a Sighting containing the following:
* id of Animal or EndangeredAnimal species
* location
(Conveyed in any manner you choose ie: "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values are all acceptable.)
* rangerName

## Exceptions
It may take a few days for new Rangers to familiarize themselves with the app. To avoid saving incomplete or invalid records, throw and catch exceptions if Rangers attempt to submit an incomplete form, or misuse the application in any other conceivable fashion.

## Database Naming Requirements
For this code review, use the following database names:
Production Database: wildlife_tracker
Development Database: wildlife_tracker_test
Table Names: animals, sightings
