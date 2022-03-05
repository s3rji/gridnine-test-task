package com.gridnine.testing.util.conditions;

import java.util.function.Predicate;

public interface Condition<T> {
    Predicate<T> getPredicate();
}
