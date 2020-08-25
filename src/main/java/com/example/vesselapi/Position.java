package vesselapi;

import java.util.Date;


public class Position {

  private Date date;
  private Date receivedDate;
  private double latitude;
  private double longitude;
  private double speed;

  Position() {}

  Position(Date date, Date receivedDate, double latitude, double longitude, double speed) {
    this.date = date;
    this.receivedDate = receivedDate;
    this.latitude = latitude;
    this.longitude = longitude;
    this.speed = speed;
  }

 public Date getDate() {
    return this.date;
  }

  public Date getReceivedDate() {
    return this.receivedDate;
  }
  

  public double getLatitude() {
    return this.latitude;
  }

  public double getLongitude() {
    return this.longitude;
  }

  public double getSpeed() {
    return this.speed;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setReceivedDate(Date receivedDate) {
    this.receivedDate = receivedDate;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  @Override
  public String toString() {
    return String.format(
        "position:{ date='%s', receivedDate='%s', latitude='%s', longitude='%s', speed='%s' }",
        date, receivedDate, latitude, longitude, speed);
  }

}