# Laborator 12
## Coteanu Andra 2A4
### Compulsory

+ Am creat interfata TestInterface (nu contine metode, insa creaza bean-urile pentru clasa de testare)
+ Am creat clasa TestClass
    + sunt definite metodele de testare aplicate asupra unei clase
    + implementeaza interfata creata pentru a putea folosi functionalitatea de testare
+ Am creat clasa ClassLoader care predefineste functii ajutatoare pentru definirea path-ului clasei ce va i testate
+ In Main:
    + am declarat un path pentru o clasa ce va fi testata
    + am verificat daca intr-adevar exista clasa la acea adresa
    + parcurg toate metodele din clasa TestClass
    + aplic metoda curenta pe clasa si in functie de rezultat se va incrementa testPassed sau testFailed
    + afisez cate teste au fost trecute si cate picate din cele aplicate pe acea clasa.
