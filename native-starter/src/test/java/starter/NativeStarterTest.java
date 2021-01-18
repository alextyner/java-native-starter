package starter;

import starter.util.Assert;

public class NativeStarterTest {

	public static void main(String... args) {
		System.out.println(CLibrary.API.testSTL((short) 14));
		Assert.that(CLibrary.API.testSTL((short) 14)).isEqualTo("13 12 11 10 9 8 7 6 5 4 3 2 1 0 ");
		Assert.that(CLibrary.API.testPrimitiveReturn()).isEqualTo(42);
		Assert.that(CLibrary.API.testHeapAllocation().getInt(0)).isEqualTo(42);

		TestStruct x = CLibrary.API.testStructReturn();
		Assert.that(x.x).isEqualTo(4);
		Assert.that(x.y).isEqualToDelta(63.0f, 0.01f);
	}

}
