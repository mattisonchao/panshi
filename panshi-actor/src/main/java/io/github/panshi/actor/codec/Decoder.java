package io.github.panshi.actor.codec;

import io.github.panshi.actor.protocol.Protocol;

public interface Decoder {

  Protocol decode(byte[] dateBytes);
}
