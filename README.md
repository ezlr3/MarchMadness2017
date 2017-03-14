# marchmadness2017
2017 Sila Bracket Challenge


The Main method in the Tournament class will generate a bracket consisting of n rounds based on the teams.csv file.  The method will also print out the the teams included in each round (the winners from the previous round).  The final round will contain a single unbeaten team which will be the overall champion.

The Game class contains methods to determine the winner when given two teams.  This determination is made based upon the average shooting percentages of 1pt, 2pt, and 3pt shots for the two teams from the 2016-2017 season.  These percentages are averaged with with the allowed shooting percentages from the opposing team.  The caclulated averages are then applied to the average nubmer of shots taken by each team over the course of the 2016-2017 season.  Again, the number of each type of shot taken is averaged with the number of shots allowed by the opposing team.  Using these metrics a score is determeined for the game and the winner selected.

All statistics are contained in .csv files from https://www.teamrankings.com/.

Bracket Output:

***Round 1***
Villanova
Mt St Marys
Wisconsin
VA Tech
Virginia
NC-Wilmgton
Florida
E Tenn St
S Methodist
USC
Baylor
New Mexico
S Carolina
Marquette
Duke
Troy
Gonzaga
S Dakota St
Northwestern
Vanderbilt
Notre Dame
Princeton
W Virginia
Bucknell
Maryland
Xavier
Florida St
Fla Gulf Cst
St Marys
VCU
Arizona
North Dakota
Kansas
NC Central
Miami (FL)
Michigan St
Iowa State
UNLV
Purdue
Vermont
Creighton
Rhode Island
Oregon
Iona
Michigan
Oklahoma St
Louisville
Jacksonville
N Carolina
TX Southern
Arkansas
Seton Hall
Minnesota
Middle Tenn
Butler
Winthrop
Cincinnati
Kansas St
UCLA
Kent State
Dayton
Wichita St
Kentucky
N Kentucky
***Round 2***
Villanova
Wisconsin
NC-Wilmgton
Florida
S Methodist
Baylor
Marquette
Duke
Gonzaga
Vanderbilt
Princeton
Bucknell
Maryland
Fla Gulf Cst
St Marys
Arizona
NC Central
Miami (FL)
Iowa State
Vermont
Rhode Island
Iona
Michigan
Louisville
N Carolina
Arkansas
Middle Tenn
Winthrop
Kansas St
UCLA
Wichita St
Kentucky
***Round 3***
Villanova
Florida
Baylor
Duke
Gonzaga
Bucknell
Maryland
St Marys
NC Central
Vermont
Iona
Michigan
N Carolina
Winthrop
UCLA
Wichita St
***Round 4***
Villanova
Duke
Gonzaga
St Marys
Vermont
Michigan
Winthrop
UCLA
***Round 5***
Villanova
Gonzaga
Michigan
UCLA
***Round 6***
Gonzaga
Michigan
***Round 7***
Gonzaga
