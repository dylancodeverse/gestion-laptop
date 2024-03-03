-- NOTION DE LAPTOP
create table laptopmarque (
    idlaptopmarque serial primary key,
    laptopmarque varchar(250) not null unique
);

create table processeurtype (
    idprocesseurtype serial primary key ,
    processeur varchar(250) not null unique
);

create table ramtype (
    idramtype varchar(250),
    ram varchar(250) not null unique
);

create table ecran (
    idecran serial primary key,
    ecran varchar(250) not null unique
) ;

create table disquedur (
    iddisquedur serial primary key,
    disquedur varchar(250) not null unique
);

create table laptop (
    laptopid serial primary key ,
    marque varchar(250),
    reference varchar(250) not null unique,
    processeur varchar(250),
    ram varchar(250),
    ecran varchar(250),
    disquedur varchar(250),
    foreign key(marque) references laptopmarque(idlaptopmarque),
    foreign key(processeur) references processeurtype(idprocesseurtype),
    foreign key(ram) references ramtype(idramtype),
    foreign key(ecran) references ecran(idecran),
    foreign key(disquedur) references disquedur(iddisquedur)
);

-- modele de laptop

create table modellaptop(
    idmodellaptop serial primary key, -- ity izany no numero de serie
    laptopid integer ,
    foreign key (laptopid) references laptop(laptopid)
);    

-- NOTION DE POINT DE VENTE

create table emplacement(
    idemplacement serial primary key,
    emplacement varchar(250) not null,
    hierarchie integer default(1) 
    -- rehefa 1 dia point de vente ~~ rehefa 10 dia magasin central
);

-- NOTION D'AFFECTATION DE LAPTOP

create table mouvementlaptop(
    idmouvementlaptop serial primary key,
    idemplacement integer,
    idmodellaptop integer,
    datedebut timestamp default(now()),
    datefin timestamp,
    foreign key (idemplacement) references emplacement(idemplacement),
    foreign key (idmodellaptop) references modellaptop(idmodellaptop)

);

-- VIEW POUR SAVOIR L'EMPLACEMENT ACTUEL DE CHAQUE PC

    create view dernieremplacement as select * from mouvementlaptop where datefin is null;

-- GESTION D'UTILISATEUR

create table utilisateur(
    idutilisateur serial primary key,
    utilisateur varchar(250) not null,
    mail varchar(250) not null ,
    password varchar(250) not null
);

create table affectationutilisateur (
    idaffectationutilisateur serial primary key ,
    idutilisateur integer ,
    idemplacement integer,
    datedebut timestamp default(now()),
    datefin timestamp
);

-- NOTION DE TRANSFERT : MI GERER HOE AVY AIZA MAKAIZA

create table TRANSFERT (
    idtransfert serial primary key,
    idmouvementlaptop integer , -- ahafantarana hoe t@ assignation an'iza sy t@ oviana (sady fantatra 
    -- oazy hoe inona lay laptop sy ilay mi transfert)
    destinataire integer ,
    datetransfert timestamp default(now()),
    datefindetransfert timestamp,
    foreign key (idmouvementlaptop) references mouvementlaptop(idmouvementlaptop),
    foreign key (destinataire) references emplacement (idemplacement)
);


-- NOTION DE VENTE DE LAPTOP

create table ventelaptop (
    idventelaptop serial primary key,
    idmouvementlaptop integer ,
    prixdevente double precision ,
    datevente timestamp default(now()),
    foreign key(idmouvementlaptop) references mouvementlaptop(idmouvementlaptop)
);

