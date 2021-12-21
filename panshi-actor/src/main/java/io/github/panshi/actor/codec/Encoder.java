package io.github.panshi.actor.codec;

import io.github.panshi.actor.protocol.Protocol;

public interface Encoder {

  byte[] encode(Protocol protocol);
}
