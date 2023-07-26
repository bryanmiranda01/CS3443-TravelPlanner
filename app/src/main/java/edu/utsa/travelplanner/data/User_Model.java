package edu.utsa.travelplanner.data;

public class User_Model {
        private int id;
        private String email;
        private String password;

        public User_Model(int id, String email, String password) {
            this.id = id;
            this.email = email;
            this.password = password;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User_Model{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
