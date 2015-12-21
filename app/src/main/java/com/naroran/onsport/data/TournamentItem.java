package com.naroran.onsport.data;


public class TournamentItem {
    private int number, score, games;
    private String teamName, teamImg;
    private boolean active;

    public TournamentItem() {
    }

    public TournamentItem(int id, String name, String image, String status,
                     String profilePic, String timeStamp, String url) {
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNubmer(int id) {
        this.number = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String name) {
        this.teamName = name;
    }

    public String getTeamImg() {
        return teamImg;
    }

    public void setTeamImg(String name) {
        this.teamImg = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int id) {
        this.score = id;
    }


    public int getGames() {
        return games;
    }

    public void setGames(int id) {
        this.games = id;
    }

}
