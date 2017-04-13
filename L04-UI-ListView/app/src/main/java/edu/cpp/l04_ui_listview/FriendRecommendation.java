package edu.cpp.l04_ui_listview;

/**
 * Created by yusun on 4/12/17.
 */

public class FriendRecommendation {

    private String name;
    private int numMutualFriends;
    private int profileIconImageRes;

    public FriendRecommendation() {

    }

    public FriendRecommendation(String name, int numMutualFriends, int profileIconImageRes) {
        this.name = name;
        this.numMutualFriends = numMutualFriends;
        this.profileIconImageRes = profileIconImageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumMutualFriends() {
        return numMutualFriends;
    }

    public void setNumMutualFriends(int numMutualFriends) {
        this.numMutualFriends = numMutualFriends;
    }

    public int getProfileIconImageRes() {
        return profileIconImageRes;
    }

    public void setProfileIconImageRes(int profileIconImageRes) {
        this.profileIconImageRes = profileIconImageRes;
    }
}
