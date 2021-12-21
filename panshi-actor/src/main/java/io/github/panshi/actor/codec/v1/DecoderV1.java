package io.github.panshi.actor.codec.v1;

import io.github.panshi.actor.codec.Decoder;
import io.github.panshi.actor.protocol.Protocol;
import io.github.panshi.actor.protocol.ProtocolV1;
import io.github.panshi.actor.schema.Schema;
import java.nio.ByteBuffer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoderV1 implements Decoder {
  @Override
  public Protocol decode(byte[] dataBytes) {
    if (dataBytes == null) {
      String errorDetail = "Null data to decode by Decoder V1";
      log.error(errorDetail);
      throw new IllegalArgumentException(errorDetail);
    }
    if (dataBytes.length < 4) {
      String errorDetail = String.format("Invalid protocol value, size=%s", dataBytes.length);
      throw new IllegalArgumentException(errorDetail);
    }
    ByteBuffer buf = ByteBuffer.wrap(dataBytes);
    byte version = buf.get();
    if (version != ProtocolV1.PROTOCOL_VERSION.getCode()) {
      String errorDetail = String.format("Invalid protocol version, version=%s", version);
      throw new IllegalStateException(errorDetail);
    }
    int headerSize = buf.getInt();
    if (headerSize != ProtocolV1.HEADER_SIZE) {
      String errorDetail =
          String.format("Invalid header size, version=%s, size=%s", version, headerSize);
      throw new IllegalStateException(errorDetail);
    }
    int requestId = buf.getInt();
    byte schema = buf.get();
    buf.position(headerSize);
    byte[] data = new byte[buf.remaining()];
    buf.get(data);
    return new ProtocolV1(requestId, Schema.valueOf(schema), data);
  }
}
