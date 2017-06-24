// !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER

// FILE: test/package-info.java

@javax.annotation.ParametersAreNonnullByDefault()
package test;

// FILE: test/A.java

package test;

import javax.annotation.*;

public class A {
    @Nullable public String field = null;

    public String foo(String q, @Nonnull String x, @CheckForNull CharSequence y) {
        return "";
    }

    @Nonnull
    public String bar() {
        return "";
    }
}

// FILE: main.kt

import test.A

fun main(a: A) {
    // foo is platform
    a.foo("", "", null)?.length
    a.foo("", "", null).length
    a.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>, <!NULL_FOR_NONNULL_TYPE!>null<!>, "").length

    a.bar().length
    a.bar()<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>.length

    a.field?.length
    a.field<!UNSAFE_CALL!>.<!>length
}
