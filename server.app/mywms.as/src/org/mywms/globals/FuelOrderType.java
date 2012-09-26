package org.mywms.globals;

public enum FuelOrderType {
    FUEL_ORDER_TYPE_1("fuel_order_type_1_str"),
    FUEL_ORDER_TYPE_2("fuel_order_type_2_str");

private final String label;

  private FuelOrderType(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }

}
