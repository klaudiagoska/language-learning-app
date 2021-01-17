# Language learning app

### Description
Language learning app is an application that allows you to quickly check your knowledge of basic Spanish vocabulary with a test. It has been created as a semester project for the Design Patterns course at the Jagiellonian University in 2020/2021. 
At the beginning of the application, the user is asked to select the category of questions that the test will consist of - it can be a test with one-choice questions or with questions where you have to type in an answer.  At the end of the test, the number of points scored by the user is displayed, as well as all questions with information on whether the user's answer was correct or not, and if not, the correct answer is displayed.

### Design patterns used in the project
* **MVC** - this pattern was used in order to organize the project architecture. The division into layers makes it possible to separate each logical part from each other, so that a change in one place does not imply the need to make changes in other places.
* **Factory method** - the pattern is represented by the displayQuestion method in the QuestionsSummary class, which checks whether the user has answered a given question correctly. Depending on whether the answer is right or wrong, a different method is run, which causes a different display.
* **Prototype** - the pattern is expressed by implementing the clone method in classes representing different types of questions (QuestionWithInput, QuestionWithOneChoice, QuestionWithBonus). This allows an object of a specific question type to be copied.
* **Singleton** - the pattern is represented by the User class. It represents the user of the application, so there is only one instance of this class at runtime.
* **Decorator** - the application offers to create a QuestionWithBonus among questions of the QuestionWithInput type. This is to "decorate" a normal question, hence the use of the given template.
* **Template method** - the pattern is represented by inheriting the AppController class and overriding the initialize method. Thanks to this, for each class from the controller package there is an individual initialization of the window, depending on the needs of the program.
* **Observator** - the application offers an observer in the form of a pop-up window with congratulations. After completing all questions, the application checks if there are at least 75% correct answers. If so, the user's observers are informed.
* **Command** - in the application there is frequent switching between windows (in classes from the controller package). That is why the Command pattern, represented by the GoTo class, was used.
* **Iterator** - the application displays all questions to the user one by one. The Iterator pattern was used to make it easier to iterate through the questions.
* **State** - pattern is represented by the AnsweredState and NonAnsweredState classes. It was used in order to quickly check the state of a question, because the application allows to go to the next question only if the user has already answered the question (AnsweredState) and allows to answer only if the user hasn't given his answer yet (NonAsnweredState).

### Diagram
Here is the simplified diagram with design patterns used in the project:

![](https://i.postimg.cc/BbTjVD5n/schemat.jpg)
