package pe.account;

public class AccountDTO {
    //your code here
    private int Id;
    private String Email;
    private String FullName;
    private String RoleId;
    private String Password;

    public AccountDTO(int Id, String Email, String FullName, String RoleId, String Password) {
        this.Id = Id;
        this.Email = Email;
        this.FullName = FullName;
        this.RoleId = RoleId;
        this.Password = Password;
    }

    public AccountDTO() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String RoleId) {
        this.RoleId = RoleId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
