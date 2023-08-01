package edu.utsa.travelplanner.data;

import android.os.Parcel;
import android.os.Parcelable;

public class User_Model implements Parcelable {
        private int id;
        private String email;
        private String password;

        // NOT IN THE UML Diagram
        private String securityCode;


        public User_Model(int id, String email, String password, String securityCode) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.securityCode = securityCode;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(id);
            parcel.writeString(email);
            parcel.writeString(password);
            parcel.writeString(securityCode);
        }

        public static final Parcelable.Creator<User_Model> CREATOR = new Parcelable.Creator<User_Model>() {
            @Override
            public User_Model createFromParcel(Parcel parcel) {
                return new User_Model(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override
            public User_Model[] newArray(int size) {
                return new User_Model[size];
            }
        };

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

            public String getSecurityCode() {
                return securityCode;
            }

            public void setSecurityCode(String securityCode) {
                this.securityCode = securityCode;
            }

            @Override
            public String toString() {
                return "User_Model{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", securityCode='" + securityCode + '\'' +
                        '}';
            }
}
