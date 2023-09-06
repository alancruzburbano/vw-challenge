# Cleaner domothic example 
This is a simple application of hexagonal architecture using springboot, as an interfaces it was defined an incoming port for reading text file and the out port by console, the single use case defines is for execute routine according to the rules given in the documentation. 

Technological stack:

    Java 11, Spring Boot

Assumptions:

    The surface is a square initially
    The first line of the file is the workspace dimensions and each two lines are part of the robot configuration


Project Domain Notes:

    All the rules are validated in the domain, the extra layers only were used  for solving issues like read data source and the outgoing method, in this case is a simple message in console, but can me easily changed implementing the outgoing port.

How to change the data for test?

    Just edit the file 'input.txt' in the src/main/resources/files  directory

How to run the project?
In a terminal placed into the folder project execute the command

    mvn spring-boot:run
