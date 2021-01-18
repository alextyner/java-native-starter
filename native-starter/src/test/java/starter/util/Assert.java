package starter.util;


public final class Assert {

	public static <T> ActualResult<T> that(T actual) {
		return new ActualResult<T>(actual);
	}

	public static RunnableResult that(Runnable actual) {
		return new RunnableResult(actual);
	}

	public static class RunnableResult {

		private Runnable actual;

		public RunnableResult(Runnable actual) {
			this.actual = actual;
		}

		public void doesNotThrow() {
			try {
				actual.run();
			} catch (Throwable t) {
				throw new AssertionError(t.getMessage(), t);
			}
		}
	}

	public static class ActualResult<T> {
		private T actual;

		public ActualResult(T actual) {
			this.actual = actual;
		}

		@SuppressWarnings("unlikely-arg-type")
		public <S> void isEqualTo(S expected) {
			if (actual == null && expected == null)
				return;
			if (actual == null || expected == null)
				throw new AssertionError();
			if (!expected.equals(actual))
				throw new AssertionError();
		}

		public void doesNotThrow() {
		}

		public <S> void isEqualToDelta(double expected, double epsilon) {
			try {
				double actual = (Double) this.actual;
				if (actual != expected && Math.abs(actual - expected) > epsilon)
					throw new AssertionError();
			} catch (ClassCastException cce) {
				throw new IllegalStateException("Actual result is not a floating point type.");
			}
		}
		


		public <S> void isEqualToDelta(float expected, float epsilon) {
			try {
				float actual = (Float) this.actual;
				if (actual != expected && Math.abs(actual - expected) > epsilon)
					throw new AssertionError();
			} catch (ClassCastException cce) {
				throw new IllegalStateException("Actual result is not a floating point type.");
			}
		}
	}

}
