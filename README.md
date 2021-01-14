**Project GMIBank - Team26**

Please make sure you update version of the below

Java version:1.8 (Java 8.0)
Maven version: 3.6.3
GitHub repository.

Project settings: To generate cummumber-html-report suscesully make sure you have have the below settings:

Step1:

Mac OS: InteliJ IDEA ->Preference->Build,Execution,Deployment->Compiler->Java complier->Project bytecode version select 1.8 on drop down then Target bytecode version select 1.8 then click OK
Windows OS: File-> Settings-> Build, Execution, Deployment->Compiler->Java compiler->Project bytecode version select 1.8 on drop down then Target bytecode version select 1.8 then click OK

Step2:

Mac OS: file->Project Structure->Project->select 1.8 Project SDK and select 1.8 Project language level 1.8 Then click on modules->language level select 1.8 then click on SDKs and select 1.8 finally click on OK
Note: After completing your settings do not forget re start your IntelliJ.


**Finally, use this command to run the test and genarete report:**

Terminal :
    Step 1--> mvn clean test verify -Dcucumber.options="--tags @tag name"
    Step 2--> cick on target
    Step 3--> click on "cucumber-html-report"
    Step 4--> Right click on the report-fature tag and open with browser
