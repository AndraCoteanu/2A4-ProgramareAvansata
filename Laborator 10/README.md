# Coteanu Andra - Laborator 10
## Compulsory

+ In proiectul pentru aplicatia server:
  + am creat clasa SocialServer care:
  - se asigura ca socketul pentru server ruleaza la un anumit port (2121)
  - pentru fiecare nou client conectat la acest port creaza un thread
  + clasa ClientThread este cea care face de fapt threadul pentru fiecare client (este apelata in SocialServer); 
