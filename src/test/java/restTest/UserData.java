package restTest;

public class UserData {
    private String name;
    private String job;
    private int id;

    public UserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UserData setName(String name) {
        this.name = name;
        return this;
    }

    public UserData setJob(String job) {
        this.job = job;
        return this;
    }

    public UserData setId(int id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getId() {
        return id;
    }


}
