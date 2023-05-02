CREATE TABLE voiture
(
    matricule VARCHAR(20) NOT NULL,
    marque VARCHAR(20),
    couleur  VARCHAR(10),
    etat VARCHAR(15),
    date_achat DATE(11),
    prix_location NUMERIC (6),
    CONSTRAINT "Voiture_pkey" PRIMARY KEY (matricule)
);


CREATE TABLE client
(
    cin integer NOT NULL,
    nom VARCHAR (20),
    prenom VARCHAR (20),
    age integer(2),
    adr VARCHAR (30),
    adr_mail VARCHAR (30),
    tel numeric (8),
    CONSTRAINT "client_pkey" PRIMARY KEY(cin)

);

CREATE TABLE locationv
(
     matricule  VARCHAR (20),
     cin integer NOT NULL,
     nom VARCHAR (64),
     date_location Date(64),
     duree  NUMERIC (10),
     prix NUMERIC(10),
     CONSTRAINT "locationv_pkey" PRIMARY KEY (cin),
     CONSTRAINT "locationv_pkey" PRIMARY KEY (matricule)
);


DROP table client;