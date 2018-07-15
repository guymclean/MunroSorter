
import java.util.Comparator;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guy
 */
public class Munro{
    private final String name;
    private final float heightInMeters;
    private final String hillCategory;
    private final String gridRef;

//    public String getName() {
//        return name;
//    }
//
    public float getHeightInMeters() {
        return heightInMeters;
    }
//
    public String getHillCategory() {
        return hillCategory;
    }
//
//    public String getGridRef() {
//        return gridRef;
//    }
    
    Munro(String name, float heightInMeters, String hillCategory, String gridRef) {
        this.name = name;
        this.heightInMeters = heightInMeters;
        this.hillCategory = hillCategory;
        this.gridRef = gridRef;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Float.floatToIntBits(this.heightInMeters);
        hash = 89 * hash + Objects.hashCode(this.hillCategory);
        hash = 89 * hash + Objects.hashCode(this.gridRef);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Munro other = (Munro) obj;
        if (Float.floatToIntBits(this.heightInMeters) != Float.floatToIntBits(other.heightInMeters)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.hillCategory, other.hillCategory)) {
            return false;
        }
        if (!Objects.equals(this.gridRef, other.gridRef)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString(){
        return name + ", " + heightInMeters + "m, (" + hillCategory + ") " + gridRef;
    }
    
    
    public static class NameComparator implements Comparator<Munro> {
        @Override
        public int compare(Munro o1, Munro o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    
    
    public static class HeightComparator implements Comparator<Munro> {
        @Override
        public int compare(Munro o1, Munro o2) {
            if (o1.heightInMeters < o2.heightInMeters) return -1;
            if (o1.heightInMeters > o2.heightInMeters) return 1;
            return 0;
        }
    }
}
