package com.ronaldophc.api.jnbt;

import lombok.Getter;

@Getter
public final class StringTag extends Tag {
    private final String value;

    public StringTag(String name, String value) {
        super(name);
        this.value = value;
    }

    public String toString() {
        String name = getName();
        String append = "";
        if (name != null && !name.isEmpty())
            append = "(\"" + getName() + "\")";
        return "TAG_String" + append + ": " + this.value;
    }
}
