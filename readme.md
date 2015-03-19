#Football Scoring Dashboard

By Alexander Boyi He
boyi.he@mail.mcgill.ca


This is an application that prints out a scoring dashboard as text during a football match.

The application's required inputs are singular entries following the following flow:

1. The Football Scoring Dashboard needs to know when a game starts through being supplied a string of this format: 
"Start: '<Name of Home Team>' vs. '<Name of Away Team>'". 
Example: "Start: 'England' vs. 'West Germany'"

2. After the start command has been given, acceptable inputs to tell the Dashboard when goals are scored follow the following structure: 
"<minute> '<Team>' <name of scorer>".
Example: "11 'West Germany' Haller"

3. The tool is able to compute the 'print' command at any time during the course of a game to print the aggregated scoring statistics of the match.
Example: If tool is given the 'print' command, it will output the following:
"England 0 vs. West Germany 1 (Haller 12')" if that is the only goal that has been scored at that point.

4. The Dashboard knows a game has ended through the 'End' command.

5. The tool will cater for the following error conditions:
	a. If the Football Scoring Dashboard is given any commands while a game is not in progress it will report: 
	'No game currently in progress'.

	b. If a game is in progress and it is not able to understand the given command it will return:
	'input error - please type 'print' for game details'.

	c. If a game is not in progress and it is not able to understand the given command, it will return: 
	'input error - please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>''.


This application consist of "DashboardReocord.java", the main program part (as an object), and "DashboardFrame.java", a simple GUI.
When running the application, input the command on the TextField provided and click Submit buttom each time.
Updated scoring statistics would be printed after each goal and another new game could be started after "End".

