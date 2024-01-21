package com.example.interfaces;

import org.pf4j.ExtensionPoint;

public interface PluginInterface extends ExtensionPoint {

    String getName();

    String getVersion();

    String getAuthor();
}
