package io.github.panshi.actor.protocol;

import io.github.panshi.actor.schema.Schema;

public interface Protocol {

  ProtocolVersion version();

  int requestId();

  Schema schema();

  byte[] data();
}
