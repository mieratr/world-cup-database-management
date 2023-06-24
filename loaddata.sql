-- Include your INSERT SQL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the INSERT statements for the tables with foreign key references
--    ONLY AFTER the parent tables!

-- This is only an example of how you add INSERT statements to this file.
--   You may remove it.
INSERT INTO MYTEST01 (id, value) VALUES(4, 1300);
-- A more complex syntax that saves you typing effort.
INSERT INTO Team (country, group, associationName, associationURL, numberofGoalsScored) VALUES
 ('Turkey', 'A', 'TFF', 'fdgd54gr6dfg468r', 18)
,('Albania', 'A', 'AFF', 'r987g918eg7985', 2)
,('Canada', 'A', 'CFF', 'eryb1e89y7165', 5)
,('Croatia', 'A', 'CCF', 'fefwe7f41ef54', 6)
,('Madagascar', 'B', 'MFA', 'pouiik8t298rh46', 8)
,('Zimbabwe', 'B', 'ZFA', 'zgzhh66d15654gs', 5)
,('Congo', 'B', 'CCF', 'sfdhjh8kj7956s', 4)
,('Botswana', 'B', 'BFW', 'sgf8fd7njyuj6854', 6)
,('France', 'C', 'FFF', 'adxhgsgbfh87410', 7)
,('Germany', 'C', 'GFF', 'sfs98fg71b68h46a8f4', 3)
,('Argentina', 'C', 'AKF', 'sgvs84b1s54fs65b4', 9)
,('Nepal', 'C', 'NFJ', 'zsfd4fb118nn468m4', 14)
,('Peru', 'D', 'PFK', 'potuyms4t5454795', 12)
,('Mexico', 'D', 'FMW', 'awzbm687498s4vj5', 13)
,('Iceland', 'D', 'FII', 'fpmzfewikl46s5v4sg1', 17)
,('Cameroon', 'D', 'CAF', '6a8w8f4mf6lp798e4v6', 1)
;

INSERT INTO Player (pid, shirtNumber, name, DOB, timeLeft, yellowCards, country, matchesPlayed) VALUES
 ('tk12', 15, 'Bob', '1965-05-21', '00:00:00', 0, 'Canada', 5)
,('sk36', 16, 'Chlob', '1965-05-25', '00:00:00', 0, 'Canada', 6)
,('fk15', 9, 'Rob', '1957-06-21', '00:00:00', 0, 'Nepal', 3)
,('ak45', 10, 'Tob', '1958-07-21', '00:00:00', 0, 'Argentina', 3)
,('mk75', 1, 'Hob', '1956-08-21', '00:00:00', 0, 'Peru', 0)
,('tk84', 4, 'Wob', '1966-09-21', '00:00:00', 0, 'Mexico', 2)
,('yk14', 5, 'Qob', '1967-04-21', '00:00:00', 0, 'Cameroon', 1)
,('tk19', 6, 'Yob', '1953-07-21', '00:00:00', 0, 'Iceland', 1)
,('sk32', 7, 'Pob', '1978-06-21', '00:00:00', 0, 'France', 4)
,('lk23', 8, 'Mob', '1986-01-21', '00:00:00', 0, 'Germany', 0)
,('jk54', 22, 'Nob', '1975-02-21', '00:00:00', 0, 'Cameroon', 0)
,('pk96', 99, 'Xob', '1957-03-21', '00:00:00', 0, 'Canada', 6)
,('tk51', 78, 'Zob', '1968-05-21', '00:00:00', 0, 'Turkey', 6)
,('yk99', 79, 'Pob', '1968-05-21', '00:00:00', 0, 'Botswana', 0)
;

INSERT INTO Coach (cid, name, DOB, country, role) VALUES
 ('coach1', 'Kyle', '2000-01-01', 'Turkey', 'head')
