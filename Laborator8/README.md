##Coteanu Andra - LABORATOR 8 
#Compulsory

* Am ales sa folosesc baza de date Oracle fiind deja familiara cu aceasta.
* Scriptul lab8.sq se afla in folderul cu resursele proiectului.
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
* In plus: am implementat si o interfata grafica pentru a face aplicatia mai user friendly.
