package com.revature.berhanu.models;
import com.revature.berhanu.Utlity;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tbltransaction {
  public Long transactionid;
  public Long tsourceaccountid;
  public Long tdestinationaccountid;
  public Double amount;
  public String date;
  public String time;
  public String transactiontype;
  public String remark;

  public void create(Long tsourceaccountid, Long tdestinationaccountid, Double amount, String date, String time,
      String transactiontype, String remark) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String InsertUserQuery = "INSERT INTO tbltransaction "
        + "(tsourceaccountid,tdestinationaccountid,amount,date,time,transactiontype,remark)"
        + "VALUES (default,  ?, ?, ?, ?, ?, ?, );";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(InsertUserQuery);
      objPreparedStatement.setLong(2, tsourceaccountid);
      objPreparedStatement.setLong(4, tdestinationaccountid);
      objPreparedStatement.setDouble(5, amount);
      objPreparedStatement.setString(6, date);
      objPreparedStatement.setString(7, time);
      objPreparedStatement.setString(8, transactiontype);
      objPreparedStatement.setString(9, remark);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void update(Long transactionid, Long tsourceaccountid, Long tdestinationaccountid, Double amount, String date,
      String time, String transactiontype, String remark) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String updateUserQuery = "UPDATE public.tbltransaction " +
        "tsourceaccountid=?," +
        "tdestinationaccountid=?," +
        "amount=?," +
        "date=?," +
        "time=?," +
        "transactiontype=?," +
        "remark=?" +
        "WHERE transactionid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(updateUserQuery);
      objPreparedStatement.setLong(1, tsourceaccountid);
      objPreparedStatement.setLong(2, tdestinationaccountid);
      objPreparedStatement.setDouble(3, amount);
      objPreparedStatement.setString(4, date);
      objPreparedStatement.setString(5, time);
      objPreparedStatement.setString(6, transactiontype);
      objPreparedStatement.setString(7, remark);
      objPreparedStatement.setLong(8, transactionid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public void delete(Long transactionid) {
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String deleteQuery = "DELETE FROM public.tbltransaction " +
        " WHERE transactionid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(deleteQuery);
      objPreparedStatement.setLong(1, transactionid);

      objPreparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw (new Error(e));
    }
  }

  public tbltransaction getSingle(Long transactionid) {
    tbltransaction objtbltransaction = new tbltransaction();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getSingleQuery = "SELECT * FROM public.tbltransaction " +
        " WHERE transactionid=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getSingleQuery);
      objPreparedStatement.setLong(1, transactionid);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbltransaction.transactionid = Result.getLong("transactionid");
        objtbltransaction.tsourceaccountid = Result.getLong("tsourceaccountid");
        objtbltransaction.tdestinationaccountid = Result.getLong("tdestinationaccountid");
        objtbltransaction.amount = Result.getDouble("amount");
        objtbltransaction.date = Result.getString("date");
        objtbltransaction.time = Result.getString("time");
        objtbltransaction.transactiontype = Result.getString("transactiontype");
        objtbltransaction.remark = Result.getString("remark");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbltransaction;
  }

  public tbltransaction getLast(Long transactionid) {
    tbltransaction objtbltransaction = new tbltransaction();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLastQuery = " SELECT MAX(transactionid) FROM tbltransaction=?;";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLastQuery);
      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbltransaction.transactionid = Result.getLong("transactionid");
        objtbltransaction.tsourceaccountid = Result.getLong("tsourceaccountid");
        objtbltransaction.tdestinationaccountid = Result.getLong("tdestinationaccountid");
        objtbltransaction.amount = Result.getDouble("amount");
        objtbltransaction.date = Result.getString("date");
        objtbltransaction.time = Result.getString("time");
        objtbltransaction.transactiontype = Result.getString("transactiontype");
        objtbltransaction.remark = Result.getString("remark");

      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbltransaction;
  }

  public List<tbltransaction> getList() {
    List<tbltransaction> objtbltransactionsList = new ArrayList<tbltransaction>();
    tbltransaction objtbltransaction = new tbltransaction();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getListQuery = "SELECT * FROM public.tbltransaction";
    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getListQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbltransaction.transactionid = Result.getLong("transactionid");
        objtbltransaction.tsourceaccountid = Result.getLong("tsourceaccountid");
        objtbltransaction.tdestinationaccountid = Result.getLong("tdestinationaccountid");
        objtbltransaction.amount = Result.getDouble("amount");
        objtbltransaction.date = Result.getString("date");
        objtbltransaction.time = Result.getString("time");
        objtbltransaction.transactiontype = Result.getString("transactiontype");
        objtbltransaction.remark = Result.getString("remark");

        objtbltransactionsList.add(objtbltransaction);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbltransactionsList;
  }

  public List<tbltransaction> getLike() {
    List<tbltransaction> objtbltransactionsList = new ArrayList<tbltransaction>();
    tbltransaction objtbltransaction = new tbltransaction();
    ServerConnect objServerConnection = new ServerConnect();
    Connection objConnection = objServerConnection.connectToServer();
    String getLikeQuery = "SELECT * FROM public.tbltransaction";

    try {
      PreparedStatement objPreparedStatement = objConnection.prepareStatement(getLikeQuery);

      ResultSet Result = objPreparedStatement.executeQuery();
      while (Result.next()) {
        objtbltransaction.transactionid = Result.getLong("transactionid");
        objtbltransaction.tsourceaccountid = Result.getLong("tsourceaccountid");
        objtbltransaction.tdestinationaccountid = Result.getLong("tdestinationaccountid");
        objtbltransaction.amount = Result.getDouble("amount");
        objtbltransaction.date = Result.getString("date");
        objtbltransaction.time = Result.getString("time");
        objtbltransaction.transactiontype = Result.getString("transactiontype");
        objtbltransaction.remark = Result.getString("remark");

        objtbltransactionsList.add(objtbltransaction);
      }
    } catch (SQLException e) {
      throw (new Error(e));
    }
    return objtbltransactionsList;
  }
}