Reading: chapter1

Videos: https://www.linkedin.com/learning/programming-foundations-object-oriented-design-3/object-oriented-thinking?u=75841506

## 1.1 Objectives and Classes

When you think of a cup in general abstract terms, it follows certain rules and has a specific purpose, this is the class. Your holiday cup you pulled form the cupboard is a specific instance of cup, that is an object that follows the rules of cup.

### Attribute

Your cup has attributes that allow it to work.

 In this case a big opening in the center that allows you to put stuff in. You might say your cup is most useful when it has content. Content would be an attribute (or property) of cup. You can pour say tea to your cups content. I think that would make more sense than basin.

### State

The state of your cup has now changed, it was empty, now it has tea content. This is how we refer to an objects state in object-oriented development. An objects state is the current value of all its attributes.

### Behaviors

By adding tea to your cup, you can perform new actions with it. The Drink action is perhaps enabled. Don’t burn your tongue. You Drink the Cups Content. Once the Content is empty, you can no longer Drink.

### Encapsulation

*/*ɪnˌkæpsjuˈleɪʃ(ə)n*/*

Content is an Attribute you can change with your cup. But you can’t change what the cup was made with, the paint, enamel*/*ɪˈnæm(ə)l/, if it has a handle (well not without breaking it). 

What it’s made with is encapsulated, protected. Classes work the same. They expose attributes you can change but keep fields private that it’s against the rules to change.

### Inheritance

Let’s think about your Cup cupboard again with the different kinds of cups. You have your cups that you can use for tea, but what about cups with thinner material? Ones made of glass or plastic? Ones without handles? They follow the same rules for content… but if you put hot tea in one, you’ll burn your hand, or worse melt the cup. The cup that can hold tea, is a specialized class made for higher temperature, but they all inherit from a fundamental generalized concept.

### ‘is a’ or ‘has a’, Inheritance or Composition

Your holiday mug ‘has a’ handle and content and a temperature allowance, ‘has a’ indicates attributes. Your holiday mug ‘is a’ cup. It follows all the rules of cup but adds the temperature specialty, ‘is a’ indicates inheritance.

### Getters and Setters

To access an `attribute `of an object it must provide you access with its interface. The interface of a mug is a hole in the top and a handle. You use the handle to hold the mug with your hand and provide its contents via the hole in the top. You can then drink the contents via the same interface.

The `get` and` set` of this content is only available through this interface, if the content could be changed without knowledge of the interface, then you would not be able to count on your desired result, you could think of this like a magic unseen hole in the bottom of your cup.

Therefore, the content of your class should never be directly accessible from outside forces.`public String Name;'`should never be used, it should be private and then grant access.

Many languages now allow this construct setup to be automatically completed and hidden from the developer it’s so important. Public Property Name as String in VB automatically creates all getters and setters as well as a private variable _Name. This is also seen in class diagrams. A class with a public attribute is assumed to be a private variable with public get and set methods, since a fully public attribute should never exist.

### Read only attributes (get only)

Temperature allowance is an attribute of cup then, one you can’t change but one you can see.

### Polymorphism

ˌ/pɑlɪˈmɔrfɪzm/

With our original concept of tea in mind, what if we’re talking iced tea? Its still tea but you pour it differently and will drink it differently from the cup as well. This is where polymorphism comes in. Your cup knows you will drink from it, but how you drink from it will be different based on the type of cup as well as its contents. You will drink differently from the specialized holiday cup then the iced tea cup, so the specialization must put different actions inside the commonly known drink action implemented by the cup class.



1. Identify the 3 main development paradigms
2. Describe the purpose of each of the 3 main development paradigms
3. Explain the advantages and disadvantages of object-oriented development
4. Identify common UML Diagrams
5. Describe the purpose of each diagram

## 1.2 Programming Paradigms

### Procedural

The analysis is action oriented so it’s very easy to program this way. People think in terms of steps they (or a process) needs to perform in order to get a result, that is how everyone is initially taught to break down problems. When I want a cup of tea I think of boiling the water, adding the water to the cup, steeping the tea, then I get to drink it. Simple. How I combine the boiling water and tea with the devices available would be in the process itself, passed as parameters to actions that need them.

Because it’s so easy to do and understand, this was the first way programming was done. It’s still quite common especially with the popularity of script programs like Powershell but in order to not cause more problems than it solves it should be used a certain way.

1. The process is a small and simple one without integration or interaction
2. The process is internal to the IT department, no outside user involvement

Why is that? The longer the process, the more actions you need to get to your result. A big long process with action after action is hard to debug and find an issue so you often have to simply start at the beginning and walk it through line by line until you find the problem. Some say that it’s because procedural code is not re-usable but that’s not the case. You can create re-usable action based code, it’s just much harder to work with later in a larger code base.

### Object-Oriented

Along comes Object-Oriented to solve all your problems and combine your code in ways that makes them easy to maintain. Well yes and no. There are 2 big requirements for proper object-oriented programming if it’s going to help you keep your large code base easy to maintain.

1. Behaviors and the data they need are stored in the same class. Parameters should only be needed if the action needs data that is not normally attributed to the class (not needed for anything else) as well to complete. The action depends on the data in the object at the time the action is executed, known as the objects State.
2. The classes, attributes, and actions are created and stored in the language of the business.

In the language of the business is generally missed, and is the reason many don’t see the value of created a solution with a complex object oriented paradigm. If you create your program in the language of your business though, whenever your business needs something changed in the program they will actually talk to you in the language of your program.

### Incomplete Truths

1. Object Oriented development was created to make code more reusable

   Procedural code is action oriented, that doesn't mean you can't break a problem down into many actions and re-use them. Consider a baking recipe, I have a recipe for making buns that contains the actions I need to perform to finish them as cinnamon buns. However I also have the option of turning them into cheese buns by following the cheese process instead. I don't have 2 entire recipe's, I just follow different actions at the end, The actions have different parameters, cheese instead of cinnamon.

   Of course If I were writing this recipe to share I would need to plan more carefully how the actions could be re-used. Can the cheese action be re-used on say Mini Pizzas for the kids? Not without careful planning and documentation.

2. Procedural is sequential, so they made object oriented development.

   All code is run sequentially, so the term sequential here likely means steps all lumped together (which we disproved above), however I'll discuss sequential as the term means as well. The process is simply what starts the code and where in the code does that call take it. A computer cannot decide to run code out of order, it does simply what the program tells it, step by step, in sequence.

   As systems get more complex, it becomes harder and harder to see the sequences. The content of the sequences become spread out. Asynchronous processes allow multiple sequences to run at the same time. When you really evaluate the processes though, they will all be sequential. Object oriented development simply helps you better keep track of how sequences relate. 

   All programming is sequential, Only the actor can change the sequences but they are still sequences

### Functional

Some equate functional as a throwback to procedural but it’s not quite the same. In procedural code, everything is actions. You supply the data an action needs as a parameter when it's executed so the action can perform it's duty. In functional code, everything is an action, however all actions are also data. When you call an action, you supply the actions it needs as parameters to execute and perform other actions. This can get very complicated, but can be very powerful, especially where mathematical or algorithmic software is involved.

A lot of developers really like to use it though because it is an action oriented paradigm which makes understanding and solving complex problems easier for them. Since functional programming is stateless, they only have to know and understand exactly what's been provided to the action at the time it is called.