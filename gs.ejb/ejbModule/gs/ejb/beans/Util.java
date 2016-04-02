package gs.ejb.beans;

import java.lang.reflect.Method;

import gs.ejb.domain.Role;
import gs.ejb.entities.Roles;

public class Util {

    public Object map(Object from, Object to) throws Throwable {
        Class<?> cfrom = from.getClass();
        Method[] mfrom = cfrom.getMethods();
        Class<?> cto = to.getClass();
        Method[] mto = cto.getMethods();
        for (Method mf : mfrom) {
            if (mf.getName().startsWith("get")) {
                String mtoname = "set" + mf.getName().substring(3);
                for (Method mt : mto) {
                    if (mt.getName().equalsIgnoreCase(mtoname)) {
                        mt.invoke(to, mf.invoke(from, null));
                    }
                }
            }
        }
        return to;
    }

    public static void main(String[] args) throws Throwable {
        Util util = new Util();
        Role role = new Role(2, "test");
        Roles roles = new Roles();
        System.out.println(util.map(role, roles));

    }

}