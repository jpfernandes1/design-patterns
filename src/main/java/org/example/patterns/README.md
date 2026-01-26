# Design Patterns

### They are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.


### Benefits of patterns

Patterns are a toolkit of solutions to common problems in software design. They define
a common language that helps your team communicate more efficiently.

### Classification

Design patterns differ by their complexity, level of detail and scale of applicability. In addition,
they can be categorized by their intent and divided into three groups.


## Creational

### Factory

The Factory Method is a creational design pattern that provides an interface for creating objects in a superclass,
but allows subclasses to change the type of objects that will be created.

This method suggests that you replace direct object construction calls (using the new operator) with
calls to a special factory method. Don't worry: objects are still created through the new operator,
but this is being called from within the factory method. Objects returned by a factory method are usually
called products.

Despite the name, product creation is not the creator's primary responsibility. Typically, the creator class already has some business logic related to the products. The factory method helps to decouple this logic from the concrete product classes.

Analysis: a software development company may have a training department for programmers.

However, the main function of the company as a whole is still to write code, not to produce programmers.