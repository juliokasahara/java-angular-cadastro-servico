package br.com.app.enumeration;

public enum RolesEnum {

    USER("USER"),MOD("MOD");

    private String userType;

    RolesEnum(String user) {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static RolesEnum createEnum(String userType){
        for (RolesEnum rolesEnum: values()) {
            if(rolesEnum.getUserType().equals(userType)){
                return rolesEnum;
            }
        }
        return null;
    }
}
