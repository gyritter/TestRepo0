package arrayselector;

public class ArraySelector {
    StringBuilder sb = new StringBuilder();

    public String selectEvens(int[] test) {
        if (test==null || test.length<1) {
            return "";

        } else
            sb.append("[");
        for (int i = 0; i < test.length; i = i + 2) {
            sb.append(test[i]);
            sb.append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
      // String sb2= sb.substring(0,sb.length()-2);
        return sb.append("]").toString();
       // return sb2.concat("]");
        }

}

/*Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből
minden második elemet kiválogat, és egy szövegként összerak,
szögletes zárójelek között!
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros,
a második, azaz egyes indexű elem páratlan, stb.
Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
 */

