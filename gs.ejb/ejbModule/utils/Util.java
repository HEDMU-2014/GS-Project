package utils;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import domain.Role;
import entities.Roles;

public class Util {
	
	public static void main(String[] args) throws Throwable {
		Util util = new Util();
		Role role = new Role();
		role.setRoleId(2);
		role.setRole("test");
		Roles roles = new Roles();
		System.out.println(util.map(role, roles));
//		System.out.println("Hash xxx = " + util.hash("xxx"));
//		System.out.println("Hash 1234567890 = " + util.hash("1234567890"));

	}


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
						mt.invoke(to, mf.invoke(from));
					}
				}
			}
		}
		return to;
	}

	public String hash(String txt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] mdbytes = md.digest(txt.getBytes());
		return Base64.getEncoder().encodeToString(mdbytes);
	}
}
