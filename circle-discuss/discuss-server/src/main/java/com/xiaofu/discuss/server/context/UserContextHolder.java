package com.xiaofu.discuss.server.context;

import lombok.Data;

import java.util.Optional;

/**
 * @author xiaofu
 * @date 2024/3/18 20:35
 * @des 用户基本信息
 */


public class UserContextHolder {
    private static ThreadLocal<UserObject> local = new ThreadLocal<>();

    @Data
    static class UserObject{
        private Long id;

        private String userName;

        private String nickName;

        private String email;

        private String phone;

        private String password;

        private Integer sex;

        private String avatar;

        private Integer status;

        private String introduce;

        private String extJson;

    }
    private static UserObject userObject() {
        UserObject object;
        if (local.get() != null) {
            object = local.get();
        } else {
            object = new UserObject();
            local.set(object);
        }
        return object;
    }

    public static void id(Long id) {
        userObject().setId(id);
    }

    public static void userName(String userName) {
        userObject().setUserName(userName);
    }

    public static void nickName(String nickName) {
        userObject().setNickName(nickName);
    }

    public static void email(String email) {
        userObject().setEmail(email);
    }

    public static void phone(String phone) {
        userObject().setPhone(phone);
    }

    public static void sex(Integer sex) {
        userObject().setSex(sex);
    }

    public static void avatar(String avatar) {
        userObject().setAvatar(avatar);
    }

    public static void status(Integer status)  {
        userObject().setStatus(status);
    }

    public static void introduce(String introduce)  {
        userObject().setIntroduce(introduce);
    }

    public static void extJson(String extJson)  {
        userObject().setExtJson(extJson);
    }


    public static Long id() {
        return Optional.ofNullable(local.get()).map(UserObject::getId).orElse(0L);
    }
    public static String userName() {
        return Optional.ofNullable(local.get()).map(UserObject::getUserName).orElse("");
    }

    public static String nickName() {
        return Optional.ofNullable(local.get()).map(UserObject::getNickName).orElse("");
    }

    public static String email() {
        return Optional.ofNullable(local.get()).map(UserObject::getEmail).orElse("");
    }

    public static String phone() {
        return Optional.ofNullable(local.get()).map(UserObject::getPhone).orElse("");
    }

    public static Integer sex() {
        return Optional.ofNullable(local.get()).map(UserObject::getSex).orElse(0);
    }

    public static String avatar() {
        return Optional.ofNullable(local.get()).map(UserObject::getAvatar).orElse("");
    }

    public static Integer status()  {
        return Optional.ofNullable(local.get()).map(UserObject::getStatus).orElse(0);
    }

    public static String introduce()  {
        return Optional.ofNullable(local.get()).map(UserObject::getIntroduce).orElse("");
    }


    public static String extJson() {
        return Optional.ofNullable(local.get()).map(UserObject::getExtJson).orElse("");
    }

    public static void remove(){
        local.remove();
    }

}
