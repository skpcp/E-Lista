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
*/pobierzPoImieniu* | Znajdź po imieniu | Funkcjonalność działająca w podobny sposób do innych opierających się na znajdowaniu użytkownika. W tym przypadku użytkownika możemy znaleźć po jego imieniu. Pole to jest kluczowe w tym wyszukiwaniu i musi być uzupełnione, nie może zostać puste. Jeżeli jest puste mamy komunikat o jego wypełnieniu. Jeżeli wpiszemy imię użytkownika, które nie pasuje do żadnego naszego pracownika dane nie zostaną wyświetlone. Po znalezieniu użytkownika bądź kilku użytkowników (kilka osób może mieć to samo imię) zostaną wyświetlone dane użytkownika. 
*/pobierzPoNazwisku* | Znajdź po nazwisku | Umożliwia nam wyszukanie użytkowników systemu po przez wpisanie nazwiska użytkownika. Podczas wyszukiwania po nazwisku pole to jest polem obowiązkowym do wpisania. Jeśli tego nie zrobimy to pole nazwisko zostanie przemienione na czerwony prostokąt, sygnalizujący że nic nie zostało wpisane. Jeżeli zaś wpiszemy nazwisko, którego nie ma w systemie zostanie nam wyświetlony komunikat o błędzie. Gdy użytkownik zostanie znaleziony system wyświetli nam informacje, które zostały podane podczas tworzenia użytkownika, grupa do której należy wyszukany użytkownik a także jej uprawnienia.
*/pobierzPoImieniuINazwisku* | Znajdź po imieniu i nazwisku | Wyszukanie użytkownika podobnie jak inne funkcjonalności znajduje nam użytkownika. Różnicą jest sposób wyszukiwania naszego użytkownika. W tym przypadku znajdujemy go po przez podanie imienia i nazwiska w pola wymagane. Pola kluczowe to imię i nazwisko. Gdy dane te nie zostaną wprowadzone lub jedno z pól nie zostanie wprowadzone to odpowiednie pole lub oba zostaną objęte czerwonym prostokątem. Jeżeli dane zostaną źle wprowadzone nic nie zostanie wyświetlone. Jeżeli wyszukanie powiedzie się zostaną wyświetlone wszystkie dane odpowiedniego użytkownika, które zostały podane podczas tworzenia jego konta, a także informacje odnośnie grupy do której użytkownik należy i uprawnienia do jego grupy. 
*/pobierzPoAktywności* | Znajdź wszystkich po aktywności | W polu wyszukiwania automatycznie jest ustawiona wartość aktywny co spowoduje wyświetlenie wszystkich użytkowników ze stanem aktywny. Po znalezieniu naszych użytkowników ze stanem aktywny zostaną pokazane wszystkie ich dane. 
*/zarejestrujUzytkownika* | Zarejestruj użytkownika | Pozwala nam zarejestrować nowego użytkownika w systemie. Aby to zrobić musimy podać danego naszego użytkownika czyli jego email, hasło, imię, nazwisko i telefon. Po zarejsetrowaniu użytkownik musi zostać aktywowany przez administratora. Aktywność posiada stan oczekujący.
*/zmienAdresEmail* | Zmień adres email użytkownika | Pozwala na zmianę adresu mailowego użytkownika. Aby to zrobić musimy podać numer id użytkownika a następnie jego nowy mail. Pola te są polami kluczowymi i muszą zostać wypełnionę. Jeżeli to nie zostanie zrobione system nam to zasygnalizuje. Wtedy brakujące pola należy uzupełnić. 
*/aktywujPoId* | Aktywuj użytkownika | Użytkownika możemy aktywować po przez podanie jego numeru id. Pole to jest polem kluczowym. Brak jego zasygnalizuje nam system i trzeba je uzupełnić. Wpisanie błędnego id spowoduje wyświetlenie błędu. Po aktywacji użytkownik otrzyma uprawnienia praconika, zostanie przydzielony do grupy pracownicy firmy a także otrzyma role pracownika. Po aktywacji jego stan zmienia się na aktywny. 
*/dezaktywujPoId* | Dezaktywuj po id | Jeżeli chcemy dezaktywować użytkownika musimy podać jego numer id. Pole to jest polem kluczowym. Brak jego zasygnalizuje nam system i trzeba je uzupełnić. Wpisanie błędnego id spowoduje wyświetlenie błędu. Dezaktywacja nie spowoduje usunięcia użytkownika z systemu. Zmieni tylko jego stan aktywności na nieaktywny.
*/zmienGrupeUzytkownika* | Zmień grupę użytkownika | Pozwala zmienić grupę dla danego użytkownika. Trzeba podać id użytkownika a także nazwę grupy do której ma trafić. Pola te muszą zostać wypełnione, jeżeli tego nie zrobimy to musimy je podać. Błąd spowoduje pokazanie odpowiedniego komunikatu o błędzie który popełniliśmy. 
*/zmienHaslo* | Zmień hasło użytkownika | Pozwala na zmianę hasła użytkownika. Aby to zrobić trzeba podać id użytkownika a także jego nowe hasło. Są to pola kluczowe tego działania i muszą zostać wypełnione. Brak ich pokaże nam system. Po wykonaniu operacji zostanie wyświetlony odpowiedni komunikat czy wszystko zostało dobrze wykonane. 
*/zmienRoleUzytkownika* | Zmień role użytkownika | Pozwala zmienić rolę danemu użytkownikowi. Do tego jest nam potrzebny numer id użytkownika a także nazwa roli jaką chcemy mu przydzielić. Są to pola kluczowe. Ich brak zasygnalizuje nam system. Po wykonaniu zostanie pokazany nam odpowiedni komunikat.
*/pobierzPoEmailuId* | Znajdz użytkownika po emailu | Pozwala wyszukać danego użytkownika za pomocą emailu. Jest to pole kluczowe naszego wyszukiwania więc nie może być ono puste. Jeśli zostanie nie wpisane system nam to pokaże. Jeżeli popełnimy inny błąd system wyświtli nam odpowiedni komunikat. 
*/pobierzPoNazwieRoli* | Znajdź wszystkich użytkowników po nazwie roli | Pozwala wyświetlić nam urzytkowników za pomocą ich roli. Nazwa roli jest polem kluczowym i musi być wypełnione. Brak tego pola pokaże nam system. Jeżeli popełnimy błąd system pokaże odpowiedni komunikat dotyczący danego błędu. 
*/pobierzPoUzytkownikowPoNazwieGrupy* | Znajdź użytkowników po nazwie grupy | Pozwala wyświetlić użytkowników danej grupy. Nazwa grupy jest polem wymaganym i nie może zostać nie wypełnione. Gdy popełnimy jakiś błąd system zwróci nam odpowiedni komunikat na temat tego błędu. 
*/pobierzPoUzytkownikowPoIdGrupy* | Znajdź użytkowników po id grupy | Pozwala wyświetlić użytkowników danej grupy za pomocą numeru id grupy. Pole to jest polem kluczowym i musi być wypełnione. Jeżeli będzie puste to system nam to pokaże. Jeżeli popełnimy jakiś błąd to system pokaże nam odpowiedni komunikat dotyczący tego błędu.
*/pobierzUzytkownikowPoGrupieIPoAktywności* | Znajdź użytkowników po nazwie grupy oraz aktywności | Pozwala nam na wyszukanie użytkowników należących do odpowiedniej grupy z podaną aktywnością. Nazwa grupy i aktywność muszą zostać podane i pola te nie mogą zostać puste. Jeśli popełnimy jakiś błąd system wskarze nam jego rodzaj.
</br>
Co mogą robić poszeczegulni użytkownicy systemu: </br>
-Admin możesz wszystko. </br> 
-Lider może pobrać użytkowników za pomocą nazwy grupy i aktywności. </br>
-Pracownik może tylko się zarejestrować. </br>
Podsumowując serwis  „Użytkownik Controller” przeznaczony jest do wykonywania operacji związanych z użytkownikiem. Podstawową operacją jest stworzenie nowego użytkownika. Dzięki temu użytkownik będzie mógł korzystać z aplikacji ale także być przypisanym do grupy użytkowników odpowiedzialnych za wykonywanie pewnych obowiązków. Oprócz tego możemy w systemie znaleźć użytkownika na kilka różnych sposobów. </br>

