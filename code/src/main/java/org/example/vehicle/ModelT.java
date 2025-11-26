package org.example.vehicle;

public enum ModelT {
    CLASS_A, CLASS_B,CLASS_C, UNKNOWN;

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
