import java.sql.* ;
import java.util.Scanner;

class Soccer

{
    public static void createTables(Statement statement, int sqlCode, String sqlState){
        try {
            String[] createTableCmds = {
                    "CREATE TABLE Team (country VARCHAR(30) NOT NULL, group VARCHAR(10), associationName VARCHAR(30), associationURL VARCHAR(30), numberOfGoalsScored INTEGER, PRIMARY KEY(country))",
                    "CREATE TABLE Player (pid VARCHAR(20) NOT NULL, shirtNumber INTEGER, name VARCHAR(30), DOB DATE, position VARCHAR(10), timeLeft TIME, timeEntered TIME, redCard BOOLEAN, yellowCards INTEGER, country VARCHAR(30), matchesPlayed INTEGER, PRIMARY KEY (pid), FOREIGN KEY (country) REFERENCES TEAM(country))",
                    "CREATE TABLE Coach (cid VARCHAR(30) NOT NULL, name VARCHAR(30), DOB DATE, role VARCHAR(30), country VARCHAR(30), PRIMARY KEY (cid), FOREIGN KEY (country) REFERENCES Team(country))",
                    "CREATE TABLE Referee (rid VARCHAR(5) NOT NULL, rname VARCHAR(30), role VARCHAR(30), YOE INTEGER, country VARCHAR(30), PRIMARY KEY (rid))",
                    "CREATE TABLE Stadium (sname VARCHAR(30) NOT NULL, location VARCHAR(30), capacity INTEGER, PRIMARY KEY (sname))",
                    "CREATE TABLE Match (matchID VARCHAR(10) NOT NULL, mdate DATE, mtime TIME, round VARCHAR(10), length INTEGER, sname VARCHAR(30), team1 VARCHAR(30), team2 VARCHAR(30), rid VARCHAR(5), PRIMARY KEY (matchID), FOREIGN KEY (sname) REFERENCES Stadium(sname), FOREIGN KEY (team1) REFERENCES Team(country), FOREIGN KEY (team2) REFERENCES Team(country), FOREIGN KEY (rid) REFERENCES Referee(rid))",
                    "CREATE TABLE Goals (pid VARCHAR(20) NOT NULL, matchID VARCHAR(10) NOT NULL, goalNo INTEGER NOT NULL, penaltyKick BOOLEAN, timeOccured TIME NOT NULL, PRIMARY KEY (pid, matchID, goalNo), FOREIGN KEY (pid) REFERENCES Player(pid), FOREIGN KEY (matchID) REFERENCES Match(matchID))",
                    "CREATE TABLE Purchase (pid VARCHAR(30) NOT NULL, totalPrice DECIMAL(10,2), pdate DATE, creditCard INTEGER, matchID VARCHAR(10), PRIMARY KEY (pid), FOREIGN KEY (matchID) REFERENCES Match(matchID))",
                    "CREATE TABLE Seat (sname VARCHAR(30) NOT NULL, seatID INTEGER NOT NULL, price DECIMAL(10,2) NOT NULL, PRIMARY KEY (sname, seatID), FOREIGN KEY (sname) REFERENCES Stadium(sname))"
            };
            for (String cmd : createTableCmds) {
                statement.execute(cmd);
                System.out.println("Created table: " + cmd.split(" ")[2]);
            }
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }

    public static void insertData(Statement statement, int sqlCode, String sqlState) {
        try
        {
            // Loading Team data
            String[] teamData = {"('Turkey', 'A', 'TFF', 'fdgd54gr6dfg468r', 18)",
                    "('Albania', 'A', 'AFF', 'r987g918eg7985', 2)",
                    "('Canada', 'A', 'CFF', 'eryb1e89y7165', 5)",
                    "('Croatia', 'A', 'CCF', 'fefwe7f41ef54', 6)",
                    "('Madagascar', 'B', 'MFA', 'pouiik8t298rh46', 8)",
                    "('Zimbabwe', 'B', 'ZFA', 'zgzhh66d15654gs', 5)",
                    "('Congo', 'B', 'CCF', 'sfdhjh8kj7956s', 4)",
                    "('Botswana', 'B', 'BFW', 'sgf8fd7njyuj6854', 6)",
                    "('France', 'C', 'FFF', 'adxhgsgbfh87410', 7)",
                    "('Germany', 'C', 'GFF', 'sfs98fg71b68h46a8f4', 3)",
                    "('Argentina', 'C', 'AKF', 'sgvs84b1s54fs65b4', 9)",
                    "('Nepal', 'C', 'NFJ', 'zsfd4fb118nn468m4', 14)",
                    "('Peru', 'D', 'PFK', 'potuyms4t5454795', 12)",
                    "('Mexico', 'D', 'FMW', 'awzbm687498s4vj5', 13)",
                    "('Iceland', 'D', 'FII', 'fpmzfewikl46s5v4sg1', 17)",
                    "('Cameroon', 'D', 'CAF', '6a8w8f4mf6lp798e4v6', 1)"};
            String insertSQL = "INSERT INTO Team (country, group, associationName, associationURL, numberofGoalsScored) VALUES ";
            for (String eachTeamData : teamData) {
                System.out.println ( insertSQL + eachTeamData + ";") ;
                statement.executeUpdate ( insertSQL + eachTeamData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Player data
            String[] playerData = {"('tk12', 15, 'Bob', '1965-05-21', 'attacker', '00:00:00', NULL, 0, FALSE, 'Canada', 5)",
                    "('sk36', 16, 'Chlob', '1965-05-25', 'attacker', NULL, NULL, 0, FALSE, 'Canada', 6)",
                    "('si40', 17, 'Peter', '1965-05-25', 'midfielder', NULL, NULL, 0, FALSE, 'Canada', 6)",
                    "('ml28', 23, 'Pen', '1965-05-25', 'defender', NULL, NULL, 0, FALSE, 'Canada', 6)",
                    "('fk15', 9, 'Rob', '1957-06-21', 'defender', '00:00:00', NULL, 0, FALSE, 'Nepal', 3)",
                    "('fk16', 13, 'Hope', '1957-06-21', 'defender', NULL, NULL, 0, FALSE, 'Nepal', 3)",
                    "('ak45', 10, 'Tob', '1958-07-21', 'attacker', '00:00:00', NULL, 0, FALSE, 'Argentina', 3)",
                    "('ak46', 16, 'Tob', '1958-07-21', 'attacker', NULL, NULL, 0, FALSE, 'Argentina', 3)",
                    "('mk75', 1, 'Hob', '1956-08-21', 'midfielder', '00:00:00', NULL, 0, FALSE, 'Peru', 0)",
                    "('tk84', 4, 'Wob', '1966-09-21', 'defender', '00:00:00', NULL, 0, FALSE, 'Mexico', 2)",
                    "('yk14', 5, 'Qob', '1967-04-21', 'attacker', '00:00:00', NULL, 0, FALSE, 'Cameroon', 1)",
                    "('tk19', 6, 'Yob', '1953-07-21', 'midfielder', '00:00:00', NULL, 0, FALSE, 'Iceland', 1)",
                    "('sk32', 7, 'Pob', '1978-06-21', 'defender', '00:00:00', NULL, 0, FALSE, 'France', 4)",
                    "('lk23', 8, 'Mob', '1986-01-21', 'attacker', '00:00:00', NULL, 0, FALSE, 'Germany', 0)",
                    "('jk54', 22, 'Nob', '1975-02-21', 'midfielder', '00:00:00', NULL, 0, FALSE, 'Cameroon', 0)",
                    "('pk96', 99, 'Xob', '1957-03-21', 'defender', '00:00:00', NULL, 0, FALSE, 'Canada', 6)",
                    "('tk51', 78, 'Zob', '1968-05-21', 'attacker', '00:00:00', NULL, 0, FALSE, 'Turkey', 6)",
                    "('tk52', 79, 'Kagan', '1968-05-21', 'midfielder', '00:00:00', NULL, 0, FALSE, 'Turkey', 0)",
                    "('tk53', 80, 'Haluk', '1968-05-21', 'defender', '00:00:00', NULL, 0, FALSE, 'Turkey', 0)",
                    "('tk54', 81, 'Bora', '1968-05-21', 'attacker', NULL, NULL, 0, FALSE, 'Turkey', 0)",
                    "('tk55', 82, 'Cem', '1968-05-21', 'midfielder', NULL, NULL, 0, FALSE, 'Turkey', 0)",
                    "('tk56', 83, 'Tibet', '1968-05-21', 'midfielder', NULL, NULL, 0, FALSE, 'Turkey', 0)",
                    "('tk57', 84, 'Teoman', '1968-05-21', 'defender', '00:00:00', NULL, 0, FALSE, 'Turkey', 0)",
                    "('yk99', 69, 'Pob', '1968-05-21', 'midfielder', '00:00:00', NULL, 0, FALSE, 'Botswana', 0)"};
            insertSQL = "INSERT INTO Player (pid, shirtNumber, name, DOB, position, timeEntered, timeLeft, yellowCards, redCard, country, matchesPlayed) VALUES ";
            for (String eachPlayerData : playerData) {
                System.out.println ( insertSQL + eachPlayerData + ";") ;
                statement.executeUpdate ( insertSQL + eachPlayerData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Coach data
            String[] coachData = {"('coach1', 'Kyle', '2000-01-01', 'Turkey', 'head')",
                    "('coach2', 'Myle', '2000-02-01', 'Albania', 'head')",
                    "('coach3', 'Xyle', '2000-03-01', 'Canada', 'head')",
                    "('coach4', 'Ryle', '2000-04-01', 'Croatia', 'head')",
                    "('coach5', 'Tyle', '2000-05-01', 'Madagascar', 'head')",
                    "('coach6', 'Qyle', '2000-06-01', 'Zimbabwe', 'head')",
                    "('coach7', 'Wyle', '2000-07-01', 'Congo', 'head')",
                    "('coach8', 'Zyle', '2000-08-01', 'Botswana', 'head')",
                    "('coach9', 'Dyle', '2000-09-01', 'France', 'head')",
                    "('coach10', 'Fyle', '2000-10-01', 'Germany', 'head')",
                    "('coach11', 'Pyle', '2000-11-01', 'Argentina', 'head')",
                    "('coach12', 'Syle', '2000-11-01', 'Nepal', 'head')",
                    "('coach13', 'Cyle', '2000-02-01', 'Peru', 'head')",
                    "('coach14', 'Vyle', '2000-03-01', 'Mexico', 'head')",
                    "('coach15', 'Byle', '2000-04-01', 'Iceland', 'head')",
                    "('coach16', 'Nyle', '2000-05-01', 'Cameroon', 'head')",
                    "('coach17', 'Roger', '2000-09-01', 'France', 'assistant')",
                    "('coach18', 'Poger', '2000-10-01', 'Germany', 'assistant')",
                    "('coach19', 'Toger', '2000-11-01', 'Argentina', 'assistant')",
                    "('coach20', 'Moger', '2000-11-01', 'Nepal', 'assistant')",
                    "('coach21', 'Woger', '2000-02-01', 'Peru', 'assistant')",
                    "('coach22', 'Goger', '2000-03-01', 'Mexico', 'assistant')"};
            insertSQL = "INSERT INTO Coach (cid, name, DOB, country, role) VALUES ";
            for (String eachCoachData : coachData) {
                System.out.println ( insertSQL + eachCoachData + ";") ;
                statement.executeUpdate ( insertSQL + eachCoachData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Referee data
            String[] refereeData = {"('r169', 'Daniel', 2, 'China')",
                    "('r756', 'Raniel', 3, 'Cameroon')",
                    "('r378', 'Maniel', 5, 'Mali')",
                    "('r752', 'Yaniel', 5, 'Russia')",
                    "('r951', 'Qaniel', 452, 'Japan')",
                    "('r185', 'Paniel', 75, 'China')",
                    "('r275', 'Saniel', 0, 'Japan')"};
            insertSQL = "INSERT INTO Referee (rid, rname, YOE, country) VALUES ";
            for (String eachRefereeData : refereeData) {
                System.out.println ( insertSQL + eachRefereeData + ";") ;
                statement.executeUpdate ( insertSQL + eachRefereeData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Stadium data
            String[] stadiumData = {"('Vodafone Park', 'Istanbul', 60000)",
                    "('Allianz Arena', 'Munich', 60000)",
                    "('Bernabeu', 'Madrid', 60000)",
                    "('Camp Nou', 'Barcelona', 60000)",
                    "('Emirates Stadium', 'London', 60000)",
                    "('Parc Des Princes', 'Paris', 60000)"};
            insertSQL = "INSERT INTO Stadium (sname, location, capacity) VALUES ";
            for (String eachStadiumData : stadiumData) {
                System.out.println ( insertSQL + eachStadiumData + ";") ;
                statement.executeUpdate ( insertSQL + eachStadiumData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Match data
            String[] matchData = {"('match1', '2023-03-13', '20:00:00', 'group', 90, 'Vodafone Park', 'Turkey', 'Canada', 'r169')",
                    "('match2', '2023-03-14', '20:00:00', 'group', 90, 'Vodafone Park', 'Turkey', 'Botswana', 'r756')",
                    "('match3', '2023-03-15', '20:00:00', 'group', 90, 'Camp Nou', 'Turkey', 'Cameroon', 'r378')",
                    "('match4', '2023-03-13', '20:00:00', 'group', 90, 'Vodafone Park', 'Nepal', 'Canada', 'r752')",
                    "('match5', '2023-03-14', '20:00:00', 'group', 90, 'Bernabeu', 'Argentina', 'Canada', 'r951')",
                    "('match6', '2023-03-15', '20:00:00', 'group', 90, 'Emirates Stadium', 'Germany', 'Canada', 'r185')",
                    "('match7', '2023-03-14', '20:00:00', 'group', 90, 'Bernabeu', 'Madagascar', 'France', 'r275')",
                    "('match8', '2023-03-14', '20:00:00', 'group', 90, 'Allianz Arena', 'Zimbabwe', 'Iceland', 'r752')",
                    "('match9', '2023-03-14', '20:00:00', 'group', 90, 'Vodafone Park', 'Mexico', 'Peru', 'r951')",
                    "('match10', '2023-03-16', '20:00:00', 'group', 90, 'Parc Des Princes', 'Argentina', 'Congo', 'r756')",
                    "('match11', '2023-03-17', '20:00:00', 'quarter', 90, 'Allianz Arena', 'Turkey', 'Canada', 'r378')",
                    "('match12', '2023-03-17', '20:00:00', 'quarter', 92, 'Emirates Stadium', NULL, 'Canada', 'r752')",
                    "('match13', '2023-03-18', '20:00:00', 'quarter', 90, 'Allianz Arena', 'Nepal', 'Argentina', 'r185')",
                    "('match14', '2023-03-18', '20:00:00', 'quarter', 91, 'Emirates Stadium', NULL, 'France', 'r951')",
                    "('match15', '2023-03-19', '20:00:00', 'semi', 98, 'Allianz Arena', 'Turkey', null, 'r185')",
                    "('match16', '2023-03-19', '20:00:00', 'semi', 92, 'Parc Des Princes', 'Nepal', null, 'r951')",
                    "('match17', '2023-03-20', '20:00:00', 'final', 93, 'Allianz Arena', null, null, 'r951')"};
            insertSQL = "INSERT INTO Match (matchID, mdate, mtime, round, length, sname, team1, team2, rid) VALUES ";
            for (String eachMatchData : matchData) {
                System.out.println ( insertSQL + eachMatchData + ";") ;
                statement.executeUpdate ( insertSQL + eachMatchData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Goals data
            String[] goalsData = { "('tk51', 'match1', 1, '21:34:23')",
                    "('yk99', 'match2', 1, '20:31:14')",
                    "('tk51', 'match3', 1, '21:54:13')",
                    "('tk51', 'match3', 2, '21:54:13')",
                    "('fk15', 'match4', 1, '20:24:22')",
                    "('fk15', 'match4', 2, '20:24:22')",
                    "('tk12', 'match5', 1, '21:34:41')",
                    "('lk23', 'match6', 1, '20:54:53')",
                    "('lk23', 'match6', 2, '20:54:53')",
                    "('sk32', 'match7', 1, '21:36:35')",
                    "('tk19', 'match8', 1, '20:14:43')",
                    "('tk84', 'match9', 1, '21:21:26')",
                    "('tk84', 'match9', 2, '21:21:26')",
                    "('ak45', 'match10', 1, '20:21:43')",
                    "('tk84', 'match10', 2, '21:21:26')",
                    "('tk51', 'match11', 1, '20:21:43')",
                    "('sk36', 'match12', 1, '20:21:43')",
                    "('fk15', 'match13', 1, '20:21:43')",
                    "('sk32', 'match14', 1, '20:21:43')",
                    "('tk51', 'match15', 1, '20:21:43')"};
            insertSQL = "INSERT INTO Goals (pid, matchID, goalNo, timeOccured) VALUES ";
            for (String eachGoalsData : goalsData) {
                System.out.println ( insertSQL + eachGoalsData + ";") ;
                statement.executeUpdate ( insertSQL + eachGoalsData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Purchase data
            String[] purchaseData = {"('p684657564', 6742.43, 'match1')",
                    "('p7686876141', 7866.67, 'match1')",
                    "('p62786276', 7561.64, 'match1')",
                    "('p268176278', 5762.47, 'match6')",
                    "('p66846247', 7565.45, 'match6')",
                    "('p268762814', 6756.46, 'match8')",
                    "('p626786448', 7355.76, 'match8')",
                    "('p26874426', 68763.13, 'match7')",
                    "('p82684287', 67868.76, 'match4')",
                    "('p26876118', 10548.44, 'match2')",
                    "('p77349387', 1059.95, 'match3')",
                    "('p41999142', 13599.08, 'match5')",
                    "('p59237188', 28361.48, 'match17')",
                    "('p78814014', 1159.68, 'match9')",
                    "('p48686863', 8600.15, 'match10')",
                    "('p32064244', 15003.07, 'match11')",
                    "('p36959997', 3905.49, 'match12')",
                    "('p30068366', 15095.96, 'match13')",
                    "('p46853899', 22331.66, 'match14')",
                    "('p50412841', 5935.60, 'match15')",
                    "('p5255519', 11102.59, 'match16')",
                    "('p40151663', 13080.30, 'match13')",
                    "('p67104159', 25313.74, 'match10')",
                    "('p53688081', 13618.36, 'match4')"};
            insertSQL = "INSERT INTO Purchase (pid, totalPrice, matchID) VALUES ";
            for (String eachPurchaseData : purchaseData) {
                System.out.println ( insertSQL + eachPurchaseData + ";") ;
                statement.executeUpdate ( insertSQL + eachPurchaseData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }

            // Loading Seat data
            String[] seatData = {"('Parc Des Princes', 6548, 5498.45)",
                    "('Parc Des Princes', 6125, 6845.98)",
                    "('Bernabeu', 1852, 123.1)",
                    "('Bernabeu', 8537, 687.45)",
                    "('Camp Nou', 8969, 213.66)",
                    "('Camp Nou', 1853, 7895.44)",
                    "('Camp Nou', 9635, 3242.77)",
                    "('Emirates Stadium', 7566, 9874.12)",
                    "('Emirates Stadium', 1235, 654.13)",
                    "('Parc Des Princes', 7663, 987.14)",
                    "('Parc Des Princes', 7566, 456.47)",
                    "('Parc Des Princes', 6754, 1235.15)",
                    "('Parc Des Princes', 5696, 7452.2)",
                    "('Parc Des Princes', 1745, 654.7)"};
            insertSQL = "INSERT INTO Seat (sname, seatID, price) VALUES ";
            for (String eachSeatData : seatData) {
                System.out.println ( insertSQL + eachSeatData + ";") ;
                statement.executeUpdate ( insertSQL + eachSeatData + ";" ) ;
                System.out.println ( "DONE" ) ;
            }
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }

    public static void dropTables(Statement statement, int sqlCode, String sqlState){
        try
        {
            String[] tblName = {"Team", "Player", "Coach", "Referee", "Stadium", "Match", "Goals", "Purchase", "Seat"};
            for (String tbl : tblName) {
                statement.executeUpdate("DROP TABLE " + tbl);
                System.out.println ("DROP TABLE " + tbl) ;
                System.out.println ("DONE");
            }
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }
    public static void option1(Statement statement, int sqlCode, String sqlState){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the country name: ");
        String countryName = scanner.next();
        try
        {
            String querySQL = "SELECT Match.team1, Match.team2, Match.mdate, Match.round, SUM(CASE WHEN Match.team1 = '" + countryName +"' THEN Goals.goalNo ELSE 0 END) AS team1Goals, SUM(CASE WHEN Match.team2 = '" + countryName + "' THEN Goals.goalNo ELSE 0 END) AS team2Goals, COUNT(Purchase.pid) AS seatsSold FROM Match LEFT JOIN Goals ON Match.matchID = Goals.matchID LEFT JOIN Purchase ON Match.matchID = Purchase.matchID WHERE Match.team1 = '" + countryName + "' OR Match.team2 = '" + countryName + "' GROUP BY Match.matchID, Match.team1, Match.team2, Match.mdate, Match.round;";
            System.out.println (querySQL);
            java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
            while ( rs.next ( ) )
            {
                String team1 = rs.getString(1);
                String team2 = rs.getString(2);
                String date = rs.getString(3);
                String round = rs.getString(4);
                String col5 = rs.getString(5);
                String col6 = rs.getString(6);
                String col7 = rs.getString(7);
                System.out.println(team1 + " " + team2 + " " + date + " " + round + " " + col5 + " " + col6 + " " + col7);
            }
            System.out.println ("DONE");
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }
    public static void option2(Statement statement, int sqlCode, String sqlState){
        Scanner scanner = new Scanner(System.in);
        try
        {
            String querySQL = "SELECT matchID, team1, team2, mdate, round FROM Match WHERE EXTRACT(DAY FROM mdate - CURRENT_DATE) BETWEEN 0 AND 3 AND team1 IS NOT NULL AND team2 IS NOT NULL ORDER BY mdate ASC;";
            System.out.println (querySQL);
            java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
            while ( rs.next ( ) )
            {
                String col1 = rs.getString(1);
                String col2 = rs.getString(2);
                String col3 = rs.getString(3);
                String col4 = rs.getString(4);
                String col5 = rs.getString(5);
                System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
            }
            System.out.print("Input the match identifier and for which country the insert should be made, or [P] to go to the previous menu: ");
            String input = scanner.nextLine();
            if (input.equals("P") || input.equals("p")) {
                return;
            } else if (!input.equals("P") || !input.equals("p")) {
                String country = input.split(" ")[1];
                String matchID = input.split(" ")[0];
                System.out.print("The following players from " + country + " are already entered for " + matchID + ": ");
                String querySQL2 = "SELECT Player.name, Player.pid, Player.position, Player.timeEntered, Player.timeLeft, Player.yellowCards, Player.redCard FROM Player WHERE Player.country = '" + country + "' AND Player.timeEntered = '00:00:00';";
                java.sql.ResultSet rs2 = statement.executeQuery ( querySQL2 ) ;
                while ( rs2.next ( ) )
                {
                    String col1 = rs2.getString(1);
                    String col2 = rs2.getString(2);
                    String col3 = rs2.getString(3);
                    String col4 = rs2.getString(4);
                    String col5 = rs2.getString(5);
                    String col6 = rs2.getString(6);
                    String col7 = rs2.getString(7);
                    System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5 + " " + col6 + " " + col7);
                }
                System.out.println ("Possible players not yet selected:");
                String querySQL3 = "SELECT Player.name, Player.pid, Player.position FROM Player WHERE Player.country = '" + country + "' AND Player.timeEntered IS NULL;";
                java.sql.ResultSet rs3 = statement.executeQuery ( querySQL3 ) ;
                while ( rs3.next ( ) )
                {
                    String col1 = rs3.getString(1);
                    String col2 = rs3.getString(2);

                    String col3 = rs3.getString(3);
                    System.out.println(col1 + " " + col2 + " " + col3);
                }
                System.out.print("Enter the number of the player you want to insert or [P] to go to the previous menu: ");
                String playerNo = scanner.next();
                if (playerNo.equals("P") || playerNo.equals("p")) {
                    return;
                }
                while (!playerNo.equals("P") || !playerNo.equals("p")) {
                    String updateQuery = "UPDATE Player SET timeEntered = '00:00:00' WHERE pid = '" + playerNo + "' AND timeEntered IS NULL;";
                    statement.executeUpdate(updateQuery);
                    System.out.print("The following players from " + country + " are already entered for " + matchID + ": ");
                    querySQL2 = "SELECT Player.name, Player.pid, Player.position, Player.timeEntered, Player.timeLeft, Player.yellowCards, Player.redCard FROM Player WHERE Player.country = '" + country + "' AND Player.timeEntered = '00:00:00';";
                    rs2 = statement.executeQuery ( querySQL2 ) ;
                    while ( rs2.next ( ) )
                    {
                        String col1 = rs2.getString(1);
                        String col2 = rs2.getString(2);
                        String col3 = rs2.getString(3);
                        String col4 = rs2.getString(4);
                        String col5 = rs2.getString(5);
                        String col6 = rs2.getString(6);
                        String col7 = rs2.getString(7);
                        System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5 + " " + col6 + " " + col7);
                    }
                    System.out.println ("Possible players not yet selected:");
                    querySQL3 = "SELECT Player.name, Player.pid, Player.position FROM Player WHERE Player.country = '" + country + "' AND Player.timeEntered IS NULL;";
                    rs3 = statement.executeQuery ( querySQL3 ) ;
                    while ( rs3.next ( ) )
                    {
                        String col1 = rs3.getString(1);
                        String col2 = rs3.getString(2);

                        String col3 = rs3.getString(3);
                        System.out.println(col1 + " " + col2 + " " + col3);
                    }
                    System.out.print("Enter the number of the player you want to insert or [P] to go to the previous menu: ");
                    playerNo = scanner.next();
                    if (playerNo.equals("P") || playerNo.equals("p")) {
                        return;
                    }
                }
            }
            System.out.println ("DONE");
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
    }

    public static void option3(Statement statement, int sqlCode, String sqlState){
        Scanner scanner = new Scanner(System.in);
        try {
            String querySQL = "SELECT matchID,  team1, team2, mdate, round FROM Match WHERE team1 IS NULL OR team2 IS NULL ORDER BY mdate ASC;";
            java.sql.ResultSet rs = statement.executeQuery(querySQL);
            while (rs.next()) {
                String col1 = rs.getString(1);
                String col2 = rs.getString(2);
                String col3 = rs.getString(3);
                String col4 = rs.getString(4);
                String col5 = rs.getString(5);
                System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
            }
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
        System.out.print("Enter the match ID of the match that you would like to update: ");
        String id = scanner.next();
        System.out.print("Is it team 1 or team 2 that you would like to update: ");
        String teamNo = scanner.next();
        System.out.print("Enter the country name: ");
        String countryName = scanner.next();
        try {
            String updateQuery = "UPDATE Match SET " + teamNo +  "= '" + countryName + "' WHERE matchID =  '" + id + "';";
            statement.executeUpdate(updateQuery);
            String querySQL = "SELECT matchID,  team1, team2, mdate, round FROM Match WHERE team1 IS NULL OR team2 IS NULL ORDER BY mdate ASC;";
            java.sql.ResultSet rs = statement.executeQuery(querySQL);
            while (rs.next()) {
                String col1 = rs.getString(1);
                String col2 = rs.getString(2);
                String col3 = rs.getString(3);
                String col4 = rs.getString(4);
                String col5 = rs.getString(5);
                System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
            }
            System.out.print("Enter [A] to update another match, [P] to go to the previous menu: ");
            String option = scanner.next();

            while (!option.equals("P") || !option.equals("p") ) {
                try {
                    querySQL = "SELECT matchID,  team1, team2, mdate, round FROM Match WHERE team1 IS NULL OR team2 IS NULL ORDER BY mdate ASC;";
                    rs = statement.executeQuery(querySQL);
                    while (rs.next()) {
                        String col1 = rs.getString(1);
                        String col2 = rs.getString(2);
                        String col3 = rs.getString(3);
                        String col4 = rs.getString(4);
                        String col5 = rs.getString(5);
                        System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
                    }
                }
                catch (SQLException e)
                {
                    sqlCode = e.getErrorCode(); // Get SQLCODE
                    sqlState = e.getSQLState(); // Get SQLSTATE

                    // Your code to handle errors comes here;
                    // something more meaningful than a print would be good
                    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                    System.out.println(e);
                }
                System.out.print("Enter the match ID of the match that you would like to update: ");
                id = scanner.next();
                System.out.print("Is it team 1 or team 2 that you would like to update: ");
                teamNo = scanner.next();
                System.out.print("Enter the country name: ");
                countryName = scanner.next();
                try {
                    updateQuery = "UPDATE Match SET " + teamNo + " = '" + countryName + "' WHERE matchID = '" + id + "';";
                    statement.executeUpdate(updateQuery);
                    querySQL = "SELECT matchID,  team1, team2, mdate, round FROM Match WHERE team1 IS NULL OR team2 IS NULL ORDER BY mdate ASC;";
                    rs = statement.executeQuery(querySQL);
                    while (rs.next()) {
                        String col1 = rs.getString(1);
                        String col2 = rs.getString(2);
                        String col3 = rs.getString(3);
                        String col4 = rs.getString(4);
                        String col5 = rs.getString(5);
                        System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
                    }
                }
                catch (SQLException e)
                {
                    sqlCode = e.getErrorCode(); // Get SQLCODE
                    sqlState = e.getSQLState(); // Get SQLSTATE

                    // Your code to handle errors comes here;
                    // something more meaningful than a print would be good
                    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                    System.out.println(e);
                }
                System.out.print("Enter [A] to update another match, [P] to go to the previous menu: ");
                option = scanner.next();
            }
        }
        catch (SQLException e)
        {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }

    }
    public static void mainMenu() {
        System.out.println("Soccer Main Menu");
        System.out.println("1. List information of matches of a country");
        System.out.println("2. Insert initial player information for a match");
        System.out.println("3. Update match");
        System.out.println("4. Exit application");
        System.out.print("\nPlease Enter Your Option: ");
    }
    public static void main ( String [ ] args ) throws SQLException
    {
        // Unique table names.  Either the user supplies a unique identifier as a command line argument, or the program makes one up.
        String tableName = "";
        int sqlCode=0;      // Variable to hold SQLCODE
        String sqlState="00000";  // Variable to hold SQLSTATE

        if ( args.length > 0 )
            tableName += args [ 0 ] ;
        else
            tableName += "Team";

        // Register the driver.  You must register the driver before you can use it.
        try { DriverManager.registerDriver ( new com.ibm.db2.jcc.DB2Driver() ) ; }
        catch (Exception cnfe){ System.out.println("Class not found"); }

        // This is the url you must use for DB2.
        //Note: This url may not valid now ! Check for the correct year and semester and server name.
        String url = "jdbc:db2://winter2023-comp421.cs.mcgill.ca:50000/cs421";

        //REMEMBER to remove your user id and password before submitting your code!!
        String your_userid = "cs421g31";
        String your_password = "Kutay&Minh31";
        //AS AN ALTERNATIVE, you can just set your password in the shell environment in the Unix (as shown below) and read it from there.
        //$  export SOCSPASSWD=yoursocspasswd
        if(your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        if(your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        Connection con = DriverManager.getConnection (url,your_userid,your_password) ;
        Statement statement = con.createStatement ( ) ;

        dropTables(statement,sqlCode, sqlState);
        //Creating tables
        createTables(statement, sqlCode, sqlState);
        // Inserting data
        insertData(statement, sqlCode, sqlState);
        // Drop tables


        Scanner scanner = new Scanner(System.in);
        mainMenu();
        int option = scanner.nextInt();
        while (option != 4) {
            if (option == 1) {
                option1(statement, sqlCode, sqlState);
                System.out.print("Enter [A] to find matches of another country, [P] to go to the previous menu: ");
                String input = scanner.next();
                while (input.equals("A") || input.equals("a")) {
                    option1(statement, sqlCode, sqlState);
                    System.out.print("Enter [A] to find matches of another country, [P] to go to the previous menu: ");
                    input = scanner.next();
                }
            } else if (option == 2) {
                option2(statement, sqlCode, sqlState);
            } else if (option == 3) {
                option3(statement, sqlCode, sqlState);
            }

            mainMenu();
            option = scanner.nextInt();

        }
        scanner.close();
        // Finally but importantly close the statement and connection
        statement.close ( ) ;
        con.close ( ) ;
    }
}
