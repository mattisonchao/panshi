package io.github.panshi.actor;

public interface Actor extends LifeCycle {

  void beforeActive();

  void whenReceive();

  void send();
}
