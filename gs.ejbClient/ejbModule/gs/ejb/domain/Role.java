package gs.ejb.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private int roleid;
    private String role;

    public Role() {

    }

    public Role(int roleid, String role) {
        this.roleid = roleid;
        this.role = role;
    }

    public int getRoleid() {
        return roleid;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Role [roleid=" + roleid + ", role=" + role + "]";
    }

}
