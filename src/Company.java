public class Company {
    private int id;
    private String nameCompany;
    private String province;
    private String tel;
    private String email;
    

    public Company(int id, String nameCompany, String province, String tel, String email) {
        this.id = id;
        this.nameCompany = nameCompany;
        this.province = province;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getProvince() {
        return province;
    }
   

    public void setId(int id) {
        this.id = id;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", nameCompany=" + nameCompany + ", province=" + province + ", tel=" + tel
                + ", email=" + email + "]";
    }
  
}

