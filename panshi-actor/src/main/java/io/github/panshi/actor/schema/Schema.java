package io.github.panshi.actor.schema;

import lombok.Getter;

public enum Schema {
  BYTE((byte) 1),
  KRYO((byte) 2);

  @Getter private final byte code;

  Schema(byte code) {
    this.code = code;
  }

  public static Schema valueOf(byte code) {
    switch (code) {
      case 1:
        return BYTE;
      case 2:
        return KRYO;
      default:
        throw new IllegalArgumentException(String.format("unsupported schema code=%s", code));
    }
  }
}
