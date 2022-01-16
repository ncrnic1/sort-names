# sort-names Overview

This program takes in a list of names and sorts them by alphabetical order; last name and then first name.  
Then, it creates a file containing the sorted order.  

# Installation

Download, and extract wherever you would like.  

# Dependencies

Java Development Kit (JDK) 17.0.1 recommended, if wanting to compile and run via command prompt.  
For javac and java to work correctly, the JDK also may need to be configured manually.  

# Usage

The instructions below refer to:  
\<extract-location>: where you extracted this repository to  
\<input-file>: the full file path of the input text file you want the program to process

- Open command prompt  
- Navigate to "\<extract-location>\sort-names-main\sort-names\src\main"  
- Type "javac *.java"  
- Type "cd .."  
- To run, type "java main/Main \<input-file>.txt"  
- The output file will be created in the same directory as the output file, with the name "\<input-file>-sorted.txt"  

Alternatively, if preferring to run via an IDE:  
- Open the project inside the IDE  
- Set the run configuration to have the desired input file path  
- Run Main  

# Testing

It is recommended that unit and integration tests be conducted through an IDE:  

- Open the project inside the IDE  
- Run either UnitTest or IntegrationTest to see the results  

IntegrationTest uses the test-files folder in the project directory. Input and expected output files can be put there, and then new tests can be created comparing the expected output to the actual output.  
