CREATE TABLE Tenant
(
    ID          SERIAL NOT NULL,
    AvatarID    int4   NOT NULL,
    Name        varchar(255),
    Email       varchar(255),
    Username    varchar(255),
    Phone       varchar(255),
    BirthDate   date,
    Sex         varchar(255),
    Nif         varchar(255),
    Nationality varchar(255),
    Occupation  varchar(255),
    Password    varchar(255),
    PRIMARY KEY (ID)
);
CREATE TABLE House
(
    ID             SERIAL NOT NULL,
    LandlordID     int4   NOT NULL,
    Address        varchar(255),
    Title          varchar(255),
    Rooms          int4   NOT NULL,
    AvailableRooms int4   NOT NULL,
    BathRooms      int4   NOT NULL,
    MinPrice       float8 NOT NULL,
    MaxPrice       float8 NOT NULL,
    Description    varchar(255),
    Features       varchar(255),
    LandlordIndex  int4,
    PRIMARY KEY (ID)
);
CREATE TABLE Photo
(
    ID         SERIAL NOT NULL,
    HouseID    int4   NOT NULL,
    Path       varchar(255),
    HouseIndex int4,
    PRIMARY KEY (ID)
);
CREATE TABLE Landlord
(
    ID        SERIAL NOT NULL,
    AvatarID  int4   NOT NULL,
    Name      varchar(255),
    Email     varchar(255),
    Username  varchar(255),
    BirthDate date,
    Sex       varchar(255),
    Nif       varchar(255),
    Address   varchar(255),
    Password  varchar(255),
    Phone     varchar(255),
    PRIMARY KEY (ID)
);
CREATE TABLE RentHistory
(
    HouseID  int4 NOT NULL,
    TenantID int4 NOT NULL,
    BDate    date NOT NULL,
    EDate    date,
    PRIMARY KEY (HouseID, TenantID)
);
CREATE TABLE Application
(
    TenantID     int4 NOT NULL,
    HouseID      int4 NOT NULL,
    ToBeAssessed bool NOT NULL,
    Accepted     bool NOT NULL,
    PRIMARY KEY (TenantID, HouseID)
);
CREATE TABLE LandlordEvaluation
(
    LandlordID  int4   NOT NULL,
    TenantID    int4   NOT NULL,
    Cleanliness float8 NOT NULL,
    Payment     float8 NOT NULL,
    Care        float8 NOT NULL,
    PRIMARY KEY (LandlordID, TenantID)
);
CREATE TABLE TenantEvaluation
(
    EvaluatorID  int4   NOT NULL,
    EvaluatedID  int4   NOT NULL,
    Tidiness     float8 NOT NULL,
    Cleanliness  float8 NOT NULL,
    Privacy      float8 NOT NULL,
    Friendliness float8 NOT NULL,
    PRIMARY KEY (EvaluatorID, EvaluatedID)
);
CREATE TABLE Avatar
(
    ID   SERIAL NOT NULL,
    Path varchar(255),
    PRIMARY KEY (ID)
);
ALTER TABLE Photo
    ADD CONSTRAINT has FOREIGN KEY (HouseID) REFERENCES House (ID);
ALTER TABLE RentHistory
    ADD CONSTRAINT rents FOREIGN KEY (TenantID) REFERENCES Tenant (ID);
ALTER TABLE House
    ADD CONSTRAINT owns FOREIGN KEY (LandlordID) REFERENCES Landlord (ID);
ALTER TABLE RentHistory
    ADD CONSTRAINT "is rented" FOREIGN KEY (HouseID) REFERENCES House (ID);
ALTER TABLE Application
    ADD CONSTRAINT isAppliedFor FOREIGN KEY (HouseID) REFERENCES House (ID);
ALTER TABLE LandlordEvaluation
    ADD CONSTRAINT "is evaluated" FOREIGN KEY (TenantID) REFERENCES Tenant (ID);
ALTER TABLE Tenant
    ADD CONSTRAINT has2 FOREIGN KEY (AvatarID) REFERENCES Avatar (ID);
ALTER TABLE Landlord
    ADD CONSTRAINT has3 FOREIGN KEY (AvatarID) REFERENCES Avatar (ID);
ALTER TABLE Application
    ADD CONSTRAINT applied FOREIGN KEY (TenantID) REFERENCES Tenant (ID);
ALTER TABLE LandlordEvaluation
    ADD CONSTRAINT evaluates2 FOREIGN KEY (LandlordID) REFERENCES Landlord (ID);
ALTER TABLE TenantEvaluation
    ADD CONSTRAINT "Is evaluated" FOREIGN KEY (EvaluatedID) REFERENCES Tenant (ID);
ALTER TABLE TenantEvaluation
    ADD CONSTRAINT evaluates FOREIGN KEY (EvaluatorID) REFERENCES Tenant (ID);
