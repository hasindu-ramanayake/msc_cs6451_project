# msc_cs6451_project
This is the system design for JCR Company internal software

## Basic Coding Style Guide to follow:
  ### File name: 
    * For a source file containing classes, the file name consists of the case-sensitive name of the top-level class (of which there is exactly one), plus the .java extension.
    * One class for a file
  ### Imports:
    * no wildcard imports 
  ### Class declaration
    * Each top-level class resides in a source file of its own.
    
  ### Naming
    * Package and module names: com.example.deepspace (all lower case letters)
    * Class names/ Enums are also classes: UpperCamelCase
    * Method names: lowerCamelCase
    * Constant names: UPPER_SNAKE_CASE
    * Non-constant field names/ Parameter names/ Local variable names: lowerCamelCase
    * Type variable names: followed by the capital letter T (examples: RequestT, FooBarT).
    * for the base interface: IThisIsMyClassInerface

  For reference: https://google.github.io/styleguide/javaguide.html#s3.4.1-one-top-level-class

## How to run the project:
    1. clone the code
    2. cd msc_cs6451_project\code directory
    3. mvn clean install
    4. run the jar file in the target folder: java -jar target/code-1.0-SNAPSHOT.jar