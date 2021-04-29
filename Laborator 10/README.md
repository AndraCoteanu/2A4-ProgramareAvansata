# Coteanu Andra - Laborator 10
## Compulsory

+ In proiectul pentru aplicatia server am creat clasa SocialServer care:
  + se asigura ca socketul pentru server ruleaza la un anumit port (2121)
  + pentru fiecare nou client conectat la acest port creaza un thread
+ Clasa ClientThread din thread:
  + este cea care face de fapt threadul pentru fiecare client (este apelata in SocialServer)
  + primeste requesturi de la client
  + creaza raspunsuri
  + le tirmite la client
+ Comenzile functionale sunt: stop, exit, iar orice mesaj care nu este recunscut ca si comanda va produce un raspuns pentru client
+ In proiectul pentru aplicatia client am creat clasa ClientCommands care:
  + citeste comenzile de la tastatura
  + le trimite serverului
  + primeste raspunsul si il afiseaza

## Optional

+ In proiectul pentru aplicatia server am creat clasa Client care retine date despre toti cleitnii conectati la server
+ Cu ajutorul unui string.split(" ") am impartit requestul de la client in cuvinte separate de spatiu:
  + primul cuvant va fi mereu comanda
  + urmatoarele cuvinte fiind fie numele de utilizator cu care vrea sa faca login / register sau numele prietenilor pe care vrea sa ii adauge
