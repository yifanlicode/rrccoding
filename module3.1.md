### Resources

videos:

- https://www.linkedin.com/learning/programming-foundations-object-oriented-design-3/identifying-the-objects?u=75841506

- https://www.linkedin.com/learning/software-architecture-domain-driven-design/what-is-ddd?u=75841506
- https://www.linkedin.com/learning/software-architecture-domain-driven-design/what-are-contexts?u=75841506
- https://www.linkedin.com/learning/behavior-driven-development/agile-in-context?u=75841506
- https://www.linkedin.com/learning/behavior-driven-development/three-amigos-meeting?u=75841506





### Noun Analysis

Noun analysis consists of analyzing the software request (user story or use case) to find links in information and business concepts. All the nouns in the request represent information that must be represented and accounted for in code. In the case of a user story a developer may need to extrapolate further information as well. A noun that has a collection of related information becomes a class, and the related information becomes attributes or properties of that class. If the attribute also has related information, then it is a class datatype, and you create another class with attributes and so on. All the verbs become actions that have to be coded on the class matching the noun. You may find a little rewording is necessary in the case of user stories as well.

Noun analysis is a way to understand what information a software program needs to have and what it needs to do by looking at the words used to describe it. For example, if a user story says "The user can view their account balance", the nouns "user" and "account balance" would be important pieces of information that the software needs to know about and be able to work with. The verb "view" would be an action that the software needs to be able to perform for the user. This can help in understanding what kind of classes, attributes and methods need to be created in the code.

| Language Construct | Language Meaning        | Development Meaning                                          |
| ------------------ | ----------------------- | ------------------------------------------------------------ |
| Noun               | Person, Place, or Thing | Actor, Class, or Attribute                                   |
| Adjective          | Describes the Noun      | Attribute, Specialization, or dropped if not relevant to Methods |
| Verb               | Action word             | Method on the class affected by the action                   |
| Adverb             | Describes the Action    | Possibly included with a Verb if multiple variations exist in the same class as part of the name.Possibly a parameter if an alternate outcome is apparent in other stories. |

#### What makes it a class?

An Actor uses the system. They are not a class unless you have to specifically store or retrieve information about them (i.e.: a login user story)

An Attribute is a Noun that directly describes or provides context for another Noun

A Noun becomes a class if it has 1 or more Attributes or Actions found

#### What are the attributes?

For the nouns you now need to determine how important is that noun, and what other data relates to it. 

A noun is an attribute of another noun if it "belongs to it" or helps describe that noun.

 If you discover an noun has attributes this means it's a class, because you have to store data about it. Once you discover a noun is a class that does not mean it's no longer an attribute of another class. An attribute that has a class type is how you connect one class to the other.

If your noun is the actor, and there are no other attribute requirements explicitly defined in the stories then it's not a class. Don't give in to thoughts of Id's and login's. If they are required that is someone else's user story.

If your noun is the entire system it's also ignored. You may use that to name the program, but as an object oriented construct it's ignored. The "system" will be created by whatever I'm working in and will obviously contain my classes. Trying to define the "system" as a class would require bringing in everything that makes it.

A good way to help you map this is to put it in a grid. You have to be careful not to forget the sentence context when you do this though.

| Noun | Class, Actor, System, Attribute only | In Class |
| ---- | ------------------------------------ | -------- |
|      |                                      |          |

#### Complex but still just an attribute

Sometimes you see a noun that you know is a complex concept.

You will want to make it a class, add id fields and attributes you know it must have. You're assuming these classes are part of a larger system, but one should not do that often.

Increasing the scope of your design is increasing work for no benefit. The old adage of what happens when you assume is very true. Remember my comment about the actor not being a class? 

By bringing in a complex class I add a complication I may not need too. I create a performance hit where none was needed. I also may be stepping into another developer's user story causing them grief.

#### Where does the Action Go?

The action is applied to the noun that is changed or responding to the action. It resides in the class that has all the attributes needed to perform that action. It’s important to remember this as almost all actions are caused by the actor, that doesn’t mean the actor becomes a class with all the methods.

#### So what does this look like?

As an *instructor* I want to *know the `letter grade` associated with a given student's mark*.

**Nouns and adjectives:**

*Instructor, (letter)grade (associated), student, (student)mark*

**Verbs:**