b)Czas Pracy Controller:</br>

Metoda | Funkcjonalność | Opis 
 --- | --- | --- 
*/pobierzWszystkieCzasyPracyUżytkownika* | Pobierz czas pracy użytkownika | Umożliwia pobranie czasu pracy dla użytkownika po przez podanie numeru id w pole użytkownik.id. Pole to jest polem kluczowym więc musi zostać wypełnione. Jeżeli nie będzie zostanie to zaznaczone przez system. Po znalezieniu użytkownika zostaną wyświetlone on nim wszystkie informacje. Czasu pracy zostaną pobrane na te dniu na które są zapisane godziny pracy z dziennika planów. 
*/zapiszCzasPracy* | Zapisz czas pracy | Umożliwia zmianę godzin pracy bez potrzeby brania z dziennika planów. Użytkownik może sobie zmienić tylko godziny pracy.
*/zapiszCzasPracyWedlugPlanu* | Zapisz czas pracy według planu | Umożliwia zapis czasu pracy według dziennika planów. W części użytkownika wpisywany jest jego numer co powoduje pobranie jego czasu pracy. Pokazane zostaną są wszystkie informacje związane z dziennikiem planów, informacje o użytkowniku dla którego jest szukany czas pracy. W tym momencie edycja czasu pracy możliwa jest tylko po przez dziennik planów ponieważ z niego są pobierane informacje o czasie pracy. Zapis czas pracy według dziennika planów zapisuje czas pracy według dnia tygodnia np.  poniedziałek, wtedy pobieramy godziny pracy z poniedziałkowego dziennika planów. Może być tylko jeden czas pracy na dzień. Jeżeli będzie próba zapisu drugiego na ten sam dzień to ponowna próba nie zostanie wykonana, gdyż dziennik jest już zapisy. 
/*pobierzCzasPracy* | Pobierz czas pracy | Nie posiada żadnych pól kluczowych. Czasy pracy zostaną pobrane dla użytkowników, którzy mają zapisany czas pracy. Wraz z tymi informacjami zostaną pobrane informacje o użytkownikach. 
*/usunCzasPracy* | Usuń czas pracy | Pozwala na usunięcie danego czasu pracy. Polem tym jest numer id czasu pracy. Pole nie może pozostać puste. Jeżeli będzie puste system nam to zgłosi. W przypadku popełnienia jakiegoś błędu otrzymamy odpowiedni komunikat.
</br>
Co mogą robić poszeczegulni użytkownicy systemu: </br>
-Admin możesz wszystko. </br>
-Lider może usunąć czas pracy, zapisz czas pracy a także zapisać czas pracy z dziennika planów. </br>
-Pracownik może zapisywać czas pracy lub zapisać czas pracy za pomocą dziennika planów. </br>
</br>
Wszystko zawarte w serwisie jest łatwe i czytelne. Użytkownik może łatwo edytować swoje godziny pracy. Umożliwia to wprowadzanie elastycznego czasu pracy, ale czas pracy jest określony na pewną liczbę godzin. </br>

