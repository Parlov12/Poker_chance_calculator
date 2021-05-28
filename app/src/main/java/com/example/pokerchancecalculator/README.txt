OSNOVNE FUNKCIONALNOSTI

// ispred svakog atributa klase se nalazi i njegovo stvarno ime u klasi

- Card_model
    -> klasa najnizeg levela
    -> osnovni model za jednu kartu
    -> atributi:
        - String type -> s - spades, h - hearts, c - clubs, d - diamons
        - String number -> 2,3,4,5,6,7,8,9,10,J,Q,K,A
        - int pic -> R.drawable.ime_slike, sluzi meni za postavljanje pojedine slike na ImageView

- Player
    -> klasa koja sadrzi 2 karte pojedinog igraca
    -> atributi:
        - List<Card_model> cards - listi se za prvu kartu pristupa s indexom 0, a za drugu kartu s indexom 1, prilikom
          stvaranja objekta Player, vrijednosti obiju karata se postavljaju na "null", a vrijednost pic-a na 0
        - Card_model empty_card - ovu kartu dodam u listu Card_model-a imena cards

- Cards
    -> klasa koja sadrzi sve podatke o trenutnom stanju odnosno 1-9 igraca te njigove karte
    -> atributi:
        - List<Player> igraci - 9 igraca, 18 karata
        - List<CardModel> table - 9 karata
- STATS
    -> statistika pojedinog igraca
    -> win, tie, lose // tie cu maknit ako ne smislimo nesto
    -> win/lose za pojedinog igraca odnosno id TextView-a je napravljen po modelu win<broj_igraca> i lose<broj_igraca>

    // MALA IZMJENA - ZANEMARI SVE OVO GORE TJ NECE TI BIT POTREBNO
    -> na samom pocetku MainActivity-a imas dvi stvari

        public Player[] players = new Player[9];
        public Card_model[] table = new Card_model[5];

    -> i iz ovoga uzimas podatke, znaci za karte odredenog igraca
       ide player[index_igraca].cards[0 ili 1, tj prva ili druga karta].getNumber() i getType()
       za karte sa stola ide table[index karte].getNumber() odnosno table[index].getType()

    -> a za String mos uzet isto String napravljen na pocetku MainActivity-a String[] konacan_unos i njega slat u funkciju




