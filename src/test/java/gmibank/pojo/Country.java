package gmibank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private int id;
    private String name;
    private String state;

//    public Country(String id, String name, String state) {
//        this.id = id;
//        this.name = name;
//        this.state = state;


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}




