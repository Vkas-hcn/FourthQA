package com.quen.ant.superkey.fourthqa.data

import com.google.gson.Gson


object DataUtils {
    fun getQaList(): ArrayList<FootballIssuesBean> {
        return Gson().fromJson(footballIssuesData, FootballIssuesList::class.java)
    }
    const val  footballIssuesData = """
[
    {
        "first": "FIFA",
        "second": "UEFA",
        "third": "CONCACAF",
        "fourth": "AFC",
        "content": "Which organization is responsible for organizing the FIFA World Cup?",
        "result": 1
    },
    {
        "first": "Brazil",
        "second": "Argentina",
        "third": "Germany",
        "fourth": "Italy",
        "content": "Which country has won the most FIFA World Cup titles?",
        "result": 3
    },
    {
        "first": "Real Madrid",
        "second": "Barcelona",
        "third": "Manchester United",
        "fourth": "Bayern Munich",
        "content": "Which club has won the most UEFA Champions League titles?",
        "result": 1
    },
    {
        "first": "Lionel Messi",
        "second": "Cristiano Ronaldo",
        "third": "Neymar",
        "fourth": "Mohamed Salah",
        "content": "Who won the FIFA Ballon d'Or in 2021?",
        "result": 2
    },
    {
        "first": "Pele",
        "second": "Diego Maradona",
        "third": "Cristiano Ronaldo",
        "fourth": "Lionel Messi",
        "content": "Who is widely regarded as the greatest football player of all time?",
        "result": 4
    },
    {
        "first": "Yellow",
        "second": "Red",
        "third": "Blue",
        "fourth": "Green",
        "content": "What color card does a referee show for a caution (booking) in football?",
        "result": 1
    },
    {
        "first": "Anfield",
        "second": "Old Trafford",
        "third": "Camp Nou",
        "fourth": "Santiago Bernabeu",
        "content": "Which stadium is the home of Liverpool FC?",
        "result": 1
    },
    {
        "first": "France",
        "second": "Spain",
        "third": "Portugal",
        "fourth": "Italy",
        "content": "Which country won the UEFA Euro 2020 tournament?",
        "result": 3
    },
    {
        "first": "Zinedine Zidane",
        "second": "Pep Guardiola",
        "third": "Jurgen Klopp",
        "fourth": "Carlo Ancelotti",
        "content": "Who coached Real Madrid to three consecutive UEFA Champions League titles?",
        "result": 1
    },
    {
        "first": "Offside",
        "second": "Handball",
        "third": "Foul",
        "fourth": "Diving",
        "content": "What is the term for an attacking player being nearer to the opponent's goal line than the ball and the second-to-last defender?",
        "result": 1
    },
    {
        "first": "Sergio Ramos",
        "second": "Gerard Piqué",
        "third": "Virgil van Dijk",
        "fourth": "Kalidou Koulibaly",
        "content": "Which defender is known for his leadership and scoring ability, particularly from set-pieces?",
        "result": 1
    },
    {
        "first": "Golden Boot",
        "second": "Golden Ball",
        "third": "Golden Glove",
        "fourth": "Golden Spike",
        "content": "What is the award given to the top goal-scorer of a football league or tournament?",
        "result": 1
    },
    {
        "first": "Goalkeeper",
        "second": "Striker",
        "third": "Midfielder",
        "fourth": "Defender",
        "content": "Which position is typically responsible for taking goal kicks?",
        "result": 4
    },
    {
        "first": "Hattrick",
        "second": "Corner Kick",
        "third": "Own Goal",
        "fourth": "Free Kick",
        "content": "What term is used when a player scores three goals in a single game?",
        "result": 1
    },
    {
        "first": "Wembley Stadium",
        "second": "Emirates Stadium",
        "third": "Stamford Bridge",
        "fourth": "Etihad Stadium",
        "content": "Which stadium is the home of the England national football team?",
        "result": 1
    },
    {
        "first": "VAR",
        "second": "AR",
        "third": "VR",
        "fourth": "PR",
        "content": "What is the abbreviation for Video Assistant Referee, a technology used in football to review decisions made by the on-field officials?",
        "result": 1
    },
    {
        "first": "Copa America",
        "second": "African Cup of Nations",
        "third": "Asian Cup",
        "fourth": "CONCACAF Gold Cup",
        "content": "Which tournament is the oldest international continental football competition?",
        "result": 1
    },
    {
        "first": "Free Kick",
        "second": "Throw-in",
        "third": "Goal Kick",
        "fourth": "Corner Kick",
        "content": "What restart is awarded to the defending team when the attacking team kicks the ball over the defending team's goal line?",
        "result": 3
    },
    {
        "first": "Soccer",
        "second": "Football",
        "third": "Rugby",
        "fourth": "Cricket",
        "content": "What is the common name for the sport known as 'Association Football'?",
        "result": 1
    },
    {
        "first": "Gareth Bale",
        "second": "Harry Kane",
        "third": "David Beckham",
        "fourth": "Steven Gerrard",
        "content": "Who is known for his long-range free-kicks and has played for both Real Madrid and Tottenham Hotspur?",
        "result": 1
    },
    {
        "first": "MLS",
        "second": "EPL",
        "third": "La Liga",
        "fourth": "Bundesliga",
        "content": "In which league does the team LA Galaxy compete?",
        "result": 1
    },
    {
        "first": "Sadio Mane",
        "second": "Kylian Mbappe",
        "third": "Raheem Sterling",
        "fourth": "Jadon Sancho",
        "content": "Who won the Golden Boy Award for the best young player in Europe in 2021?",
        "result": 2
    },
    {
        "first": "Cruyff Turn",
        "second": "Maradona Turn",
        "third": "Roulette",
        "fourth": "Stepover",
        "content": "Which skill move involves a quick 180-degree turn with the ball to evade a defender?",
        "result": 1
    },
    {
        "first": "Johan Cruyff",
        "second": "Pele",
        "third": "George Best",
        "fourth": "Alfredo Di Stefano",
        "content": "Who is credited with popularizing the 'Cruyff Turn' skill move in football?",
        "result": 1
    },
    {
        "first": "Copa Libertadores",
        "second": "AFC Champions League",
        "third": "CAF Champions League",
        "fourth": "Oceania Champions League",
        "content": "Which tournament is the premier club competition in South American football?",
        "result": 1
    },
    {
        "first": "Dribbling",
        "second": "Tackling",
        "third": "Heading",
        "fourth": "Goalkeeping",
        "content": "What skill is Cristiano Ronaldo particularly known for in football?",
        "result": 1
    },
    {
        "first": "Ajax",
        "second": "PSV Eindhoven",
        "third": "Feyenoord",
        "fourth": "AZ Alkmaar",
        "content": "Which Dutch football club is known for its youth development system called 'De Toekomst'?",
        "result": 1
    },
    {
        "first": "Alan Shearer",
        "second": "Thierry Henry",
        "third": "Frank Lampard",
        "fourth": "Wayne Rooney",
        "content": "Who is the all-time top scorer in the history of the Premier League?",
        "result": 1
    },
    {
        "first": "Serie A",
        "second": "Bundesliga",
        "third": "Ligue 1",
        "fourth": "La Liga",
        "content": "In which league do AC Milan and Inter Milan compete?",
        "result": 1
    },
    {
        "first": "Ole Gunnar Solskjaer",
        "second": "Jurgen Klopp",
        "third": "Jose Mourinho",
        "fourth": "Pep Guardiola",
        "content": "Who managed Manchester United during the 1998-1999 season when they won the historic treble?",
        "result": 1
    },
    {
        "first": "Golden Glove",
        "second": "Silver Boot",
        "third": "Bronze Ball",
        "fourth": "Platinum Spike",
        "content": "What is the award given to the best goalkeeper in a football tournament?",
        "result": 1
    },
    {
        "first": "Dennis Bergkamp",
        "second": "Ruud Gullit",
        "third": "Marco van Basten",
        "fourth": "Robin van Persie",
        "content": "Which Dutch forward is known for his goal against Argentina in the 1998 FIFA World Cup with an incredible solo effort?",
        "result": 1
    },
    {
        "first": "Cristiano Ronaldo",
        "second": "Lionel Messi",
        "third": "Neymar",
        "fourth": "Kylian Mbappe",
        "content": "Who won the Golden Shoe award for being the top goalscorer in European domestic leagues in the 2020-2021 season?",
        "result": 2
    },
    {
        "first": "MLS Cup",
        "second": "Supporters' Shield",
        "third": "US Open Cup",
        "fourth": "MLS All-Star Game",
        "content": "Which competition determines the champion of Major League Soccer (MLS) in the United States?",
        "result": 1
    },
    {
        "first": "Roberto Baggio",
        "second": "Gianluigi Buffon",
        "third": "Paolo Maldini",
        "fourth": "Alessandro Del Piero",
        "content": "Who is often referred to as 'Il Capitano' and spent his entire club career at AC Milan as a one-club man?",
        "result": 3
    },
    {
        "first": "Kaka",
        "second": "Ronaldinho",
        "third": "Zlatan Ibrahimovic",
        "fourth": "Luis Suarez",
        "content": "Who won the FIFA World Player of the Year in 2007?",
        "result": 1
    },
    {
        "first": "David De Gea",
        "second": "Ederson",
        "third": "Alisson Becker",
        "fourth": "Thibaut Courtois",
        "content": "Who won the Premier League Golden Glove for the 2020-2021 season?",
        "result": 3
    },
    {
        "first": "Erling Haaland",
        "second": "Jadon Sancho",
        "third": "Phil Foden",
        "fourth": "Bukayo Saka",
        "content": "Which young talent was a key player for Borussia Dortmund before transferring to Manchester City?",
        "result": 2
    },
    {
        "first": "Atletico Madrid",
        "second": "Sevilla",
        "third": "Valencia",
        "fourth": "Real Betis",
        "content": "Which Spanish club won the La Liga title in the 2020-2021 season?",
        "result": 1
    },
    {
        "first": "Cristiano Ronaldo",
        "second": "Lionel Messi",
        "third": "Neymar",
        "fourth": "Kylian Mbappe",
        "content": "Who won the 2021 FIFA Best Men's Player award?",
        "result": 1
    },
    {
        "first": "Zlatan Ibrahimovic",
        "second": "Wayne Rooney",
        "third": "Didier Drogba",
        "fourth": "Thierry Henry",
        "content": "Who scored the first goal in Major League Soccer (MLS) history?",
        "result": 4
    },
    {
        "first": "Iker Casillas",
        "second": "Petr Cech",
        "third": "Manuel Neuer",
        "fourth": "Gianluigi Buffon",
        "content": "Who is widely regarded as one of the greatest goalkeepers of all time and spent the majority of his career at Real Madrid?",
        "result": 1
    },
    {
        "first": "Soccer",
        "second": "Football",
        "third": "Rugby",
        "fourth": "Cricket",
        "content": "What is the sport known as 'Calcio' in Italy?",
        "result": 2
    },
    {
        "first": "8 players",
        "second": "10 players",
        "third": "11 players",
        "fourth": "12 players",
        "content": "How many players are there on a standard soccer team during a match?",
        "result":3
    },
    {
        "first": "60 minutes",
        "second": "75 minutes",
        "third": "90 minutes",
        "fourth": "120 minutes",
        "content": "What is the maximum duration of a regulation soccer match, including injury time?",
        "result":3
    },
    {
        "first": "Kicking",
        "second": "Heading",
        "third": "Elbowing",
        "fourth": "Shouldering",
        "content": "In soccer, what is the term for deliberately using one's head to redirect the ball during play?",
        "result":2
    },
    {
        "first": "UEFA Champions League",
        "second": "Copa America",
        "third": "FIFA World Cup",
        "fourth": "AFC Asian Cup",
        "content": "Which prestigious international soccer tournament is held every four years and contested by national teams from around the world?",
        "result":3
    }
]
    """




}