- *Know - this is a pretty obscure action.**
- **Given- this data will be provided, not an action that requires implementation. Given indicates a parameter on a method or another attribute, not a real action.*
- Verbs are pretty obscure here so we may need to reword before continuing to make it a little more understandable.

As an *instructor* I want to *get a student letter grade associated with a given student's mark*.

The sentence uses the same words but if we re-order or adjust the action words to be more clear we get a better definition of what the user wants to accomplish.

***Get* the *StudentLetterGrade***

The other thing that is missing is the relationship between a Mark and a Letter Grade. The 'Association' mentioned. There must be a missing user story. On gathering further requirements a Letter Grade is provided when a students mark is above it's low value but below it's high value.

**As an *instructor* I want to *get the student letter grade with a given student's mark that is above it's low value and below it's high value*.**

Additional nouns

*(Low, High)Value*

Let's look at this closely and plug that into a grid:

Nouns:

1. Instructor - Actor (direct user of the process). This can only become a class if something about a login is noted or there is direct associated information
2. letter grade - related to a students mark but not unique to it (anyone can get a b+). How does a letter grade apply? based on the mark being between a high and low value. We now see new attributes so this is actually a class.
3. grade low value - this is a number like mark so not a class, it's an attriute of letter grade
4. grade high value - this is a number like mark so not a class, it's an attribute of letter grade
5. Student - Not an actor. Has associated mark. Class
6. student mark - attribute of student. No further information so it's a value type and not another class.

But wait, How many marks can a student have? 1 per course? So they can have many marks and of course, a course can have many students. Well hey this changes how classes relate and what the data is. A Student doesn't have a Mark so 5. and 6. above is wrong

As a *student* I want to *get a mark for my course*

Additional nouns

*(Course, Student)Mark,* *Course*

5. Student Mark - Numeric value, Attribute of Course Mark

6. Course Mark - Attribute of the Course, Indicates the Student Mark, Class

7. Student - Related to Student Mark through Course Mark, Attribute of Course Mark

8. Course - Contains the marks for students and grades, Class

| Noun         | Class, Actor, System, Attribute only     | In Class                                                     |
| ------------ | ---------------------------------------- | ------------------------------------------------------------ |
| Instructor   | Actor                                    | Actors are not in anything                                   |
| Student      | Attribute only                           | Course Mark                                                  |
| Student Mark | Attribute only                           | Course Mark                                                  |
| Letter Grade | Class due to high, low values            | Course                                                       |
| High Value   | Attribute only                           | Letter Grade                                                 |
| Low Value    | Attribute only                           | Letter Grade                                                 |
| Course       | Class (due to CourseMarks, LetterGrades) | Since I can't find where to put this, it must be the first class accessed |
| Course Mark  | Class due to StudentMark, Student        | Course                                                       |

**Note:** in the class diagram below it shows the attributes that cause relations on the line instead of inside the class. This is a "feature" of the software for this diagram. Most diagramming tools will place that attribute, as you would expect, inside the class the arrow comes from.

**Note:** it does show Student as a class with an id, this is an addition you would only add if you Student was a class available in the system and not just an attribute (containing say the student number).
 

