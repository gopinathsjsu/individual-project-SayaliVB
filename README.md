### H3 Credit card problem

<details>
  <summary>

  #### H4 Part 1: (20 points)

  </summary>

You have a CSV file that contains credit card  records. Each record is on a line. It contains a field for the card number, the expiration date, and the name of the card holder. The fields are comma-separated.  In your system you have the following class structure for the credit cards:

     a class CreditCard,

     classes VisaCC, MasterCC, AmExCC that are all subclasses of CreditCard,

     you can assume more subclasses for other credit card types will be added later on.

You now have to design the method(s) (and maybe additional classes) that  reads a record from the file, verifies that the credit card number is a valid account number, and creates an instance of the appropriate credit card class.  

Important details: Credit card numbers cannot exceed 19.  You can determine the card issuer based on the credit card number:

MasterCard

First digit is a 5, second digit is in range 1 through 5 inclusive. Only valid length of number is 16 digits.

Visa

First digit is a 4. Length is either 13 or 16 digits.

AmericanExpress

First digit is a 3 and second digit a 4 or 7. Length is 15 digits.

Discover

First four digits are 6011. Length is 16 digits.

Deliverables:

Upload a PDF document containing the text and UML Class diagram in your Git repo. You can use Astah tool for the diagrams.

- Describe what is the primary problem you try to solve.

- Describe what are the secondary problems you try to solve (if there are any).

- Describe what design pattern(s) you use how (use plain text and diagrams).

- Describe the consequences of using this/these pattern(s).

Hint: you face here (at least) two problems, one has to do with how you figure out what kind of card a specific record is about, the other one with how you create the appropriate objects. Look at behavioral patterns and at creational patterns.

</details>

<details>
  <summary>

  #### H4 Part 2:  15 points (Design only)

   </summary>

Continue with the design from Part 1 and extend it to parse different input file formats (json, xml, csv) and detect the type of credit card and then output to a file  (in the same format as the input - json or xml or csv) - with each line showing the card number, type of card (if a valid card number) and an error (if the card number is not valid). The design should accommodate newer file formats for the future. Draw a  UML Class Diagram for Part 2

</details>

<details>
  <summary>

  #### H4 Part 3: 65 points

  </summary>

Implement an application (Java code and JUnit tests) for Part 1 and Part2 - that accepts input file name and output file name and writes an output file in the same format as the input (CSV or JSON or XML). Output should contain the details specified in Part 2.

</details>


<details>

<summary>Console Input example:</summary>

input file name:

src/main/java/org/creditcard/sample_files/input_file.json


output file name:

src/main/java/org/creditcard/sample_files/output_file.json

</details>


[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/9NZqTcR2)
