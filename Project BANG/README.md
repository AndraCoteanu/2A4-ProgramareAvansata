# Project BANG
## game designed by Coteanu Andra
### (c) all rights for the boardgame idea, logo and the cards designs go to their rightfull owners 

This game is meant to be a demo for my bachelor thesis.
What you can do right now with this game:
  + you can see the rule book
  + you can open fragments of the rule book while in the middle of a game (helpful if you're a beginner)
  + you can start a game
    + set the number of players you want
    + set a name for yourself (max. 7 characters long and you can't use any special symbols, only letters and numbers)
  + after the game is created you can 
    + see the other players (bots) and some info about them
    + see all the info available about yourself, including the cards you start with
    + the character crads and the sheriff badge are clickable (they pop-up and you can clearly see what character does everyone have)
    + you can leave the game anytime by using: the x - close button, the leave button that appears on the left of the screen or by clicking 'Game' -> 'Exit' in the menu bar 

Algorithm:
  + separated classes for each menu screen
  + when the player inserts his name it is verified and should be only letters and numbers and no longer than 7 characters, otherwise the player is asked to insert his name again
  + 3 separated classes for: characters, roles and cards
  + this classes are based on a list of information that is then suffled (1-3 times)
  + the players get their cards so that no 2 players get to be the same character in a game or to have the same playing card
  + in the player class are: cards list, role, character and other player info 

#### The programming language used for this game prototipe was java (using javaFX for graphics).
#### You can see a short video with the game as it is now following this link: https://youtu.be/XPlNMLqJKlY
#### All the images used were designed by myself (sometimes starting from a googled photo or from scrach) usind pixlr photo editor.
#### The cards were provided by https://bang.dvgiochi.com/cardslist.php?id=1#q_result (downloaded from the page source).
#### The rule book in .pdf format was provided by http://www.dvgiochi.net/bang/bang_rules.pdf .
#### !! disclaimer: the game isn't yet playable, nor is it finnished
