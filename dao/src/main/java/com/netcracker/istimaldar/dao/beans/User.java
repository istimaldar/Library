package com.netcracker.istimaldar.dao.beans;

import java.io.Serializable;

/**
 * Created by istimaldar
 */
public class User implements Cloneable, Serializable {
    private int id;
    private String login;
    private String hpassword;
    private String email;

    private User() {

    }


    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getHpassword() {
        return hpassword;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id && login.equals(user.login) && hpassword.equals(user.hpassword) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + hpassword.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", hpassword='" + hpassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static UserBuilder newBuilder() {
        return new User().new UserBuilder();
    }

    public class UserBuilder {
        private UserBuilder() {

        }

        public UserBuilder setId(int id) {
            User.this.id = id;
            return this;
        }

        public UserBuilder setLogin(String login) {
            User.this.login = login;
            return this;
        }

        public UserBuilder setHpassword(String hpassword) {
            User.this.hpassword = hpassword;
            return this;
        }

        public UserBuilder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
