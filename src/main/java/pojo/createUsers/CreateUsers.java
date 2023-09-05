package pojo.createUsers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CreateUsers {

    @JsonPropertyOrder({"name", "job"})

    private String name;
    private String job;

    public CreateUsers() {
    }


    public CreateUsers(String name, String job) throws JsonProcessingException {
        this.name = name;
        this.job = job;

    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }


}
