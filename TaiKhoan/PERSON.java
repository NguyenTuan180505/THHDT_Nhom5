package TaiKhoan;
import Enum.VAITRO;
import java.io.Serializable;

public class PERSON implements Serializable {
    protected String id;
    protected String name;
    protected String password;
    protected String SDT;
    protected String email;
    protected String address;
    protected VAITRO role;

    public PERSON() {
        this.role = VAITRO.KHACHHANG;
    }

    public VAITRO getRole() {
        return role;
    }

    public void setRole(VAITRO role) {
        this.role = role;
    }

    public PERSON(String id, String name, String email, String SDT, String address,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.SDT = SDT;
        this.address = address;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TaiKhoan.PERSON{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", SDT='" + SDT + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
