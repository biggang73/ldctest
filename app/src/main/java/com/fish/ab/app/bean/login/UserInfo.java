package com.fish.ab.app.bean.login;


public class UserInfo {

    // {"userId":1,"projectId":1,"roleId":1,"roleType":"SystemAdmin","roleName":"系统管理员","code":1}

    private String userID;
    private String projectId;
    private String roleId;
    private String roleType;
    private String roleName;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
