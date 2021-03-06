package fakedds;

import ice.CdrHelper;

import java.io.Serializable;
import java.util.Arrays;

public class Values implements Copyable, Serializable
{

    //TODO: why 1024 and does it limit bandwidth?
    public FloatSeq userData = new FloatSeq((1024));


    public Values() {

    }

    public float[] getValuesAsArray() {
        float[] result = Arrays.copyOfRange(this.userData.getPrimitiveArray(), 0, this.userData.size());
        assert result.length == this.userData.size();
        return result;
    }


    public Values(Values other) {

        this();
        copy_from(other);
    }



    public static Object create() {
        Values self;
        self = new Values();

        self.clear();

        return self;
    }

    public void clear() {

        if (userData != null) {
            userData.clear();
        }

    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }



        if(getClass() != o.getClass()) {
            return false;
        }

        Values otherObj = (Values)o;



        if(!userData.equals(otherObj.userData)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result += userData.hashCode();

        return __result;
    }


    /**
     * This is the implementation of the <code>Copyable</code> interface.
     * This method will perform a deep copy of <code>src</code>
     * This method could be placed into <code>ValuesTypeSupport</code>
     * rather than here by using the <code>-noCopyable</code> option
     * to rtiddsgen.
     *
     * @param src The Object which contains the data to be copied.
     * @return Returns <code>this</code>.
     * @exception NullPointerException If <code>src</code> is null.
     * @exception ClassCastException If <code>src</code> is not the
     * same type as <code>this</code>.
     * @see #copy_from(java.lang.Object)
     */
    public Object copy_from(Object src) {


        Values typedSrc = (Values) src;
        Values typedDst = this;

        typedDst.userData.copy_from(typedSrc.userData);

        return this;
    }



    public String toString(){
        return toString("", 0);
    }


    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();


        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }


        CdrHelper.printIndent(strBuffer, indent+1);
        strBuffer.append("userData: ");
        for(int i__ = 0; i__ < userData.size(); ++i__) {
            if (i__!=0) strBuffer.append(", ");
            strBuffer.append(userData.get(i__));
        }
        strBuffer.append("\n");

        return strBuffer.toString();
    }

}