,('coach2', 'Myle', '2000-02-01', 'Albania', 'head')
,('coach3', 'Xyle', '2000-03-01', 'Canada', 'head')
,('coach4', 'Ryle', '2000-04-01', 'Croatia', 'head')
,('coach5', 'Tyle', '2000-05-01', 'Madagascar', 'head')
,('coach6', 'Qyle', '2000-06-01', 'Zimbabwe', 'head')
,('coach7', 'Wyle', '2000-07-01', 'Congo', 'head')
,('coach8', 'Zyle', '2000-08-01', 'Botswana', 'head')
,('coach9', 'Dyle', '2000-09-01', 'France', 'head')
,('coach10', 'Fyle', '2000-10-01', 'Germany', 'head')
,('coach11', 'Pyle', '2000-11-01', 'Argentina', 'head')
,('coach12', 'Syle', '2000-11-01', 'Nepal', 'head')
,('coach13', 'Cyle', '2000-02-01', 'Peru', 'head')
,('coach14', 'Vyle', '2000-03-01', 'Mexico', 'head')
,('coach15', 'Byle', '2000-04-01', 'Iceland', 'head')
,('coach16', 'Nyle', '2000-05-01', 'Cameroon', 'head')
,('coach17', 'Roger', '2000-09-01', 'France', 'assistant')
,('coach18', 'Poger', '2000-10-01', 'Germany', 'assistant')
,('coach19', 'Toger', '2000-11-01', 'Argentina', 'assistant')
,('coach20', 'Moger', '2000-11-01', 'Nepal', 'assistant')
,('coach21', 'Woger', '2000-02-01', 'Peru', 'assistant')
,('coach22', 'Goger', '2000-03-01', 'Mexico', 'assistant')
;

INSERT INTO Referee (rid, rname, YOE, country) VALUES
 ('r169', 'Daniel', 2, 'China')
,('r756', 'Raniel', 3, 'Cameroon')
,('r378', 'Maniel', 5, 'Mali')
,('r752', 'Yaniel', 5, 'Russia')
,('r951', 'Qaniel', 452, 'Japan')
,('r185', 'Paniel', 75, 'China')
,('r275', 'Saniel', 0, 'Japan')
;

INSERT INTO Stadium (sname, location, capacity) VALUES
 ('Vodafone Park', 'Istanbul', 60000)
,('Allianz Arena', 'Munich', 60000)
,('Bernabeu', 'Madrid', 60000)
,('Camp Nou', 'Barcelona', 60000)
,('Emirates Stadium', 'London', 60000)
,('Parc Des Princes', 'Paris', 60000)
;

INSERT INTO Match (matchID, mdate, mtime, round, length, sname, team1, team2, rid) VALUES
 ('match1', '2022-05-02', '20:00:00', 'group', 90, 'Vodafone Park', 'Turkey', 'Canada', 'r169')
