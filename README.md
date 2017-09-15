Problém
Web hostingová firma poskytuje svojím zákazníkom podporu cez email. Zaznamenáva čas
čakania zákazníka na odpoveď spolu s údajmi o type otázky, kategórii problému a typu služby
ktorej sa otázka týka. Pretože chce zlepšiť spokojnosť zákazníkov, potrebuje analytický
nástroj na vyhodnotenie týchto dát na základe rôznych parametrov.

Vstup

Firma poskytuje 10 rôznych služieb, každá má maximálne 3 variácie. Otázky sú rozdelené
do 10 rôznych typov, každý typ môže byť rozdelený do 20 kategórii, a kategória do
maximálne 5 pod­kategorií.
Prvý riadok v súbore obsahuje počet S (<= 100.000) riadkov.
Každý riadok začína znakom C (čas čakania na odpoveď) alebo D (dotaz)
C sluzba_id[.variacia_id] typ_otazky_id[.kategoria_id.[pod-kategoria_id]] P/N datum cas
Hodnoty v hranatých zátvorkách su voliteľne. Služba 9.1 predstavuje službu 9 s variáciou 1.
Typ otázky 7.14.4 predstavuje typ otázky 7 kategória 14 a pod­kategoria 4. Typ odpovede
môže byť ‘P’ (prvá odpoveď) alebo ‘N’ (nasledujúca odpoveď). Dátum odpovede je vo formáte
DD.MM.RRRR, napríklad 27.11.2012 (27.november 2012). Čas v minútach predstavuje počet
minút, ktoré zákazník čakal na odpoveď.
Podobne riadok typu dotaz:
D sluzba_id[.variacia_id] typ_otazky_id[.kategoria_id.[pod-kategoria_id]] P/N datum_od[-datum_do]
Predstavuje dotaz ktorý vypíše priemerný čas čakania na odpoveď na základe časov
odpovedí, ktoré vyhovujú špecifikovaným kritériam. Ak nie je zadaný čas ‘datum_do’ tak len
odpovede v datum­od budú započítané. sluzba_id môze mať špeciálnu hodnotu ‘*’ ktorá
znamená všetky služby a podobne ‘*’ pre typ_otazky znamená všetky typy otázok. V prípade
hodnoty ‘*’ už nemôže nasledovať variácia, alebo kategória.

Výstup

Každý riadok typu ‘D’ dotaz vypíše priemerný čas čakania na odpoveď, zaokrúhlený na čele
minúty, pre odpovede, ktoré vyhovujú kritériám v dotaze. Do výpočtu vstupujú iba riadky
nachádzajúce sa pred riadkom dotazu. Ak nie je výsledok definovaný vypíše sa ‘­’ .
