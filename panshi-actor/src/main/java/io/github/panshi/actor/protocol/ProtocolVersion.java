package io.github.panshi.actor.protocol;

import lombok.Getter;

public enum ProtocolVersion {
  V_1((byte) 1);
  @Getter private final byte code;

  ProtocolVersion(byte code) {
    this.code = code;
  }
}
