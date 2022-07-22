package com.revature.berhanu.models;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.berhanu.Utlity;

public class tblaccount {
  public Long accountid;
  public Long aaccounttypeid;
  public Double accountbalance;
  public String accountownershiptype;
  public String accountnumber;
  public String accountstatus;

  public void create(Long aaccounttypeid, Double accountbalance, String accountownershiptype, String accountnumber,
      String accountstatus) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String InsertUserQuery = "INSERT INTO tblaccount "
        + "(aaccounttypeid,accountbalance,accountownershiptype,accountnumber,accountstatus)"
        + "VALUES (default,  ?, ?, ?, ?, );";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
      objPreparedStatement.setLong(1, aaccounttypeid);
      objPreparedStatement.setDouble(2, accountbalance);
      objPreparedStatement.setString(3, accountownershiptype);
      objPreparedStatement.setString(4, accountnumber);
      objPreparedStatement.setString(5, accountstatus);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void update(Long accountid, Long aaccounttypeid, Double accountbalance, String accountownershiptype,
      String accountnumber, String accountstatus) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String updateUserQuery = "UPDATE public.tblaccount " +
        "aaccounttypeid=?," +
        "accountbalance=?," +
        "accountownershiptype=?," +
        "accountnumber=?," +
        "accountstatus=?" +
        "WHERE accountid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
      objPreparedStatement.setLong(1, aaccounttypeid);
      objPreparedStatement.setDouble(2, accountbalance);
      objPreparedStatement.setString(3, accountownershiptype);
      objPreparedStatement.setString(4, accountnumber);
      objPreparedStatement.setString(5, accountstatus);
      objPreparedStatement.setLong(6, accountid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void delete(Long accountid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String deleteQuery = "DELETE FROM public.tblaccount " +
        " WHERE accountid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);
      objPreparedStatement.setLong(1, accountid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public tblaccount getSingle(Long accountid) {
    tblaccount objtblaccount = new tblaccount();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getSingleQuery = "SELECT * FROM public.tblaccount " +
        " WHERE accountid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleQuery);
      objPreparedStatement.setLong(1, accountid);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccount.accountid = Result.getLong("accountid");
        objtblaccount.aaccounttypeid = Result.getLong("aaccounttypeid");
        objtblaccount.accountbalance = Result.getDouble("accountbalance");
        objtblaccount.accountownershiptype = Result.getString("accountownershiptype");
        objtblaccount.accountnumber = Result.getString("accountnumber");
        objtblaccount.accountstatus = Result.getString("accountstatus");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccount;
  }

  public tblaccount getLast(Long accountid) {
    tblaccount objtblaccount = new tblaccount();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLastQuery = " SELECT MAX(accountid) FROM tblaccount=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccount.accountid = Result.getLong("accountid");
        objtblaccount.aaccounttypeid = Result.getLong("aaccounttypeid");
        objtblaccount.accountbalance = Result.getDouble("accountbalance");
        objtblaccount.accountownershiptype = Result.getString("accountownershiptype");
        objtblaccount.accountnumber = Result.getString("accountnumber");
        objtblaccount.accountstatus = Result.getString("accountstatus");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccount;
  }

  public List<tblaccount> getList() {
    List<tblaccount> objtblaccountsList = new ArrayList<tblaccount>();
    tblaccount objtblaccount = new tblaccount();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getListQuery = "SELECT * FROM public.tblaccount";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getListQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccount.accountid = Result.getLong("accountid");
        objtblaccount.aaccounttypeid = Result.getLong("aaccounttypeid");
        objtblaccount.accountbalance = Result.getDouble("accountbalance");
        objtblaccount.accountownershiptype = Result.getString("accountownershiptype");
        objtblaccount.accountnumber = Result.getString("accountnumber");
        objtblaccount.accountstatus = Result.getString("accountstatus");

        objtblaccountsList.add(objtblaccount);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountsList;
  }

  public List<tblaccount> getLike() {
    List<tblaccount> objtblaccountsList = new ArrayList<tblaccount>();
    tblaccount objtblaccount = new tblaccount();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLikeQuery = "SELECT * FROM public.tblaccount";

    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLikeQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccount.accountid = Result.getLong("accountid");
        objtblaccount.aaccounttypeid = Result.getLong("aaccounttypeid");
        objtblaccount.accountbalance = Result.getDouble("accountbalance");
        objtblaccount.accountownershiptype = Result.getString("accountownershiptype");
        objtblaccount.accountnumber = Result.getString("accountnumber");
        objtblaccount.accountstatus = Result.getString("accountstatus");

        objtblaccountsList.add(objtblaccount);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccountsList;
  }
}