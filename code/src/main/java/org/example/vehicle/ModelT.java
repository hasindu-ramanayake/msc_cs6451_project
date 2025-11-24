package org.example.vehicle;

public enum ModelT {
    IBIZA, UNKNOWN;

    public static ModelT getType(String t){
        if ( t==null || t.isEmpty() ) return UNKNOWN;
        String normalized = t.trim().toUpperCase();
        for (ModelT model : ModelT.values()) {
            if (model.name().equals(normalized)) {
                return model;
            }
        }
        return UNKNOWN;
    }

}
