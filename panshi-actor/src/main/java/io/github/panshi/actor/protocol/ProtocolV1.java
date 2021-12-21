package io.github.panshi.actor.protocol;

import io.github.panshi.actor.schema.Schema;
import java.util.Arrays;

public class ProtocolV1 implements Protocol {
  public static final ProtocolVersion PROTOCOL_VERSION = ProtocolVersion.V_1;
  public static final char HEADER_SIZE = 4 + 4 + 8 + 4;
  private final int requestId;
  private final Schema schema;
  private final byte[] msg;

  public ProtocolV1(int requestId, Schema schema, byte[] msg) {
    this.requestId = requestId;
    this.schema = schema;
    this.msg = Arrays.copyOf(msg, msg.length);
  }

  @Override
  public ProtocolVersion version() {
    return PROTOCOL_VERSION;
  }

  @Override
  public int requestId() {
    return requestId;
  }

  @Override
  public Schema schema() {
    return schema;
  }

  @Override
  public byte[] data() {
    return Arrays.copyOf(msg, msg.length);
  }
}