c)Dziennik Planow Controller:</br>

Metoda | Funkcjonalność | Opis 
 --- | --- | ---
*/pobierzPoId* | Znajdz dziennik planow po id | Funkcjonalność umożliwiająca nam pobranie dziennika planów dla konkretnego użytkownika. Polem kluczowym w czasie wyszukiwania jest uzytkownik.id. Jest to pole kluczowe naszego wyszukiwania a więc musi ono zostać podane. Jeżeli pole nie zostanie wypełnione zostanie on objęte czerwonym prostokątem oznaczającym potrzebę wypełnienia pola. Gdy użytkownik zostanie znaleziony zostanie wyświetlony cały jego dziennik planów. Zaletą tej funkcjonalności jest to że mamy pokazany tylko dziennik planów osoby której id użyliśmy. 
*/pobierzWszystkie* | Znajdz wszystkie dzienniki planow | Umożliwia nam pobranie wszystkich dzienników planów dla wszystkich użytkowników. Zostaną one wyświetlone po kolei, czyli zostanie najpierw wyświetlony dziennik planów na każdy z dni roboczych tygodnia dla jednego użytkownika. Po pokazaniu całego dziennika planów dla jednego użytkownika pokazany zostanie następny dziennik dla innego użytkownika. W tym przypadku nie ma żadnych pól kluczowych. Oprócz dziennika zostaną też wyświetlone informacje na temat użytkownika do którego określony jest dany dziennik. 
*/pobierzPoUzytkowniku* | Znajdz dziennik planow po uzytkowniku | Funkcjonalność umożliwiająca nam pobranie dziennika planów dla konkretnego użytkownika. Polem kluczowym w czasie wyszukiwania jest uzytkownik.id. Jest to pole kluczowe naszego wyszukiwania a więc musi ono zostać podane. Jeżeli pole nie zostanie wypełnione zostanie on objęte czerwonym prostokątem oznaczającym potrzebę wypełnienia pola. Gdy użytkownik zostanie znaleziony zostanie wyświetlony cały jego dziennik planów. Zaletą tej funkcjonalności jest to że mamy pokazany tylko dziennik planów osoby której id użyliśmy. 
*/zapiszDziennikPlanow* | Zapisz dziennik planow | Służy do zapisu edytowanego dziennika planów. Samego dziennika planów nie możemy stworzyć od nowa ponieważ jest on tworzony automatycznie pod czas tworzenia użytkownika w systemie. Edycje możemy przeprowadzić po przez wpisanie w drugim polu id: wpisanie numeru dotyczącego dziennika planów. Jeżeli to wprowadzimy do danego dziennika planów w pola „PlanOd” i „PlanDo” wpisujemy datę i godzinę oraz w pole techData kiedy modyfikacja miała miejsce. Do tego jeszcze w części kodu dotyczącego użytkownika musimy wpisać id które określi nam użytkownika dla którego modyfikacja zostanie wprowadzona. To nam umożliwia zmianę dziennika planów dla użytkownika. Największą korzyścią jest to że każdemu z naszych użytkowników możemy na każdy dzień roboczy tygodnia zmienić godziny jego pracy.
*/usunPoId* | Usuń dziennik planów | Pozwala na usunięcie dziennika planów za pomocą jego numeru id. Jest to pole kluczowe, które musi zostać wypełnione. W przypadku braku tego pola system nam to pokarze. Popełnienie jakiego kolwiek błędu będzie wskazane odpowiednim komunikatem. 
</br>
Co mogą robić poszeczegulni użytkownicy systemu: </br>
-Admin możesz wszystko. </br>
-Lider może zapisać dziennik planów i może też usunąć dziennik planów. </br>
-Pracownik może tylko zapisać dziennik planów. </br>
Dziennik planów jest serwisem załatwiającym nam harmonogram. Każdy ma swój dziennik i może go edytować jeżeli to konieczne. Jest jasno pokazany czas pracy a także są oddzielone dni tygodnia. </br>

