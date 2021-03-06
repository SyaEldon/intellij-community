package com.intellij.ide.ui.search;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;
import java.util.Set;

public interface TraverseUIHelper {
  String EP_NAME = "com.intellij.search.traverseUiHelper";
  ExtensionPointName<TraverseUIHelper> helperExtensionPoint = ExtensionPointName.create(EP_NAME);

  /**
   * Invoked before indexing SearchableConfigurables
   */
  default void beforeStart() {}

  /**
   * Invoked after all configurables were traversed
   */
  default void afterTraversal(@NotNull Map<SearchableConfigurable, Set<OptionDescription>> options) {}

  /**
   * Invoked after indexing all SearchableConfigurables and results are saved
   */
  default void afterResultsAreSaved() {}

  /**
   * Invoked before indexing a SearchableConfigurable
   */
  default void beforeConfigurable(@NotNull SearchableConfigurable configurable, @NotNull Set<OptionDescription> options) {}

  /**
   * Invoked after indexing a SearchableConfigurable
   */
  default void afterConfigurable(@NotNull SearchableConfigurable configurable, @NotNull Set<OptionDescription> options) {}

  /**
   * Invoked before indexing the root component of a SearchableConfigurable
   */
  default void beforeComponent(@NotNull SearchableConfigurable configurable, @NotNull JComponent component, @NotNull Set<? super OptionDescription> options) {}

  /**
   * Invoked after indexing the root component of a SearchableConfigurable
   */
  default void afterComponent(@NotNull SearchableConfigurable configurable, @NotNull JComponent component, @NotNull Set<? super OptionDescription> options) {}
}