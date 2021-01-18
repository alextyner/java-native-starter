package starter;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({ "x", "y" })
public class TestStruct extends Structure {
	public static class ByValue extends TestStruct implements Structure.ByValue {
	}

	public static class ByReference extends TestStruct implements Structure.ByReference {
	}

	public int x;
	public float y;
}
