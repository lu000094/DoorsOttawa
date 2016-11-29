# DoorsOttawa
#The requirements for this app:
1. Starting (launch) activity: MainActivity. When the app first launches, the list of buildings is automatically fetched from the RESTful API server (https://doors-open-ottawa-hurdleg.mybluemix.net (Links to an external site.)).
Notice: this is different behaviour from the labs.
2. Improve the visual appearance of MainActivity.
Current view: photo + building name on a white background. Uninspiring.
At a minimum,
•	display the building name in a larger font size (because it's the primary text)
•	display one other JSON property, such as the building's address, in a smaller font (because it's secondary text)
•	select a mono-chromatic colour to replace the white background of each list cell
Consider other UI improvements.... express yourself!
3. Class DetailActivity. Create a second Activity, named DetailActivity, that displays the detailed information for a selected building.
Use-case: when the user selects a building from the list, use an Intent to inflate the DetailActivity.
At a minimum, design your view to display the following information:
•	building name
•	building description
•	pin the building's address to a Google Map; set an appropriate zoom level
•	open hours (i.e. the calendar JSON property)
You can display other building information as well.
You're encouraged to express yourself... impress me with a spectacular UI
4. New JSON property: description. The building JSON object now includes the building's description.
5. Remove the 'Get Data' button.
6. About Dialog. Provide an information icon to the app's Action Bar. When clicked, display a dialog (i.e. AlertDialog) that displays your full name (first & last) and username. Dismiss the dialog when the OK button is clicked.
7. Custom Launch Icon
Design and use a custom icon for your app's launch icon.
8. Remove all references to my Planets app.
9. Refactor the JSON property calendar to open_hours
10. Edit model.Building to include an instance variable for the building's open hours: private List<String> openHours;
Getter method: public List<String> getOpenHours( )
Setter method: public void addDate( String date )
