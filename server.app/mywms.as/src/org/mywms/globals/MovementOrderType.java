package org.mywms.globals;

public enum MovementOrderType {
    VEHICLE_REFUEL("VEHICLE_REFUEL"),
    SERVICE_NOTE("SERVICE_NOTE");

private final String label;

  private MovementOrderType(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }

}
