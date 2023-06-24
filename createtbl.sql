-- Include your create table DDL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the create table ddls for the tables with foreign key references
--    ONLY AFTER the parent tables has already been created.

-- This is only an example of how you add create table ddls to this file.
--   You may remove it.
CREATE TABLE Team
(
    country VARCHAR(30) NOT NULL,
    group VARCHAR(10),
    associationName VARCHAR(30),
    associationURL VARCHAR(30),
    numberOfGoalsScored INTEGER,
    PRIMARY KEY(country)
);

CREATE TABLE Player
(
    pid VARCHAR(20) NOT NULL,
    shirtNumber INTEGER,
    name VARCHAR(30),
    DOB DATE,
    position VARCHAR(10),
    timeLeft TIME,
    timeEntered TIME,
    redCard BOOLEAN,
    yellowCards INTEGER,
    country VARCHAR(30),
    matchesPlayed INTEGER,
    PRIMARY KEY (pid),
    FOREIGN KEY (country) REFERENCES TEAM(country)
);

CREATE TABLE Coach
(
    cid VARCHAR(30) NOT NULL,
    name VARCHAR(30),
    DOB DATE,
    role VARCHAR(30),
    country VARCHAR(30),
    PRIMARY KEY (cid),
    FOREIGN KEY (country) REFERENCES Team(country)
);


CREATE TABLE Referee
(
    rid VARCHAR(5) NOT NULL,
    rname VARCHAR(30),
    role VARCHAR(30),
    YOE INTEGER,
    country VARCHAR(30),
    PRIMARY KEY (rid)
);

CREATE TABLE Stadium
(
    sname VARCHAR(30) NOT NULL,
    location VARCHAR(30),
    capacity INTEGER,
    PRIMARY KEY (sname)
);

CREATE TABLE Match
(
    matchID VARCHAR(10) NOT NULL,
    mdate DATE,
    mtime TIME,
    round VARCHAR(10),
    length INTEGER,
    sname VARCHAR(30),
    team1 VARCHAR(30),
    team2 VARCHAR(30),
    rid VARCHAR(5),
    PRIMARY KEY (matchID),
    FOREIGN KEY (sname) REFERENCES Stadium(sname),
    FOREIGN KEY (team1) REFERENCES Team(country),
    FOREIGN KEY (team2) REFERENCES Team(country),
    FOREIGN KEY (rid) REFERENCES Referee(rid)
);

CREATE TABLE Goals
(
    pid VARCHAR(20) NOT NULL,
    matchID VARCHAR(10) NOT NULL,
    goalNo INTEGER NOT NULL,
    penaltyKick BOOLEAN,
    timeOccured TIME NOT NULL,
    PRIMARY KEY (pid, matchID, goalNo),
    FOREIGN KEY (pid) REFERENCES Player(pid),
    FOREIGN KEY (matchID) REFERENCES Match(matchID)
);


CREATE TABLE Purchase
(
    pid VARCHAR(30) NOT NULL,
    totalPrice DECIMAL(10,2),
    pdate DATE,
    creditCard INTEGER,
    matchID VARCHAR(10),
    PRIMARY KEY (pid),
    FOREIGN KEY (matchID) REFERENCES Match(matchID)
);

CREATE TABLE Seat
(
    sname VARCHAR(30) NOT NULL,
    seatID INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (sname, seatID),
    FOREIGN KEY (sname) REFERENCES Stadium(sname)
);

