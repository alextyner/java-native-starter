package starter;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

interface CLibrary extends Library {
	
	static final CLibrary API = (CLibrary) Native.load("Library.dll", CLibrary.class);
	
	int testPrimitiveReturn();
	
	Pointer testHeapAllocation();
	
	String testSTL(short length);
	
	TestStruct.ByValue testStructReturn();
	
}
