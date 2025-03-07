package com.ronaldophc.api.jnbt;

public final class ShortTag extends Tag {
    private final short value;

    public ShortTag(String name, short value) {
        super(name);
        this.value = value;
    }

    public Short getValue() {
        return this.value;
    }

    public String toString() {
        String name = getName();
        String append = "";
        if (name != null && !name.isEmpty())
            append = "(\"" + getName() + "\")";
        return "TAG_Short" + append + ": " + this.value;
    }
}

