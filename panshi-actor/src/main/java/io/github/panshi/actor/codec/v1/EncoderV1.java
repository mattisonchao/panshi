package io.github.panshi.actor.codec.v1;

import io.github.panshi.actor.codec.Encoder;
import io.github.panshi.actor.protocol.Protocol;
import io.github.panshi.actor.protocol.ProtocolV1;
import java.nio.ByteBuffer;

public class EncoderV1 implements Encoder {

  @Override
  public byte[] encode(Protocol v1) {
    byte[] encodedBytes = new byte[ProtocolV1.HEADER_SIZE + v1.data().length];
    ByteBuffer buf = ByteBuffer.wrap(encodedBytes);
    buf.put(v1.version().getCode());
    buf.putInt(ProtocolV1.HEADER_SIZE);
    buf.putInt(v1.requestId());
    buf.put(v1.schema().getCode());
    buf.put(v1.data());
    return encodedBytes;
  }
}