![img](https://learn.rrc.ca/content/enforced/366609-240202/Module%203/File_h8prv66bq2u4jdbjakbuqleu52u9k47h00139126721.png?_&d2lSessionVal=sIyW6mKixenzgYH1mp7NXqh3Z&ou=366609)


So after selecting which course they are working with the instructor can use GetStudentLetterGrade to check the students mark against the courses list of valid letter grades and return the correct grade.



### Noun Analysis Hints

- Look for pronouns and replace them with actual nouns.
- Don't add attributes to the diagram you don't need (If there is no student first name and last name in the noun analysis then don't add them). The noun analysis is there to help you maintain scope and only create attributes and classes that are needed for this solution.
- Some people are more visual. If you get stuck look to a wire frame. Classes group related data together. If you see data relations on the wire frame but don't see a noun in your analysis there is likely a class you're overlooking. If all else fails plug several scenarios into the wire frame (as a mental practice).
- A noun can be a class and an attribute of another class (this is how you create object relations). Look to the user story to see what nouns in the sentence are working together. Make sure there is a class allowing them to work together. It's not the screen or system.
- Tie the actions to the noun changed by or performing the action. These become methods on those nouns.
- You can determine if the noun you found is an example of inheritance or just an attribute with the "Is a (is sometimes a)" "Has a" rule
- If you can say and Instructor "Is a (is sometimes a)" Student then Instructor inherits from student
  (Careful, while you can say that a Student is sometimes a instructor (in my case), which is the more specialized entity? Inheritance flows from the more specialized entity to the more general entity)
- If you can say "Is a" in both directions and there is no real specialty difference to consider then chances are it's the same class.
- If you can say and Instructor "Has a" course then Instructor has an attribute of course



### Testing

It may seem unusual to talk about testing the application before the application is even written. Testing is an important part of the development cycle though, as the invention of V-Model to try and help Waterfall indicates. The problem with Waterfall is that the requirements were wrong, and no-one noticed until the end. The problem with V-Model is the testing still generally confirms what the development team already knows, and the testing is systemic until the end. Think about testing before you start developing, is the first step towards true Agile development.

Users only care that the result is what they want when they want it. This has caused developers to only show the user what they will get at the end. The developer doesn’t know what the user knows though, only what the user has told them. So how do we improve that knowledge?

We develop the test plan before coding starts. There are many ways to test out there, but from a development perspective we’re concerned with the main tests.

- **Happy Path** – This is the most likely way the system will be used. It is generally what they user is thinking about when the story was requested. It is the most basic test.
- **Extremity** – This path tests extreme values, what is the worst case the test will go through and still give the expected result. What are the highest/lowest values we need to test? What are the other possible states of objects we will run into?
- **Exception** – This is what happens when values are not provided as expected. What would happen if a value had something different than expected?

In Waterfall documentation the test scripts are as detailed as the use case detail. If you were to use the Waterfall methodology, your project will be a lot less likely to fail if you developed the test scripts before coding and considered them part of the requirements process.

In Agile user stories even have a place form them, Scenarios. When TDD (Test Driven Development) became first became required practice to help self-document and protect code, they came up with a pattern to help new developers pick it up. AAA (Arrange Act Assert) was a pattern followed to declare the starting state, perform the action to be tested, and then assert that the result state is as it should be. This was easily picked up by developers, but was still very much in their arena and not helpful to gather requirements from users. BDD (Behavior Driven Development) changed the pattern into something more user friendly and Gherkin was invented to help users tell the developers concisely what the scenarios were using a known pattern but in business language.

- **Given** – a current state, business concepts and values that indicate a starting place
- **When** – a single action to be performed. A single action may be many behind the scenes of course. This is a behavior/event from a business users perspective (e.g.  ‘A sale is completed’)
- **Then** – This should indicate everything the user expects to see when this occurs (e.g. ‘The customers payment is taken and a receipt detailing all products purchased is printed…. Etc.)

There are applications that will take scenarios written with these three words and automatically map them to automated coded tests for developers. The real advantage though is the tool to help the user tell the developer what they will accept in the extreme cases they haven’t mentioned before.

 A detailed test script is similar to a use case, more used for manual testing of an application. It will follow the same steps as the use case but instead of very general terms, "Enter a number" it will be more specific to try and cause one of the main test situations mentioned above, "Enter 123" or "Enter 3,000,000,000,000". It may still be somewhat general but try and prompt the situation in the step, "Enter an item number from an item in stock" or "not in stock" as the case may be.



### Discussion

Looking at the common stories below. 

What classes do you see? What nouns do you see that are composed with others? What specialized classes do you see? What actions do you see and what is actually performing the action?

Noun composed with others: Nouns that are attributes of other nouns, indicating a relationship between them.

Specialized class: A specialized version of a class, with additional attributes or behaviors that are unique to a specific use case or scenario.

Action: An operation or behavior that can be performed on or by an object or class.

Actor: The person or entity that initiates an action or interacts with the system.

- As a driver I want to open the door of my vehicle

  - Classes:Driver,Vehicle,Door
  - Nouns composed with others: Door is an attribute of Vehicle
  - Specialized classes: None
  - Actions: Open
  - Actor: Driver

- As a driver I want to add air to the tires of my truck

  - Classes: Driver, Truck, Tires
  - Nouns composed with others:Tires is an attribute of truck
  - Specialized classe:None
  - Actions: Add
  - Actor:Driver

- As a driver I want to start the engine of my vehicle

  - Classes:Driver,Vehicle,Engine

  - Nouns composed with others: Engine is an attribute of Vehicle

  - Specialized classes: None

  - Actions: Start

  - Actor: Driver

