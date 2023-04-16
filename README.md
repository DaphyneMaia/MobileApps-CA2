Student Name: Daphyne da Maia
Student ID: 24945
Course: BSC2

Requirement Checklist

 1. Movie recycler view:
 [ ] 1.1. Create a Movie class with the structure specified in movie.json (provided on Moodle)
 [ ] 1.2. Obtain and fill data (minimum of 4 movies)
 [ ] 1.2.1. Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
 [ ] 1.2.2. Generate a random number between 0 and 15 for each movie and assign to seats_remaining
 [ ] 1.2.3. Start with an initial default seats_selected value of 0 for all movies
 [ ] 1.2.4. You shall fill random URLs for images from pixabay or other free image providers to begin with
 [ ] 1.3. Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg (provided on Moodle)
 [ ] 1.4. If any seats are selected, show how many seats are selected and hide remaining seats
 2. Seat selection feature:
 [ ] 2.1. Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg (provided on Moodle)
 [ ] 2.2. Add plus and minus icons, show seats_selected in the middle
 [ ] 2.3. On click plus/minus, update both seats_selected and seats_remaining for that movie
 [ ] 2.4. Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
 2.5. When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyItemChanged as soon as you return to the recycler view activity)
 3. Bonus:
 [ ] 3.1. Add "filling fast" badge if less than 3 seats remaining
 [ ] 3.2. Use "Roboto Condensed" font to replicate same style
 [ ] 3.3. Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif (provided on Moodle))
Additional Features implemented
This is an optional section, feel free to remove this.

Report
A short report (300-1000 words) describing the challenges you faced, failed attempts and workarounds used, any helper or alternative libraries you have used, and what you have learned in the process.

To begin with, I have never faced such a difficult task before. Dispate off the layout everything else ended up with error. Buttons, recyclerView, JSON file, HTTP request, some things I have just giving up of doing such as downloading JSON file from the internet or update the remaining seats when pressing the back arrow.
I am very proud of my progress, because personally speaking kotlyn is a complete new language what makes it even more challenge when we are barelly learning java. Kotlin is more direct and has short commands, exactly what makes it harder than java to understand the syntax.

References and Credits
Most of the work was done using https://github.com/saravanabalagi/dorset_mobileApps1 
Watch zoom classes over and over
https://developer.android.com/
https://stackoverflow.com

APK Releases
Add your release name and update this [link] (https://github.com/DaphyneMaia/MobileApps-CA2/blob/main/app-debug.apk)
