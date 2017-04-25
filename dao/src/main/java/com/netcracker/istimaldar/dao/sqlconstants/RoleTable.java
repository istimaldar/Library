package com.netcracker.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public final class RoleTable {
    private RoleTable() {

    }

    public static final String ID = "id";
    public static final String ROLE = "role";

    public static final String CREATE = "INSERT INTO library.role (role) VALUES (?);";
    public static final String READ = "SELECT * FROM library.role WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.role SET id = ?, role = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.role WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.role;";
}
