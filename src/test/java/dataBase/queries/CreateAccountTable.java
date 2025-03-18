package dataBase.queries;

import ObjectData.CreateAccountObjectData;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountTable extends CommonTable {

    public CreateAccountTable() throws SQLException {
    }
    public synchronized void insertTableObject(CreateAccountObjectData data) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "INSERT INTO SignUp_users(password, day, month, year, firstName, lastName, company, address1, address2, state, city, zipcode, mobileNumber) " +
                "VALUES ('" + data.getPassword() + "', " +
                data.getDay() + ", " +
                data.getMonth() + ", " +
                data.getYear() + ", '" +
                data.getFirstName() + "', '" +
                data.getLastName() + "', '" +
                data.getCompany() + "', '" +
                data.getAddress1() + "', '" +
                data.getAddress2() + "', '" +
                data.getState() + "', '" +
                data.getCity() + "', '" +
                data.getZipcode() + "', '" +
                data.getMobileNumber() + "');";
        stm.executeUpdate(query);
    }
    public synchronized void updateEntryById(CreateAccountObjectData data, Integer idSignUpTable) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "update SignUp_users set company='" + data.getCompany() +
                "' where id=" + idSignUpTable + ";";
        stm.execute(query);
    }
}
