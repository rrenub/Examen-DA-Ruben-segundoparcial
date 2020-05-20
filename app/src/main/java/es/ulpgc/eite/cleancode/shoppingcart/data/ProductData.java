package es.ulpgc.eite.cleancode.shoppingcart.data;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.UUID;

public class ProductData implements BaseData {

  // put the view state here
  public Long id;
  public String label;
  public Integer content;
  public Integer value;

  public ProductData(String label) {
    id = generateUniqueId();
    value=0;
    content=3;
    this.label=label;
  }

  public ProductData(ProductData data) {
    id=data.id;
    label=data.label;
    value=data.value;
    content=0;
  }

  @Override
  public String label() {
    return label;
  }

  @Override
  public String content() {
    return "Store: " + content;
  }

  public String details() {
    return "Store: " + content + " Cart: " + value;
  }

  @Override
  public String value() {
    return "Cart: " + value;
  }

  /**
   * Genereate unique ID from UUID in positive space
   * Reference: http://www.gregbugaj.com/?p=587
   *
   * @return long label representing UUID
   */
  private Long generateUniqueId() {
    long val = -1;

    do {

      final UUID uid = UUID.randomUUID();
      final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
      buffer.putLong(uid.getLeastSignificantBits());
      buffer.putLong(uid.getMostSignificantBits());
      final BigInteger bi = new BigInteger(buffer.array());
      val = bi.longValue();
    }

    // We also make sure that the ID is in positive space,
    // if its not we simply repeat the process
    while (val < 0);
    return val;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof ProductData)) return false;
    ProductData data = (ProductData) obj;
    return Objects.equals(id, data.id);
  }

  @Override
  public String toString() {
    return String.valueOf(label);
  }


}
