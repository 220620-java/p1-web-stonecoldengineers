package com.revature.berhanu.models;
import com.revature.berhanu.Utlity;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tblaccountuser {
  public Long accountuserid;
  public Long auuserid;
  public Long auaccountid;

  public void create(Long auuserid, Long auaccountid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String InsertUserQuery = "INSERT INTO tblaccountuser "
        + "(auuserid,auaccountid)"
        + "VALUES (default,  ?, );";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
      objPreparedStatement.setLong(1, auuserid);
      objPreparedStatement.setLong(2, auaccountid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void update(Long accountuserid, Long auuserid, Long auaccountid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String updateUserQuery = "UPDATE public.tblaccountuser " +
        "auuserid=?," +
        "auaccountid=?" +
        "WHERE accountuserid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
      objPreparedStatement.setLong(1, auuserid);
      objPreparedStatement.setLong(2, auaccountid);
      objPreparedStatement.setLong(3, accountuserid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void delete(Long accountuserid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String deleteQuery = "DELETE FROM public.tblaccountuser " +
        " WHERE accountuserid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);
      objPreparedStatement.setLong(1, accountuserid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public tblaccountuser getSingle(Long accountuserid) {
    tblaccountuser objtblaccountuser = new tblaccountuser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getSingleQuery = "SELECT * FROM public.tblaccountuser " +
        " WHERE accountuserid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleQuery);
      objPreparedStatement.setLong(1, accountuserid);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccountuser.accountuserid = Result.getLong("accountuserid");
        objtblaccountuser.auuserid = Result.getLong("auuserid");
        objtblaccountuser.auaccountid = Result.getLong("auaccountid");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountuser;
  }

  public tblaccountuser getLast(Long accountuserid) {
    tblaccountuser objtblaccountuser = new tblaccountuser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLastQuery = " SELECT MAX(accountuserid) FROM tblaccountuser=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccountuser.accountuserid = Result.getLong("accountuserid");
        objtblaccountuser.auuserid = Result.getLong("auuserid");
        objtblaccountuser.auaccountid = Result.getLong("auaccountid");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountuser;
  }

  public List<tblaccountuser> getList() {
    List<tblaccountuser> objtblaccountusersList = new ArrayList<tblaccountuser>();
    tblaccountuser objtblaccountuser = new tblaccountuser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getListQuery = "SELECT * FROM public.tblaccountuser";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getListQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccountuser.accountuserid = Result.getLong("accountuserid");
        objtblaccountuser.auuserid = Result.getLong("auuserid");
        objtblaccountuser.auaccountid = Result.getLong("auaccountid");

        objtblaccountusersList.add(objtblaccountuser);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountusersList;
  }

  public List<tblaccountuser> getLike() {
    List<tblaccountuser> objtblaccountusersList = new ArrayList<tblaccountuser>();
    tblaccountuser objtblaccountuser = new tblaccountuser();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLikeQuery = "SELECT * FROM public.tblaccountuser";

    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLikeQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccountuser.accountuserid = Result.getLong("accountuserid");
        objtblaccountuser.auuserid = Result.getLong("auuserid");
        objtblaccountuser.auaccountid = Result.getLong("auaccountid");

        objtblaccountusersList.add(objtblaccountuser);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountusersList;
  }
}