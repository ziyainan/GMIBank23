package gmibank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class pojos {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        private int id;
        private String login;
        private String fistName;
        private String lastName;
        private String email;
        private boolean activated;
        private String langKey;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getFistName() {
            return fistName;
        }

        public void setFistName(String fistName) {
            this.fistName = fistName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isActivated() {
            return activated;
        }

        public void setActivated(boolean activated) {
            this.activated = activated;
        }

        public String getLangKey() {
            return langKey;
        }

        public void setLangKey(String langKey) {
            this.langKey = langKey;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getResetDate() {
            return resetDate;
        }

        public void setResetDate(String resetDate) {
            this.resetDate = resetDate;
        }

        private String resetDate;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Customer {
        private int id;
        private String ssn;
        private String firstName;
        private String lastName;
        private String middleInitial;
        private String address;
        private String mobilePhoneNumber;
        private String phoneNumber;
        private String zipCode;
        private String city;
        private String email;
        private String createDate;
        private boolean zelleEnrolled;
        private Country country;
        private String state;
        private User user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleInitial() {
            return middleInitial;
        }

        public void setMiddleInitial(String middleInitial) {
            this.middleInitial = middleInitial;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobilePhoneNumber() {
            return mobilePhoneNumber;
        }

        public void setMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public boolean isZelleEnrolled() {
            return zelleEnrolled;
        }

        public void setZelleEnrolled(boolean zelleEnrolled) {
            this.zelleEnrolled = zelleEnrolled;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Accounts getAccount() {
            return account;
        }

        public void setAccount(Accounts account) {
            this.account = account;
        }

        private Accounts account;






    }

     @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Country {
        private int id;
        private String state;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

     @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Accounts {
        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        private String account;
    }
}
