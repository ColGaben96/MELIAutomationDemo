# MELI AUTOMATION DEMO
# DISCLAIMER
Mercado Libre is a registered trademark and this project does not relate to anything between them.<br>
Please use this project as a demo of how I do consider Automation with Serenity  must be done, and this project can be 
changed according to the necessities of the client.
## How to run
### 1. Enable Google Sheets API
In order to do this, open GCP and create a project. Once you have it you can do this<br>
Click on:
<pre>Burger Menu > APIs & Services > Enabled APIs & Services</pre>
Then, search for
<pre>Google Sheets API</pre>
Then, go to Credentials and create an OAuth 2.0 Client IDs
Download the JSON file and put in on this path:
<pre>./src/test/resources/</pre>
Create a folder named credentials and paste the downloaded JSON there.
### 2. Authenticate with Google Account Services
When you make the project run, it will ask you for authenticate, remember to enable the OAuth consent screen and add 
your Google Account to the Test Users.

## Some couple of warnings
You can see my Google Sheets with the hash-id of the file found on 
<pre>com.colgaben.meli.automation.domain.constants.GoogleDataConstants</pre>
There you will find a constant called WORKBOOK_ID
You can paste to your WebBrowser and see the file on this <a href="https://docs.google.com/spreadsheets/d/1OlaodnQs8HQtKK0vUiyiRiIZTgko4e8t8RhKhvgTz-Q">URL</a>
<pre>https://docs.google.com/spreadsheets/d/WORKBOOK_ID VALUE</pre>
If do you want to create your own file, you can give viewer rights to anyone with the link
and replicate the file structure if you want.

## FAQ

<ul>
<li>
<b><i>Is this a "cheat sheet" for passing a QA Automation interview?</i></b> <br>
If do you want to see it like that, yes... But it doesn't guarantee you to pass the technical screening.<br> 
</li>
<li>
<b><i>I created my own file, but my project fails when i make it run</i></b><br>
Remember to change the header title and workbook's sheet name on the <b>Steps Definition</b>. If these two values 
differs, there will be exception errors. I can recommend you to duplicate my file if you're just looking the project.
</li>
</ul>
If for any reason you have any more questions or comments you can email me to 
<a href="mailto:geblarot96@gmail.com?subject=Questions from MELIAutomationDemo">geblarot96@gmail.com</a> and I promise 
to answer as soon as I can