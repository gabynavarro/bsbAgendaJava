public class Person {
        private int id;
        private String name;
        private String lastname;
        private String province;
        private String email;
        private String cell;

    public Person(int id, String name, String lastname, String province, String email, String cell) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.province = province;
        this.email = email;
        this.cell = cell;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", province='" + province + '\'' +
                ", email='" + email + '\'' +
                ", cell='" + cell + '\'' +
                '}';
    }
}