d)Nieobecnosc Controller:</br>

Metoda | Funkcjonalność | Opis 
 --- | --- | --- 
*/pobierzPoId* | Znajdz nieobecnosc po id | Jeżeli chcemy tego dokonać musimy podać id nieobecności. Pole id jest konieczne jeżeli będzie puste system zaznaczy je na czerwono. Informacje pobrane za pomocą id zostaną wyświetlone do użytkownika dla którego jest przypisany numer nie obecności. Do tego otrzyma on informacje o nieobecności i użytkowniku, który je posiada. 
*/pobierzWszystkie* | Znajdz wszystkie | Umożliwia pobranie wszystkich nieobecności wszystkich użytkowników. Nieobecności będą uporządkowane w kolejności ich tworzenia. Razem i nimi zostają wyświetlone wszystkie informacje o użytkownikach dla których zostały nieobecności utworzone. 
*/pobierzPoIdUzytkownika* | Znajdz po id uzytkownika | Wyszukanie po polu użytkownik.id wyszuka użytkownika, którego numer został podany. Wraz z informacjami zostaną wyszukane ilość nieobecności a także informacje dotyczące użytkownika, którego id został wpisane w wyszukiwanie. Pole użytkownik.id jest konieczne do wyszukania i jeżeli będzie puste wyszukanie nie rozpocznie się. 
*/pobierzPoDacie* | Znajdz po dacie | Pola kluczowe tego wyszukania to data i użytkownik.id. W ten sposób będzie można zobaczyć czy w danym dniu, dany użytkownik miał jakieś nieobecności. Filtr ten po przez takie wyszukanie umożliwi nam łatwe przeglądanie rekordów, ponieważ jeżeli byśmy szukali tylko po dacie mogło by to być mało przejrzyste gdyż wielu użytkowników może mieć nieobecność w danym dniu. 
*/pobierzPoTypie* | Znajdz po typie | Użytkownik chcąc wyszukać nieobecności musi podać jej typ. Jest to pole, które nie może zostać puste. Nieobecności zostaną wyświetlone dla tych użytkowników co będą posiadali wpisany typ. Wraz z nią zostaną podane informacje o tych użytkownikach, którzy posiadają nieobecności wpisanego w wyszukiwanie typu. 
*/pobierzPoTypieIUzytkowniku* | Znajdz po typie i uzytkowniku | Umożliwia pobranie nieobecności po typie nieobecności i użytkowniku. Pola te są polami obowiązkowymi więc trzeba je wpisać. Informacje które zostaną wyświetlone będą dotyczyły osoby, której id zostało wtedy użyte. 
*/zapiszNieobecnosc* | Zapisz nieobecnosc | Użytkownik może zapisać swoje nieobecności po przez podanie daty i ilości godzin w części nieobecności. Do tego dopisuje typ swojej nieobecności a także id w części użytkownika. Wszystko zostanie dla niego zapisane. Jeżeli zapisze już jedną nieobecność na dany dzień to nie może jej nadpisać. Po zapisaniu nieobecności zostaną wyświetlone wszystkie dane związane z jego nieobecnością a także informacje o samym użytkowniku dla, którego zostało to zrobione.
 </br>
 Serwis pozwala na łatwe przeglądanie tego czy nasi pracownicy mają jakieś nieobecności. Do niej jest zapisywany typ tej nieobecności co umożliwia automatyczny podgląd na daną sytuację. </br>
 
 e)Grupa Controller:</br>
 
 Metoda | Funkcjonalność | Opis 
  --- | --- | --- 
