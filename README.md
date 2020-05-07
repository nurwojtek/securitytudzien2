Zad 1
Napisz aplikacje, która posiada 4 endpointy zwracające:
1. „Cześć admin {imie}”
2. „Cześć user {imie}”
3. „Cześć nieznajomy”
4. „Papa”
Administrator ma mieć dostęp do wszystkich endpointów. User tylko do 2, 3, 4. Natomiast niezalogowany do 3. Skonfiguruj aplikacje w taki sposób, aby po wylogowaniu się użytkownik aplikacji (bez względu na role) zawsze zostawał przekierowany do endpointu z napisem „Papa”.
Kiedy Administrator lub User wejdą na endpoint 3 to dostaną komunikat „Cześć {imie}”
Zad 2 – opcjonalne
Rozbuduj aplikacje, aby dodawała licznik, który będzie weryfikował ile razy dany użytkownik uwierzytelnił się w aplikacji. Wyświetlaj mu ten komunikat 😉