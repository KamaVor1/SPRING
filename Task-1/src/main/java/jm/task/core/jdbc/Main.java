package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Дмитрий","Кочергин",(byte) 30);
        userDaoHibernate.saveUser("Савин","Семен",(byte) 19);
        userDaoHibernate.saveUser("Лев","Красавчик",(byte) 23);
        userDaoHibernate.removeUserById(1);
    }
}
