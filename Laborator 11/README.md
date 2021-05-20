# Laborator 11
## Coteanu Andra 2A4
### Compulsory

+ Am creat un proiect nou folosind Spring Initializer.
+ Am creat o noua baza de date (Oracle) si am adaugat modulul JPA pentru a putea lucra cu baze de date.
+ Pe baza BD-ului, cu ajutorul JPA-ului, am generat automat mapari pentru tabelele create:
    + users
    + friends
+ Am creat interfata UserRepository pentru a avea o evidenta mai clara a functiilor predefinite in SpringBoot pe care le-am folosit pentru operatiile pe BD.
+ In clasa UserService am folosit metodele din interfata pentru a defini functiile necesare.
+ In clasa UserController am definit metode REST pentru a putea face requesturile HTTP de modificare a BD-ului (cu ajutorul functiilor din UserService).
+ Am testat serverul creat cu SpringBoot in postman 
    + id-ul este transmis direct in url
    + fisiere JSON pentru a crea noi useri (contin si id-ul si numele)
    + fie, pentru a modifica numele unui user: trimit id-ul prin url si numele ca parametru.

### Optional

+ Am creat interfata FriendRepository si clasele FriendService si FriendController.
+ Am facut serviciile REST pentru operatiile pentru: 
    + inserarea unui prieten, 
    + stergerea unui prieten,
    + afisarea tuturor prietenilor din lista. 
+ Am testat cu Postman noile servicii create.
+ Am integrat laboratorul 10 cu 11
    + am folosit proiectul din laboratorul 11 (cu unele modificari) drept server
    + am pastrat clientul din laboratorul 10 
