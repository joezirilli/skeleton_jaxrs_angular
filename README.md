# skeleton_jaxrs_angular
Basic setup for a JAX-RS + AngularJS web application

## Pre-requisites

**Client**
* [NodeJS](http://nodejs.org/)
* Bower `sudo npm install -g bower`
* Grunt `sudo npm install -g grunt-cli`

**Server**
* Java 8
* Tomcat 7
* Maven 3
* Eclipse

## Setup

**Client setup**
* Open terminal and `cd` to the client directory
* Run `npm install && bower install`
  * installs 3rd party client dependencies
* Run `grunt`
  * runs jslint, the test suite, and builds the web resources into the dist folder

**Server setup**
* Open eclipse in a new workspace and select File > Import
* Under Maven, select Existing Maven Projects and click Next
* For root directory, enter the path to the server directory
* Make sure everything is selected (should be by default) and click Finish
* Open the Servers view in Eclipse (Window > Show View)
* Click the link to create a new server
* Under Apache, select Tomcat 7 and click Next
* Add the skeleton resource and click Finish
* In the project explorer, run the maven build by right clicking and select Maven > Update Project
* Right click on the server and select Publish
* Run the server and go to [http:localhost:8080/skeleton](http:localhost:8080/skeleton)
  * Note: After starting tomcat, you can also run `grunt serve` from the client directory to spin up a server on port 9000 with live-reload and unminified resources
