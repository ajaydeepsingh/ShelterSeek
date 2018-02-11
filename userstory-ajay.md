
## Ajaydeep Singh User Story

#### Title: As a homeless shelter, I want to be able to upload status (full, empty) so that I can communicate better with homeless people and help them understand what is available 

#### Tasks:

- Implement a submitStatus function
- in submitStatus include variable that set the location, occupancy, and meal times
- implement fucntion in controller/activity
- add button to allow user to submit status which ultimately calls the submitStatus function
- add radio buttons to allow shelter to set location and occupancy which will be passed to submitStatus function
- Implement back button on the Status page to return the user to the previous screen
- Implement a login button and text field for the registered shelter to enter in their username and password


#### Acceptance Scenarios:

-Given a registered user is in any activity, WHEN the registered user clicks the add report button, THEN the
registered user is shown the form to fill out a report
-Given a registered user is in the report form, WHEN the registered user clicks the submit button, THEN the
registered user's form is submitted and added to the reports list
-Given a registered user in the report form, WHEN the registered user clicks the back button, THEN the
registered user is returned to the previous activity
-Given a registered user in the login screen, WHEN the registered user fills out the username and password
text field and clicks the login button, THEN the registered user is verified and sent to the map view
-Given a registered user in the login screen, WHEN the registered user fails to enter in a valid login, THEN
the registered user is prompted with a error message
-Given a registered user is in the report form, WHEN the registered user clicks the submit button and did not fill out all fields, THEN the registered user is prompted with a error message and asked to refill the form

#### Done Done Criteria:

- Unit test are written or updated to check for allowing a registered user to login, submit a report, backout of a report, and are passed




