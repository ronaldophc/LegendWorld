package com.ronaldophc.api.jnbt;

public final class FloatTag extends Tag {
    private final float value;

    public FloatTag(String name, float value) {
        super(name);
        this.value = value;
    }

    public Float getValue() {
        return this.value;
    }

    public String toString() {
        String name = getName();
        String append = "";
        if (name != null && !name.isEmpty())
            append = "(\"" + getName() + "\")";
        return "TAG_Float" + append + ": " + this.value;
    }
}
