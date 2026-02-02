public class RoleBasedAccessControl {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        System.out.println("---- USER ROLE ----");
        SecurityManager.execute(adminService, "USER");
        System.out.println("\n---- ADMIN ROLE ----");
        SecurityManager.execute(adminService, "ADMIN");
    }
}