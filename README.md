# Alkalmazások fejlesztése beadandó feladat
*Molnár Adrián és Molnár Dominik munkája*
### Rubik-kocka timer app

**Timer app, amiben Rubik-kocka kirakás időeredményt mérniés kezelni lehet.
Más felhasználók eredményeinek követésére is lehetőséget ad.**

Beadandó feladat az ELTE Informatikai Karon, az Alkalmazások fejlesztése nevű tárgyból.

* **App kipróbálása:** [Placeholder]

## Dokumentáció:
### Funkcionális elvárások
    
**Mindenki által elérhető funkciók**
- Regisztráció
- Rubik-kocka stopper

**Regisztrált felhasználók által elérhető funkciók**
- Időeredmények kezelése
- Felhasználók listázása
- Felhasználó adatlapjának megtekintése az időeredmények megjelenítésével
- Más felhasználók követése 

**Adminisztrátorok által elérhető funkciók**
- Felhasználók kezelése (módosítás, törlés)
- Belső adatok kezelése (hozzáadás, módosítás, törlés)

### Nem funkcionális elvárások

- Felhasználóbarát, egyszerű, letisztult felület
- Lekérdezési eredmények gyors megjelenítése
- Jelszavas azonosítás, jelszavak biztonságos tárolása

### Szakterületi fogalomjegyzék

- **Kocka:** Kirakós játék, amelyet időre rak ki a felhasználó. (pl.: 3x3x3-as Rubik kocka, 4x4x4-es Rubik-kocka, Skewb, Megaminx, stb.)
- **Kirakás:** Adott kocka kirakása, amelyhez tartozik az elért időeredmény, a kirakó személy, illetve a keverés lépései is.
- **Szett:** 5 kirakás halmaza, amelyből az átlagoot számolják. A szett eredményét a legjobb és legroszabb időeredmény kivétele után, a maradék 3 eredmény átlaga adja. Érvénytelen kirakás automatikusan a legroszabb eredménynek számít. Legalább két érvénytelen kirakás esetén a szett érvénytelen.
- **Érvényes kirakás:** A kirakás érvényes, ha a keverés a nemzetközileg elfogadott keverési algoritmus alapján történik, illetve, ha a stopper csak a kocka kirakása után állítódik meg. Ha a kocka csupán egy fordítással marad el a kirakott állapottól, akkor az időeredményhez +2 másodperces büntetés adódik. Ha a kocka legalább két fordítással marad el a kirakott állapottól, akkor a kirakás érvénytelen.

### Szerepkörök

- **Vendég:** nem regisztrált látogató, a Rubik-kocka stoppert használhatja
- **Tag:** regisztrált és bejelentkezett felhasználó, aki saját időeredményeit kezelheti valamint követhet más felhasználókat
- **Adminisztrátor:** felhasználókat és egyéb belső adatokat kezelhet




