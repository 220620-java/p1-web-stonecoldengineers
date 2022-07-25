package com.revature.berhanu.models;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.berhanu.Utlity;
public class tblaccounttype {
  public Long accounttypeid;
  public String accounttypename;
  public Double interestrate;

  public void create(String accounttypename, Double interestrate) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String InsertUserQuery = "INSERT INTO tblaccounttype "
        + "(accounttypename,interestrate)"
        + "VALUES (default,  ?, );";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
      objPreparedStatement.setString(3, accounttypename);
      objPreparedStatement.setDouble(4, interestrate);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void update(Long accounttypeid, String accounttypename, Double interestrate) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String updateUserQuery = "UPDATE public.tblaccounttype " +
        "accounttypename=?," +
        "interestrate=?" +
        "WHERE accounttypeid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
      objPreparedStatement.setString(1, accounttypename);
      objPreparedStatement.setDouble(2, interestrate);
      objPreparedStatement.setLong(3, accounttypeid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void delete(Long accounttypeid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String deleteQuery = "DELETE FROM public.tblaccounttype " +
        " WHERE accounttypeid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);
      objPreparedStatement.setLong(1, accounttypeid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public tblaccounttype getSingle(Long accounttypeid) {
    tblaccounttype objtblaccounttype = new tblaccounttype();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getSingleQuery = "SELECT * FROM public.tblaccounttype " +
        " WHERE accounttypeid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleQuery);
      objPreparedStatement.setLong(1, accounttypeid);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccounttype.accounttypeid = Result.getLong("accounttypeid");
        objtblaccounttype.accounttypename = Result.getString("accounttypename");
        objtblaccounttype.interestrate = Result.getDouble("interestrate");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccounttype;
  }

  public tblaccounttype getLast(Long accounttypeid) {
    tblaccounttype objtblaccounttype = new tblaccounttype();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLastQuery = " SELECT MAX(accounttypeid) FROM tblaccounttype=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccounttype.accounttypeid = Result.getLong("accounttypeid");
        objtblaccounttype.accounttypename = Result.getString("accounttypename");
        objtblaccounttype.interestrate = Result.getDouble("interestrate");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccounttype;
  }

  public List<tblaccounttype> getList() {
    List<tblaccounttype> objtblaccounttypesList = new ArrayList<tblaccounttype>();
    tblaccounttype objtblaccounttype = new tblaccounttype();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getListQuery = "SELECT * FROM public.tblaccounttype";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getListQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccounttype.accounttypeid = Result.getLong("accounttypeid");
        objtblaccounttype.accounttypename = Result.getString("accounttypename");
        objtblaccounttype.interestrate = Result.getDouble("interestrate");

        objtblaccounttypesList.add(objtblaccounttype);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccounttypesList;
  }

  public List<tblaccounttype> getLike() {
    List<tblaccounttype> objtblaccounttypesList = new ArrayList<tblaccounttype>();
    tblaccounttype objtblaccounttype = new tblaccounttype();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLikeQuery = "SELECT * FROM public.tblaccounttype";

    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLikeQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtblaccounttype.accounttypeid = Result.getLong("accounttypeid");
        objtblaccounttype.accounttypename = Result.getString("accounttypename");
        objtblaccounttype.interestrate = Result.getDouble("interestrate");

        objtblaccounttypesList.add(objtblaccounttype);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtblaccounttypesList;
  }
}