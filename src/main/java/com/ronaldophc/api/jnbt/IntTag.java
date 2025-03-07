package com.ronaldophc.api.jnbt;

public final class IntTag extends Tag {
    private final int value;

    public IntTag(String name, int value) {
        super(name);
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString() {
        String name = getName();
        String append = "";
        if (name != null && !name.isEmpty())
            append = "(\"" + getName() + "\")";
        return "TAG_Int" + append + ": " + this.value;
    }
}
