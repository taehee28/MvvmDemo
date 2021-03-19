/*
 * Created by taehee28 on 2021. 3. 19
 * Last modified 21. 3. 19 오후 3:20
 * https://github.com/taehee28
 */

package com.thk.mvvmdemo;

public class User {

    public User(String userId, String userName, String userNum) {
        this.userId = userId;
        this.userName = userName;
        this.userNum = userNum;
    }

    private String userId;
    private String userName;
    private String userNum;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userNum='" + userNum + '\'' +
                '}';
    }
}
