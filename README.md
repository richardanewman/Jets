### Jets Application Project

### Week 3 Homework Project for Skill Distillery

### Overview

This program simulates a jet command interface. At least five jets, containing a model, speed, range, and price, are read into the program from a text file upon program launch. Users are prompted with a menu so that they can interact with the jets, create new jets and delete aircraft from the file. More details on the scope of the assignment can be found below in the context section.

### Technologies

Java Version 1.8, Eclipse IDE, Git, Github, Atom

### Topics Applied

The primary topics applied from Week 3 at Skill Distillery were the use of abstract and implementation classes.

### Lessons Learned

Biggest take aways from this exercise are encapsulation and polymorphism via subclasses. Access modifiers certainly help with data hiding, but the use of abstract classes and interfaces forces you carefully consider your program's development. I feel more confident working with interfaces after this exercise.
Remembering when to downcast objects in order to access the methods forced onto the subclasses by the interface was a key moment in the learning process. We went over it in class, but working on this program really helped to make the concepts more fluent. I feel comfortable with them now.

Troubleshooting nextLine(), file.io, and the bufferedwriter were tedious snags in the development process. I feel that they were the type of issues that only can slow you down significantly when you encounter them for the first time. Once you're aware of their temperament, you can quickly recover from future encounters. I had a few small issues while trying to properly format the I/O to prevent an out of bounds exception. In the end, I used next() instead of nextLine to read in my model names. And to get around the spacing issue I called .useDelimeter(\\n) on the scanner so I could take in more than one word. Again, most of the trouble came from lack of familiarity with certain Java classes like File.io and Bufferedwriter. Overall, it didn't take long to troubleshoot the issues.

On the next project, I'd like to work on reducing the size of my application file. I don't believe it should be that long. Maybe I'm wrong, but I'd like to break that up and spread it out more. I will definitely be reading more on design patterns and gaining a better understanding of code organization.

### How to Run

You must compile this program to run it. Download or clone this repository to a local directory. Open Eclipse IDE (or your favorite Java compiler) and import the project under the File menu. Alternatively, you can clone the repository directly into your IDE via terminal. Once you have compiled it, click run and follow the prompts.

Clone with SSH:

git@github.com:richardanewman/Jets.git

Clone with HTTPS:

https://github.com/richardanewman/Jets.git

## Context

Below you will find a copy of the assignment's tasks. I am providing this context for anyone evaluating my code. We were not given a code stub or boilerplate for this exercise. For better or worse, the code is my own. The only resources referenced were from the prior week's course material and my class notes. I am not a fan of copy and paste code because it does not aid in the learning process. I am attending this bootcamp so that I can thoroughly understand how to properly develop software using Java.

### Task Overview Provided by Skill Distillery

Users will be given a menu to use your jets and access information about them.

### Structure

All jets must have a model, speed, range, and price associated with them. Speed is in MPH, but your Jet can also output the speed in mach.

Jets have a fly() method that prints out the jet details and the amount of time the jet can fly until it runs out of fuel (based on speed and range).

Jet itself is an abstract base class. Its purpose it to be extended by other types with different behavior.

That said, you will still have a plain vanilla Jet class. Create a JetImpl class that extends the base class.

You must create two interfaces of your choice for specializations of Jets. For example, CargoCarrier could have a loadCargo() method (which just prints out a message about loading cargo). CombatReady could have a method fight().

You will create at least two implementation classes that extend Jet and implement your interfaces. (The more types you have, the more interesting the project.)

Do not structure your code so that all implementation classes implement all interfaces. We want Jets with different capabilities.

## User Stories

### User Story 1

Create a JetsApplication with a main method to launch your program.

### User Story 2

Jets are found at an AirField. Create the AirField class, which has an empty List of Jets.

### User Story 3

On program startup, populate the AirField with at least 5 Jets of different types.

These jets must be read from a text file, where each line in the file contains data for a single Jet object.

This file exists at the root of your Eclipse project. It can be comma- or tab-separated; either implementation is acceptable.
The method to parse a file into Jet objects should return a List<Jet>. Its parameter can be a String file name.
Remember to use String.split(regex) to break each line in the file into data to create an individual jet.

### User Story 4

There is a menu with these options:

List fleet
Fly all jets
View fastest jet
View jet with longest range
Load all Cargo Jets
Dogfight!
Add a jet to Fleet
Remove a jet from Fleet
Quit

### User Story 5

List fleet prints out the model, speed, range, and price of each jet. (There must be at least 5 jets stored when the program starts).

### User Story 6

Fly all Jets calls the fly() method on the entire fleet of jets. fly() prints out the jet details and the amount of time the jet can fly until it runs out of fuel (based on speed and range).

### User Story 7

The view fastest jet and longest range options both print out all of the information about a jet.

Note: these methods must search the collection of jets to find the appropriate jet.

### User Story 8

The user is presented with an option specific to the interfaces you created. For example, Load all Cargo Jets, above, finds all implementors of the CargoCarrier interface and calls loadCargo() on each. (Note that the menu text is italicized because your options may be different, depending on your interfaces.)

### User Story 9

A user can add custom jets to the fleet.

This can be a JetImpl.
Stretch Goal: This leads to a sub-menu where the user chooses the type of Jet.
Users then enter information for the Jet, and it is added to the AirField.

### User Story 10

A user can remove a jet from the fleet.

The user is presented with a sub-menu to select a jet to delete by number.
Stretch Goal: a user can remove a jet (or jets) by name.

### User Story 11

Quit exits the program.

## Stretch Goals

Try implementing these stories only when you have committed and pushed a working project.

### User Story 12

Users see a menu item to fly an individual Jet, and then choose the Jet in a sub-menu.

### User Story 13

Each jet has a pilot.

### User Story 14

Assign a random pilot to each jet that is created.

### User Story 15

Users can hire pilots.

### User Story 16

Whenever a jet's information is displayed, that jet's pilot and his/her information should also be displayed.

### Grading
This is a graded project. You are expected to have your project completed by the start of class next week.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

The initial list of Jets must be loaded from a text file.
When menu option 1 is pressed all Jets in the fleet are displayed to the user.
When menu option 2 is selected, fly() is executed on all Jets.
When menu option 3 is selected, the fastest jet from the list of Jets should be displayed to the user.
When menu option 4 is selected, the jet with the longest range should be displayed to the user.
Choosing type-specific behavior calls the interface method for those Jets.
When the user chooses to add a Jet, you are prompted to enter the model, speed (in MPH), range, and price. This Jet should be added to the list of Jets so that when the user again selects menu option 1, that custom jet is included.
If you implement the option to choose Jet type, this menu displays before entering Jet data.
When the user chooses to remove a Jet, the user is presented a menu for selecting the jet to remove.
The final menu option should exit the program.
If the project does work with all of the above test conditions, you will be given a 1 for this week's project.

If the project does not work with the above test conditions, you will be given a 0 for this week's project.
