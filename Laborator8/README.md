# Coteanu Andra - LABORATOR 8
## Compulsory 

* Am ales sa folosesc baza de date Oracle fiind deja familiara cu aceasta.
* Scriptul lab8.sql se afla in folderul cu resursele proiectului.
  * contine codul pentru crearea celor 3 tabele
  * contine cateva inserturi in tabele 
* In pom.xml am adaugat 2 dependente:
  * driverul pentru baza de date
  * pentru a putea rula scriptul .sql
* Am folosit 2 interfete MovieDAO si GenreDAO pentru a fluidiza codul. Interfetele contin 2 functii:
  * crearea unui insert
  * o interogare de tip select pentru a gasi un element in tabel dupa nume (de film sau de gen)
* Testul implementat pe baza de date presupune:
  * conectarea la baza de date
  * inserarea unui film in tabela movies
  * inserarea unui gen de filme in tabela genres
  
## Optional

* Am adaugat in lab8.sql tabelele pentru actori si directori ca extensie a tabelei persoane
* Pentru datele cu care lucreaza acteasta aplicatie Java:
  * am modificat butonul "connect to DB" in "Test Connection" - se vor insera 2 randuri in tabelele genres si movies ca sa se testeze daca functioneaza conexiunea
  * am adaugat butonul "All Movies Info" - afiseaza informatii despre toate filmele din baza de date ex: titlu, scor, director, actori, genuri, etc
  * am adaugat butonul "Genres" - se selecteaza un gen de film si se vor afisa toate filmele existene in baza de date cu acel gen
  * dupa selectarea unei optiuni apare o fereastra de tip pop-up care anunta ca toate informatiile au fost afisate in consola
  
## Bonus

* Am implementat clasa ConnectionPool pentru a realiza conexiuni la baza de date cu c3p0.
* Clasa MovieThread implementeaza functia care va fi rulata de threaduri in conexiune.
* Clasa MovieThreadPool creaza threaduri pentru conexiunea cu c3p0.
* Am creat intr-un for 20 de threaduri si am monitorizat activitatea lor cu Visual VM

#### In plus: am implementat si o interfata grafica cu javaFX pentru a face aplicatia mai user friendly.

  
