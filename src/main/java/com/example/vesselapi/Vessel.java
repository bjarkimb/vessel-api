package vesselapi;

import org.springframework.data.annotation.Id;


public class Vessel {

  @Id
  private String id;

  private String name;
  private Position position;

  Vessel() {}

  Vessel(String name, Position position) {
    this.name = name;
    this.position = position;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Position getPosition() {
    return this.position;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return String.format(
        "vessel:{ id=%s, name='%s'",
        id, name) + position.toString() + " }";
  }

}