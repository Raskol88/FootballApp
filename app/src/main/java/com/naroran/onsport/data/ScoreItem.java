package com.naroran.onsport.data;


public class ScoreItem {
    private int id;
    private String time, date, teamOneName, teamTwoName, score, teamOneImg, teamTwoImg;
    private boolean active;

    public ScoreItem() {
    }

    public ScoreItem(int id, String name, String image, String status,
                     String profilePic, String timeStamp, String url) {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String name) {
        this.teamOneName = name;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String name) {
        this.teamTwoName = name;
    }

    public String getTeamOneImg() {
        return teamOneImg;
    }

    public void setTeamOneImg(String name) {
        this.teamOneImg = name;
    }

    public String getTeamTwoImg() {
        return teamTwoImg;
    }

    public void setTeamTwoImg(String name) {
        this.teamTwoImg = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
