# E-Lista

<b>Jest to system pozwalający na:</b></br>
-zarządzanie obecnością</br>
-tworzenia grup użytkowników i zarządzania nimi</br>
-prowadzenia ewidencji nieobecnosci</br>
-ustalenia własnego trybu pracy i monitorowania pracy;</br>
</br>
<b>Aktywności: </b></br>
-Nieobecnosci</br>
-Grupy</br>
-Obecnosci</br>
-Dzienniki planów </br>
<i>-Zarządzanie użytkownikami</i></br>
</br>
<b> Serwisy: </b> </br>

a)Użytkownik Controller:</br>

Metoda | Funkcjonalnosć | Opis 
 --- | --- | --- 
*/zapiszUzytkownika* | Tworzenie/edytowanie użytkownika | Funkcjonalność przeznaczona do tworzenia nowych użytkowników lub do edycji istniejących. W czasie tworzenia użytkownika trzeba uzupełnić pewne niezbędne pola, które są wymagane podczas tworzenia nowego użytkownika. Polami tymi są : imię, nazwisko, hasło, telefon i email. Email i hasło są polami po przez które użytkownik będzie się logował do aplikacji.
*/pobierzWszystkich* | Znajdź wszystkich | Funkcjonalność umożliwiająca pokazanie nam wszystkich użytkowników jakich mamy utworzonych w systemie. Po wyszukaniu użytkowników zostaną wyświetlone ich wszystkie dane. Jest przydatna bardzo w czasie różnorodnego dokonywania przeglądu kadr gdyż umożliwia podgląd wszystkich pracowników. 
*/pobierzPoId* | Znajdź użytkownika po id | Funkcjonalność należąca do najlepszego typu gdyż każdy użytkownik ma swój nie powtarzalny numer id, który go identyfikuje. Polem kluczowym jest id, które musi zostać podane w czasie wyszukiwania. Jeżeli nie ma konta przypisanego do wpisanego numeru id nic nie zostanie wyświetlone. Po znalezieniu naszego użytkownika który ma przypisany id zostaną wyświetlone jego dane. 
*/pobierzPoImieniu* | 
