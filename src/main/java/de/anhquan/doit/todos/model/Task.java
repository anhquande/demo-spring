package de.anhquan.doit.todos.model;

import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value.Immutable
public interface Task {

    @NotNull
    String getTitle();

    @Nullable
    String description();

    @NotNull
    String getId();
}