,('match2', '2022-05-03', '20:00:00', 'group', 90, 'Vodafone Park', 'Turkey', 'Botswana', 'r756')
,('match3', '2022-05-04', '20:00:00', 'group', 90, 'Camp Nou', 'Turkey', 'Cameroon', 'r378')
,('match4', '2022-05-05', '20:00:00', 'group', 90, 'Vodafone Park', 'Nepal', 'Canada', 'r752')
,('match5', '2022-05-06', '20:00:00', 'group', 90, 'Bernabeu', 'Argentina', 'Canada', 'r951')
,('match6', '2022-05-07', '20:00:00', 'group', 90, 'Emirates Stadium', 'Germany', 'Canada', 'r185')
,('match7', '2022-05-08', '20:00:00', 'group', 90, 'Bernabeu', 'Madagascar', 'France', 'r275')
,('match8', '2022-05-09', '20:00:00', 'group', 90, 'Allianz Arena', 'Zimbabwe', 'Iceland', 'r752')
,('match9', '2022-05-10', '20:00:00', 'group', 90, 'Vodafone Park', 'Mexico', 'Peru', 'r951')
,('match10', '2022-05-11', '20:00:00', 'group', 90, 'Parc Des Princes', 'Argentina', 'Congo', 'r756')
,('match11', '2022-05-12', '20:00:00', 'quarter', 90, 'Allianz Arena', 'Turkey', 'Iceland', 'r378')
,('match12', '2022-05-13', '20:00:00', 'quarter', 92, 'Emirates Stadium', 'Mexico', 'Canada', 'r752')
,('match13', '2022-05-14', '20:00:00', 'quarter', 90, 'Allianz Arena', 'Nepal', 'Argentina', 'r185')
,('match14', '2022-05-15', '20:00:00', 'quarter', 91, 'Emirates Stadium', 'Congo', 'France', 'r951')
,('match15', '2022-05-16', '20:00:00', 'semi', 98, 'Allianz Arena', 'Turkey', 'Canada', 'r185')
,('match16', '2022-05-17', '20:00:00', 'semi', 92, 'Parc Des Princes', 'Nepal', 'France', 'r951')
,('match17', '2022-05-18', '20:00:00', 'final', 93, 'Allianz Arena', 'Turkey', 'France', 'r951')
,('match18', '2022-05-04', '20:00:00', 'group', 90, 'Vodafone Park', 'Albania', 'Croatia', 'r275')
;

INSERT INTO Goals (pid, matchID, goalNo, timeOccured) VALUES
 ('tk51', 'match1', 1, '21:34:23')
,('yk99', 'match2', 1, '20:31:14')
,('tk51', 'match3', 2, '21:54:13')
,('fk15', 'match4', 1, '20:24:22')
,('tk12', 'match5', 1, '21:34:41')
,('lk23', 'match6', 1, '20:54:53')
,('sk32', 'match7', 1, '21:36:35')
,('tk19', 'match8', 1, '20:14:43')
,('tk84', 'match9', 1, '21:21:26')
,('ak45', 'match10', 1, '20:21:43')
;


INSERT INTO Purchase (pid, totalPrice, matchID) VALUES
 ('p684657564', 6742.43, 'match1')
,('p7686876141', 7866.67, 'match1')
,('p62786276', 7561.64, 'match1')
,('p268176278', 5762.47, 'match6')
,('p66846247', 7565.45, 'match6')
,('p268762814', 6756.46, 'match8')
,('p626786448', 7355.76, 'match8')
,('p26874426', 68763.13, 'match7')
,('p82684287', 67868.76, 'match4')
,('p26876118', 10548.44, 'match2')
,('p77349387', 1059.95, 'match3')
,('p41999142', 13599.08, 'match5')
,('p59237188', 28361.48, 'match17')
,('p78814014', 1159.68, 'match9')
,('p48686863', 8600.15, 'match10')
,('p32064244', 15003.07, 'match11')
,('p36959997', 3905.49, 'match12')
,('p30068366', 15095.96, 'match13')
,('p46853899', 22331.66, 'match14')
,('p50412841', 5935.60, 'match15')
,('p5255519', 11102.59, 'match16')
,('p40151663', 13080.30, 'match13')
,('p67104159', 25313.74, 'match10')
,('p53688081', 13618.36, 'match4')
;

INSERT INTO Seat (sname, seatID, price) VALUES
 ('Parc Des Princes', 6548, 5498.45)
,('Parc Des Princes', 6125, 6845.98)
,('Bernabeu', 1852, 123.1)
,('Bernabeu', 8537, 687.45)
,('Camp Nou', 8969, 213.66)
,('Camp Nou', 1853, 7895.44)
,('Camp Nou', 9635, 3242.77)
,('Emirates Stadium', 7566, 9874.12)
,('Emirates Stadium', 1235, 654.13)
,('Parc Des Princes', 7663, 987.14)
,('Parc Des Princes', 7566, 456.47)
,('Parc Des Princes', 6754, 1235.15)
,('Parc Des Princes', 5696, 7452.2)
,('Parc Des Princes', 1745, 654.7)
;