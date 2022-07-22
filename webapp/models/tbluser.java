package com.revature.berhanu.models;
import com.revature.berhanu.Utlity;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tbluser {
  public Long userid;
  public String ssn;
  public String firstname;
  public String middlename;
  public String lastname;
  public String dob;
  public String gender;
  public String email;
  public String phonenumber;
  public String password;

  public void create(String ssn, String firstname, String middlename, String lastname, String dob, String gender,
      String email, String phonenumber, String password) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String InsertUserQuery = "INSERT INTO tbluser "
        + "(ssn,firstname,middlename,lastname,dob,gender,email,phonenumber,password)"
        + "VALUES (default,  ?, ?, ?, ?, ?, ?, ?, ?, );";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
      objPreparedStatement.setString(1, ssn);
      objPreparedStatement.setString(2, firstname);
      objPreparedStatement.setString(3, middlename);
      objPreparedStatement.setString(4, lastname);
      objPreparedStatement.setString(5, dob);
      objPreparedStatement.setString(6, gender);
      objPreparedStatement.setString(7, email);
      objPreparedStatement.setString(8, phonenumber);
      objPreparedStatement.setString(9, password);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void update(Long userid, String ssn, String firstname, String middlename, String lastname, String dob,
      String gender, String email, String phonenumber, String password) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String updateUserQuery = "UPDATE public.tbluser " +
        "ssn=?," +
        "firstname=?," +
        "middlename=?," +
        "lastname=?," +
        "dob=?," +
        "gender=?," +
        "email=?," +
        "phonenumber=?," +
        "password=?" +
        "WHERE userid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
      objPreparedStatement.setString(1, ssn);
      objPreparedStatement.setString(2, firstname);
      objPreparedStatement.setString(3, middlename);
      objPreparedStatement.setString(4, lastname);
      objPreparedStatement.setString(5, dob);
      objPreparedStatement.setString(6, gender);
      objPreparedStatement.setString(7, email);
      objPreparedStatement.setString(8, phonenumber);
      objPreparedStatement.setString(9, password);
      objPreparedStatement.setLong(10, userid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void delete(Long userid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String deleteQuery = "DELETE FROM public.tbluser " +
        " WHERE userid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);
      objPreparedStatement.setLong(1, userid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public tbluser getSingle(Long userid) {
    tbluser objtbluser = new tbluser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getSingleQuery = "SELECT * FROM public.tbluser " +
        " WHERE userid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleQuery);
      objPreparedStatement.setLong(1, userid);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbluser.userid = Result.getLong("userid");
        objtbluser.ssn = Result.getString("ssn");
        objtbluser.firstname = Result.getString("firstname");
        objtbluser.middlename = Result.getString("middlename");
        objtbluser.lastname = Result.getString("lastname");
        objtbluser.dob = Result.getString("dob");
        objtbluser.gender = Result.getString("gender");
        objtbluser.email = Result.getString("email");
        objtbluser.phonenumber = Result.getString("phonenumber");
        objtbluser.password = Result.getString("password");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbluser;
  }

  public tbluser getLast(Long userid) {
    tbluser objtbluser = new tbluser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLastQuery = " SELECT MAX(userid) FROM tbluser=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbluser.userid = Result.getLong("userid");
        objtbluser.ssn = Result.getString("ssn");
        objtbluser.firstname = Result.getString("firstname");
        objtbluser.middlename = Result.getString("middlename");
        objtbluser.lastname = Result.getString("lastname");
        objtbluser.dob = Result.getString("dob");
        objtbluser.gender = Result.getString("gender");
        objtbluser.email = Result.getString("email");
        objtbluser.phonenumber = Result.getString("phonenumber");
        objtbluser.password = Result.getString("password");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbluser;
  }

  public List<tbluser> getList() {
    List<tbluser> objtblusersList = new ArrayList<tbluser>();
    tbluser objtbluser = new tbluser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getListQuery = "SELECT * FROM public.tbluser";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getListQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbluser.userid = Result.getLong("userid");
        objtbluser.ssn = Result.getString("ssn");
        objtbluser.firstname = Result.getString("firstname");
        objtbluser.middlename = Result.getString("middlename");
        objtbluser.lastname = Result.getString("lastname");
        objtbluser.dob = Result.getString("dob");
        objtbluser.gender = Result.getString("gender");
        objtbluser.email = Result.getString("email");
        objtbluser.phonenumber = Result.getString("phonenumber");
        objtbluser.password = Result.getString("password");

        objtblusersList.add(objtbluser);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblusersList;
  }

  public List<tbluser> getLike() {
    List<tbluser> objtblusersList = new ArrayList<tbluser>();
    tbluser objtbluser = new tbluser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLikeQuery = "SELECT * FROM public.tbluser";

    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLikeQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbluser.userid = Result.getLong("userid");
        objtbluser.ssn = Result.getString("ssn");
        objtbluser.firstname = Result.getString("firstname");
        objtbluser.middlename = Result.getString("middlename");
        objtbluser.lastname = Result.getString("lastname");
        objtbluser.dob = Result.getString("dob");
        objtbluser.gender = Result.getString("gender");
        objtbluser.email = Result.getString("email");
        objtbluser.phonenumber = Result.getString("phonenumber");
        objtbluser.password = Result.getString("password");

        objtblusersList.add(objtbluser);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblusersList;
  }
}